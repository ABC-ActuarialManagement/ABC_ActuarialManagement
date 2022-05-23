<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.PrjBean"%>

<% ArrayList<PrjBean> list = (ArrayList<PrjBean>)session.getAttribute("list"); %>
<% ArrayList<PrjBean> code = (ArrayList<PrjBean>)session.getAttribute("code"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>精算管理システム</title>
</head>
<body>

<h1>交通費新規申請</h1>

<% int no = Integer.parseInt(request.getParameter("no")); %>

<form action="/ABC_ActuarialManagement/prjInsert" method="post">

	<%-- 入力フォーム --%>
	<% for(int i = 0; i < (no+2); i++){ %>
		区分
		<select name="classification">
			<option selected>片道</option>
			<option>往復</option>
		</select>
		
		年/月/日
		<input type="text" name="date" size="30">
		
		区間
		<input type="text" name="getOn" size="30">
		～
		<input type="text" name="getOff" size="30">
		
		交通機関
		<select name="trafficInstitution">
			<option selected>JR</option>
			<option>私鉄</option>
			<option>新幹線</option>
			<option>バス</option>
			<option>飛行機</option>
		</select>
		
		交通費
		<input type="text" name="trafficCost" size="30">円
		
		負担
		<select name="loads">
			<option selected>自己</option>
			<option>会社</option>
		</select>
		
		PRJCD
		<select name="projectCode">
			<% for(int j = 0; j < code.size(); j++){ %>
			<option><%=code.get(j).getProjectCode() %></option>
			<% } %>
		</select>
		
		領収書
		<select name="receipt">
			<option selected>なし</option>
			<option>あり</option>
		</select>
		
		報告書
		<select name="report">
			<option selected>なし</option>
			<option>あり</option>
		</select>
		<hr>
	<% } %>

<input type="submit" name="submit" value="申請">
</form>

<input type="button" value="戻る" onClick="history.go(-1)">

</body>
</html>