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
<title>Mise à jour</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Modification ${media.ty_type.ty_id == 2 ? 'du' : 'de la'} ${media.ty_type.ty_type}
				n°${media.fs_id}</h1>
			<p class="lead">Modification des données ${media.ty_type.ty_id == 2 ? 'du' : 'de la'} ${media.ty_type.ty_type}</p>
		</div>
	</div>
	<div class="container">
		<form action="update" method="post">
			<input id="fs_id" name="fs_id" value="${media.fs_id }" hidden>
			<div class="form-group">
				<label for="fs_nom">Nom</label> <input type="text"
					class="form-control" id="fs_nom" name="fs_nom"
					value="${media.fs_nom}">
			</div>
			<div class="form-group">
				<label for="fs_synopsis">Synopsis</label>
				<textarea class="form-control" id="fs_synopsis" name="fs_synopsis"
					rows="3">${media.fs_synopsis}</textarea>
			</div>
			<div class="form-group">
				<c:if test="${ media.ty_type.ty_id != 2 }">
					<label for="fs_type">Type</label>
				</c:if>
				<select class="custom-select" id="fs_type" name="fs_type" hidden>
					<c:forEach items="${ types }" var="type">
						<option value="${ type.ty_id }"
							${ media.ty_type.ty_id == type.ty_id ? 'selected' : '' }>${ type.ty_type }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="fs_genre">Genre</label> <select class="custom-select"
					id="fs_genre" name="fs_genre">
					<option selected>Choisir un type</option>
					<c:forEach items="${ genres }" var="genre">
						<option value="${ genre.ge_id }"
							${ media.ge_genre.ge_id == genre.ge_id ? 'selected' : '' }>${ genre.ge_nom }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<c:if test="${ media.ty_type.ty_id != 2 }">
					<label for="fs_saison">Nombre de saison</label>
				</c:if>
				<input type="number" class="form-control" id="fs_saison"
					name="fs_saison"
					value="${media.ty_type.ty_id == 2 ? 0 : media.fs_saison}" min="0"
					${ media.ty_type.ty_id == 2 ? 'hidden' : '' }>

			</div>
			<div class="form-group">
				<c:if test="${ media.ty_type.ty_id != 2 }">
					<label for="fs_episode">Nombre d'épisode</label>
				</c:if>
				<input type="${ media.ty_type.ty_id == 2 ? 'hidden' : 'number' }"
					class="form-control" id="fs_episode" name="fs_episode"
					value="${media.ty_type.ty_id == 2 ? 0 : media.fs_episode}" min="0">
			</div>
			<div class="form-group">

				<label for="fs_date">Date de publication</label> <input type="date"
					class="form-control" id="fs_date" name="fs_date"
					value="${media.fs_date_sortie.toLocalDate() }">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Modifier</button>
			</div>

		</form>
	</div>


</body>
</html>