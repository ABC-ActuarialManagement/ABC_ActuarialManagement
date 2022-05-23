<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.BYBean"%>

<% ArrayList<BYBean> list = (ArrayList<BYBean>)session.getAttribute("list"); %>
<% String by = (String)session.getAttribute("by"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body>

<% if(by.equals("b")){ %>
	<%-- 部署一覧 --%>
	<% for(int i = 0; i < list.size(); i++){ %>
		<%=list.get(i).getDepartment() %>
		<%=list.get(i).getDivision() %>
		<input type="button" value="変更" onclick="location.href='/ABC_ActuarialManagement/byHenshu?i=<%=i %>'">
		<hr>
	<% } %>
	
<% } else if(by.equals("y")){ %>
	<%-- 役職一覧 --%>
	<% for(int i = 0; i < list.size(); i++){ %>
		<%=list.get(i).getPosition() %>
		<input type="button" value="変更" onclick="location.href='/ABC_ActuarialManagement/byHenshu?i=<%=i %>'">
		<hr>
	<% } %>
	
<% } %>

<input type="button" value="新規登録" onclick="location.href='/ABC_ActuarialManagement/bySinki'">
<input type="button" value="戻る" onclick="location.href='/ABC_ActuarialManagement/topMenu?no=1'">

</body>
</html>