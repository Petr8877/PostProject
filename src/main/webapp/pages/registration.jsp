<%@ page    language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
 <head>
     <title>login</title>
 </head>
 <body>
 <jsp:include page="/pages/navbar.jsp"/>
 <div class="container mt-5">
 </div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<form action= "${pageContext.request.contextPath}/api/user" method="POST">
<div class="mx-auto" style="width: 200px;">

      Login:
    <input type="text" name="login" />
     </br>Password:
    <input type="password" name="password" />
     </br>FullName:
        <input type="text" name="fullName" />
     </br>Birthday:
             <input type="text" name="birthdate" />
     <br/>
     ${error_registration}
     <br/>
  <input type="submit" value="submit" />
</div>
</form>
</body>
</html>
