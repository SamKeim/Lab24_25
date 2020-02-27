<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN CONFIRM CHANGES || A Latte Fun</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/slate/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-G9YbB4o4U6WS4wCthMOpAeweY4gQJyyx0P3nZbEBHyz+AtNoeasfRChmek1C2iqV"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="partials/header.jsp" %>
	<h1>A Latte Fun</h1>
	<h2>${title} Confirmed</h2>
	<p>Category: ${item.category}</p>
	<p>Name: ${item.name}</p>
	<p>Description: ${item.description}</p>
	<p>
		Price:
		<fmt:formatNumber value="${item.price}" type="currency" />
	</p>
</body>
</html>