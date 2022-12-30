<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="Include.jsp" %>

<style>
.logo {
color: Azure;
font-family: Times New Roman;
font-size: 18px;
}

.border-button {
  text-decoration: none;
  display: inline-block;
  padding: 20px 30px;
  margin: 10px 20px;
  position: relative;
  color: white;
  border: 1px solid rgba(255, 255, 255, .4);
  background: none;
  font-weight: 300;
  font-family: 'Montserrat', sans-serif;
  text-transform: uppercase;
  letter-spacing: 2px;
}
.border-button:before, .border-button:after {
  content: "";
  position: absolute;
  width: 0;
  height: 0;
  opacity: 0;
  box-sizing: border-box;
}
.border-button:before {
  bottom: 0;
  left: 0;
  border-left: 1px solid white;
  border-top: 1px solid white;
  transition: 0s ease opacity .8s, .2s ease width .4s, .2s ease height .6s;
}
.border-button:after {
  top: 0;
  right: 0;
  border-right: 1px solid white;
  border-bottom: 1px solid white;
  transition: 0s ease opacity .4s, .2s ease width, .2s ease height .2s;
}
.border-button:hover:before,
.border-button:hover:after {
  height: 100%;
  width: 100%;
  opacity: 1;
}
.border-button:hover:before {
  transition: 0s ease opacity 0s, .2s ease height, .2s ease width .2s;
}
.border-button:hover:after {
  transition: 0s ease opacity .4s, .2s ease height .4s, .2s ease width .6s;
}
.border-button:hover {
  background: rgba(255, 255, 255, .2);
}

</style>

</head>


<body bgcolor="#5F9EA0">
<h1 class="logo">Полученные письма</h1>

<c:choose>
<c:when test="${chats==null}">
<c:out value="${exception}"/>
</c:when>
<c:otherwise>
<c:forEach items="${chats}" var="item">
    <c:out value="Дата и время сообщения: ${item.timeMessage}"/><br>
    <c:out value="Отправитель: ${item.sender}"/><br>
    <c:out value="Текст сообщения: ${item.text}"/>
 <br><br>
</c:forEach>
</c:otherwise>
</c:choose>
</body>
</html>