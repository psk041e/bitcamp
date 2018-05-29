<%@page import="bitcamp.java106.pms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 목록</title>
</head>
<body>
<!-- jsp를 include시킨다. -->
<!-- out.flush() 위아래 반전되는것을 막아준다. -->
<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<h1>게시물 목록(MVC)</h1>
<p><a href='form.html'>새 글</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>제목</th><th>등록일</th>
</tr>
<!-- 반드시 파라미터명은 request, response가 되도록 해야 한다. 규칙이다. -->
<% 
List<Board> list = (List<Board>) request.getAttribute("list");
for (Board board : list) {
%>
<tr>
    <td><%=board.getNo()%></td>
    <td><a href='view?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
    <td><%=board.getCreatedDate()%></td>
</tr>
<%} %>

</table>
</body>
</html>
