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

<jsp:include page="/header.jsp"/>

<h1><a href='../team/view?name=<%=
request.getParameter("teamName")%>'><%=
request.getParameter("teamName")%></a>의 작업 목록(MVC)</h1>
<p><a href='add?teamName=<%=request.getParameter("teamName")%>'>새작업</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>작업명</th><th>기간</th><th>작업자</th>
</tr>
<%
List<Task> list = (List<Task>)request.getAttribute("list");
for (Task task : list) {
%>
<tr>
    <td><%=task.getNo()%></td>    
    <td><a href='view?no=<%=task.getNo()%>'><%=task.getTitle()%></a></td>    
    <td><%=task.getStartDate()%> ~ <%=task.getEndDate()%></td>    
    <td><%=(task.getWorker() == null)? "" : task.getWorker().getId()%></td>
    <!-- 에러뜨는것 신경쓰지 말아라 에디터가 어리버리해서 그런다. 
                    어차피 println에 들어가도 아무 상관 없는것이다. -->
</tr>
<%}%>
</table>
</body>
</html>


    