<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>


<style>
*{
margin: 0;
padding: 0;
box-sizing: border-box;
}
.logo {
color: Azure;
font-family: Times New Roman;
font-size: 18px;
margin-left: 40px;
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
input {
  border: 2px solid currentcolor;
}
input:invalid {
  border: 2px dashed red;
}
.bod {
  height: 120%;
  width: 100%;
  background-image: url("../img/logo4.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}
.tab { margin-left: 40px; }
</style>

</head>
<body bgcolor="#5F9EA0">
<form method="POST" action="${pageContext.request.contextPath}/api/user">
<div class="bod">
<%@ include file="Include.jsp" %>
<h1 class="logo">Форма для регистрации</h1><br>


  <input class="tab" type="text" minlength="6" maxlength="30" id="login" name="login" required="required" pattern="\b([a-zA-Z\d]+\.?[a-zA-Z\d]+)+" placeholder="логин"><br><br>

  <input class="tab" type="password" id="password"  name="password" required="required" minlength="8" placeholder="пароль"><br><br>

  <input class="tab" type="text" id="fullName" name="fullName" required="required" pattern="[a-zA-Z]+ +[a-zA-Z]+$" minlength="4" placeholder="имя и фамилия"><br><br>

  <input class="tab" type="date" name="birthdate" min="1930-01-01" max="2022-01-01"><br><br>



   <button type="submit" class="border-button">Отправить форму</button>
   </div>
</form>
</body>
</html>