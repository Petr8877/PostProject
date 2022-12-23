<%@ page    language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" %>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form action= "${pageContext.request.contextPath}/api/login" method="POST">
      Login:</br>
    <input type="text" name="login" />
     </br>Password:</br>
    <input type="password" name="password" />  <br/>
  <input type="submit" value="submit" />
</form>
</body>
</html>