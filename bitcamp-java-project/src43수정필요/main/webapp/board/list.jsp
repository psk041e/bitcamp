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
<jsp:include page="/header.jsp"/>
<h1>게시물 목록(MVC + JSP 전용 태그 + EL)</h1>
<p><a href='form.html'>새 글</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>제목</th><th>등록일</th>
</tr>

<%-- ArrayList는 객체를 생성하지 못한다. --%>
<jsp:useBean id="list" 
             type="java.util.List<Board>"
             class="java.util.ArrayList" 
             scope="request"/>
<%
for (Board board : list) {
    pageContext.setAttribute("board", board);
%>

<tr>
    <td>${board.no}</td>
    <td><a href='view?no=${board.no}'>${board.title}</a></td>
    <td>${board.createdDate}</td>
</tr>
<%}%>
</table>
</body>
</html>