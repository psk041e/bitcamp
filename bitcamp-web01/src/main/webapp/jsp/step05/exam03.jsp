<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam03</title>
</head>
<body>

<h1>JSTL - c:set</h1>
<pre>
- 값을 저장소에 보관하기
&lt;c:set var="변수명" value="저장할 값" scope="page|request|session|application"/>
&lt;c:set var="변수명" scope="page|request|session|application"/>저장할 값&lt;/c:set>
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
pageContext.setAttribute("name", "홍길동");
%>
<c:set var="name2" value="임꺽정" scope="page"/> <%-- scope의 기본값: page --%>
<c:set var="name3" scope="page">유관순</c:set>
<%-- 되도록이면 위의 방법을 사용해 저장하라 --%>

name = ${pageScope.name} <br>
name = ${requestScope.name} <br>
name2 = ${pageScope.name2} <br> <%-- name2라는 이름으로 pageScope에 저장 --%>
name2 = ${requestScope.name2} <br> 
name2 = ${pageScope.name2} <br>
name2 = ${requestScope.name2} <br>

</body>
</html>










