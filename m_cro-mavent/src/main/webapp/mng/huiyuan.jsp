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
				width: 800px;
				text-align: center;
			}
		</style>
<title>Insert title here</title>
</head>
<body>
			<table border="1" cellspacing="0px" cellpadding="0px">
				<tr>
					<th>id</th>
					<th>账户名称</th>
					<th>密码</th>
					<th>电子邮箱</th>
					<th>电话号码</th>
					<th>找回密码问题</th>
					<th>找回密码答案</th>
					<th>角色</th>
					<th>创建时间</th>
					<th>更新时间</th>
				</tr>
				<c:forEach items="${model.data}" var="model">
<tr>
	<td><a href="../qt/AddressServlet?pageNo=1&user_id=${model.id} "> ${model.id }</a></td>
	<td>${model.username }</td>
	<td>${model.password }</td>
	<td>${model.email }</td>
	<td>${model.phone}</td>
	<td>${model.question }</td>
	<td>${model.answer }</td>
	<td>${model.role }</td>
	<td>${model.create_time }</td>
	<td>${model.update_time }</td>
	
</tr>
</c:forEach>
			</table>
	<c:forEach var="pageNo" begin="1" end="${model.totalPage}"  step="1">
     
      <a href="UserServlet?pageNo=${pageNo}">${pageNo}</a>
     
    </c:forEach>
</body>
</html>