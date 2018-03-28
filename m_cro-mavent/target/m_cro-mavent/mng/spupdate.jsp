<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateProductServlet" method="post">
<table>
	<tr>
	<td>商品id</td>
		<td><input type="text" name="id" value="${was.id}" readonly="readonly"> </td>
	</tr>
	<tr>
		<td>分类编号</td>
		<td>
		<select name="category_id">
		<c:forEach items="${wqa }" var="pl">
		<option value="${was.category_id }">${pl.category_id} </option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>商品名称</td>
		<td><input type="text" name="name" value="${was.name}"> </td>
	</tr>
	<tr>
	<td>商品副标题</td>
	<td><input type="text" name="subtitle" value="${was.subtitle}"> </td>
	</tr>
	<tr>
		<td>商品主图</td>
		<td><input type="text" name="main_image" value="${was.main_image }"> </td>
	</tr>
	<tr>
		<td>图片地址</td>
		<td><input type="text" name="sub_images" value="${was.sub_images }"> </td>
	</tr>
	<tr>
		<td>商品详情</td>
		<td><input type="text" name="detail" value="${was.detail }"> </td>
	</tr>
	<tr>
		<td>价格</td>
		<td><input type="text" name="price" value="${was.price }"> </td>
	</tr>
	<tr>
		<td>库存数量</td>
		<td><input type="text" name="stock" value="${was.stock }"> </td>
	</tr>
	<tr>
		<td>商品状态</td>
		<td>
		<select name="status">
		<c:forEach items="${wqa }" var="pl">
		<option value="${was.status }">${pl.status} </option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="提交"> </td>
	</tr>
</table>
</form>
</body>
</html>