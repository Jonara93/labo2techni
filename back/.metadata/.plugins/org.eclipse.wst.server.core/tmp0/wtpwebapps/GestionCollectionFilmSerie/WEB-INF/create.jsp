<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Ajouter un film</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Ajouter un film ou une série</h1>
			<p class="lead">Ajouter un film à la liste de nos films et séries</p>
		</div>
	</div>
	<c:if test="${messages != null }">
		<c:forEach var="message" items="${messages }" varStatus="boucle">
			<p>${boucle.count}:${message}</p>
		</c:forEach>
	</c:if>
	<div class=container>
		<form action="create" method="post">
			<div class="form-group">
				<label for="fs_nom">Nom</label> <input type="text"
					class="form-control" id="fs_nom" name="fs_nom"
					placeholder="Nom du film ou de la série">
			</div>
			<div class="form-group">
				<label for="fs_synopsis">Synopsis</label>
				<textarea class="form-control" id="fs_synopsis" name="fs_synopsis"
					placeholder="Description du film" rows="3"></textarea>
			</div>
			<div class="form-group">
				<label for="fs_type">Type</label> <select class="custom-select"
					id="fs_type" name="fs_type">
					<option selected>Choisir un type</option>
					<c:forEach items="${ types }" var="type">
						<option value="${ type.ty_id }">${ type.ty_type }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="fs_genre">Genre</label> <select class="custom-select"
					id="fs_genre" name="fs_genre">
					<option selected>Choisir un type</option>
					<c:forEach items="${ genres }" var="genre">
						<option value="${ genre.ge_id }">${ genre.ge_nom }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="fs_saison">Nombre de saison</label> <input type="number"
					class="form-control" id="fs_saison" name="fs_saison"
					placeholder="Nombre de saison de la série" min="0" value="0">

			</div>
			<div class="form-group">
				<label for="fs_episode">Nombre d'épisode</label> <input
					type="number" class="form-control" id="fs_episode" name="fs_episode"
					placeholder="Nom d'épisode de la série" min="0" value="0">
			</div>
			<div class="form-group">
				<label for="fs_date">Nombre d'épisode</label> <input type="date"
					class="form-control" id="fs_date" name="fs_date">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>

		</form>
	</div>
</body>
</html>