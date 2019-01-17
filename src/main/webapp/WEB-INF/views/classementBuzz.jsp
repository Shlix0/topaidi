<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>

<!-- Custom styles for this template -->
<link href="classementBuzzStyle.css" rel="stylesheet">

<style>
.carousel-control .glyphicon-chevron-right, .carousel-control .icon-next
	{
	margin-right: -382px;
}

.carousel-control .glyphicon-chevron-left, .carousel-control .icon-prev
	{
	margin-left: -71px;
}
</style>

<div class="row">
	<div class="col-1"></div>
	<div class="col-10 text-center">
		<br></br>
		<div>
			<h1 align="center">
				Classement BUZZ <i class="fas fa-medal"></i>
			</h1>
		</div>
		<div>
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">Classement</th>
						<th scope="col">Titre</th>
						<th scope="col">Catégorie</th>
						<th scope="col">Note</th>
						<th scope="col">Nombre de votes</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${artisteList}" var="aL">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<!-- Button trigger modal -->
								<div align="center">
									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#exampleModalLong8">Visualiser</button>
								</div> <!-- Modal -->
								<div class="modal fade" id="exampleModalLong8" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLongTitle"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle"
													align="center">Titre idée / Titre Catégorie / Pseudo
													ou nom d'ultilisateur</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<div class="card h-100 border-0">
													<a href="#"><img class="card-img-top"
														src="http://placehold.it/700x400" alt=""></a>
													<div class="perso">
														<div class="card-body">
															<h4 class="card-title" align="center">
																<a>Projet 1</a>
															</h4>
															<p class="card-text" align="justify">Lorem ipsum
																dolor sit amet, consectetur adipisicing elit. Amet
																numquam aspernatur eum quasi sapiente nesciunt?
																Voluptatibus sit, repellat sequi itaque deserunt,
																dolores in, nesciunt, illum tempora ex quae? Nihil,
																dolorem!</p>
														</div>

														<div class="titleBox" align="left">
															<label><i class="far fa-comment"></i>
																Commentaires </label> <input placeholder="Votre commentaire..."
																type="text" style="height: 50px" class="form-control" />
															<div align="left">
																<span class="date sub-text">3 Janvier 2018</span>
																<div align="right">
																	<a href="#" class="btn btn-primary btn-lg active"
																		role="button" aria-pressed="true" data-dismiss="modal"><i
																		class="fas fa-sign-in-alt"></i></a>
																</div>
															</div>
														</div>
														<div align="center">
															<a href="#" class="btn btn-primary btn-lg active"
																role="button" aria-pressed="true" data-dismiss="modal"><i
																class="fas fa-exclamation-circle"></i></a><a href="#"
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
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-1"></div>
</div>

<jsp:include page="include/footer.jsp"></jsp:include>