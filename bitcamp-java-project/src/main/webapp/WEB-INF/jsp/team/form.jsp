<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 등록</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>팀 등록</h1>
<form action="add" method="post">
<table border='1'>
<tr>
    <th>팀명</th><td><input type="text" name="name"></td>
</tr>
<tr>
    <th>설명</th><td><textarea name="description" 
        rows="6" cols="60"></textarea></td>
</tr>
<tr>
    <th>최대인원</th><td><input type="number" name="maxQty" value="3"></td>
</tr>
<tr>
    <th>시작일</th><td><input type="date" name="startDate"></td>
</tr>
<tr>
    <th>종료일</th><td><input type="date" name="endDate"></td>
</tr>

</table>
<button>등록</button>

</form>

</body>
</html>

    