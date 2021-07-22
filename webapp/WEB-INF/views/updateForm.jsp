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

<form action="/phonebook3/update" method="get">
	이름 : <input type="text" name="name" value="${personVo.name}"> <br>
	핸드폰 : <input type="text" name="hp" value="${personVo.hp}"> <br>
	회사번호 : <input type="text" name="company" value="${personVo.company }"> <br>
	<input type="hidden" name="personId" value="${personVo.personId }">
	<button type="submit">등록</button>
</form>

</body>
</html>