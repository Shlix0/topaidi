<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>

<!-- Custom styles for this template -->
<link href="addIdeaStyle.css" rel="stylesheet">

<style>
.carousel-control .glyphicon-chevron-right, .carousel-control .icon-next
	{
	margin-right: -382px;
}

.carousel-control .glyphicon-chevron-left, .carousel-control .icon-prev
	{
	margin-left: -71px;
	/* Popup container - can be anything you want */ . popup { position :
	relative;
	display: inline-block;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}
</style>

<spring:url value="/admin/processAdd" var="processUrl" />
<form:form method="POST" action="${processUrl}"
	modelAttribute="category" role="form">
	<div class="row">
		<div
			class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<h2>Ajouter votre Catégorie</h2>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input path="title" type="text" id="title"
							class="form-control input-lg" placeholder="Titre" tabindex="1" />
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input path="content" type="text" id="content"
							class="form-control input-lg" placeholder="Contenu" tabindex="2" />
					</div>
				</div>
				<div align="left">
					<div class="col-xs-12 col-md-6">
						<button type="submit" id="btnLogin" class="btn btn-success btn-sm">Ajouter
							l'idée</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>

<spring:url value="/admin/processActivated" var="processUrl" />
<form:form method="POST" action="${processUrl}" modelAttribute="user"
	role="form">
	<div class="row">
		<h1>Utilisateurs inactivés</h1>
		<br>
		<div class="col-xs-12 col-sm-6 col-md-6">
			<table class="table table-dark">
				<thead>
					<tr>
						<th></th>
						<th scope="col">Id Utilisateur</th>
						<th scope="col">Nom</th>
						<th scope="col">Prénom</th>
						<th scope="col">Activé l'utilisateur</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="count" value="0" />
					<c:forEach items="${inactivateUser}" var="user">
						<tr>
							<td><c:set var="count" value="${count + 1}" /> ${count}</td>
							<td>${user.id}</td>
							<td>${user.lastName}</td>
							<td>${user.firstName}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</form:form>

<div class="row">
	<h1>Idées signalées</h1>
	
	<div class="col-xs-12 col-sm-6 col-md-6">
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Id Idée</th>
					<th scope="col">Category</th>
					<th scope="col">Titre</th>
					<th scope="col">Nom</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" />
				<c:forEach items="${signaledIdea}" var="idea">
					<tr>
						<td><c:set var="count" value="${count + 1}" /> ${count}</td>
						<td></td>
						<td></td>
						<td>${idea.lastName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<jsp:include page="include/footer.jsp"></jsp:include>