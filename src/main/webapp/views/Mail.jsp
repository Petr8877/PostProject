
<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="Include2.jsp" %>
</head>

<body bgcolor="#5F9EA0">
<div class="tab">
<h1 class="logo">Пользователь: ${name} </h1>
<form method="POST" action="${pageContext.request.contextPath}/api/message">

  <input type="text" id="recipient" name="recipient" placeholder="получатель"><br><br>
  <label for="text" class="logo">Введите текст:</label><br><br>

  <input type="text" id="text" name="text"><br><br>
  <button type="submit" class="border-button">Отправить</button>
</form>
</div>
</body>
</html>