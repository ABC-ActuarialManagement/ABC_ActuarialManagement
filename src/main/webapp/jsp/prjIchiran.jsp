<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.PrjBean"%>

<% ArrayList<PrjBean> list = (ArrayList<PrjBean>)session.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body style="text-align:center">

	<h2>プロジェクト一覧</h2>
	<hr>
	
	<%-- 一覧表示 --%>
	<% for(int i = 0; i < list.size(); i++){ %>
		<%=list.get(i).getStartDate() %>
		<%=list.get(i).getEndDate() %>
		<%=list.get(i).getSupliers() %>
		<%=list.get(i).getProjectCode() %>
		<input type="button" value="変更" onclick="location.href='/ABC_ActuarialManagement/prjHenshu?i=<%=i %>'">
		<hr>
	<% } %>
	
	<input type="button" value="新規登録" onclick="location.href='/ABC_ActuarialManagement/prjSinki'">
	<input type="button" value="戻る" onClick="history.go(-1)">
	
</body>
</html>