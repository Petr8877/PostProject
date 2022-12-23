<%@ page    language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" %>

<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form action= "${pageContext.request.contextPath}/api/user" method="POST">
      Login:</br>
    <input type="text" name="login" />
     </br>Password:</br>
    <input type="password" name="password" />
     </br>FullName:</br>
        <input type="text" name="fullName" />
     </br>Birthday:</br>
             <input type="text" name="birthdate" />

             <br/>
  <input type="submit" value="submit" />
</form>
</body>
</html>
