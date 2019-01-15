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


<div class="row">
	<div
		class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form role="form">
			<h2>Ajouter votre Id�e</h2>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input path="title" type="text" id="title"
							class="form-control input-lg" placeholder="Titre" tabindex="1"
							value="${idea.title}" />
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input path="content" type="text" id="content"
							class="form-control input-lg" placeholder="Contenu" tabindex="2"
							value="${idea.content}" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input path="picture" type="text" id="picture"
							class="form-control input-lg" placeholder="Entrer l'URL"
							tabindex="3" value="${idea.picture}" />
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<div class="popup" onclick="myFunction()">
							<i class="fas fa-info"></i><span class="popuptext" id="myPopup">Si
								votre photo ce situe dans votre ordinateur, veuillez vous rendre
								sur le site https://www.casimages.com/ pour h�berger votre image
								en ligne.</span>
							<script>
								function myFunction() {
									var popup = document
											.getElementById("myPopup");
									popup.classList.toggle("show");
								}
							</script>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<div align="left">
	<a href="#" class="btn btn-primary btn-lg active btn-sm" role="button"
		aria-pressed="true" data-dismiss="modal"><i
		class="fas fa-plus-circle"></i> </a>
</div>

<jsp:include page="include/footer.jsp"></jsp:include>