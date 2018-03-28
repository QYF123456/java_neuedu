<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
			ul{
				list-style: none;
				/*height: 400px;*/
			}
			a{
				text-decoration: none;
			}
			a:link{
				color:black;
			}
			a:visited{
				color:black;
			}
			li{
				margin: 20px;
			}
			span{
				font-family: "微软雅黑";
				font-size: 23px;
			}
			.bs{
			background-color: #DDDDDD;
			padding-left: 10px;
			border-radius: 5px;
			}
			.tr{
			background-color: #FFFFFF;
			padding-left: 10px;
			border-radius: 5px;
			}
		</style>
</head>
<script type="text/javascript">
$(function() {
	$("body").css("background-color","#6666CC");
	$("li").on("click",function(e){
	   // event.preventDefault();
	    $(this).addClass("bs").siblings().removeClass("bs");
	});
	$("li").mouseover(function(){
		$(this).addClass("tr");
	})
	$("li").mouseout(function(){
		$(this).removeClass("tr");
	})
})
	
</script>
<body>
<h3>欢迎${user.username}登录</h3>

<ul id="ul">	
		<li><a href="../UserorderServlet?operationtype=2&pageNo=1&pageSize=6&value=0" target="root"><span>订单管理</span></a></li>
		<li><a href="PageProduct?pageNo=1&value=1" target="root"><span>商品管理</span></a></li>
		<li><span>库存管理</span></a></li>
		<li><a href="PageServlet?pageNo=1" target="root"><span>分类管理</span></a></li>
		<li><a href="UserServlet?pageNo=1" target="root"><span>会员管理</span></a></li>
		<%-- <li><a href="../qt/AddressServlet?pageNo=1&user_id=${user.id}" target="root"><span>地址管理</span> </a> </li> --%>
		</ul>
</body>
</html>