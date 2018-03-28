<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateCroServlet" method="post">
<table>
	<tr>
		<td>id</td>
		<td><input type="text" name="id" readonly="readonly" value="${was.id }"> </td>
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
		<td><input type="text" name="name" value="${was.name}"> </td>
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
		<td>排序编号</td>
		<td><input type="text" name="sort_order" readonly="readonly" value="${was.sort_order}"> </td>
	</tr>
	<tr>
		<td>创建时间</td>
		<td><input type="text" name="create_time" readonly="readonly" value="${was.create_time}"> </td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td><input type="text" name="update_time" readonly="readonly" value="${was.update_time}"> </td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="提交"> </td>
	</tr>
</table>
</form>
</body>
</html>