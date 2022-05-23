<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.KotuBean"%>

<% ArrayList<KotuBean> list = (ArrayList<KotuBean>)session.getAttribute("detail"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精算管理システム</title>
</head>
<body>

<h2>交通費詳細</h2>

<table border="1">
	<tr>
		<td>日付</td>
		<td colspan="3">区間</td>
		<td>区分</td>
		<td>交通機関</td>
		<td>PJRCD</td>
		<td>摘要</td>
		<td>負担</td>
		<td>領収書</td>
		<td>報告書</td>
		<td>交通費</td>
	</tr>
	<%-- 一覧表示 --%>
	<% for(int i = 0; i < list.size(); i++){ %>
		<tr>
			<td><%=list.get(i).getDate() %></td>
			<td><%=list.get(i).getGetOn() %></td>
			<td>～</td>
			<td><%=list.get(i).getGetOff() %></td>
			<td><%=list.get(i).getClassification() %></td>
			<td><%=list.get(i).getTrafficInstitution() %></td>
			<td><%=list.get(i).getProjectId() %></td>
			<td>摘要　ない</td>
			<td><%=list.get(i).getLoads() %></td>
			<td><%=list.get(i).getReceipt() %></td>
			<td><%=list.get(i).getReport() %></td>
			<td><%=list.get(i).getTrafficExpenses() %></td>
		</tr>
	<% } %>
</table>


<input type="submit" value="編集" onclick="location.href='/ABC_ActuarialManagement/kotuHenshu'">
<input type="button" value="戻る" onClick="history.go(-1)">

</body>
</html>