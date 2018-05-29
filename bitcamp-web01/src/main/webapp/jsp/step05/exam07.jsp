<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam07</title>
</head>
<body>
<h1>JSTL - c:choose</h1>
<pre>
- if ~ else if ~ else if ~ else 또는 switch 기능을 하는 자바 코드를 만든다.
   &lt;c:choose 
        &lt;when test="true or false">콘텐트&lt;/c:when>
        &lt;when test="true or false">콘텐트&lt;/c:when>
        &lt;when test="true or false">콘텐트&lt;/c:when>
   &lt;/c:choose>
   콘텐츠 
   &lt;c:if>
- test 속성의 값
   true 또는 false 값을 리턴하는 EL 태그가 온다.
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="age" value="17"/>
<c:choose>
    <c:when test="${age > 0 && age < 19}">
                미성년 입니다.
    </c:when>
    <c:when test="${age < 19 and age < 65}">
                성년 입니다.
    </c:when>
    <c:when test="${age >= 65}">
                노인 입니다.
    </c:when>
    <c:otherwise>
                나이 값이 없거나 잘못된 값입니다.
    </c:otherwise>
</c:choose>
</body>
</html>







