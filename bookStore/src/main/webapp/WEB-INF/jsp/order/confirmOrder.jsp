<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${path}/css/login.css">
<link type="text/css" rel="stylesheet" href="${path}/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/cart.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/order_list.css" />
<title></title>
</head>
<body onload="doSubmit2()">
 <div id="nav">
 <%@include file="../common/nav.jsp" %>
 </div>
 <!--购物车 begin-->
        <!--外层div-->
        <div class="container">
            <!--左边-->
            <div class="col-md-8 col-sm-12">
                <ol class="breadcrumb">
                    <li>
                        <a href="#" class="text-success"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;送货地址</a>
                    </li>
                </ol>
                
                <!--送货地址  begin-->
                <div style="margin-bottom: 5px;" id="addrDiv">
                    <ul class="list-group" id="address">
                    <c:forEach items="${adds}" var="a">
                        <li class="list-group-item"><input type="radio" name="addr" value="${a.addressId}" <c:if test="${a.isDefault=='是'}">checked</c:if>>&nbsp;${a.detailAddress}&nbsp;&nbsp;<c:if test="${a.isDefault=='是'}"><span class="text-success" id="dftaddr">默认地址</span></c:if> </li>
                   </c:forEach>
                    </ul>
                    <a href="#" class="text-info" onclick="dispalyMoreAddr(this)">更多地址↓&nbsp;&nbsp;</a>
                    <a href="javascript:void(0)" id="addAddr" class="text-success" data-toggle="modal" data-target="#myModal">添加新地址</a>
                </div>
                <hr>
                
                
                <!--添加新地址模态框 begin-->
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">
                                    <span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;添加新收货地址
                                </h4>
                            </div>
                            <div class="modal-body">
                            <!--登录的form表单-->
                            <form action="" class="form-horizontal" id="f" role="form">
                                <div class="form-group">
                                    <label class="col-md-2 control-label" style="margin-right: 2.9%;">所在地区:</label>
                                        
                                    <div data-toggle="distpicker">
                                        <div class="form-group col-sm-12 col-md-3">
                                          <label class="sr-only" for="province1">Province</label>
                                          <select class="form-control" id="province1"></select>
                                        </div>
                                        <div class="form-group col-sm-12 col-md-3">
                                          <label class="sr-only" for="city1">City</label>
                                          <select class="form-control" id="city1"></select>
                                        </div>
                                        <div class="form-group col-sm-12 col-md-3">
                                          <label class="sr-only" for="district1">District</label>
                                          <select class="form-control" id="district1"></select>
                                        </div>
                                     </div>
                                </div>
                                <div class="form-group has-feedback" style="clear:both">
                                    <label for="lastname" class="col-sm-2 control-label">详细地址:</label>
                                    <div class="col-sm-5">
                                        <textarea class="form-control" id="details"></textarea>
                                    </div>
                                    
                                </div>
                                <div class="form-group has-feedback">
                                    <label class="col-sm-2 control-label">邮政编码</label>
                                    <div class="col-md-5">
                                        <input type="text" class="form-control" id="emailcode" placeholder="邮政编码">
                                        <span class="glyphicon glyphicon-hand-left form-control-feedback"></span>
                                 </div>
                                 <div class="col-sm-3" style="padding-top: 10px;">
                                        <span class="glyphicon glyphicon-ok text-success" style="display: none" id="ecsucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="ecfail"></span>
                                    
                                    </div>
                                </div>
    
                                <div class="form-group has-feedback">
                                    <label class="col-sm-2 control-label">姓名</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" id="reciver" placeholder="收货人姓名" style="border: red solid 1px">
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="col-sm-3" style="padding-top: 10px;">
                                        <span class="glyphicon glyphicon-ok text-success" style="display: none" id="unsucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="unfail"></span>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="col-sm-2 control-label">电话</label>
                                    <div class="col-sm-5">
                                        <input type="tel" class="form-control" id="tel" placeholder="合法手机格式">
                                        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                                   </div>
                                   <div class="col-sm-3" style="padding-top: 10px;">
                                        <span class="glyphicon glyphicon-ok text-success" style="display: none" id="tesucc"></span>
                                    <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="tefail"></span>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                      <div class="checkbox">
                                        <label>
                                          <input type="checkbox" id="setDefaultAddr" value="b"><span class="text-success">设置默认地址</span>
                                        </label>
                                      </div>
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" id="addrclose">关闭</button>
                                    <input type="button" class="btn btn-primary" value="提交地址" onclick="doSubmit2('p')">
                                </div>
                            </form>
                        <!--form结束-->
                        </div>
                    </div>
                <!-- /.modal-content -->
                </div>
            </div>
                <!--左边-->
                <ol class="breadcrumb">
                    <li>
                        <a href="#" class="text-success"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;结算清单</a>
                    </li>
                </ol>

                <!--购物车表格 begin-->
                <div class="table-responsive" id="imgDiv">
                    <table class="table table-hover table-striped" style="vertical-align:middle;">
                        <thead>
                            <tr class="text-success success">
                                <th>图书编号</th>
                                <th>图片</th>
                                <th>书名</th>
                                <th>单价</th>
                                <th>数量</th>
                                <th>合计</th>
                            </tr>
                        </thead>
                        <tbody id="tby">
                             <c:forEach items="${order.cart}" var="o">
                            <tr>
                                <input type="hidden" value="${o.itemId}">
                                <td >${o.book_isbn}</td>
                                <td><img src="${path}/img/${o.book_imgurl}"></td>
                                <td>${o.book_name}</td>
                                <td>${o.book_price}元</td>
                                <td>${o.count}</td>
                                <td><fmt:formatNumber type="number" 
            maxFractionDigits="3" value="${o.allPrice}"/></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="4"></td>
                                <td class="text-success">总价:</td>
                                <td class="text-success"><fmt:formatNumber type="number" 
            maxFractionDigits="3" value="${order.totalprice}"/>元</td>
                            </tr>
                            <tr style="background-color: white;">
                                <td>
                                    <a href="${path}/jsp/book/index.jsp" class="btn btn-info">&lt;&lt;继续购买</a>
                                </td>
                                <td colspan="4"></td>
                                <td>
                                    <a href="javascript:submitOrder()" class="btn btn-warning">提交订单</a>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <!--购物车 end-->
            </div>

            <!--右边-->
            <div class="col-md-4 col-sm-3 col-xs-8">
                <ol class="breadcrumb">
                    <li>
                        <a href="#" class="text-success"><span class="glyphicon glyphicon-shopping-cart "></span>我的购物车</a>
                    </li>
                    <li>
                        <a href="# ">${order.totalcount}个商品</a>
                    </li>
                    <li>
                        <a href="# ">$<fmt:formatNumber type="number" 
            maxFractionDigits="3" value="${order.totalprice}"/>元</a>
                    </li>
                </ol>

            <!--猜您喜欢-->
                <div>
                    <span class="text-info"><span class="glyphicon glyphicon-heart"></span><span style="font-size: 20px; ">&nbsp;&nbsp;猜您喜欢</span></span>
                    <div class="row" id="love">
                        <div class="wow fadeInRight animated">
                            <div class="thumbnail">
                                <a href="details.html"><img src="${path}/img/dongjian.jpg " style="height: 200px; " alt="通用的占位符缩略图 ">
                                <div class="caption ">
                                    <h3>洞见</h3>
                                </div>
                            </div>
                        </div>
                        <div class="wow fadeInRight animated">
                            <div class="thumbnail ">
                                <a href="details.html"><img src="${path}/img/tenxunchuan.jpg" style="height: 200px; " alt="通用的占位符缩略图 "></a>
                                <div class="caption ">
                                    <h3>腾讯传</h3>
                                </div>
                            </div>
                        </div>
                        <div class="wow fadeInRight animated">
                            <div class="thumbnail ">
                                <a href="details.html"><img src="${path}/img/taikong.jpg" style="height: 200px; " alt="通用的占位符缩略图 "></a>
                                <div class="caption ">
                                    <h3>太空</h3>
                                </div>
                            </div>
                        </div>
                        <div>
                            <ul class="pager">
                                <li>
                                    <a href="#" onclick="pageUp() ">&larr;上一页</a>
                                    <a href="#" onclick="pageDown() ">下一页 &rarr;</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--喜欢end-->
            </div>
        </div>

        <div class="container">
            <!--首页底部信息 begin-->
            <div class="container ">
                <div class="row ">
                    <div class="col-md-offset-2 col-md-8">
                        <div class="row ">
                            <div class="col-md-offset-2 col-md-2">
                                <img src="images/logo.png ">
                            </div>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-offset-2 col-md-10 ">
                                        <a href="http://www.sztzedu.com ">威思登软件科技有限公司&copy;所有</a>
                                    </div>
                                </div>
                                <div class="gap"></div>
                                <div class="row">
                                    <div class="col-md-offset-2 col-md-10 ">
                                        <span class="text-info ">天智教育&reg; |&nbsp;</span>
                                        <span class="text-info ">项目实训管理平台 |&nbsp;</span>
                                        <span class="text-info ">2012－2020 </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script type="text/javascript" src="${path}/js/handler.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${path}/js/moment.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="${path}/js/date.js"></script>
    <script type="text/javascript" src="${path}/js/wow.js"></script>
    <script src="${path}/dist/js/distpicker.data.min.js"></script>
        <script src="${path}/dist/js/distpicker.min.js"></script>
    <script src="${path}/js/cart.js" type="text/javascript" charset="utf-8"></script>
    <script src="${path}/js/confirm_order.js"></script>
     <script type="text/javascript">

    $(function() {
        $("#nav").load("${path}/book/nav");
    });
    if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
        new WOW().init();
    };
    
    //添加地址验证
var reciver=document.getElementById("reciver");
var tel=document.getElementById("tel");
var emailcode=document.getElementById("emailcode");
var province=document.getElementById("province1");
var city=document.getElementById("city1");
var district=document.getElementById("district1");
var details=document.getElementById("details");
var isDefault=document.getElementById("setDefaultAddr");
var def="";
var addr=document.getElementById("address");
var close=document.getElementById("addrclose");
var ph=/^1[34578][0-9]{9}$/;
var em=/^[0-9]\d{5}$/;
var flag1=false;
 function doSubmit2(param) {
	 
      if(isDefault.checked)
    	  def="是";
      else
    	  def="否"
	 
//验证手机号
checkdata(tel,"te",function(){
    if(ph.test(tel.value))
        {
    	flag1=true;
        return true;
        }
    else{
        flag1=false;
        return false;
    }
},param); 
//验证收件人 
checkdata(reciver,"un",function(){
    if(reciver.value!=null&&reciver.value!="")
        {
    	flag1=true;
        return true;
        }
    else{
        flag1=false;
        return false;
    }
},param); 
//验证邮编
checkdata(emailcode,"ec",function(){
	  if(em.test(emailcode.value))
        {
		flag1=true;
        return true;
        }
    else{
        flag1=false;
        return false;
    }
},param);
  if(flag1){

	  var xmlhttp=new XMLHttpRequest();
	    xmlhttp.onreadystatechange= function () {
	           if(xmlhttp.readyState==4)
	               {
	               if(xmlhttp.status==200){
	               var s=xmlhttp.responseText.split(":");
            	   var li=document.createElement("li");
            	   li.className="list-group-item";
            	   if(s[0]=="0"){
            		var dft=document.getElementById("dftaddr");
            		if(dft!=null)
            		dft.parentNode.removeChild(dft);
            	   li.innerHTML="<input type='radio' name='addr' value='"+s[1]+"' checked>&nbsp;"+details.value+"&nbsp;&nbsp;<span class='text-success' id='dftaddr'>默认地址</span>";
            	   }
            	   if(s[0]=="1"){
                   li.innerHTML="<input type='radio' name='addr' value='"+s[1]+"'>&nbsp;"+details.value+"&nbsp;&nbsp;";
            	   }
            	    addr.appendChild(li);  
	                 }
	                }
	    }
	      xmlhttp.open("get","${path}/address/add?p="+province.value+"&c="+city.value+"&d="+district.value+"&details="+details.value+"&emailcode="+emailcode.value+"&reciver="+reciver.value+"&phone="+tel.value+"&isDefault="+def,true);
	      xmlhttp.send();
	      close.click();
	/*       $(function(){
	            $("#myModal").on("hide.bs.modal",function(){
	                $('#f')[0].reset(); //重置表单
	                $(this).find("label.error").remove(); //去掉错误提示
	            })
	        }) */
  }
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

function submitOrder(){
	var uaddr=document.getElementsByName("addr");
	if(uaddr!=null&&uaddr.length>0){
	for(var i=0;i<uaddr.length;i++)
		{
		  if(uaddr[i].checked)
			  window.location="/BookStore/myorder/submit?addrId="+uaddr[i].value;
		}
	}
}
    </script> 
</body>
</html>