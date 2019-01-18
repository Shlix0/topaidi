<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Topaidi</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

<!-- Custom styles for this template -->
<link href="acceuilStyle.css" rel="stylesheet">

<style>
.carousel-control .glyphicon-chevron-right, .carousel-control .icon-next
	{
	margin-right: -382px;
}

.carousel-control .glyphicon-chevron-left, .carousel-control .icon-prev
	{
	margin-left: -71px;
}
<%@include file="/WEB-INF/views/accueilStyle.css"%>
</style>

</head>
<body>

<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">TOPAIDI</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/topaidi/admin/home">Administrateur</a></li>
					<li class="nav-item active"><a class="nav-link" href="/topaidi/ideas/home">Accueil
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/topaidi/classements/home">Classements</a></li>
				</ul>
	<!-- -------------------------------------- MODAL LOGIN ----------------------------------------------------  -->
	
		<c:choose>
			<c:when test="${empty sessionScope.user}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button"> Connexion<span
							class="caret"></span>
					</a>
					<form:form method="POST" action="login" modelAttribute="login">
						<div class="dropdown-menu dropdown-menu-right" id="formLogin" >
							<div class="container-fluid">
								<form class="dropdown">
									<div class="form-group">
										<label class="">Nom d'utilisateur</label>
										 <form:input path="mail"	class="form-control" name="username" id="username"
											type="text" placeholder="email@exemple.com"/>
									</div>
									<div class="form-group">
										<label class="">Mot de passe</label>
										 <form:input path="password"
											class="form-control" name="password" id="password"
											type="password" placeholder="Mot de passe"/>
									</div>

									<div class="form-group">
										<div class="form-check">
											<input type="checkbox" class="form-check-input"
												id="dropdownCheck"> <label class="form-check-label"
												for="dropdownCheck"> Se souvenir de moi </label>
										</div>
									</div>
							</form:form>
									<button type="submit" id="btnLogin"
										class="btn btn-success btn-sm">Connexion</button>

								</form>
								<div class="dropdown-divider"></div>
								<!-- <spring:url value="/user/add" var="add" /> -->
<%-- 	<form:form method="post" action="${processUrl}" modelAttribute="artist"> --%>
								<a href="/topaidi/user" class="dropdown-item">Nouveau sur ce site ?
									Inscription</a> <a class="dropdown-item" href="">Mot de passe
									oublié ?</a>
							</div>
						</div></li>
						</c:when>
						<c:otherwise>
						<a  href="/topaidi/ideas/loggout" class="btn btn-danger btn-sm"><i class="fas fa-power-off"></i></a>
						</c:otherwise>
		</c:choose>
							
				</ul>
			</div>
		</div>
	</nav>


	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3" align="center">BIENVENUE SUR TOPAIDI !</h1>
			<p class="lead" align="justify"  >Haut lieu de rassemblement
				francophones des inventeurs, le site Topaidi symbolise toute
				l&rsquo;essence et l&rsquo;étendue du concept d&rsquo;invention en France. Curieux et
				professionnels, aux enjeux divers et variés, se rendent chaque année
				ici pour y découvrir les inventions de demain !</p>
			<div align="center">
				<a href="/topaidi/ideas/add" class="btn btn-primary btn-lg active b" role="button"
					aria-pressed="true" >Nouvelle idée <i class="fas fa-lightbulb"></i></a>
			</div>
		</header>

	