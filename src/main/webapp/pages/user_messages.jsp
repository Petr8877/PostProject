<%@ page    language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration page</title>
</head>
<body>

<c:forEach items="${chats}" var="item">

    <c:out value="${item.timeMessage} " />
    <c:out value="${item.sender} " />
    <c:out value="${item.text} " /> </br>

</c:forEach>

    <a href="index.jsp">main</a>

</form>
</body>
</html>