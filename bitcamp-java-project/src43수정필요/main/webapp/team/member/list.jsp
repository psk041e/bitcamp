<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@page import="bitcamp.java106.pms.domain.Team"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="team" class="bitcamp.java106.pms.domain.Team" scope="request"/>
<%
List<Member> members = team.getMembers();
%>
<h2>회원 목록(EL)</h2>
<form action='member/add' method='post'>
<input type='text' name='memberId' placeholder='회원아이디'>
<input type='hidden' name='teamName' value='${param.name}'>
<button>추가</button>
</form>
<table border='1'>
<tr><th>아이디</th><th>이메일</th><th> </th></tr>
<%
for (Member member : members) {
    pageContext.setAttribute("member", member);
%>
<tr>
  <td>${member.id}</td>
  <td>${member.email}</td>
  <td><a href='member/delete?teamName=<%=request.getParameter("name")
  %>&memberId=${member.id}'>삭제</a></td>
</tr>
<%}%>
</table>







    