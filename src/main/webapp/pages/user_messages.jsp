<%@ page    language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<head>
    <title>chat</title>
</head>
<body>

<jsp:include page="/pages/navbar_user.jsp"/>
<div class="container mt-5">
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>


<body>
 <div class="mx-auto" style="width: 1000px;">
${user.login}
</br>
</br>

<table class="table table-striped table-hover">
  <thead>
    <tr>
      <th scope="col"> </th>
      <th scope="col">Time</th>
      <th scope="col">Sender</th>
      <th scope="col">Message</th>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${chats}" var="item">
   <th scope="row"> </th>
   <td> <c:out value="${item.timeMessage}" /></td>
    <td><c:out value="${item.sender}" /></td>
   <td> <c:out value="${item.text}" /></td>
   </tr>

</c:forEach>
</tr>
</tbody>

</table>

</div>
</body>
</html>