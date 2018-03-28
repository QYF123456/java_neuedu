<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form action="InsertAddressServlet" method="get">
 	<table>
 	<tr>
 		<td>收货人姓名</td>
 		<td><input type="text" name="receiver_name"> </td>
 	</tr>
 	<tr>
 		<td>收货人固定电话</td>
 		<td><input type="text" name="receiver_phone"> </td>
 	</tr>
 	<tr>
 		<td>收货人移动电话</td>
 		<td><input type="text" name="receiver_mobile"> </td>
 	</tr>
 	<tr>
 		<td>省份</td>
 		<td><input type="text" name="receiver_provinc"> </td>
 	</tr>
 	<tr>
 		<td>城市</td>
 		<td><input type="text" name="receiver_city"> </td>
 	</tr>
 	<tr>
 		<td>区/县</td>
 		<td><input type="text" name="receiver_district"> </td>
 	</tr>
 	<tr>
 		<td>详细地址</td>
 		<td><input type="text" name="receiver_address"> </td>
 	</tr>
 	<tr>
 		<td>邮编</td>
 		<td><input type="text" name="receiver_zip"> </td>
 	</tr>
 	
 	<tr>
 		<td><input type="submit" value="提交"> </td>
 	</tr>
 	</table>
 	
 	</form>
</body>
</html>