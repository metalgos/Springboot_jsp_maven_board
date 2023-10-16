<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>음식정보</h3>
<br>
<c:forEach var="item" items="${food}">
    음식 이름: <c:out value="${item.name}" />
    <br>
    음식 제작사: <c:out value="${item.manufacture}" />
    <br>
    영양소 : <c:out value="${item.nutri}" />
    <br>
    <img src = "${item.img}">
    <br>
</c:forEach>




</body>
</html>