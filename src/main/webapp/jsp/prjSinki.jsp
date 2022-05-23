<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String err = request.getParameter("err"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body>

<%-- エラー文表示 --%>
<% if(err == null){ %>
<% } else { %>
項目を入力してください
<% } %>

<form action="/ABC_ActuarialManagement/prjInsert" method="post">

プロジェクトコード：
<input type="text" name="projectCode" size="30"><br>

取引先：
<input type="text" name="supliers" size="30"><br>

摘要：
<input type="text" name="description" size="30"><br>

開始日：
<input type="text" name="startDate" size="30"><br>

終了日：
<input type="text" name="endDate" size="30"><br>

<input type="submit" name="submit" value="登録">
</form>

<input type="button" value="戻る" onclick="location.href='/ABC_ActuarialManagement/prjIchiran'">

</body>
</html>