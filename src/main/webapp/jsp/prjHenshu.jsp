<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.PrjBean"%>

<% int i = Integer.parseInt(request.getParameter("i")); %>
<% ArrayList<PrjBean> list = (ArrayList<PrjBean>)session.getAttribute("list"); %>
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

<form action="/ABC_ActuarialManagement/prjUpdate?i=<%=i %>" method="post">

プロジェクトコード：
<input type="text" name="projectCode" size="30" value="<%=list.get(i).getProjectCode() %>"><br>

取引先：
<input type="text" name="supliers" size="30" value="<%=list.get(i).getSupliers() %>"><br>

摘要：
<input type="text" name="description" size="30" value="<%=list.get(i).getDescription() %>"><br>

開始日：
<input type="text" name="startDate" size="30" value="<%=list.get(i).getStartDate() %>"><br>

終了日：
<input type="text" name="endDate" size="30" value="<%=list.get(i).getEndDate() %>"><br>

<input type="submit" name="submit" value="変更">
<input type="submit" name="submit" value="削除">
</form>

<input type="button" value="戻る" onClick="history.go(-1)">

</body>
</html>