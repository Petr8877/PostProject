<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>Очень плохая почта</head>
<p> ${sessionScope.user} </p>
<form method="POST" action="/PostProject/api/message">

  <label for="recipient">Введите получателя:</label>
  <input type="text" id="recipient" name="recipient"><br><br>
  <label for="text">Введите текст:</label>
  <input type="text" id="text" name="text"><br><br>
  <button type="submit">Отправить</button>
</form>
</html>