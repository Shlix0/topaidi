<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
							<a>${idea.title}</a>
						</h4>
						<p class="card-text" align="justify">${idea.content}</p>

						<!-- Button trigger modal -->
						<div align="center">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModalLong">Visualiser</button>
						</div>
						<!-- Modal -->
						<div class="modal fade" id="exampleModalLong" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLongTitle"
							aria-hidden="true">

							<form:input path="idIdea" type="hidden" />

							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle"
											align="center">${idea.title}/${idea.category.title}/
											${idea.user.firstName} / ${idea.user.lastName}</h5>

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
													<p class="card-text" align="justify">${idea.content}</p>
												</div>

												<div class="titleBox">
													<label><i class="far fa-comment"></i> Commentaires
													</label> <input placeholder="Votre commentaire..." type="text"
														style="height: 50px" class="form-control" />
													<div align="left">
														<span class="date sub-text">${idea.creationDate}</span>
														<div align="right">
															<a href="${idea.idIdea}/addComment"
																class="btn btn-primary btn-lg active" role="button"
																aria-pressed="true"><i class="fas fa-sign-in-alt"></i></a>
														</div>
													</div>
													<c:forEach items="${commentList}" var="comment">
														<p>${comment.title} ${comment.content}</p>
													</c:forEach>
												</div>
												<div align="center">
													<a href="#" class="btn btn-primary btn-lg active"
														role="button" aria-pressed="true" data-dismiss="modal"><i
														class="fas fa-exclamation-circle"></i></a> <a href="#"
														class="btn btn-primary btn-lg active" role="button"
														aria-pressed="true" data-dismiss="modal"><i
														class="fas fa-user-slash"></i></a> <a href="#"
														class="btn btn-primary btn-lg active" role="button"
														aria-pressed="true" data-dismiss="modal"><i
														class="fas fa-thumbs-up"></i></a> <a href="#"
														class="btn btn-primary btn-lg active" role="button"
														aria-pressed="true" data-dismiss="modal"><i
														class="fas fa-thumbs-down"></i></a>
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