<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="include/header.jsp"></jsp:include>

<style>
<%@include file="/WEB-INF/views/pageAdminStyle.css"%>
</style>


<p align="center">
	<a class="btn btn-primary" data-toggle="collapse"
		href="#multiCollapseExample1" role="button" aria-expanded="false"
		aria-controls="multiCollapseExample1">Ajouter Catégorie</a> <a
		class="btn btn-primary" data-toggle="collapse"
		href="#multiCollapseExample2" role="button" aria-expanded="false"
		aria-controls="multiCollapseExample2">Utilisateurs inactivés</a>

	<button class="btn btn-primary" type="button" data-toggle="collapse"
		data-target="#multiCollapseExample3" aria-expanded="false"
		aria-controls="#multiCollapseExample3">Idées signalées</button>
</p>
<div class="row">
	<div class="col-sm-6">
		<div class="collapse multi-collapse" id="multiCollapseExample1">
			<div class="card card-body">
				<spring:url value="/admin/processAdd" var="processUrl" />
				<form:form method="POST" action="${processUrl}"
					modelAttribute="category" role="form">
					<div class="row">
						<div class="col-xs-12">
							<h2 align="center">Ajouter votre Catégorie</h2>
							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<form:input path="title" type="text" id="title"
											class="form-control input-lg" placeholder="Titre"
											tabindex="1" />
									</div>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<form:input path="content" type="text" id="content"
											class="form-control input-lg" placeholder="Contenu"
											tabindex="2" />
									</div>
								</div>
								<div>
									<div class="col-xs-12 col-md-6 center-block">
										<button type="submit" id="btnLogin"
											class="btn btn-custom center-block">Ajouter</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="collapse multi-collapse" id="multiCollapseExample2">
			<div class="card card-body">
				<h1>Utilisateurs inactivés</h1>
				<br>
				<div class="col">
					<table class="table table-dark">
						<thead>
							<tr>
								<th scope="col" align="center">Id Utilisateur</th>
								<th scope="col">Nom</th>
								<th scope="col">Prénom</th>
								<th scope="col">Activé l'utilisateur</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${inactivateUser}" var="user">
								<tr>
									<td>${user.id}</td>
									<td>${user.lastName}</td>
									<td>${user.firstName}</td>
									<td><a
										href="/topaidi/admin/${user.id}/processActivated"
										class="btn btn-primary btn-lg active a" role="button"> <i
											class="fas fa-check-square"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="collapse multi-collapse" id="multiCollapseExample3">
			<div class="card card-body">
				<h1>Idées signalées</h1>

				<div class="col">
					<table class="table table-dark">
						<thead>
							<tr>
								<th scope="col">Id Idée</th>
								<th scope="col">Category</th>
								<th scope="col">Titre</th>
								<th scope="col">Nom</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${signaledIdea}" var="idea">
								<tr>
									<td>${idea.id}</td>
									<td>${idea.category.title}</td>
									<td>${idea.title}</td>
									<td>${idea.user.lastName}</td>
									<td>
										<!-- Button trigger modal -->
										<div align="center">
											<button type="button" class="btn btn-primary"
												data-toggle="modal"
												data-target="#exampleModalLong-${idea.id}">Visualiser</button>
										</div>
										<div class="modal fade" id="exampleModalLong-${idea.id}"
											tabindex="-1" role="dialog"
											aria-labelledby="exampleModalLongTitle" aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLongTitle"
															align="center">${idea.title} - ${idea.category.title}
															- ${idea.user.firstName} ${idea.user.lastName}</h5>

														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">
														<div class="card h-100 border-0">
															<a href="#"><img class="card-img-top"
																src="${idea.picture}" alt=""></a>
															<div class="perso">
																<div class="card-body">
																	<h4 class="card-title" align="center">
																		<a>${idea.title}</a>
																	</h4>
																	<p class="card-text" align="justify">${idea.content}
																		<br> <span class="date sub-text">
																			${idea.creationDate} </span>
																	</p>
																</div>
																<div align="center">
																	<a href="/topaidi/ideas/${idea.id}/addReport"
																		class="btn btn-primary btn-lg active" role="button">
																		<i class="fas fa-exclamation-circle"></i>
																	</a><span> ${fn:length(idea.usersReport)}</span> <a
																		href="/topaidi/ideas/${idea.id}/addVoteTop"
																		class="btn btn-primary btn-lg active" role="button"><i
																		class="fas fa-thumbs-up"></i></a><span>
																		${fn:length(idea.usersVoteTop)} </span> <a
																		href="/topaidi/ideas/${idea.id}/addVoteFlop"
																		class="btn btn-primary btn-lg active" role="button"
																		aria-pressed="true"><i class="fas fa-thumbs-down"></i></a><span>
																		${fn:length(idea.usersVoteFlop)}</span>
																</div>

																<div class="titleBox">
																	<label><i class="far fa-comment"></i>
																		Commentaires </label>
																	<c:forEach items="${idea.comments}" var="comment">
																		<p>${comment.user.firstName}
																			${comment.user.lastName} : <br> ${comment.title}
																			${comment.content}
																		</p>
																	</c:forEach>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="include/footer.jsp"></jsp:include>