<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    errorPage="exam09_error.jspd"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>exam09</title>
</head>
<body>
<h1>JSP 빌트인 객체</h1>
<pre>
JSP 엔진이 JSP 파일을 가지고  서블릿 클래스를 만들 때 
반드시 다음 객체를 그 이름으로 사용할 수 있도록 정의해야 한다.
이 아홉개의 객체는 반드시 있어야 한다.
1) HttpServletRequest   => request 라는 이름으로,
2) HttpServletResponse  => response 라는 이름으로,
3) JspWriter            => out 
4) HttpSession          => session
5) ServletContext       => application
6) PageContext          => pageContext
7) ServletConfig        => config
8) 서블릿 객체 그 자신은                 => page
9) 오류 객체                                 => error

오류 객체?
- 다른 서블릿에서 오류가 발생했을 때 그 오류를 처리하는 JSP는
  오류 정보를 담은 객체를 받는다.
- 바로 그 객체의 수명이 변수명이 error이다.

errorPage 속성
- 오류가 발생했을 때


</body>
</html>














