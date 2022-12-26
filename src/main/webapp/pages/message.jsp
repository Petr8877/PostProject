<%@ page    language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action= "${pageContext.request.contextPath}/api/message" method="POST">
      Recipient login:</br>
    <input type="text" name="recipient" />
     </br>Message:</br>
    <input type="text" name="text" /></br>

  <input type="submit" value="submit" />
</form>
</body>
</html>