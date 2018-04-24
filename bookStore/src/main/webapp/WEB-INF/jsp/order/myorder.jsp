<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${path}/css/login.css">
<link type="text/css" rel="stylesheet" href="${path}/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/animate.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/order_list.css"/>
<title></title>
</head>
<body>
 <div id="nav">
 <%@include file="../common/nav.jsp" %>
 </div>
 
<!--订单begin-->
        <!--外层div-->
        <div class="container">
            <!--左边-->
            <div class="container pull-left">
                <ol class="breadcrumb">
                    <li>
                        <a href="#" class="text-success"><span class="glyphicon glyphicon-list"></span>&nbsp;&nbsp;我的订单</a>
                    </li>
                </ol>

                <!--订单查询导航 begin-->
                <div>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">所有订单</a>
                        </div>

                        <form class="navbar-form navbar-left" role="search">
                            <input type="text" class="form-control" placeholder="输入订单号进行查询">
                            <button type="button" class="btn btn-search">
                                <span class="text-success">Search</span>&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></span>
                            </button>
                        </form>

                        <ul class="nav navbar-nav navbar-left">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    交易状态
                                    <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">全部</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">已付款</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">未付款</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">交易成功</a>
                                    </li>
                                    <li class="divider"></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-left">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    订单排序
                                    <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">订单日期降序</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">订单日期升序</a>
                                    </li>
                                    <li class="divider"></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li style="padding-right: 15px;">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">更多筛选条件</a>
                            </li>
                        </ul>
                        
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="javascript:deleteorder()">删除订单</a>
                            </li>
                        </ul>
                            <ul class="nav navbar-nav">
                            <li>
                                <a href="javascript:clearorder()">清空订单列表</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                
                <!--订单查询导航 end-->
                <!--日期控件-->
                <div id="collapseTwo" class="panel-collapse collapse">
                    <div class="panel-body">
                        <div class="form-group">    
                            <div>
                                <form class="form-horizontal">
                                    <div class="form-group has-feedback">
                                        <div class="col-md-1" style="padding-top:5px ;">
                                            成交日期:
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" class="form-control" id="datetimepicker" placeholder="开始时间">
                                            <span class="glyphicon glyphicon-time form-control-feedback"></span>
                                        </div>
                                        <div class="col-md-1" style="padding-top:5px ;text-align:center;">
                                            至
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" class="form-control" id="datetimepicker2" placeholder="结束日期">
                                            <span class="glyphicon glyphicon-time form-control-feedback"></span>
                                        </div>
                                        <div class="col-md-3">
                                            <button type="button" class="btn btn-default">查询&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!--日期控件-->
                
                <!--内容展示 begin-->
                <div class="table-responsive" id="tablebody">
                <c:forEach items="${pageOrder.datas}" var="o">
                  <table class="table table-hover table-striped">
                    <caption class="text-info">
                        <div class="col-md-10" style="padding-left: 0px;">
                            <input type="checkbox" name="cks" value="${o.orderId}">&nbsp;${o.createDate}  订单号:${o.orderNum}单
                        </div>
                        <div class="col-md-2" style="text-align: right;">
                            <a data-toggle="collapse" data-parent="#accordion" href="#${o.orderId}">订单详情</a>
                        </div>
                    </caption>
                    <thead>
                        <tr id="${o.orderId}" class="panel-collapse collapse">
                            <td colspan="9">
                            <div class="panel-body">
                                <!--tab选项卡 begin-->
                                <ul id="myTab" class="nav nav-tabs">
                                    <li class="active">
                                        <a href="#home${o.orderId}" data-toggle="tab">
                                            联系人信息
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#ios${o.orderId}" data-toggle="tab">订单信息</a>
                                    </li>
                                </ul>
                                <div id="myTabContent" class="tab-content">
                                    <div class="tab-pane fade in active" id="home${o.orderId}">
                                        <div class="row">
                                            <div>
                                                <ul class="nav navbar-collapse" style="line-height: 3;>
                                                    <li class="text-info"><span class="text-success">姓名:</span><span class="text-info">${o.address.reciver}</span></li>
                                                    <li class="text-info"><span class="text-success">联系方式:</span> ${o.address.tel}</li>
                                                    <li class="text-info"><span class="text-success">收货地址:</span>${o.address.detailAddress}</li>
                                                </ul>
                                            </div>
                                        </div>
                                        </p>
                                    </div>
                                    <div class="tab-pane fade" id="ios${o.orderId}">
                                        <div class="row">
                                            <div>
                                                <ul class="nav navbar-collapse" style="line-height: 3;>
                                                    <li class="text-info"><span class="text-success">订单编号:</span><span class="text-info">${o.orderNum}</span></li>
                                                    <li class="text-info"><span class="text-success">交易时间:</span>${o.createDate}</li>
                                                    <li class="text-info"><span class="text-success">订单总金额:</span>520.0元</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--tab选项卡 end-->   
                            </td>
                        </tr>
                        <tr class="active">
                            <th>图书编号</th>
                            <th>图片</th>
                            <th>图片名称</th>
                            <th>单价(元)</th>
                            <th>数量</th>
                            <th>实付款(元)</th>
                            <th>付款日期</th>
                            <th>交易状态</th>
                        </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${o.items}" var="i">
                      <tr class="warning">
                        <td>${i.book_isbn}</td>
                        <td><img src="${path}/img/${i.book_imgurl}"></td>
                        <td>${i.book_name}</td>
                        <td>${i.book_price}</td>
                        <td>${i.count}</td>
                        <td>${i.allPrice}</td>
                        <td>01/08/2017</td>
                        <td>${o.orderStatus}</td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                  </c:forEach>
                </div>
                <!--内容展示end-->
            </div>
            <!--分页begin-->
     <c:set var="queryUrl" value="${path}/myorder/list?pageSize=${pageOrder.pageSize}"></c:set>
<div class="container" align="center">
    <ul class="pagination">
        <li><a href="${queryUrl}&pageNow=1">首页</a></li>
        
        <c:if test="${pageOrder.pageNow<=1 }">
            <li class="disabled"><a>&laquo;</a></li>
        </c:if>
        <c:if test="${pageOrder.pageNow>1 }">
             <li><a href="${queryUrl}&pageNow=${pageBean.pageNow-1}">&laquo;</a></li>
        </c:if>   
        
        <!-- 处理尾部 -->
        <c:if test="${pageOrder.pageNow+4<pageOrder.pageCounts }">
            <c:set var="endPage" value="${pageOrder.pageNow+4}"></c:set>
            <c:set var="startPage" value="${pageOrder.pageNow}"></c:set>
        </c:if>
        
        <c:if test="${pageOrder.pageNow+4>=pageOrder.pageCounts }">
            <c:set var="endPage" value="${pageOrder.pageCounts }"></c:set>
            <c:set var="startPage" value="${pageOrder.pageCounts-4}"></c:set>
        </c:if>
        
        <!-- 处理起始位置和结束位置 -->
        <c:forEach var="p" begin="${startPage<=0?1:startPage}" end="${endPage}">
            <c:if test="${pageOrder.pageNow==p}">
                <li class="active"><a href="${queryUrl}&pageNow=${p}">${p}</a></li>
            </c:if>
            <c:if test="${pageOrder.pageNow!=p }">
                <li><a href="${queryUrl}&pageNow=${p}">${p}</a></li>
            </c:if>
        </c:forEach>       
        
        <!-- 判断是否到达尾页 -->
        <c:if test="${pageOrder.pageNow>=pageOrder.pageCounts }">
            <li class="disabled"><a>&raquo;</a></li>
        </c:if>
        
        <c:if test="${pageOrder.pageNow<pageOrder.pageCounts }">
            <li><a href="${queryUrl}&pageNow=${pageOrder.pageNow+1}">&raquo;</a></li>
        </c:if>
        
        <li><a href="${queryUrl }&pageNow=${pageOrder.pageCounts}">尾页</a></li>
        <li><a>当前页<span class="text-success">${pageOrder.pageNow}</span>/<span class="text-danger">${pageOrder.pageCounts}</span>总页</a><li>
        <li>
            <div class="pull-left">
                <form class="bs-example bs-example-form" role="form">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="input-group">
                                <input placeholder="跳转页" id="toPages" type="text" class="form-control" >
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
                                  <option value="2" <c:if test="${pageOrder.pageSize==2}">selected</c:if> >2</option>
                                  <option value="4" <c:if test="${pageOrder.pageSize==4}">selected</c:if>>4</option>
                                  <option value="6" <c:if test="${pageOrder.pageSize==6}">selected</c:if>>6</option>
                                  <option value="8" <c:if test="${pageOrder.pageSize==8}">selected</c:if>>8</option>
                                  <option value="14" <c:if test="${pageOrder.pageSize==14}">selected</c:if>>14</option>
                                </select>
                            </div>
                        </div>
                    </div>
            </form>
            </div>
        </li>
    </ul>
</div>
            <!--分页end-->
        </div>
        <div class="container">
        <hr>
            <!--首页底部信息 begin-->
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div class="row">
                            <div class="col-md-offset-2 col-md-2">
                                <img src="${path}/img/logo.png">
                            </div>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-offset-2 col-md-10">
                                        <a href="http://www.sztzedu.com">威思登软件科技有限公司&copy;所有</a>
                                    </div>
                                </div>
                                <div class="gap"></div>
                                <div class="row">
                                    <div class="col-md-offset-2 col-md-10">
                                        <span class="text-info">天智教育&reg; |&nbsp;</span>
                                        <span class="text-info">项目实训管理平台 |&nbsp;</span>
                                        <span class="text-info">2012－2020 </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--end-->
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
    var cks = document.getElementsByName("cks");
    var tby = document.getElementById("tablebody");
    function deleteorder()
    {
    var str="";
    var count="";
    for(var i=cks.length-1;i>=0;i--){
        if(cks[i].checked){
            count+=i+":";
            str+=cks[i].value+":";
        }
    }
       var xmlhttp=new XMLHttpRequest();
        xmlhttp.onreadystatechange= function () {
          if(xmlhttp.readyState==4)
              {
               if(xmlhttp.status==200){
                var result=xmlhttp.responseText;
                if(result!=null&&result.length>0)
                {
                 var s=result.split(":");
                 for(var i=0;i<s.length;i++){
                    tby.removeChild(cks[s[i]].parentNode.parentNode.parentNode);
                 }
                }
                         }
                        }
            }
              xmlhttp.open("get","/BookStore/myorder/handler/delete?orderIds="+str.substring(0,str.length-1)+"&count="+count,true);
              xmlhttp.send();
    }
    
        
        function clearorder(){
         var xmlhttp=new XMLHttpRequest();
        xmlhttp.onreadystatechange= function () {
          if(xmlhttp.readyState==4)
              {
               if(xmlhttp.status==200){
                var result=xmlhttp.responseText;
                if(result=="1")
                {
                     for(var i=cks.length-1;i>=0;i--){
                      tby.removeChild(cks[i].parentNode.parentNode.parentNode);
                    } 
                }
                
                }
             }
             }
              xmlhttp.open("get","/BookStore/myorder/handler/clear",true);
              xmlhttp.send();
    }
    </script> 
</body>
</html>