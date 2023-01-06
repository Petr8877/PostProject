<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="Include.jsp" %>
</head>

<br><br>
<body bgcolor="#5F9EA0">
<div class="logo">
<div class="tab">
<h1>Регистрация не завершена</h1>
<p>Логин занят</p>
<a href="${pageContext.request.contextPath}/ui/" class="border-button">Возврат на главную</a><br><br>
<a href="${pageContext.request.contextPath}/ui/signIn" class="border-button">Вход</a><br><br>
</div>
</div>
</body>
</html>