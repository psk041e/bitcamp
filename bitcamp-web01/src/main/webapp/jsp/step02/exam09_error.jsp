<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="treu"%>
    <!-- 이 페이지는 에러를 처리하는 페이지라는 의미이다.ㄴ -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>오류 = 처리</title>
</head>
<body>
<h1>오류 처리 JSP</h1>
<pre>
오류를 처리할 목적으로 만든 JSP 페이지는 다음과 같이 
page 지시문 태그에 속성을 추가해야 한다.

    isErrorPage="true"
    
이 속성이 추가되면 오류 정보를 저장하고 있는 error라는 빌트인 변수가 추가된다.
</pre>
</body>
</html>














