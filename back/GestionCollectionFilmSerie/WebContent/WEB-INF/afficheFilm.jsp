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
<title>Tous nos films</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Toutes nos films et séries</h1>
			<p class="lead">Voici la liste de tous les films et séries
				référencées sur notre site.</p>
		</div>
	</div>
	<c:if test="${messages != null }">
		<c:forEach var="message" items="${messages }" varStatus="boucle">
			<p>${boucle.count}:${message}</p>
		</c:forEach>
	</c:if>
	<div class="container">
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nom</th>
					<th scope="col">Synopsis</th>
					<th scope="col">Type</th>
					<th scope="col">Date de sortie</th>
					<th scope="col">Genre</th>
					<th scope="col">Nombre(s) de saison(s)</th>
					<th scope="col">Nombre total d'épisodes</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ medias }" var="media">
					<tr>
						<td>${media.fs_id }</td>
						<td>${media.fs_nom }</td>
						<td>${media.fs_synopsis }</td>
						<td>${media.ty_type.ty_type }</td>
						<td>${media.fs_date_sortie }</td>
						<td>${media.ge_genre.ge_nom }</td>
						<c:choose>
							<c:when
								test="${media.ty_type.ty_type.equalsIgnoreCase(\"Serie\")}">
								<td>${media.fs_saison }</td>
								<td>${media.fs_episode }</td>
							</c:when>
							<c:otherwise>
								<td>/</td>
								<td>/</td>
							</c:otherwise>
						</c:choose>
						<td><a href="films/detail/${media.fs_id}"><button
									type="button" class="btn btn-outline-light">Détails</button></a></td>
						<td><a href="films/update/${media.fs_id}"><button
									type="button" class="btn btn-outline-light">Modifier</button></a></td>
						<td><a href="films/delete/${media.fs_id}"><button
									type="button" class="btn btn-outline-light">Supprimer</button></a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="11"><a href="films/create"><button type="button"
								class="btn btn-outline-light">Ajouter</button></a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>