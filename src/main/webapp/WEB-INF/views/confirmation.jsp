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
<title>Confirmation || A Latte Fun</title>
</head>
<body>
<%@ include file="partials/header.jsp" %>
<div class="container">
<h2>Thank you for registering, ${user.firstName}.</h2>
<p><ul>
<li>Name: ${user.firstName} ${user.lastName}</li>
<li>Email: ${user.email}</li>
<li>Phone: ${user.phoneNumber}</li>
</ul>
<p><a href="/">Home Page</a></p>
</div>
</body>
</html>