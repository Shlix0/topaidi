<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="include/header.jsp"></jsp:include>
<div class="row">
	<c:forEach items="${ideaList}" var="idea">
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<!-- <div class="card"> -->
			<!-- <img src="..." class="card-img-top" alt="Image de ?"> -->
			<div class="card h-100">
				<a href="#"><img class="card-img-top" src="${idea.title}" alt=""></a>
				<div class="perso">
					<div class="card-body">
						<h4 class="card-title" align="center">
							<a><span style="text-decoration: underline;">Titre :</span>
								${idea.title}</a>
						</h4>
						<p align="center">
							<span style="text-decoration: underline;"> Catégorie :</span>
							${idea.category.title}
						</p>
						<p align="center">
							<span style="text-decoration: underline;">Auteur :</span>
							${idea.user.firstName} ${idea.user.lastName}
						</p>
						<!-- Button trigger modal -->
						<div align="center">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModalLong-${idea.id}">Visualiser</button>
						</div>
						<!-- Modal -->
						<div class="modal fade" id="exampleModalLong-${idea.id}"
							tabindex="-1" role="dialog"
							aria-labelledby="exampleModalLongTitle" aria-hidden="true">

							<%-- 							<form:input path="idIdea" type="hidden" /> --%>

							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle"
											align="center">${idea.title}- ${idea.category.title} -
											${idea.user.firstName} ${idea.user.lastName}</h5>

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
														class="btn btn-primary btn-lg active" role="button"> <i
														class="fas fa-exclamation-circle"></i>
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
													<label><i class="far fa-comment"></i> Commentaires
													</label>
													<form:form method="POST" action="${idea.id}/addComment"
														modelAttribute="comment">
														<form:input path="title"
															placeholder="Votre titre" type="text"
															style="height: 20px" class="form-control b" />
														<form:input path="content"
															placeholder="Votre commentaire..." type="text"
															style="height: 30px" class="form-control" />
															<br>
															<div align="right">
																	<input type="submit" class="btn btn-primary bg-sm"
																	value="Ajouter Commentaire" />
															</div>
													</form:form>
													<c:forEach items="${idea.comments}" var="comment">
														<p>${comment.user.firstName}
															${comment.user.lastName} : ${comment.title}
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
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>





<jsp:include page="include/footer.jsp"></jsp:include>