<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%
     String path = request.getContextPath();
     String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path +"/";
 %>
<!DOCTYPE html>
<html>
<head>
<base href = "<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<style type="text/css">
			form{
				font-family: "微软雅黑";
				font-size: 30px;
			}
			select{
				font-family: "微软雅黑";
				font-size: 18px;
				margin-right: 35px;
				margin-bottom: 15px;
			}
			input{
				height: 40px;
				font-size: 28px;
			}
			table{
				width:1300px;
				height: 50px;
			}
			th:nth-child(2){
				width: 160px;
			}
			th:nth-last-child(3){
				width: 200px;
			}
		</style>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function sendRequest(url){
		var src=document.createElement("script");
		src.setAttribute("src",url);
		src.setAttribute("type","text/javascript");
		document.getElementsByTagName("body")[0].appendChild(src);
	}
	
function find() {
	var qa=$("input[type='text']").val();
	//alert(qa);
	sendRequest("http://localhost:8080/qyf-m-cro/UserorderServlet?operationtype=3&order_no="+qa+"&callback=finduserorder&pageNo=1");
	sendRequest("http://localhost:8080/qyf-m-cro/UserorderitemServlet?order_no="+qa+"&callback=finduserorderitem");
	return false;
}
function finduserorder(qw) {
	//alert(JSON.stringify(qw));
	//alert(qw.data[0].id);
	$("#tr2").show().siblings().hide();
	$("#tr1").show();
	$("#pn").hide();
} 
function finduserorderitem(qa) {
	//alert(JSON.stringify(qa));
	//alert(qa.length);
	
	$("body").append("订单明细");
	
	var $tb2= $("body").append("<table id='tb2' border='1' cellspacing='0px' cellpadding='0px'></table>");
	//$("#tb2").text("");
	
	var $th=$("#tb2").append("<tr><td><input type='checkbox'></td><td>主键id</td><td>订单编号</td><td>商品名称</td><td>商品图片</td><td>商品金额</td><td>商品数量</td><td>商品总价</td><td>创建时间</td><td>更新时间</td></tr> ");
	for(var i=0;i<qa.length;i++){
		//alert(qa[i].item_id);
		var $tr=$("#tb2").append("<tr><td><input type='checkbox'></td><td>"+qa[i].item_id+"</td> <td>"+qa[i].order_no+"</td> <td>"+qa[i].product_name+"</td><td>"+qa[i].product_image+"</td> <td>"+qa[i].current_unit_price+"</td><td>"+qa[i].quantity+"</td> <td>"+qa[i].total_price+"</td> <td>"+qa[i].create_time+"</td> <td>"+qa[i].update_time+"</td> </tr>");
		
	}
	
}

function _onsubmit(form){
	//请求Servlet的url
	var url=form.action;
	var $order_no=$("#ti1").val();
	var $status=$("select").val();
	url=url+"?operationtype=4&order_no="+$order_no+"&status="+$status+"&callback=finduserorder_item";
	sendRequest(url);
	return false;
}

function finduserorder_item(data){
	//alert(JSON.stringify(data));
	//alert(data.data.length);
	var lg=data.data.length;
	var status= data.data[0].status;
	//alert(status);
	$("#st1").text(status);
	
}
</script>
<body>
<form action="http://localhost:8080/qyf-m-cro/UserorderServlet" method="get" onsubmit="return _onsubmit(this)">
			<fieldset>
				<legend>订单搜索</legend>
				订单号<input id="ti1" type="text" />
				<input id="bt1" type="button" value="搜索" onclick="find()" /><br />
				<select>
					<option selected="selected">订单状态</option>
					<option value="0">已取消</option>
					<option selected="selected" value="10">未付款</option>
					<option value="20">已付款</option>
					<option value="40">已发货</option>
					<option value="50">交易成功</option>
					<option value="60">交易关闭</option>
				</select>
				<input type="submit" value="确定">
			</fieldset>
		</form>
<table border="1"cellspacing="0px" cellpadding="0px">
	<tr id="tr1">
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
	<tr id="tr2">
	<td><input type="checkbox" value="${pageModel.id }"></td>
		<td>${pageModel.id }</td>
		<td>${pageModel.order_no }</td>
		<td>${pageModel.user.username }</td>
		<td>${pageModel.address.receiver_name }</td>
		<td>${pageModel.payment }</td>
		<td>${pageModel.payment_type }</td>
		<td>${pageModel.postage }</td>
		<td id="st1">${pageModel.status }</td>
		<td>${pageModel.payment_time }</td>
		<td>${pageModel.send_time }</td>
		<td>${pageModel._end_time }</td>
		<td>${pageModel._close_time }</td>
		<td>${pageModel._create_time }</td>
		<td>${pageModel._update_time }</td>
	</tr>
	</c:forEach>
</table>
<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a id="pn" href="UserorderServlet?pageNo=${pageNo}&operationtype=2&pageSize=1">${pageNo}</a>
      </c:forEach>
</body>
</html>