<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam04</title>
</head>
<body>

<h1>JSTL - c:set II</h1>
<pre>
- 객체의 프로퍼티 값을 설정하기
    &lt;c:set target="객체주소" property="프로퍼티명" value="저장할 값" />
    객체 주소를 주려면 EL 표기법을 사용하라!
<%-- 이미 객체가 존재하므로 scope이 붙지 x --%>
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Member member = new Member();
pageContext.setAttribute("member", member);
%>

&lt;설정하기 전><br>
id: ${member.id} <br>
email: ${member.email} <br>
password: ${member.password} <br>
<hr>

<c:set target="${member}" property="id" value="user01"/>
<%-- 언제 이것을 써야하는지 잘 기억해라 이 자리에 멤버 객체를 놓겠다는 뜻이다. --%>
<c:set target="${member}" property="email" value="user01@test.com"/>
<c:set target="${member}" property="password" value="1111"/>

&lt;설정한 후><br>
id: ${member.id} <br>
email: ${member.email} <br>
password: ${member.password} <br>


</body>
</html>










