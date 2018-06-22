<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%-- JSTL 태그를 사용하여 다른 서버에 HTTP 요청을 할 것이다. 
    (bitcamp-web01의 webapp/jsp/step05/exam12.jsp에서 복사해온다.)
--%>
<%-- JSTL 라이브러리를 가져온다.
     만약 프로젝트에 JSTL 라이브러리를 추가하지 않았다면
     build.gradle에 추가하라!
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- www.zdnet.co.kr 사이트의 콘텐트를 요청한다.
     변수를 지정하지 않으면 응답 결과를 따로 보관하지 않고 
   c:import 태그가 있는 그 위치에서 응답 결과를 그대로 출력한다.
 --%>
<c:import url="http://m.zdnet.co.kr/news_view.asp?article_id=20180621153416"/>

<!-- AJAX로는 직접 요청할 수 없지만 프록시 서버로는 요청할 수 있다.
     javascript로는 안되지만 jsp에서 import하는 것은 된다.
     => javascript에서 html을 다운받은 ajaxproxy.jsp를 요청하면 된다. -->
