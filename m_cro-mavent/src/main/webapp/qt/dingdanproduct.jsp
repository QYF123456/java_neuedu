<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
			form>input{
				font-family: "微软雅黑";
				font-size: 20px;
				padding: 5px 15px;
			}
			form>select{
				font-family: "微软雅黑";
				font-size: 20px;
				height: 35px;
			}
			
		</style>
<title>Insert title here</title>
</head>
<body>
		<table border="1" cellspacing="0px" cellpadding="5px">
			<tr>
				<th>商品编号</th>
				<th>分类编号</th>
				<th>商品名称</th>
				<th>商品副标题</th>
				<th>商品主图</th>
				<th>图片地址</th>
				<th>商品详情</th>
				<th>价格</th>
				<th>库存数量</th>
				<th>商品状态</th>
				<th>创建时间</th>
				<th>更新时间</th>
			</tr>
			<c:forEach items="${qd }" var="products">
			<tr>
			<td>${products.id }</td>
			<td>${products.category_id }</td>
			<td>${products.name }</td>
			<td>${products.subtitle }</td>
			<td>${products.main_image }</td>
			<td>${products.sub_images }</td>
			<td>${products.detail }</td>
			<td>${products.price }</td>
			<td>${products.stock }</td>
			<td>${products.status }</td>
			<td>${products.create_time }</td>
			<td>${products.update_time }</td>
			
			</tr>
			</c:forEach>
		</table>
</body>
</html>