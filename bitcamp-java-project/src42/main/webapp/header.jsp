<%@ page import="bitcamp.java106.pms.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 멤버객체가 없으면 생성되어서 저장되는 문제가 발생하기 때문에 로그인된것처럼 느껴질 것이다.
     그러니까 여기서 useBean을 사용하지 말아라 -->
<div id='header'>
<% 
Member loginUser = (Member)session.getAttribute("loginUser");
if (loginUser == null) { %>
    <a href='<%=request.getContextPath()%>/auth/form.jsp'>로그인</a>
<%} else { %>
    <%=loginUser.getId()%> <a href='<%=request.getContextPath()%>/auth/logout'>로그아웃</a>
<%} %>
</div>
    