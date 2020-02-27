<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<title>Menu || A Latte Fun</title>
</head>
<body>
<%@ include file="partials/header.jsp" %>
	<div class="container">
		<h2>Menu Items</h2>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
			<c:forEach var="menuItem" items="${menu}">
					<tr>
						<td>${menuItem.name}</td>
						<td>${menuItem.description}</td>
						<td>${menuItem.price}</td>
					</tr>
				</c:forEach>
		</table>
		<p>
			<a href="/">Home Page</a>
		</p>
	</div>
</body>
</html>