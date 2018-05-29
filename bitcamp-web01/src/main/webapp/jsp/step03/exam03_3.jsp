<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>exam03_3</title>
</head>
<body>
<h1>JSP 전용 태그: useBean</h1>
<pre>
jsp:useBean
- 태그를 이용하여 객체를 꺼낼때 사용한다.
- 만약 객체가 없다면 해당 객체를 생성할 수도 있다.

[문법]
  jsp:setProperty name="객체명" property="프로퍼티명(셋터명)" value="값"

scope
  객체를 꺼낼 저장소를 가리킨다.
  page  => PageContext 저장소 (기본 값)
  request => ServletRequest 저장소
  session => HttpSession 저장소
  application => ServletContext 저장소
</pre>

 <h2>Member 객체를 만들어 PageContext에 보관하기 + 프로퍼티 값 설정하기</h2>
 <jsp:useBean id="member" class="jsp.Member"></jsp:useBean>
 <%-- id로 지정된 객체에 setProperty를 사용하고 싶다면 아래의 태그를 사용한다. --%>
 <jsp:setProperty name="member" property="id" value="홍길동"/>
 <jsp:setProperty name="member" property="email" value="hong@test.com"/>
 <jsp:setProperty name="member" property="password" value="1111"/> 
 <%-- 자바 코드: 
 jsp.Member member = (jsp.Member)pageContext.getAttribute("member");
 if (member == null) {
    member = new jsp.Member();
    pageContext.setAttribute("member", member);
    member.setId("홍길동");
    member.setEmail("hong@test.com");
    member.setId("1111");
}
  --%>
 아이디: <%=member.getId()%><br>
 이메일: <%=member.getEmail()%><br>
 암호: <%=member.getPassword()%><br>

</body>
</html>



