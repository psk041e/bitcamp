<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 보기</title>
</head>
<body>
<jsp:include page="../header.jsp"/> <!-- 웹브라우저 주소와 다르다. 현재 jsp위치에 대해 상대적이어야 한다. -->
<h1>작업 보기</h1>
<form action='update' method='post'> <!-- 브라우저와 연결된다. -->
<input type='hidden' name='no' value='${task.no}'>
<table border='1'>
<tr>
    <th>팀명</th>
    <td><input type='text' value='${task.team.name}' readOnly></td> 
        <!-- 이미 url속에 팀명이 있기 때문에 팀명을 보내지 않아도 된다. 
            - 이름이 없는 입력 항목은 보내지 않는다. 
            - 따라서 화면에 출력은 하고싶으나 보내고싶지 않을 때 이름을 생략한다.
        -->
</tr>
<tr>
    <th>작업명</th>
    <td><input type='text' name='title' value='${task.title}'></td>
</tr>
<tr>
    <th>시작일</th>
    <td><input type='date' name='startDate' value='${task.startDate}'></td></tr>
<tr>
    <th>종료일</th>
    <td><input type='date' name='endDate' value='${task.endDate}'></td></tr>
<tr>
    <th>작업자</th>
    <td>
        <select name='memberId'>
            <option value=''>--선택 안함--</option>
<c:forEach items="${members}" var="member">            
            <option ${member.id == task.worker.id ? "selected" : ""}>${member.id}</option>
</c:forEach>
        </select>
    </td>
</tr>
<tr>
    <th>작업상태</th><td><select name='state'>
        <option value='0' ${task.state == 0 ? "selected" : ""}>작업대기</option>
        <option value='1' ${task.state == 1 ? "selected" : ""}>작업중</option>
        <option value='9' ${task.state == 9 ? "selected" : ""}>작업완료</option>
    </select></td>
</tr>
</table>
<a href='list'>목록</a>
<button>변경</button> 
<a href='delete?no=${task.no}'>삭제</a>
</form>
</body>
</html>



    