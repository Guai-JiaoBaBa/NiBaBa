<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="css/index2.css">
<script type="text/javascript" src = "js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
		function page(cpage){
			
			$("[name = cpage]").val(cpage)
			$("#page").submit()
		}
		//全选
		function qx(){
			$(":checkbox").attr("checked",true);
		}
		//全不选
		function qbx(){
			$(":checkbox").attr("checked",false);
		}
		//反选
		function fx(){
			$(":checkbox:checked").each(function(){
				this.checked = !this.checked
			});
		}

		//批量删除
		function plsc(){
			
			$.post("todelAll.do",$("#del").serialize(),function(flag){
				if(flag){
					alert("删除成功")
					location = "list.do"
				}else{
					alert("删除失败")
				}
			},"json")
		}
</script>
</head>
<body>
<form action="list.do" method="post" id = "page">
	<input type = "hidden" name = "cpage">
</form>
<input type = "button" value = "添加" onclick="location='toadd.do'">
<form action="" id = "del">
	<table>
		<tr>
			<td>角色ID</td>
			<td>角色名称</td>
			<td>创建日期</td>
			<td>拥有权限</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var = "l">
			<tr>
				<td>
					<input type = "checkbox" name = "uids" value = "${l.uid }">
				${l.uid }</td>
				<td>${l.uname }</td>
				<td>${l.datea }</td>
				<td>${l.tnames }</td>
				<td>
					<input type = "button" value = "查看">
				</td>
			</tr>
			
		</c:forEach>
		<tr>
			<td colspan="11">
				${page }
			</td>
		</tr>
		<tr>
			<td colspan="11">
				<input type = "button" value = "全选" onclick="qx()">
				<input type = "button" value = "全不选" onclick="qbx()">
				<input type = "button" value = "反选" onclick="fx()">
				<input onclick="plsc()" value = "批量删除" type = "button">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>