<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
    <div><img alt="" src="../../img/bullet1.gif"><a href="#">${bookStyle.styleName}</a></div>
        <c:forEach items="${pageBean.datas}" var="d">
            <div class="col-xs-6 col-md-3">
                <div class="thumbnail" style="padding-left: 10px">
                <a href="${path}/book/detail?bookId=${d.bookId}" >
                     <img alt="" src="${path}/img/${d.imageUrl}">
                </a>
                     <h4>${d.bookName}</h4>
                     <div>价格:${d.oldPrice}元</div>
                     <div>作者:${d.author}</div><br>
                     <a href="${path}/book/detail?bookId=${d.bookId}">更多信息</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
       <nav aria-label="...">
  <ul class="pager">
    <li><a href="javascript:nextPage1(${pageBean.pageNow-1})" " class="glyphicon glyphicon-backward"> 上一页</a></li>&nbsp
    <li><a href="javascript:nextPage1(${pageBean.pageNow+1})" class="glyphicon glyphicon-forward"> 下一页</a></li>
  </ul>
</nav>
    </div>
 </div>
<!--     <script type="text/javascript">
      var count=1;
      function initDate1(param)
      {
    	  count=count+param;
    	  var xmlhttp=new XMLHttpRequest();
    	 xmlhttp.onreadystatechange = function(){
            if(xmlhttp.readyState==4 && xmlhttp.status==200){
            	var jasnStr = xmlhttp.responseText;
            	var books=JSON.parse(jasnStr);
            	var booklist=document.getElementById("book1");
            	var str= "<div class='container' style='margin-top: 30px'> <div class='row'><div><img src='../../img/bullet1.gif'><a href='#'>${bookStyle.styleName}</a></div>";
            	for(var i=0;i<books.length;i++){
            		str+="<div class='col-xs-6 col-md-3'><div class='thumbnail' style='padding-left: 10px'>";
            		str+="<a href='#' ><img src='${path}/img/"+books[i].imageUrl+"'></a>";
            		str+="<h3>"+books[i].bookName+"</h3>";
            		str+="<div>价格:"+books[i].oldPrice+"元&nbsp;&nbsp;作者:"+books[i].author+"</div><br>";
            		str+="<a href='#'>更多信息</a></div></div>";
            	}
            	str+="</div><div class='row'><nav aria-label='...'><ul class='pager'>";
             str+="<li><a href='javascript:initDate1(-1)' class='glyphicon glyphicon-backward'> 上一页</a></li>&nbsp";
             str+="<li><a href='javascript:initDate1(1)' class='glyphicon glyphicon-forward'> 下一页</a></li></ul></nav></div></div>";
            	booklist.innerHTML=str;
             }
            }
    	 xmlhttp.open("get","${path}/jingxuan/list?pageNowC="+count,true);
    	 xmlhttp.send();
      }
    
    </script> -->
</body>
</html>