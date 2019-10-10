<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href = "css/index2.css">
<script type="text/javascript" src = "js/jquery-1.8.3.js"></script>
<script type="text/javascript" src = "My97DatePicker/WdatePicker.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function upd(){
		$.post("updMovie.do",$("form").serializa(),function(flag){
		alert(222)
			if(flag){
				alert("修改成功")
				location = "list.do"
			}else{
				alert("修改失败")
			}
		},"json")
	}
</script>
</head>
<body>
<form>
	<table>
		<tr>
			<td>电影名称</td>
			<td>
			<input type = "text" name= "mname" value = "${movieById.mname }" >
			<input type = "hidden" name= "mid">
			</td>
		</tr>
		<tr>
			<td>介绍</td>
			<td>
				<textarea rows="5" cols="30" name = "content" >${movieById.content }</textarea>
			</td>
		</tr>
		<tr>
			<td>导演</td>
			<td><input type = "text" name= "author" value = "${movieById.author }"></td>
		</tr>
		<tr>
			<td>发型时间</td>
			<td><input type = "text" name= "datea" onclick="WdatePicker()" value = "${movieById.datea }"></td>
		</tr>
		<tr>
			<td>分类</td>
			<td>
				<c:forEach items="${typeList }" var = "t">
					<input type = "checkbox"  name = "tid">${t.tname }
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "button" value= "修改" onclick="upd()"></td>
		</tr>
	</table>
</form>
</body>
</html>