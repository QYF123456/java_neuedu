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
<h1>${user.username}的订单</h1>
<table border="1"cellspacing="0px" cellpadding="10px">
	<tr>
		<td><input type="checkbox"></td>
		<td>主键id</td>
		<td>订单编号</td>
		<td>用户姓名</td>
		<td>地址名称</td>
		<td>付款金额</td>
		<td>支付类型</td>
		<td>运费</td>
		<td>订单状态</td>
		<td>支付时间</td>
		<td>发货时间</td>
		<td>交易完成时间</td>
		<td>交易关闭时间</td>
		<td>创建时间</td>
		<td>更新时间</td>
	</tr>
	<c:forEach items="${pageModel.data}" var="pageModel">
	<tr>
	<td><input type="checkbox" value="${pageModel.id }"></td>
		<td>${pageModel.id }</td>
		<td>${pageModel.order_no }</td>
		<td>${pageModel.user.username }</td>
		<td>${pageModel.address.receiver_name }</td>
		<td>${pageModel.payment }</td>
		<td>${pageModel.payment_type }</td>
		<td>${pageModel.postage }</td>
		<td>${pageModel.status }</td>
		<td>${pageModel.payment_time }</td>
		<td>${pageModel.send_time }</td>
		<td>${pageModel._end_time }</td>
		<td>${pageModel._close_time }</td>
		<td>${pageModel._create_time }</td>
		<td>${pageModel._update_time }</td>
		<td><a href="">删除</a></td>
	</tr>
	</c:forEach>
</table>
<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a href="UserorderServlet?pageNo=${pageNo}&operationtype=2&pageSize=1">${pageNo}</a>
      </c:forEach>
</body>
</html>