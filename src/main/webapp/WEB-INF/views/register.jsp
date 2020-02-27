<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
	<%@ include file="partials/header.jsp" %>
<title>Register || A Latte Fun</title>
</head>
<body>
<div class="container">
	<h2>Registration</h2>

	<form action="/register" method="post">

		<p>
			First Name: <input type="text" name="firstName" />
		</p>
		<p>
			Last Name: <input type="text" name="lastName" />
		</p>
		<p>
			E-mail: <input type="email" name="email" />
		</p>
		<p>
			Phone Number: <input type="tel" name="phoneNumber" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<button type="submit">Click Here to Register</button>
	</form>
	<p><a href="/">Home</a></p>
</div>
</body>
</html>