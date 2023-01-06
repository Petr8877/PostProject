<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="Include.jsp" %>
</head>

<body bgcolor="#5F9EA0">
<form method="POST" action="${pageContext.request.contextPath}/api/user">
<div class="tab">
<h1 class="logo">Форма для регистрации</h1><br>

  <label class="logo">Логин:</label><br>
  <input type="text" minlength="6" maxlength="30" id="login" name="login" required="required" pattern="\b([a-zA-Z\d]+\.?[a-zA-Z\d]+)+" placeholder="pochtovichok"><br><br>
  <label class="logo">Пароль:</label><br>
  <input type="password" id="password"  name="password" required="required" minlength="8" placeholder="pochtovichok1"><br><br>
  <label class="logo">Полное имя:</label><br>
  <input type="text" id="fullName" name="fullName" required="required" pattern="[A-Z]\w+ +[A-Z]\w+$" minlength="4" placeholder="Ilya Shadrin"><br><br>
  <label class="logo">Дата рождения:</label><br>
  <input type="date" name="birthdate" min="1930-01-01" max="2022-12-31"><br><br>

  <button type="submit" class="border-button">Отправить форму</button>
  </div>
</form>
</body>
</html>