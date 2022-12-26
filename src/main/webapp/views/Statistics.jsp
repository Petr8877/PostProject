<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<title>Application statistics</title>
</head>
<body>
<h1>Application usage statistics</h1>
</br>
<c:out value="Number of active users in the application:  ${statistic.countActiveUser}" />
</br>
</br>
<c:out value="Number of all registered users in the application: ${statistic.countAllUser}" />
</br>
</br>
<c:out value="Number of sent messages in the application: ${statistic.countMessage}" />
</br>
</body>
</html>