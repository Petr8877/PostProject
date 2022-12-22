<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>Очень плохая почта</head>
<form method="POST" action="${pageContext.request.contextPath}/api/login">
  <label for="login">Введите логин:</label>
  <input type="text" id="login" name="login"><br><br>
  <label for="password">Введите пароль:</label>
  <input type="text" id="password" name="password"><br><br>
  <button type="submit">Войти</button>
</form>
</html>