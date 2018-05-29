<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 목록</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1><a href='../team/view?name=${param.teamName}'>${param.teamName}</a>
의 작업 목록(MVC + JSP 전용 태그 + EL + JSTL)</h1>
<p><a href='add?teamName=${param.teamName}'>새작업</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>작업명</th><th>기간</th><th>작업자</th>
</tr>
<c:forEach items="${list}" var="task">
<tr>
    <td>${task.no}</td>    
    <td><a href='view?no=${task.no}'>${task.title}</a></td>    
    <td>${task.startDate} ~ ${task.endDate}</td>    
    <td>${task.worker == null ? "" : task.worker.id}</td>
    <!-- 에러뜨는것 신경쓰지 말아라 에디터가 어리버리해서 그런다. 
                    어차피 println에 들어가도 아무 상관 없는것이다. -->
</tr>
</c:forEach>
</table>
</body>
</html>


    