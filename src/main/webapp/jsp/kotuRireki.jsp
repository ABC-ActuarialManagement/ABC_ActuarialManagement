<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.KotuBean"%>

<% ArrayList<KotuBean> list = (ArrayList<KotuBean>)session.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body>

<h2>交通費申請一覧</h2>
<hr>

<%-- 一覧表示 --%>
<% for(int i = 0; i < list.size(); i++){ %>
	<%=list.get(i).getDate() %>
	<%=list.get(i).getEmpId() %>
	<%=list.get(i).getStatus() %>
	<input type="button" value="詳細" onclick="location.href='/ABC_ActuarialManagement/kotuShosai?i=<%=i %>'">
	<hr>
<% } %>

<input type="button" value="新規申請" onclick="location.href='/ABC_ActuarialManagement/kotuSinsei'">
<input type="button" value="戻る" onclick="location.href='/ABC_ActuarialManagement/sinseiMenu'">

</body>
</html>