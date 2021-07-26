<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/phonebook5/update" method="get">
	이름 : <input type="text" name="name" value="${requestScope.pMap.NAME}"> <br>
	핸드폰 : <input type="text" name="hp" value="${requestScope.pMap.HP}"> <br>
	회사번호 : <input type="text" name="company" value="${requestScope.pMap.COMPANY }"> <br>
	<input type="hidden" name="personId" value="${requestScope.pMap.PERSON_ID }">
	<button type="submit">등록</button>
</form>

</body>
</html>