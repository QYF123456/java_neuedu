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
	<c:forEach items="${qauserorder.data}" var="userorder">
	<tr>
		<td>${userorder.id }</td>
		<td>${userorder.order_no }</td>
		<td>${userorder.user.username }</td>
		<td>${userorder.address.receiver_name }</td>
		<td>${userorder.payment }</td>
		<td>${userorder.payment_type }</td>
		<td>${userorder.postage }</td>
		<td>${userorder.status }</td>
		<td>${userorder.payment_time }</td>
		<td>${userorder.send_time }</td>
		<td>${userorder._end_time }</td>
		<td>${userorder._close_time }</td>
		<td>${userorder._create_time }</td>
		<td>${userorder._update_time }</td>
	</tr>
	</c:forEach>
</table>

<h2><a href="">订单明细</a> </h2>
	<table border="1"cellspacing="0px" cellpadding="10px">
		<tr>
			<td>主键id</td>
			<td>订单编号</td>
			<td>用户姓名</td>
			<td>商品名称</td>
			<td>商品图片</td>
			<td>商品金额</td>
			<td>商品数量</td>
			<td>商品总价</td>
			<td>创建时间</td>
			<td>更新时间</td>
		</tr>
		<c:forEach items="${ userorder_items}" var="userorder_items">
		<tr>
		<td>${userorder_items.item_id }</td>
		<td>${userorder_items.order_no }</td>
		<td>${userorder_items.user.username }</td>
		<td>${userorder_items.product_name }</td>
		<td>${userorder_items.product_image }</td>
		<td>${userorder_items.current_unit_price }</td>
		<td>${userorder_items.quantity }</td>
		<td>${userorder_items.total_price }</td>
		<td>${userorder_items.create_time }</td>
		<td>${userorder_items.update_time }</td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>