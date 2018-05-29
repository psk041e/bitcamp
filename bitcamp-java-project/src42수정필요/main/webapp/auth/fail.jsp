<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 로그인 실패시 출력할 내용 -->
<!DOCTYPE html>
<html>

<head>
<meta charset='UTF-8'>
<meta http-equiv='Refresh' content='1;url=/<%=request.getContextPath()%>/auth/login'><title>로그인</title>
<!-- 리턴값 -> /어플리케이션이름 -->
</head>

<body>
<h1>로그인 실패!(MVC)</h1>
<p>아이디 또는 암호가 맞지 않습니다.</p>
</body>

</html>
