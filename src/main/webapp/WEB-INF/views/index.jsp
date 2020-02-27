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
<link rel="stylesheet" href="/temp.css" />

<title>Home || A Latte Fun</title>
</head>
<body>
	<%@ include file="partials/header.jsp"%>
	<div class="container">
		<h2>We're glad to have you here!</h2>
		<h2>We have three locations across Southeast Michigan to better
			serve you.</h2>

		<div class="row">
			<article class="col text-center">
				<img class="bg-cover" src="/Ann Arbor.jfif">
				<h3>Ann Arbor</h3>
			</article>
			<article class="col text-center">
				<img class="bg-cover" src="/DIA.jpg">
				<h3>Detroit Institute of Arts</h3>
			</article>
			<article class="col text-center">
				<img class="bg-cover" src="/ypsilanti.jpeg">
				<h3>Ypsilanti</h3>
			</article>
		</div>
	</div>
</body>
</html>