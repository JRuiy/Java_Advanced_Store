<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/64/000000/external-user-interface-kiranshastry-gradient-kiranshastry.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form method="POST" action="/login">
	  <span>${message}</span>
      <input type="text" id="login" class="fadeIn second ${error != null ? 'has-error' : ''}" name="email" placeholder="Login">
      <input type="password" id="password" class="fadeIn third ${error != null ? 'has-error' : ''}" name="password" placeholder="Password">
      <input type="submit" class="fadeIn fourth ${error != null ? 'has-error' : ''}" value="Log In">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <br>
      <span>${error}</span>
    </form>
    
    <div id="formFooter">
      <a class="underlineHover" href="/registration">Create an account</a>
    </div>

  </div>
</div>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>