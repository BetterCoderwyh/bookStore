<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container" style="margin-top: 10px;">
	<nav class="navbar navbar-default well-sm">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">图书商城</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${path}/index">首页<span
							class="sr-only">(current)</span></a></li>
					<c:if test="${empty user}">
						<li><a href="#" data-toggle="modal" data-target="#login">登录 </a></li>
					</c:if>
					<%-- <li><a href="${path}/register/register2.jsp">注册</a></li> --%>
					<li><a href="${path}/register">注册</a></li>
                        <%@ include file="../user/myModal.jsp" %>
					<c:if test="${!empty user}">
						<li><a href="#">${user.userName}</a></li>
						<li><a href="${path}/user/exit">安全退出</a></li>
						</c:if>
					<c:if test="${!empty user }">
					<li><a href="${path}/order/list">我的订单</a></li>
					<li><a href="${path}/mycart"><span class="glyphicon glyphicon-shopping-cart"></span>我的购物车</a></li>
					</c:if>
					   <li class="dropdown">
					   <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                        aria-haspopup="true" aria-expanded="true" id="style"> 图书类型
                                 <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                            <c:forEach items="${bookStyles}" var="s">
                                <li><a href="javascript:booklist(${s.bookStyleId},'${bookName}','${pageBean.pageSize}','${pageBean.pageNow}')">${s.styleName}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
				</ul>
				<form class="navbar-form navbar-right" role="search" action="#">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入图书名"
							name="bookName" id="bookName" value="${bookName}">
	                <input type="hidden" value="${checksid}" name="styleId" id="styleId">
	                <input type="hidden" value="${pageBean.pageSize}" name="pageSize">
					</div>
					<button type="button" class="btn btn-default" onclick="javascript:booksearch('${bookName}')">Submit</button>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>
<div class="container" style="margin-bottom: 20px">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
  <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
           <div class="item active">
              <img src="${path}/dict/img/advert1.jpg" alt="...">
                  <div class="carousel-caption">
                 ... 
                  </div>
            </div>
           <div class="item">
              <img src="${path}/dict/img/advert2.jpg" alt="...">
                  <div class="carousel-caption">
                ...
                  </div>
            </div>
           <div class="item">
              <img src="${path}/dict/img/advert3.jpg" alt="...">
                  <div class="carousel-caption">
                ...
                 </div>
                </div>
           </div>
  <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                     <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                     <span class="sr-only">Next</span>
                </a>
        </div>
 </div>