<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="Include2.jsp" %>
</head>

<body bgcolor="#5F9EA0">
<h1 class="logo">Полученные письма</h1>
<c:choose>
<c:when test="${chats==null}">
<c:out value="${exception}"/>
</c:when>
<c:otherwise>
<c:forEach items="${chats}" var="item">
<div class="logo">
    <c:out value="Дата и время сообщения: ${item.timeMessage}"/><br>
    <c:out value="Отправитель: ${item.sender}"/><br>
    <c:out value="Текст сообщения: ${item.text}"/>
</div>
 <br><br>
</c:forEach>
</c:otherwise>
</c:choose>
</body>
</html>