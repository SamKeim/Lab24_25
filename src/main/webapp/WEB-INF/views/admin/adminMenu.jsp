<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/slate/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-G9YbB4o4U6WS4wCthMOpAeweY4gQJyyx0P3nZbEBHyz+AtNoeasfRChmek1C2iqV"
	crossorigin="anonymous">


<title>ADMIN MENU || A Latte Fun</title>
</head>
<body>
	<%@ include file="partials/header.jsp"%>
	<div class="container">
		<h1>A Latte Fun</h1>
		<h2>Admin Menu Items</h2>
		<table class="table">
			<tr>
				<th>Category</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="menuItem" items="${menu}">
				<tr>
				<td>${menuItem.category}</td>
					<td>${menuItem.name}</td>
					<td>${menuItem.description}</td>
					<td><fmt:formatNumber value="${menuItem.price}"
							type="currency" /></td>
					<td><input type="button" class="btn btn-primary"
						onclick="window.location.href = '/admin/edit?id=${menuItem.id}';"
						value="Edit" />
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>