<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<h1>收货地址</h1>
			<h2><a href="homeadd.jsp">添加收货地址</a> </h2>
			
			<table border="1"cellspacing="0px" cellpadding="10px">
				
				<tr>
					<td>id</td>
					<td>用户id</td>
					<td>收货人姓名</td>
					<td>收货人固定电话</td>
					<td>收货人移动电话</td>
					<td>省份</td>
					<td>城市</td>
					<td>区/县</td>
					<td>详细地址*</td>
					<td>邮政编码</td>
					<td>创建时间</td>
					<td>更新时间</td>
					<td>操作</td> 
				</tr>
				<c:forEach items="${qwe.data }" var="pageModel">
			<tr>
			<td>${pageModel.id} </td>
			<td>${pageModel.user_id }</td>
			<td>${pageModel.receiver_name}</td>
			<td>${pageModel.receiver_phone }</td>
			<td>${pageModel.receiver_mobile }</td>
			<td>${pageModel.receiver_provinc }</td>
			<td>${pageModel.receiver_city }</td>
			<td>${pageModel.receiver_district }</td>
			<td>${pageModel.receiver_address }</td>
			<td>${pageModel.receiver_zip }</td>
			<td>${pageModel.create_time }</td>
			<td>${pageModel.update_time}</td>
			<td><a href="DeleteAddressServlet?id=${pageModel.id }">删除</a> |<a href="UpdateAddrssServlet?id=${pageModel.id }">修改</a></td>
			</tr>
			</c:forEach>
			</table>
	<c:forEach  var="pageNo" begin="1" end="${qwe.totalPage}"  step="1">
     
      <a href="AddressServlet?pageNo=${pageNo}&user_id=${pageModel.user_id}">${pageNo}</a>
     
    </c:forEach>
</body>
</html>
