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
    <div><img alt="" src=""${path}/dict/img/bullet1.gif"><a href="#">${bookStyle.styleName}</a></div>
        <c:forEach items="${pageBean.datas}" var="d">
            <div class="col-xs-6 col-md-3">
                <div class="thumbnail" style="padding-left: 10px">
                <a href="${path}/book/detail?bookId=${d.bookId}" >
                     <img alt="" src="${path}/dict/img/${d.imageUrl}">
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
    <li><a href="javascript:nextPage3(${pageBean.pageNow-1})"  class="glyphicon glyphicon-backward"> 上一页</a></li>&nbsp
    <li><a href="javascript:nextPage3(${pageBean.pageNow+1})" class="glyphicon glyphicon-forward"> 下一页</a></li>
  </ul>
</nav>
    </div>
 </div>
</body>
</html>