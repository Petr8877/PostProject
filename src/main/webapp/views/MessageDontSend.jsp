<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<title>Илья привет</title>
<%@ include file="Include.jsp" %>
</head>

<br><br>
<body bgcolor="#5F9EA0">
<div class="logo">
<div class="tab">
<h1>Сообщение не отправлено</h1>
<p>Указанного получателя не существует</p>
<a href="${pageContext.request.contextPath}/ui/" class="border-button">Возврат на главную</a><br><br>
<a href="${pageContext.request.contextPath}/ui/user/message" class="border-button">Отправить письмо</a><br><br>
</div>
</div>
</body>
</html>