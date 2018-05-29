<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 로그인을 한 후 다시 로그인폼으로 가지 못하게 한다. -->
<%
String refererUrl = request.getHeader("Referer");
if (refererUrl != null && refererUrl.endsWith("/auth/login")) {
    session.setAttribute("refererUrl", request.getHeader("Referer"));
} 
// builtIn 객체, 이미 이런 이름으로 변수가 존재하게끔 명세서에 나와있다.
// 톰캣뿐만 아니라 다른 서버를 쓰더라도 규칙은 똑같다.
String id = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("id")) {
            id = cookie.getValue();
            break;
        }
    }
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action='login' method='post'>
<table border='1'>
<tr><th>아이디</th>
    <td><input type='text' name='id' value='<%=id%>'></td></tr>
<tr><th>암호</th>
    <td><input type='password' name='password'></td></tr>
</table>
<p><input type='checkbox' name='saveId'> 아이디 저장</p>
<button>로그인</button>
</form>
</body>
</html>
