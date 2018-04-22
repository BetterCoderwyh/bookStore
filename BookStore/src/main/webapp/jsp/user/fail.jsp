<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>注册失败</title>


</head>
<body bgcolor="#F4F6F6" onLoad="countdown();">
<span id="showtime"></span>
注册失败.......请重新注册

<script type="text/javascript">
var count = 5;//记数器
var showtime=document.getElementById("showtime");
function countdown()
{ 
count--;
showtime.innerText=count+" 秒后自动返回 ...";

if(count == 1)
{
window.location.href="../book/index.jsp";
}

if(document.layers)
{   
document.layers.showtime.document.write(count);   
document.layers.showtime.document.close();   
}   
else if(document.all)
{
showtime.innerText=count+" 秒后自动返回 ...";
}

setTimeout("countdown()",1000);   
}   
</script>
</body>
</html>