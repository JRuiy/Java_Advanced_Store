<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code='login.title'></spring:message></title>
<link href="/css/login.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/i18n.js"></script>
</head>
<body>

	<div class="wrapper fadeInDown">
		<div id="formContent">

			<!-- Icon -->
			<div class="fadeIn first">
				<img
					src="https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/64/000000/external-user-interface-kiranshastry-gradient-kiranshastry.png"
					id="icon" alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form method="POST" action="/login">
				<span>${message}</span> <input type="text" id="login"
					class="fadeIn second ${error != null ? 'has-error' : ''}"
					name="email"
					placeholder="<spring:message code='login.email'></spring:message>">
				<input type="password" id="password"
					class="fadeIn third ${error != null ? 'has-error' : ''}"
					name="password"
					placeholder="<spring:message code='login.password'></spring:message>">
				<input type="submit"
					class="fadeIn fourth ${error != null ? 'has-error' : ''}"
					value="<spring:message code='login.logIn'></spring:message>">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <br> <span>${error}</span>
			</form>

			<div>
				<fieldset>
					<label><spring:message code="login.choose_lang"></spring:message></label>
					<select id="locales">
					<option value="en"><spring:message code="login.english"></spring:message></option>
					<option value="ua"><spring:message code="login.ukrainian"></spring:message></option>

					</select>
				</fieldset>
			</div>

			<div id="formFooter">
				<a class="underlineHover" href="/registration"><spring:message
						code="login.registration"></spring:message></a>
			</div>

		</div>
	</div>


</body>
</html>