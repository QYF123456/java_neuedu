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
<form action="InsertProductServlet" method="post">
<table>
	<!-- <tr>
	<td>商品id</td>
	<td><input type="text" name="id"> </td>
	</tr> -->
	<tr>
		<td>分类编号</td>
		<td>
		<select name="category_id">
		<c:forEach items="${sec }" var="ser">
		<option >${ser.id} </option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>商品名称</td>
		<td><input type="text" name="name"> </td>
	</tr>
	<tr>
	<td>商品副标题</td>
	<td><input type="text" name="subtitle"> </td>
	</tr>
	<tr>
		<td>商品主图</td>
		<td><input type="text" name="main_image"> </td>
	</tr>
	<tr>
		<td>图片地址</td>
		<td><input type="text" name="sub_images"> </td>
	</tr>
	<tr>
		<td>商品详情</td>
		<td><input type="text" name="detail"> </td>
	</tr>
	<tr>
		<td>价格</td>
		<td><input type="text" name="price"> </td>
	</tr>
	<tr>
		<td>库存数量</td>
		<td><input type="text" name="stock"> </td>
	</tr>
	<tr>
		<td>商品状态</td>
		<td>
		<select name="status">
		<option>0</option>
		<option>1</option>
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