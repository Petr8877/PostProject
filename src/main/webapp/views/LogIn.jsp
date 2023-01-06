<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="Include.jsp" %>
</head>

<body bgcolor="#5F9EA0">

<div style="text-align:center;">
<h1 class="logo">Страница авторизации</h1>
<form method = "POST" action = ${path}>
<input type="text" name="login" required="required" placeholder="Логин"/>
<br></br>
<input type="password" name="password" required="required" placeholder="Пароль"/>
<br></br>
<button type="submit" class="border-button"/>Войти</button>
</form>
</div>

</body>
</html>