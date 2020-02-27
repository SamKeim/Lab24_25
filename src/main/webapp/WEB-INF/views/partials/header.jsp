<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">A Latte Love</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor02" aria-controls="navbarColor02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor02">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/menu">Menu</a></li>
			<li class="nav-item"><a class="nav-link" href="/register">Register</a></li>
			<li class="nav-item"><a class="nav-link" href="/admin/">Admin</a></li>
		</ul>

		<c:if test="${location eq null}">
			<div class="form-group">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link">Select a
							Favorite Location:</a></li>
				</ul>
				<form method="post">
					<select class="custom-select form-inline my-0" name="location">
						<option selected=""></option>
						<option value="Ann Arbor">Ann Arbor</option>
						<option value="Detroit">Detroit</option>
						<option value="Ypsilanti">Ypsilanti</option>
					</select>
					<button class="btn btn-secondary my-2 my-sm-0" type="submit">Go</button>
				</form>
			</div>
		</c:if>
		<c:if test="${location ne null}">
		<div class="nav-item active navbar-nav"><a class="nav-link">Your Favorite: ${location}</a>
		<span class="btn btn-link text-secondary"><a href="/clearfavorite"><i>Clear</i></a></span>
		</div>
		</c:if>
	</div>
</nav>