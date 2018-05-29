<%@page import="bitcamp.java106.pms.domain.Team"%>
<%@page import="bitcamp.java106.pms.domain.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 목록</title>
</head>
<body>
<div id='header'>
<a href='/bitcamp-java-project/auth/login'>로그인</a></div>
<% 
Team team = (Team) request.getAttribute("team");
%>
<h1><a href='../team/view?name=<%=team.getName()%>'><%=team.getName()%></a>의 작업 목록(MVC)</h1>
<p><a href='add?teamName=<%=team.getName()%>'>새작업</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>작업명</th><th>기간</th><th>작업자</th>
</tr>
<% 
List<Task> list = (List<Task>) request.getAttribute("list");
for (Task task : list) {
%>
<tr>
    <td><%=task.getNo()%></td>
    <td><a href='view?no=<%=task.getNo()%>'><%=task.getTitle()%></a></td>
    <td><%=task.getStartDate()%> ~ <%=task.getEndDate()%></td>
    <td><%=(task.getWorker() == null) ? "-" : task.getWorker().getId()%></td>
</tr>
<%}%>
</table>
</body>
</html>
