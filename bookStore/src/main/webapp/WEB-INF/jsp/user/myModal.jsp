<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
            String username = "";
            String password = "";
            Cookie[] cookies = request.getCookies();
            if(cookies!=null && cookies.length>0){
                for(Cookie c:cookies){
                    if("userinfo".equals(c.getName())){
                        String value = c.getValue();
                         username = value.split("-")[0];
                        //对uname可能为中文的进行二级解码
                        
                        //username = URLDecoder.decode(URLDecoder.decode(uname, "UTF-8"),"UTF-8");
                        
                        password = value.split("-")[1];
                    }
                }
            }
     
            request.setAttribute("username", username);
            request.setAttribute("password", password);
        %>
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                        <h4 class="modal-title" id="myModalLabel1">
                    用户注册
                </h4>
                    </div>
                    <div class="modal-body">
                        <!--登录的form表单-->
                        <form action="${path}/user/register" class="form-horizontal" method="post" onsubmit="return doSubmit('p');">
                            <div class="form-group has-feedback">
                                <label for="reusername" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="reusername" required placeholder="小写字母开头字母或数字,不含中文." name="reusername"
                                    style="ime-mode:disabled">
                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label class="alert-danger" style="display: none">用户名已存在</label>
                                    <span class="glyphicon glyphicon-ok text-success" style="display: none" id="usucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="ufail"></span>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label for="repassword" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="repassword" name="repassword" placeholder="密码长度6-8位" minlength="6" maxlength="8">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                   <span class="glyphicon glyphicon-ok text-success" style="display: none" id="psucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="pfail"></span>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">确认密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="repwd" name="repwd" minlength="6" maxlength="8" placeholder="和密码保持一致">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <span class="glyphicon glyphicon-ok text-success" style="display: none" id="rpsucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="rpfail"></span>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">邮箱</label>
                                <div class="col-sm-5">
                                    <input type="email" class="form-control" id="reemail" placeholder="合法邮箱格式" name="reemail">
                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <span class="glyphicon glyphicon-ok text-success" style="display: none" id="esucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="efail"></span>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">电话</label>
                                <div class="col-sm-5">
                                    <input type="tel" class="form-control" id="rephone" name="rephone" placeholder="合法手机格式">
                                    <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <span class="glyphicon glyphicon-ok text-success" style="display: none" id="phsucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="phfail"></span>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">公司</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="recompany" name="recompany" placeholder="请输入公司地址">
                                    <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <span class="glyphicon glyphicon-ok text-success" style="display: none" id="csucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="cfail"></span>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">地址</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="readdress" name="readdress" placeholder="请输入收货地址">
                                    <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <span class="glyphicon glyphicon-ok text-success" style="display: none" id="asucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="afail"></span>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <input type="submit" class="btn btn-primary" value="注册">
                            </div>
                        </form>
                        <!--form结束-->
                        <a href="#">已有账号点我登录</a>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
        </div>
<div class="modal fade" id="login" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">用户登录</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" action="#" method="post" onsubmit="return loginSubmit()">
                              <div class="form-group has-feedback" >
                                  <label for="lousername" class="col-sm-2 control-label">用户名</label>
                                  <div class="col-sm-5">
                                  <input class="form-control" type="text" name="lousername" maxlength="10" placeholder="请输入用户名" id="lousername" value="${username}">
                                  <span class="glyphicon glyphicon-user form-control-feedback" ></span>
                                  </div>
                                  <div class="col-sm-3">
                                  <label class="alert-danger" style="padding-top: 10px; display: none" id="usersign">用户名不存在</label>
                                  </div>
                              </div>
                             <div class="form-group has-feedback">
                                 <label for="lopassword" class="col-sm-2 control-label">密码</label>
                                 <div class="col-sm-5">
                                  <input class="form-control " type="password" name="lopassword" placeholder="请输入密码" id="lopassword" value="${password}">
                                  <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                 </div>
                                  <div class="col-sm-3">
                                    <label class="alert-danger" style="padding-top: 10px;display: none" id="pwdsign">密码不正确</label>
                                  </div>
                             </div>
                              <div class="form-group">
                              <div class="col-sm-offset-2 col-sm-10">
                                <input type="checkbox" name="rememberme" checked value="true" id="rem">    请记住我
                                </div>
                              </div>
                              <div class="text-right">
                                  <input type="submit" class="btn btn-primary" value="登录">
                                  <button class="btn btn-danger" data-dismiss="modal">取消</button>
                              </div>
                      </form>

      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
 <script type="text/javascript">
var username=document.getElementById("reusername");
var password=document.getElementById("repassword");
var repassword=document.getElementById("repwd");
var email=document.getElementById("reemail");
var phone=document.getElementById("rephone");
var company=document.getElementById("recompany");
var address=document.getElementById("readdress");
var u=/^[a-zA-Z][a-zA-Z0-9]*$/;
var p=/^[0-9]+$/;
var e = /^[a-z0-9]\w+@[a-z0-9]{2,3}(\.[a-z]{2,3}){1,2}$/i;
var ph=/^1[34578][0-9]{9}$/;
var flag1=true;
var flag2=true; 
 function doSubmit(param) {
    //验证用户名
     checkdata(username,"u",function(){
    if(u.test(username.value))
    {
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange= function () {
           if(xmlhttp.readyState==4)
               {
               if(xmlhttp.status==200){
               var s=xmlhttp.responseText;
               if(s=="0"){
                   flag2=true;
               }if(s=="1"){
                   flag2=false;
                    }
                 }
                }
    }
      xmlhttp.open("get","${path}/register/verify?username="+username.value,true);
      xmlhttp.send();
      for(var i=0;i<=500000000;i++);
       return flag2;
    }
    else{
        flag1=false;
        return false;
}
    
},param);  
//验证密码
checkdata(password,"p",function(){
    if(p.test(password.value))
    {
           return true;
    }else{
        flag1=false;
        return false;
    }
            
},param);
//验证再次输入的密码
checkdata(repassword,"rp",function(){
    if(p.test(password.value))
    {
        if(password.value==repassword.value)
           return true;
        else
            { flag1=false;
            return false;}
    }else{
        flag1=false;
        return false;
    }
},param);
//验证邮箱
checkdata(email,"e",function(){
    if(e.test(email.value))
        {
        return true;
        }
    else{
        flag1=false;
        return false;
    }
},param); 

//验证手机号
checkdata(phone,"ph",function(){
    if(ph.test(phone.value))
        {
        return true;
        }
    else{
        flag1=false;
        return false;
    }
},param); 
//验证地址
checkdata(address,"a",function(){
    if(address.value!=null&&address.value!="")
        {
        return true;
        }
    else{
        flag1=false;
        return false;
    }
},param); 
//验证公司
checkdata(company,"c",function(){
    if(company.value!=null&&company.value!="")
        {
        return true;
        }
    else{
        flag1=false;
        return false;
    }
},param); 
return flag1&flag2;
}
function checkdata(obj,info,fun,param)
{   
     
       obj.onblur = function(){
           var sname1=info+"succ";
           var sname2=info+"fail";
           var span1=document.getElementById(sname1);
           var span2=document.getElementById(sname2);
           if(fun()){
               span2.style.display="none";
                span1.style.display="block";
          }
            else{
                 span1.style.display="none";
                 span2.style.display="block";
         }
    }
       if(param=='p')
        {
           obj.onblur();
        }
}

function loginSubmit() {
    var lousername=$("#lousername").val();
    var lopassword=$("#lopassword").val();
    var pwdsign=document.getElementById("pwdsign");
     var usersign=document.getElementById("usersign");
     var rem=$("#rem").val();
    var flag=false;
      $.get("${path}/user/login?lousername="+lousername+"&lopassword="+lopassword+"&rem="+rem,function(data) {
          if(data[0]==0){
              pwdsign.style.display="none";
              usersign.style.display="block";
              return false;
          }else if(data[0]==1){
              usersign.style.display="none";
              pwdsign.style.display="block";
              return false;
          }else{
              flag=true;
          window.location="/springmvc_new/index"
          }
      });
    return flag;
}
</script> 
