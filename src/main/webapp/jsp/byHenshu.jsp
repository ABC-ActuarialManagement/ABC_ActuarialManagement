<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.BYBean"%>

<% int i = Integer.parseInt(request.getParameter("i")); %>
<% ArrayList<BYBean> list = (ArrayList<BYBean>)session.getAttribute("list"); %>
<% String err = request.getParameter("err"); %>
<% String by = (String)session.getAttribute("by"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body>

<% if(by.equals("b")){ %>
	<form action="/ABC_ActuarialManagement/byUpdate?i=<%=i %>" method="post">
	
	部署：
	<input type="text" name="department" size="30" value="<%=list.get(i).getDepartment() %>"><br>
	
	課：
	<input type="text" name="division" size="30" value="<%=list.get(i).getDivision() %>"><br>
	
	<input type="submit" name="submit" value="変更">
	<input type="submit" name="submit" value="削除">
	</form>
<% } else if(by.equals("y")){ %>
	<form action="/ABC_ActuarialManagement/byUpdate?i=<%=i %>" method="post">
	
	役職：
	<input type="text" name="position" size="30" value="<%=list.get(i).getPosition() %>"><br>
	
	<input type="submit" name="submit" value="変更">
	<input type="submit" name="submit" value="削除">
	</form>
<% } %>
<input type="button" value="戻る" onClick="location.href='/ABC_ActuarialManagement/byIchiran?by=<%=by %>'">

</body>
</html>