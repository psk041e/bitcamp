<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%> <%-- 이것을 붙이는 순간 Exception객체가 만들어진다. 에러 정보를 받는 변수가 자동으로 생긴다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv='Refresh' 
      content='5;url=<%=request.getHeader("Referer")%>'>
<title>실행 오류</title>
</head>
<body>
<h1>실행 오류!</h1>
<pre>
<%=exception%>
</pre>
</body>
</html>
    