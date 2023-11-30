<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="header.jsp"%>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="/payServlet">
			<table>

				<tr class="title">
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
					<th class="nums">操作</th>
				</tr>


			</table>


			<input type="hidden" id="count" name="count" value="2"/>
			<div class="button">
				<h4>总价：￥<span id="total_price">##</span>元</h4>
				<input type="hidden" id="hidden_total_price" name="hidden_total_price" value="${totalprice}"/>
				<input class="input-chart"  id="goumai" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
</body>
<div id="footer" class="wrap">
	老夫子旧书网< &copy;版权所有
</div>
</html>
