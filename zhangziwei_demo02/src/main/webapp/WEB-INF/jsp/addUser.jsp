<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href="css/index2.css">
<script type="text/javascript" src = "js/jquery-1.8.3.js"></script>
<script type="text/javascript" src = "My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	
</script>
<title>Insert title here</title>
</head>
<body>
<form action="addUser.do" method="post">
	<table>
		<tr>
			<td>角色</td>
			<td><input type = "text" name = "uname"></td>
		</tr>
		<tr>
			<td>创建日期</td>
			<td><input type = "text" name = "datea" onclick="WdatePicker()"></td>
		</tr>
		<tr>
			<td>拥有权限</td>
			<td>
			<c:forEach items="${listType }" var="t">
			<input type = "checkbox" value = "${t.tid }" name = "tids">${t.tname }
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "submit" value = "保存" ></td>
		</tr>
	</table>
</form>
	
</body>
</html>