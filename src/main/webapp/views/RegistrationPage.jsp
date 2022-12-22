<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>Очень плохая почта</head>
<form method="POST" action="${pageContext.request.contextPath}/api/user">
  <label for="login">Введите логин:</label>
  <input type="text" id="login" name="login"><br><br>
  <label for="password">Введите пароль:</label>
  <input type="text" id="password" name="password"><br><br>
    <label for="fullName">Введите ФИО:</label>
    <input type="text" id="fullName" name="fullName"><br><br>
      <label for="birthdate">Введите дату рождения (ГГГГ-ММ-ДД):</label>
      <input type="text" id="birthdate" name="birthdate"><br><br>
   <button type="submit">Отправить форму</button>
</form>
</html>