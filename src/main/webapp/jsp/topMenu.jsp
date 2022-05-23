<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body>

<input type="button" value="申請" onclick="location.href='/ABC_ActuarialManagement/kotuRireki'">
<input type="button" value="部署" onclick="location.href='/ABC_ActuarialManagement/byIchiran?by=b'">
<input type="button" value="役職" onclick="location.href='/ABC_ActuarialManagement/byIchiran?by=y'">
<input type="button" value="ログアウト" onclick="location.href='/ABC_ActuarialManagement/logout'">
<input type="button" value="戻る" onClick="history.go(-1)">

</body>
</html>