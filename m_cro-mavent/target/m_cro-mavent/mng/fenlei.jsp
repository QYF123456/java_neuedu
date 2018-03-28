<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
			form>input{
				font-family: "微软雅黑";
				font-size: 20px;
				padding: 5px 15px;
			}
			table{
				width: 1000px;
				text-align: center;
			}
		</style>
<title>Insert title here</title>
</head>
<body>
<a href="InsertCroServlet">添加类别</a>
			<table border="1" cellspacing="0px" cellpadding="0px">
				<tr>
					<th>类别id</th>
					<th>父类id</th>
					<th>类别名称</th>
					<th>类别状态</th>
					<th>排序编号</th>
					<th>创建时间</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageModel.data}" var="ser">
<tr>
	<td>${ser.id }</td>
	<td>${ser.parent_id }</td>
	<td>${ser.name }</td>
	<td>${ser.status }</td>
	<td>${ser.sort_order}</td>
	<td>${ser.create_time }</td>
	<td>${ser.update_time }</td>
	<td><a href="DeleteCroServlet?id=${ser.id}">删除</a> |<a href="UpdateCroServlet?id=${ser.id }">修改</a></td>
</tr>
</c:forEach>
			</table>
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a href="PageServlet?pageNo=${pageNo}">${pageNo}</a>
     
    </c:forEach>
</body>
</html>