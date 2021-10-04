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
<title>Basket</title>

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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/create-game">Add game</a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="/baskets">Basket</a></li>
				</security:authorize>
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

						<table class="table table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Description</th>
									<th>Price</th>
									<th>Platform</th>
									<th>Publisher</th>
									<th>Release</th>
									<th>Genre</th>
									<th>Image</th>
									<th>Purchase Date</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="basket" items="${basketItems}">
									<tr>
										<td>${basket.id}</td>
										<td>${basket.game.name}</td>
										<td>${basket.game.description}</td>
										<td>${basket.game.price}</td>
										<td>${basket.game.platform}</td>
										<td>${basket.game.publisher}</td>
										<td>${basket.game.release}</td>
										<td>${basket.game.genre}</td>
										<td><img
											src="data:image/jpg;base64,${basket.game.encodedImage}"
											alt="image" style="width: 10%"></td>
										<td>${basket.purchaseDate}</td>
										<td><a href="basket?id= ${basket.id}">delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

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