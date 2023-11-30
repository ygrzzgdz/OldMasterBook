<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String base = request.getContextPath()+"/";
    String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+base;
%>
<base href="<%=url%>">
<%@include file="header.jsp"%>
<script src="../js/page.js"></script>
<div id="content" class="wrap">
    <div class="list bookList">		<!-- 发起请求的地方  找web.xml -->
        <form method="post" name="shoping" action="/addItems">
            <table cellpadding="0" border="1"  cellspacing="0" >
                <tr class="title">
                    <th class="checker"></th>
                    <th>书名</th>
                    <th class="price">价格</th>
                    <th class="store">库存</th>
                    <th class="view">图片预览</th>
                </tr>
                <c:if test="${!empty books}">
                    <c:forEach items="${books}" var="b">
                        <tr >
                            <td ></td>
                            <td>${b.name}</td>
                            <td >${b.price}</td>
                            <td >${b.stock}</td>
                            <td ><img src="${b.image}"></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>

            <div class="page-spliter">

                <a class="abq">首页</a>
                <a class="abq" id="pre" onclick="changePage('-')">上一页</a>

                第<input id="currentPage"  style="height: 20px;width: 20px" value="${currentPage}" >页/<a id="countPage">${count}</a>页
                <a class="abq" id="next" onclick="changePage('+')">下一页</a>
                <a class="abq">尾页</a>


            </div>

            <div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
        </form>
    </div>
</div>
<div id="footer" class="wrap">
    老夫子旧书网&copy;版权所有
</div>
</body>
</html>