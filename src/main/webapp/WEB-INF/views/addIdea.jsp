<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>

<!-- Custom styles for this template -->
<link href="addIdeaStyle.css" rel="stylesheet">

<style>
<%@include file="/WEB-INF/views/addIdeaStyle.css"%>
</style>


<spring:url value="/ideas/processAdd" var="processUrl" />
<form:form method="POST" action="${processUrl}" modelAttribute="idea"
	role="form">
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
						<a class="btn btn-primary" href="#primary" data-toggle="modal">
							<i class="fas fa-info"></i>
						</a>

						<!-- 						Modal -->
						<div class="modal fade" id="primary" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header modal-header-primary"
										style="padding-left: 110px;">
										<h1>Renseignement</h1>
									</div>
									<div class="modal-body" align="justify">
										Si votre photo ce situe dans votre ordinateur, veuillez vous
										rendre sur le site <span
											style="text-decoration: underline; font-weight: bold;">https://www.casimages.com/</span>
										pour héberger votre image en ligne.
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal" >
											<i class="fas fa-window-close"></i>
										</button>
									</div>
								</div>
								<!-- 								.modal-content -->
							</div>
							<!-- 							.modal-dialog -->
						</div>
						<!-- 						end.modal -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<div align="left">
		<div class="col-xs-12 col-md-6">
			<button type="submit" id="btnLogin" class="btn btn-custom">Ajouter
				l'idée</button>
			<%-- 	<form:button type="submit" class="btn btn-primary btn-lg active">ADD</form:button> --%>
			<!-- <button type="submit" class="btn btn-primary btn-lg active"
				value="add">Ajouter</button> -->
		</div>
	</div>
</form:form>
<jsp:include page="include/footer.jsp"></jsp:include>