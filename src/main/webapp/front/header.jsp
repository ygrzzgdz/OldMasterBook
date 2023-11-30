<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/header.js"></script>
	<title>老夫子旧书网</title>
	<link type="text/css" rel="stylesheet" href="/css/style.css"/>
	<style type="text/css">
		span:hover {color: red;}
	</style>
	<script>
		function qudenglu() {
			window.location.href = "/front/login.jsp";
		}
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">老夫子旧书网</div>
	<div id="shuone"></div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li class="current" style="color: mediumvioletred">
					欢迎您,${username}
				</li>
				<li><a href="/front/main.jsp">首页</a></li>
				<li><a href="orders?action=findAll">我的订单</a></li>
				<li><a href="/showCart">购物车</a></li>
				<li><a href="/front/ranking.jsp">排行榜</a></li>
				<!--  页面鼠标点击的地方，就会发出一个请求 ，请求会从web.xml中找对应的url-pattern
                    如果找到了，就会找对应的的servlet-class,然后执行get/post功能
                    如果找不到就报404
                    500就是代码有错，400
                -->
				<li><a href="/users?action=loginout" id="cancel">注销</a></li>
			</ul>
		</div>
		<form id="chashu" method="post" name="search" action="findBookByQuery">
			<input type="hidden" id="pagenum2" name="pagenum" value="1"/>
			<span class="dhlys"> 类型:</span>
            <select name="cid" id="category">
                <option value="-1">--请选择--</option>
                <c:if test="${!empty types}">
                    <c:forEach items="${types}" var="t">
                        <option value="${t.cid}">${t.name}</option>
                    </c:forEach>
                </c:if>

            </select>
			<span class="dhlys"> 价格:</span>
			<input class="input-text" type="text" style="width: 35px;" name="minprice"
				   value="${page.queryMap.minprice}"/><font color="black">元-</font>
			<input class="input-text" type="text" style="width: 35px;" name="maxprice"
				   value="${page.queryMap.maxprice}"/><font color="black">元</font>
			<span class="dhlys"> 搜索：</span>
			<input class="input-text" type="text" name="keywords" value="${page.queryMap.name}"/>
			<input class="input-btn" type="submit" value=""/>
		</form>
	</div>
</div>