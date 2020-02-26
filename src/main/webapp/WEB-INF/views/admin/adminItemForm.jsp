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

<title>ADMIN CHANGE ITEM || A Latte Fun</title>
</head>
<body>
	<div class="container">
		<h1>A Latte Fun</h1>
		<h2>${title} Item</h2>
		<div class="form-group">
			<form method="post" action="/admin/checking">
				<input type="hidden" name="id" value="${product.id}" />
				<label for="category">Category</label> <select class="form-control"
					name="category" required>
					<c:forEach items="${categories}" var="category">
						<c:choose>
							<c:when test="${category eq product.category}">
								<option value="${category}" selected>${category}</option>
							</c:when>
							<c:when test="${category ne product.category}">
								<option value="${category}">${category }</option>
							</c:when>
						</c:choose>
					</c:forEach>
				</select> <label for="name">Name</label> <input class="form-control"
					id="name" name="name" value="${product.name}" required
					minlength="2" autocomplete="off"> <label for="description">Description</label>
				<input class="form-control" id="description" name="description"
					value="${product.description}" required minlength="2"
					autocomplete="off">

				<fmt:formatNumber type="number" pattern="0.00"
					value="${product.price}" var="price" />
				<label for="Price">Price</label> <input class="form-control"
					id="price" name="price" value="${price}" required step="0.01"
					autocomplete="off">
				<input type="submit" class="btn btn-primary" name="Submit" />
				<!--  <button type="button" class="btn btn-primary" name="DELETE"
					onclick="return confirm('Are you sure you want to delete this item?');">Delete</button> -->
			</form>
		</div>
		<p>
			<input type="button" class="btn btn-primary"
				onclick="window.location.href = '/admin/';" value="Admin Home Page" />
		</p>
	</div>
</body>
</html>