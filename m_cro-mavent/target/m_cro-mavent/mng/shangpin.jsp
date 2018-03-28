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
	<a href="InsertProductServlet">添加</a>
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
			<c:forEach items="${pageModel.data }" var="qa">
			<tr>
			<td>${qa.id }</td>
			<td>${qa.category_id }</td>
			<td>${qa.name }</td>
			<td>${qa.subtitle }</td>
			<td>${qa.main_image }</td>
			<td>${qa.sub_images }</td>
			<td>${qa.detail }</td>
			<td>${qa.price }</td>
			<td>${qa.stock }</td>
			<td>${qa.status }</td>
			<td>${qa.create_time }</td> 
			<td>${qa.update_time }</td>
			<td><a href="DeleteProductServlet?id=${qa.id }">删除</a> |<a href="UpdateProductServlet?id=${qa.id }">修改</a></td>
			</tr>
			</c:forEach>
		</table>
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a href="PageProduct?pageNo=${pageNo}&value=1">${pageNo}</a>
     
    </c:forEach>
</body>
</html>