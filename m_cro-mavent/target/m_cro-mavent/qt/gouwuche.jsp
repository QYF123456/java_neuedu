<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${user.username}的购物车</h1>
<h3>一共${num }件商品</h3>
<table border="1"cellspacing="0px" cellpadding="10px">
	<tr>
		<td><input type="checkbox"></td>
		<td>主键id</td>
		<td>用户姓名</td>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>数量</td>
		<td>是否选择</td>
		<td>创建时间</td>
		<td>更新时间</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${qaq.data}" var="cart">
	<tr>
	<td><input type="checkbox" value="${cart.id }"></td>
		<td>${cart.id }</td>
		<td>${cart.user.username }</td>
		<td>${cart.product.name }</td>
		<td>${cart.product.price }</td>
		<td>${cart.quantity }</td>
		<td>${cart.checked }</td>
		<td>${cart.create_time }</td>
		<td>${cart.update_time }</td>
		<td><a href="DeleteCartServlet?id=${cart.id}">删除</a></td>
		<td>
		<form action="UpdateCartServlet" method="get">
		<input type="number" name="quantity" value="cart.quantity">
		<input type="submit" value="添加">
		</form>
		</td>
	</tr>
	</c:forEach>
</table>
<c:forEach var="pageNo" begin="1" end="${qaq.totalPage}"  step="1">
     
      <a href="SelectCartServlet?pageNo=${pageNo}&user_id=4">${pageNo}</a>
      </c:forEach>
</body>
</html>