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

								<script>
									function myFunction() {
										var popup = document
												.getElementById("myPopup");
										popup.classList.toggle("show");
									}
								</script>
<spring:url value="/ideas/processAdd" var="processUrl" />
				<form:form method="POST" action="${processUrl}" modelAttribute="idea" role="form">
	<div class="row">
		<div
			class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<h2>Ajouter votre Idée</h2>
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
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<form:input path="picture" type="text" id="picture"
								class="form-control input-lg" placeholder="Entrer l'URL"
								tabindex="3" />
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<form:select class="custom-select" path="category.id">
							<c:forEach items="${categoryList}" var="category">
								<form:option value="${category.id}">${category.title}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<div class="popup" onclick="myFunction()">
								<i class="fas fa-info"></i><span class="popuptext" id="myPopup">Si
									votre photo ce situe dans votre ordinateur, veuillez vous
									rendre sur le site https://www.casimages.com/ pour héberger
									votre image en ligne.</span>

							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
	<div align="left">
		<div class="col-xs-12 col-md-6">
		<button type="submit" id="btnLogin"
										class="btn btn-success btn-sm">Connexion</button>
	<%-- 	<form:button type="submit" class="btn btn-primary btn-lg active">ADD</form:button> --%>
			<!-- <button type="submit" class="btn btn-primary btn-lg active"
				value="add">Ajouter</button> -->
		</div>
	</div>
</form:form>
<jsp:include page="include/footer.jsp"></jsp:include>