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
<title>Games</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/css/tether.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/home.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
				<li><a href="/home" class="home">Home</a></li>
				<li><a href="/create-game">Add game</a></li>
				<li><a href="/basket">Basket</a></li>
				<li><a href="/login?logout"
					onclick="document.forms['logoutForm'].submit()">Logout</a></li>
			</ul>
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
				<div class="row">
					<div class="col-lg-12 col-lg-offset-2">
						<h2>Welcome ${pageContext.request.userPrincipal.name}</h2>

						<form:form method="POST" action="${contextPath}/addGame"
							modelAttribute="game">
							<table>
								<tr>
									<td><form:label path="name">Name</form:label></td>
									<td><form:input path="name" /></td>
								</tr>
								<tr>
									<td><form:label path="description">Description</form:label></td>
									<td><form:input path="description" /></td>
								</tr>
								<tr>
									<td><form:label path="platform">Platform</form:label></td>
									<td><form:select path="platform">
											<form:option value="PS4" label="PS4"></form:option>
											<form:option value="PS5" label="PS5"></form:option>
											<form:option value="Xbox ONE" label="Xbox ONE"></form:option>
											<form:option value="Xbox X" label="Xbox X"></form:option>
											<form:option value="PC" label="PC"></form:option>
										</form:select></td>
								</tr>
								<tr>
									<td><form:label path="publisher">Publisher</form:label></td>
									<td><form:input path="publisher" /></td>
								</tr>
								<tr>
									<td><form:label path="release">Date release</form:label></td>
									<td><form:input path="release" id="datepicker" autocomplete="off"/></td>
								</tr>
								<tr>
									<td><form:label path="genre">Genre</form:label></td>
									<td><form:input path="genre" /></td>
								</tr>
								<tr>
									<td><form:label path="price" >Price</form:label></td>
									<td><form:input path="price" autocomplete="off"/></td>
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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/home.js"></script>
	<script src="${contextPath}/resources/js/calendar.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/js/tether.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>