<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<title>Login form</title>
</head>
<body>
<h1>Login page</h1>
<form action = ${path} method = "POST">
Login: <input name="login"/>
<br></br>
Password: <input name="password"/>
<br></br>
<input type="submit" value="Sign In"/>
</form>
</body>
</html>