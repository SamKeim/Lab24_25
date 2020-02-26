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
	<div class="container">
		<h1>A Latte Fun</h1>
		<h2>Admin Menu Items</h2>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="menuItem" items="${menu}">
				<c:if test="${menuItem.quantity == null}">
					<tr>
						<td>${menuItem.name}</td>
						<td>${menuItem.description}</td>
						<td><fmt:formatNumber value="${menuItem.price}"
								type="currency" /></td>
						<td><input type="button" class="btn btn-primary"
			onclick="window.location.href = '/admin/form?id=${menuItem.id}';" value="Edit/Delete" />
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<h2>Products Available Online</h2>
		<table class="table">
			<tr>
				<td>Name</td>
				<td>Description</td>
				<td>Price</td>
			</tr>
			<c:forEach var="product" items="${menu}">
				<c:if
					test="${(product.quantity >= '1') && (product.quantity != 'null') }">
					<tr>
						<td>${product.name}</td>
						<td>${product.description }</td>
						<td>${product.price }</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<p>
			<input type="button" class="btn btn-primary" onclick="window.location.href = '/admin/create';" value="Add Item" />
			<input type="button" class="btn btn-primary" onclick="window.location.href = '/';" value="Home Page" />
		</p>
	</div>
</body>
</html>