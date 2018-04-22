<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${path}/css/login.css">
<link type="text/css" rel="stylesheet" href="${path}/css/bootstrap-datetimepicker.min.css">
<title>图书商城首页</title>
</head>
<body onload="doSubmit()">
<div id="nav">
 <%@include file="../common/nav.jsp" %>
 </div>
 <div id="list" style="display: none">
 </div>
 <div id="book1">
 </div>
  <div id="book2">
 </div>
  <div id="book3">
 </div>
 
<%--  <%@ include file="../common/pageBean.jsp" %> --%>
	<script type="text/javascript" src="${path}/js/handler.js"></script>
	<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/js/moment.js"></script>
	<script type="text/javascript" src="${path}/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="${path}/js/date.js"></script>
    <script type="text/javascript">
    $(function() {
        $("#nav").load("${path}/book/nav");
    });
    $(function() {
        $("#book1").load("${path}/jingxuan/list");
    });
    $(function() {
        $("#book2").load("${path}/tuijian/list");
    });
    $(function() {
        $("#book3").load("${path}/tejia/list");
    });
    function nextPage1(param){
        $("#book1").load("${path}/jingxuan/list",{"pageNow":param});
    }
    function nextPage2(param){
        $("#book2").load("${path}/tuijian/list",{"pageNow":param});
    }
    function nextPage3(param){
        $("#book3").load("${path}/tejia/list",{"pageNow":param});
    }
    function booklist(styleId,bookName,pageSize,pageNow){
         bookName=document.getElementById("bookName").value;
        var book1=document.getElementById("book1");
        var book2=document.getElementById("book2");
        var book3=document.getElementById("book3");
        var list=document.getElementById("list");
        book1.style.display="none";
        book2.style.display="none";
        book3.style.display="none";
        $("#list").load("${path}/book/list",{"styleId":styleId,"bookName":bookName,"pageSize":pageSize,"pageNow":pageNow});
        list.style.display="block"; 
    }
    
    function booksearch(){
    	var bookName=document.getElementById("bookName").value;
    	var size=document.getElementById("size");
    	var pageSize=2;
    	var styleId="";
    	if(size!=null){
    		var options=size.getElementsByTagName("option");
    		for(var i=0;i<options.length;i++)
            {
              if(options[i].selected)
                  pageSize=options[i].value;
            }
    	}
    	var style=document.getElementById("bsid");
    	if(style!=null)
    		{
    		styleId=style.value;
    		}
    	booklist(styleId,bookName,pageSize,1);
    }
    function goPage(styleId,bookName,pageSize)
    {
           //1.获取跳转框中的数据
        var v = document.getElementById("toPages").value;
        
        //2.进行参数有效性判断..判断输入的数据是一个整数
        var regex = /^[0-9]+$/;
        
        if(!regex.test(v)){
            alert("输入的数据不合法!");
            return;
        }
        booklist(styleId,bookName,pageSize,v);
    }
    function changeSize(styleId,bookName,obj,pageNow) {
        alert(obj.value);
        booklist(styleId,bookName,obj.value,pageNow);
    }

</script> 
</body>
</html>
