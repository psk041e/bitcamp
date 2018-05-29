<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>exam03_5</title>
</head>
<body>
<h1>JSP 전용 태그: useBean + type + class </h1>
<pre>
type과 class 속성을 모두 지정했을 때 동작 원리

type 속성
  generic 표현을 사용할 수 있다.
class 속성
  generic 표현을 사용할 수 없다.
</pre>

<%
Member obj = new Member();
obj.setId("홍길동");
obj.setEmail("hong@test.com");
obj.setPassword("1111");

Member obj2 = new Member();
obj2.setId("홍길동");
obj2.setEmail("hong@test.com");
obj2.setPassword("1111");

ArrayList<Member> arr = new ArrayList<>();
arra.add(obj);
arr.add(obj2);

pageContext.setAttribute("list", arr);
%>
<h2>type 과  class 속성을 동시에 설정하기 </h2>
 <jsp:useBean id="member"
        type="java.util.List<Member>" 
        class="java.util.ArrayList"></jsp:useBean>
 <%-- 자바 코드: 
 // type 속성 값은 변수를 선언할 때 사용한다.
 jsp.util.ArrayList<Member> list = 
    (jsp.util.ArrayList<Member>)pageContext.getAttribute("list");
 if (list == null) {
    // class 속성 값은 개체를 생성할 때 사용한다.
    throw new Exception();
}
  --%>
  <%-- ArrayList에 들어있는 데이터 타입이 Member라고 명시해 주어야 한다. 그렇지 않으면
       기본 타입이 Object 타입이기 때문에 브라우저에서 실행시 에러가 발생한다. --%>
  <%-- 만약 list라는 이름으로 저장소에 들어있지 않으면 에러를 띄운다. 
        위의 pageContext.setAttribute("list", arr);를 주석으로 막고 실행해보자
  --%>
  <%-- list객체가 jsp에 안넘어 올때는 출력을 안할수도 있을것이다. 그러면 사용자들이 당황하는 경우가 발생할것이다.
       개발자들이 이를 대비해서 --%>
  <%-- 타입에는 제네릭표현을 넣을 수 있지만, 클래스에는 제네릭 표현을 넣을 수 없다. 
       현업에서는type을 쓰지 않고 class만 쓰는 경우가 있을 텐데 
       class를 반드시 지정한 이유는 객체가 없는 경우 화면에 에러를 띄우지 말고 빈 채로 내버려두기 위해서이다.--%>
<%
for (Member member : list) {
%>
  <%=member.getId()%><br>

</body>
</html>










