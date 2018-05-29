<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Team"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam09</title>
</head>
<body>
<h1>EL : 연산자</h1>

<h2>1. 산술 연산자</h2>

${20 + 30} <br>
${20 - 30} <br>
${20 * 30} <br>
${20 / 30} <br>
${20 div 30} <br> <%-- div라고 하면 div태그라고 에디터가 착각해 에러가 난다. --%>
${20 % 30} <br>
${20 mod 30} <br>

<h2>2. 논리 연산자</h2>

${true && false} <br>
${true and false} <br>
${true || false} <br>
${true or false} <br>
${!true} <br>
${not true} <br>

<h2>3. 관계 연산자</h2>

${20 == 30} <br>
${20 eq 30} <br>
${20 != 30} <br>
${20 ne 30} <br>
${20 < 30} <br>
${20 lt 30} <br> <%-- less than --%>
${20 <= 30} <br>
${20 le 30} <br> <%-- less than or equal --%>
${20 > 30} <br>
${20 gt 30} <br> <%--  than --%>
${20 >= 30} <br>
${20 ge 30} <br> <%-- g than or equal --%>

<h2>4. empty 연산자</h2>
저장소에 해당 이름으로 저장된 값이 있는지 없는지 검사할 때 사용한다. <br>
<%
pageContext.setAttribute("name", "안중근");
pageContext.setAttribute("age", 20);
%>
${empty name} <br> <%-- name이라는 이름의 값이 비어있는가? --%>
${empty addr} <br>

<h2>5. 조건 연산자</h2>
${20 > 30 ? "크다" : "작다"} <br>


</body>
</html>











