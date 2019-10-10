<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href = "css/index2.css">
<script type="text/javascript" src = "js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function page(cpage){
		$("[name = cpage]").val(cpage)
		$("form").submit()
	}
</script>
</head>
<body>
<form action="list.do" method="post">
	<input type = "hidden" name = "cpage">
</form>
	<table>
		<tr>
			<td>编号</td>
			<td>电影名称</td>
			<td>介绍</td>
			<td>导演</td>
			<td>发行时间</td>
			<td>电影分类</td>
			<td>操作
				<input type = "button" value = "添加" onclick="location='toadd.do'">
			</td>
		</tr>
		<c:forEach items="${list }" var = "l">
			<tr>
				<td>${l.mid }</td>
				<td>${l.mname}</td>
				<td>${l.content }</td>
				<td>${l.author }</td>
				<td>${l.datea }</td>
				<td>${l.tnames }</td>
				<td>
					<input type = "button" value = "删除" onclick="location='todel.do?mid=${l.mid}'">
					<input type = "button" value = "修改" onclick="location='toupd.do?mid=${l.mid}'">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="11">
				${page }
			</td>
		</tr>
	</table>
</body>
</html>