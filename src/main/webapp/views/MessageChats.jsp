<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>chat</head>


<body>
</br>
<c:forEach items="${chats}" var="item">
    <c:out value="${item.sender} " />
    <c:out value="${item.text} " />
    <c:out value="${item.timeMessage} " /> </br>

</c:forEach>

    <a href="${pageContext.request.contextPath}/ui/">main</a>

</body>
</html>