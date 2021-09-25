<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>403</title>
</head>
<body>
<div>
		<div>
				<h3> You have no permission to access page!</h3>
		</div>
			<form action="/logout" method="post">
				<input type="submit" value="Sign in as different user"/>
				<input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>
			</form>
	
	</div>
</body>
</html>