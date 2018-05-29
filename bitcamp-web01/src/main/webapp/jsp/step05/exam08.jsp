<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam08</title>
</head>
<body>
<h1>JSTL - c:forEach</h1>
<pre>
- 반복문 기능을 하는 자바 코드를 만든다.
   &lt;c:forEach items="배열|java.util.Collection 구현|java.util.Iterator 구현체|java.util.Enumeration|"
                var="목록에서 꺼낸 항목을 가리키는 이름"
                begin="시작인덱스"
                end="끝인덱스"
                step="증가치">'콘텐트&lt;/c:forEach>
- 항목에서 꺼낸 값은 PageContext 보관소에 저장된다. (반복문을 돌때마다 )
- step의 기본값은 1이다.
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>14에서 20까지 반복하기</h2>

<p>
<c:forEach begin="14" end="20" var="no">
${pageScope.no}, 
</c:forEach>
</p>

<p>
<c:forEach begin="14" end="20" var="no" step="3">
${pageScope.no}, 
</c:forEach>
</p>

<h2>배열 반복하기</h2>
<%pageContext.setAttribute("names", 
        new String[]{"홍길동","임꺽정","유관순","안중근","윤봉길","김구","신채호","김원봉"}); %>

<p>
<c:forEach items="${names}" begin="2" end="5" var="name">
<%-- 객체가 들어갈때는 반드시 EL로 표현해야 한다! --%>
${pageScope.name}, 
</c:forEach>
</p>

<p>
<c:forEach items="${names}" begin="2" var="name">
${pageScope.name}, 
</c:forEach>
</p>


<p>
<c:forEach items="${names}" end="5" var="name">
${pageScope.name}, 
</c:forEach>
</p>

<p> <%-- 가장 많이 사용할 것이다. --%>
<c:forEach items="${names}"var="name">
${pageScope.name}, 
</c:forEach>
</p>


</body>
</html>







