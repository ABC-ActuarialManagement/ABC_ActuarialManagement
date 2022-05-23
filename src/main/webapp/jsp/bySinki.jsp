<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String by = (String)session.getAttribute("by"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body>

<% if(by.equals("b")){ %>
	<form action="/ABC_ActuarialManagement/byInsert" method="post">
	
	部署：
	<input type="text" name="department" size="30"><br>
	
	課：
	<input type="text" name="division" size="30"><br>
	
	<input type="submit" name="submit" value="登録">
	</form>
<% } else if(by.equals("y")){ %>
	<form action="/ABC_ActuarialManagement/byInsert" method="post">
	
	役職：
	<input type="text" name="position" size="30"><br>
	
	<input type="submit" name="submit" value="登録">
	</form>
<% } %>

<input type="button" value="戻る" onclick="location.href='/ABC_ActuarialManagement/byIchiran?by=<%=by %>'">

</body>
</html>