<%@page import="bitcamp.java106.pms.domain.Task"%>
<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 보기</title>
</head>
<body>
<div id='header'>
<a href='/bitcamp-java-project/auth/login'>로그인</a></div>
<h1>작업 보기(MVC)</h1>
<%
Task task = (Task)request.getAttribute("task");
int no = (int)request.getAttribute("no");
%>
<form action='update' method='post'>
<input type='text' name='no' value='<%=no%>'>
<table border='1'>
<tr>
    <th>팀명</th>
    <td><input type='text' name='teamName' value='<%=task.getTeam().getName()%>' readOnly></td>
</tr>
<tr>
    <th>작업명</th>
    <td><input type='text' name='title' value='<%=task.getTitle()%>'></td>
</tr>
<tr>
    <th>시작일</th>
    <td><input type='date' name='startDate' value='<%=task.getStartDate()%>'></td></tr>
<tr>
    <th>종료일</th>
    <td><input type='date' name='endDate' value='<%=task.getEndDate()%>'></td></tr>
<tr>
    <th>작업자</th>
    <td>
        <select name='memberId'>
<%List<Member> list = (List<Member>) request.getAttribute("members"); %>
            <option value=''>--선택 안함--</option>
            <%for (Member member : list) {%>
                <option <%=(member.equals(task.getWorker())) ? "selected" : ""%>><%=member.getId()%></option>
            <%}%>
        </select>
    </td>
</tr>
<tr>
    <th>작업상태</th><td><select name='state'>
        <option value='0' <%=(task.getState() == 0) ? "selected" : ""%>>작업대기</option>
        <option value='1' <%=(task.getState() == 0) ? "selected" : ""%>>작업중</option>
        <option value='9' <%=(task.getState() == 0) ? "selected" : ""%>>작업완료</option>
    </select></td>
</tr>
</table>
<button>변경</button> 
<a href='delete?no=<%=task.getNo()%>&teamName=<%=task.getTeam().getName()%>'>삭제</a>
</form>
</body>
</html>
