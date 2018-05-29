<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam10</title>
</head>
<body>
<h1>JSTL - c:forToken</h1>
<pre>
- 특정 식별자로 구분된 문자열을 반복할 때 사용된다.
   &lt;c:item items="문자열"|java.util.Collection 구현|java.util.Iterator 구현체|java.util.Enumeration|"
                var="목록에서 꺼낸 항목을 가리키는 이름"
                begin="시작인덱스"
                end="끝인덱스"
                step="증가치">'콘텐트&lt;/c:forEach>
- 
<%-- forEach는 콤마(,)만 가능하지만, forTokens는 다른 것으로도 자르기가 가능하다. --%>
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

ㅇㅇㅇㅇㅇnames2.put("s04", "안중근");
names2.put("s05", "윤봉길");
names2.put("s06", "김구");
names2.put("s07", "김원봉");
pageContext.setAttribute("names2", names2);
%>

<%-- 객체가 들어갈때는 반드시 EL로 표현해야 한다! --%>
<%-- 한 항목에 key와 value가 들어가 있다. --%>
<p>
<c:forEach items="${names2}" var="name">
${pageScope.name.key}==>${pageScope.name.value }, 
</c:forEach>
</p>

<%-- ,로 되어있는 태그도 반복문을 사용하여 돌릴 수 있다. --%>
<h2>CSV 반복하기</h2>
<c:set var="names" value="홍길동,임꺽정,유관순,안중근,윤봉길"></c:set>
<c:forEach itmes="${names}" var="name">
${pageScope.name} - 
</c:forEach>


</body>
</html>







