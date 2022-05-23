<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String err = request.getParameter("err"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
<link rel="stylesheet" href="css/login.css">
</head>

<body>
	<img id="logo" src="../ABC株式会社.png">
	<div id="logoback"></div>
	
	<h1>ログイン</h1>
	
	<!-- ログインボタンを押したら、入力したユーザIDとパスワードをTopMenuServletへ送信する -->
	<form action="/ABC_ActuarialManagement/topMenu?no=0" method="post">
	<div class="place">
		<div class="text">社員番号</div><br>
		<input type="text" name="number" size="21"><br>
		<div class="text">パスワード</div><br>
		<input type="password" name="pass" size="22"><br>
	<br>
	<input type="submit" name="submit" value="ログイン"></div></form>
	
</body>
</html>