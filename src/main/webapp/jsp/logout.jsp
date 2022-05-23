<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<% String name = (String)session.getAttribute("UserName"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>

<body style="text-align:center">
	<h1>ログアウト</h1>
	保存していないデータは消えてしまいます。<br>
	ログアウトしますか？<br><br>
	user：<%= name %>
	
	<!-- ログアウトボタンを押すとLoginServletへ行く -->
	<input type="button" value="ログアウト" onclick="location.href='/ABC_ActuarialManagement/login'">
	<input type="button" value="戻る" onClick="history.go(-1)">


</body>
</html>