
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ui/signUp"/>
        <input type="submit" name="sub" value="registration"/>
</form>
<form action="${pageContext.request.contextPath}/ui/signIn"/>
        <input type="submit" name="sub" value="log in"/>
</form>

<form action="${pageContext.request.contextPath}/ui/user/chats"/>
        <input type="submit" name="sub" value="chat"/>
</form>
<form action="${pageContext.request.contextPath}/ui/user/message"/>
        <input type="submit" name="sub" value="send message"/>
</form>



</body>

