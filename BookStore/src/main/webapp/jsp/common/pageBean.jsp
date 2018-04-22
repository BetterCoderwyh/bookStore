<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 可能需要改变的. -->
<c:set var="queryUrl" value="${path}/book/list?bookName=${bookName}&styleId=${checksid}&pageSize=${pageBean.pageSize}"></c:set>

<div class="container" align="center">
	<ul class="pagination">
		<li><a href="${queryUrl}&pageNow=1">首页</a></li>
	    
	    <c:if test="${pageBean.pageNow<=1 }">
		    <li class="disabled"><a>&laquo;</a></li>
	    </c:if>
	    <c:if test="${pageBean.pageNow>1 }">
	    	 <li><a href="${queryUrl}&pageNow=${pageBean.pageNow-1}">&laquo;</a></li>
	    </c:if>	  
		
		<!-- 处理尾部 -->
		<c:if test="${pageBean.pageNow+4<pageBean.pageCounts }">
			<c:set var="endPage" value="${pageBean.pageNow+4}"></c:set>
			<c:set var="startPage" value="${pageBean.pageNow}"></c:set>
		</c:if>
		
		<c:if test="${pageBean.pageNow+4>=pageBean.pageCounts }">
			<c:set var="endPage" value="${pageBean.pageCounts }"></c:set>
			<c:set var="startPage" value="${pageBean.pageCounts-4}"></c:set>
		</c:if>
		
		<!-- 处理起始位置和结束位置 -->
		<c:forEach var="p" begin="${startPage<=0?1:startPage}" end="${endPage}">
			<c:if test="${pageBean.pageNow==p}">
				<li class="active"><a href="${queryUrl}&pageNow=${p}">${p}</a></li>
			</c:if>
			<c:if test="${pageBean.pageNow!=p }">
				<li><a href="${queryUrl}&pageNow=${p}">${p}</a></li>
			</c:if>
		</c:forEach>	   
	    
	    <!-- 判断是否到达尾页 -->
	    <c:if test="${pageBean.pageNow>=pageBean.pageCounts }">
	    	<li class="disabled"><a>&raquo;</a></li>
	    </c:if>
	    
	    <c:if test="${pageBean.pageNow<pageBean.pageCounts }">
	    	<li><a href="${queryUrl}&pageNow=${pageBean.pageNow+1}">&raquo;</a></li>
	    </c:if>
	    
	    <li><a href="${queryUrl }&pageNow=${pageBean.pageCounts}">尾页</a></li>
	    <li><a>当前页<span class="text-success">${pageBean.pageNow}</span>/<span class="text-danger">${pageBean.pageCounts}</span>总页</a><li>
	    <li>
			<div class="pull-left">
			    <form class="bs-example bs-example-form" role="form">
			        <div class="row">
			            <div class="col-md-8">
			                <div class="input-group">
			                    <input placeholder="跳转页" id="toPages" type="text" class="form-control">
			                    <span class="input-group-btn">
			                        <button class="btn btn-default" onclick="goPage()" type="button" >跳转页</button>
			                    </span>
			                </div>
			            </div>
			        </div>
			    </form>
			</div>
	    </li>
	    <li>   	
	    	<div class="pull-left">
	    		<form role="form">
					<div class="row">
						<div class="col-md-12">
							 <div class="form-group">
							    <select id="size" onchange="changeSize(this)" class="form-control">
							      <option value="-1">==显示条数==</option>
							      <option value="2" <c:if test="${pageBean.pageSize==2}">selected</c:if> >2</option>
							      <option value="4" <c:if test="${pageBean.pageSize==4}">selected</c:if>>4</option>
							      <option value="6" <c:if test="${pageBean.pageSize==6}">selected</c:if>>6</option>
							      <option value="8" <c:if test="${pageBean.pageSize==8}">selected</c:if>>8</option>
							      <option value="14" <c:if test="${pageBean.pageSize==14}">selected</c:if>>14</option>
							    </select>
					  		</div>
						</div>
					</div>
			</form>
	    	</div>
	    </li>
	</ul>
</div>