<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>Сообщения для пользователя</head>
<c:set var="user" scope="session" value="${sessionScope.user}" />
<p> ${user} </p>

<body>

<c:forEach items="${list}" var="item">
    <c:out value="${item}" />
    </c:forEach>
</body>
</html>