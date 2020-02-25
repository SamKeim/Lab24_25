<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<title>Menu || A Latte Fun</title>
</head>
<body>
<div class="container">
	<h1>A Latte Fun</h1>
	<h2>Products</h2>
	<table class="table">
		<tr>
			<td>Name</td>
			<td>Description</td>
			<td>Price</td>
		</tr>
		<c:forEach var="product" items="${menu}">
			<tr>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="/">Home Page</a></p>
	</div>
</body>
</html>