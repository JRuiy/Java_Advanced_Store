<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<spring:message code="registration.firstName" var="registrationFirstName"/>
<spring:message code='registration.lastName' var="registrationLastName"/>
<spring:message code='registration.email' var="registrationEmail"/>
<spring:message code='registration.phone' var="registrationPhone"/>
<spring:message code='registration.password' var="registrationPassword"/>
<spring:message code='registration.confirmPassword' var="registrationConfirmPassword"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code="login.registration"></spring:message></title>

<link href="/css/registration.css" rel="stylesheet">
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
			<h2 class="heading">
				<spring:message code="login.registration"></spring:message>
			</h2>


			<form:form method="POST" modelAttribute="userForm">

				<spring:bind path="firstName">
					<form:input type="text" path="firstName" class="fadeIn first"
						placeholder="${registrationFirstName}" />
					<form:errors path="firstName"></form:errors>
				</spring:bind>

				<spring:bind path="lastName">
					<form:input type="text" path="lastName" class="fadeIn second"
						placeholder="${registrationLastName}" />
					<form:errors path="firstName"></form:errors>
				</spring:bind>

				<spring:bind path="email">
					<form:input type="text" path="email" class="fadeIn third"
						placeholder="${registrationEmail}" />
					<form:errors path="email"></form:errors>
				</spring:bind>

				<spring:bind path="phone">
					<form:input type="text" path="phone" class="fadeIn fourth"
						placeholder="${registrationPhone}" />
					<form:errors path="phone"></form:errors>
				</spring:bind>

				<spring:bind path="password">
					<form:input type="password" path="password" class="fadeIn fiveth"
						placeholder="${registrationPassword}" />
					<form:errors path="password"></form:errors>
				</spring:bind>

				<spring:bind path="passwordConfim">
					<form:input type="password" path="passwordConfim"
						class="fadeIn sixth"
						placeholder="${registrationConfirmPassword}" />
					<form:errors path="passwordConfim"></form:errors>
				</spring:bind>

				<input type="submit" class="fadeIn seventh"
					value="<spring:message code='registration.submit'></spring:message>">

			</form:form>

			<div>
				<fieldset>
					<label><spring:message code="login.choose_lang"></spring:message></label>
					<select id="locales">
						<option value="en"><spring:message code="login.english"></spring:message></option>
						<option value="ua"><spring:message code="login.ukrainian"></spring:message></option>
					</select>
				</fieldset>
			</div>

		</div>
	</div>
</body>
</html>