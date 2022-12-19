<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<
<html>
<head>Форма регистрации</head>
<p></p>
<p></p>
<body>
<p></p>
<from method="POST" action="RegistrationServlet">
Введите логин:<br>
<input type=text name="login">
<br>
<p></p>
<p> ${password}</p>
Введите пароль:<br>
<input type=text name="password">
<br>
<p></p>
<p> ${fullName}</p>
Введите ФИО:<br>
<input type=text name="fullName">
<br>
<p></p>
<p> ${date}</p>
Введите дату рождения (ГГГГ-ММ-ДД):<br>
<input type=text name="birthdate">
<br>
</from>
<p></p>
</body>
</html>