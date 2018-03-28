<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="InsertCroServlet" method="post">
<table>
	<tr>
		<td>id</td>
		<td><input type="text" name="id"> </td>
	</tr>
	<tr>
		<td>父类id</td>
		<td>
		<select name="parent_id">
		<c:forEach items="${sec }" var="ser">
		<option >${ser.id} </option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>类别名称</td>
		<td><input type="text" name="name"> </td>
	</tr>
	<tr>
	<td>类别状态</td>
	<td>
		<select name="status">
		<c:forEach items="${sec }" var="ser">
		<option >${ser.status} </option>
		</c:forEach>
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