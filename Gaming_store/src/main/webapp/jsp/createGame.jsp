<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

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
<title><spring:message code="home.addGame"></spring:message></title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/css/home.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/css/tether.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/home.js"></script>
<script src="/js/calendar.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/js/tether.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="/js/i18n.js"></script>
</head>
<body>

	<div id="wrapper">
		<div class="overlay"></div>

		<!-- Sidebar -->
		<nav class="navbar navbar-inverse fixed-top" id="sidebar-wrapper"
			role="navigation">
			<ul class="nav sidebar-nav">
				<div class="sidebar-header">
					<div class="sidebar-brand">
						<a href="/home">Brand</a>
					</div>
				</div>
				<li><a href="/home" class="home"><spring:message
							code="home.home"></spring:message></a></li>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/create-game"><spring:message
								code="home.addGame"></spring:message></a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="/baskets"><spring:message code="home.basket"></spring:message></a></li>
				</security:authorize>
				<li><a href="/login?logout"
					onclick="document.forms['logoutForm'].submit()"><spring:message
							code="home.logout"></spring:message></a></li>
			</ul>
			<div style="width: 100%; position: absolute; bottom: 40px;">
				<fieldset>
					<label><spring:message code="login.choose_lang"></spring:message></label>
					<select id="locales">
						<option value="en"><spring:message code="login.english"></spring:message></option>
						<option value="ua"><spring:message code="login.ukrainian"></spring:message></option>
					</select>
				</fieldset>
			</div>
		</nav>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<button type="button" class="hamburger animated fadeInLeft is-closed"
				data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
					class="hamb-bottom"></span>
			</button>
			<div class="container">
				<div class="row" style="justify-content: left;">
					<div class="col-lg-12 col-lg-offset-2"
						style="max-width: 550px; background-color: #d8d8d8;">
					<h2><spring:message code="home.title"></spring:message> ${pageContext.request.userPrincipal.name}</h2>
						<form:form method="POST" action="${contextPath}/addGame"
							enctype="multipart/form-data">
							<table>
								<tr>
									<td><spring:message code="createGame.name"></spring:message></td>
									<td><input type="text" name="name" /></td>
								</tr>
								<tr>
									<td><spring:message code="createGame.description"></spring:message></td>
									<td><input type="text" name="description" /></td>
								</tr>
								<tr>
									<td><spring:message code="createGame.platform"></spring:message></td>
									<td><select name="platform">
											<option value="PS4">PS4</option>
											<option value="PS5">PS5</option>
											<option value="Xbox ONE">Xbox ONE</option>
											<option value="Xbox X">Xbox X</option>
											<option value="PC">PC</option>
									</select></td>
								</tr>
								<tr>
									<td><spring:message code="createGame.publisher"></spring:message></td>
									<td><input type="text" name="publisher" /></td>
								</tr>
								<tr>
									<td><spring:message code="createGame.dateRelease"></spring:message></td>
									<td><input type="text" name="release" id="datepicker"
										autocomplete="off" /></td>
								</tr>
								<tr>
									<td><spring:message code="createGame.genre"></spring:message></td>
									<td><input type="text" name="genre" /></td>
								</tr>
								<tr>
									<td><spring:message code="createGame.price"></spring:message></td>
									<td><input type="number" name="price" autocomplete="off" /></td>
								</tr>
								<tr>
									<td><spring:message code="createGame.image"></spring:message></td>
									<td><input type="file" name="image" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="Submit" /></td>
								</tr>
							</table>

						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->
	</div>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</c:if>

</body>
</html>