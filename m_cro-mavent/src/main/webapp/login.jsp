<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/login.css"></link> 

<title>Insert title here</title>

</head>
<body>
<h1><img src="img/10.png" />米高轮滑官网后台管理中心 </h1>
<form action="LoginServlet" method="get">
<table>
	<tr>
 		<td>用户名</td>
 		<td><input type="text" name=username> </td>
 	</tr>
 	<tr>
 		<td>用户密码</td>
 		<td><input type="password" name=password> </td>
 	</tr>
 	<tr>
 	<td colspan="2"><input type="submit" value="登录"> </td>
 	<td><a href="">注册</a> </td>
 	</tr>
</table>
</form>

</body>
</html>