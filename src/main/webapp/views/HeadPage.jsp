<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="Include.jsp" %>
</head>

<body bgcolor="#5F9EA0">

<a href="${pageContext.request.contextPath}/ui/singUp" class="border-button">Регистрация</a><br><br>
<a href="${pageContext.request.contextPath}/ui/signIn" class="border-button">Вход</a><br><br>
<a href="${pageContext.request.contextPath}/ui/user/message" class="border-button">Отправить письмо</a><br><br>
<a href="${pageContext.request.contextPath}/ui/user/chats" class="border-button">Полученные письма</a><br><br>
<a href="${pageContext.request.contextPath}/ui/admin/statistics" class="border-button">Статиска</a><br><br>

</body>
</html>