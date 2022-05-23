<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String err = request.getParameter("err"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>

<body>
	
	<h1>パスワード変更</h1>
	
	<!-- 変更ボタンを押したら、入力したパスワードをPassServletへ送信する -->
	<form action="/ABC_ActuarialManagement/passUpdate" method="post">	
	パスワード<br>
		<input type="password" name="pass" size="22"><br>
	<br>
	<input type="submit" name="submit" value="変更"></div></form>
	
</body>
</html>