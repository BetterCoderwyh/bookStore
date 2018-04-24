     var username=document.getElementById("reusername");
     var password=document.getElementById("repassword");
     var repassword=document.getElementById("repwd");
     var email=document.getElementById("reemail");
     var phone=document.getElementById("rephone");
     var company=document.getElementById("recompany");
     var address=document.getElementById("readdress");
      function doSubmit(param) {
         var u=/^[a-zA-Z][a-zA-Z0-9]*$/;
         var p=/^[0-9]+$/;
         var flag=true;
         var flag2=true;
         
         //用户名是否存在的验证
         checkdata(username,info,function(){
             if(u.test(username.value))
                 {
            	 var xmlhttp=new XMLHttpRequest();
                 xmlhttp.onreadystatechange= function () {
                        if(xmlhttp.readyState==4)
                            {
                            if(xmlhttp.status==200){
                            var s=xmlhttp.responseText;
                            if(s=="0"){
                            	info="usucc";
                            }if(s=="1"){
                            	info="ufail";
                            	flag2=false;
                            	return false;
                            }
                            }
                    }
                   xmlhttp.open("get","${path}/register/verify?username="+username.value,true);
                   xmlhttp.send();
                    return true;
                 }
                 }
             else {
                 flag=false;
                 return false;
             }
         },param);
//           checkdata(password,info1,info2,function(){
//               if(pptn.test(password.value))
//                   {
//                      return true;
//                   }
//               else{
//                   flag=false;
//                   return false;
//               }
//           },param);
           
           
           
           
           return flag&flag2;
           } 
     function checkdata(obj,info,fun,param){
         var span=getSpan(obj);
         var span2=getSpan(span);
         obj.onblur =function (){
        	 var span=document.getElementById(info);
        	 span.style.display="block";
             }
         if(param=='p'){
             obj.onblur();
         }
     }
  