<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>

<!-- Custom styles for this template -->
<link href="classementTopStyle.css" rel="stylesheet">

<style>
.carousel-control .glyphicon-chevron-right, .carousel-control .icon-next
	{
	margin-right: -382px;
}

.carousel-control .glyphicon-chevron-left, .carousel-control .icon-prev
	{
	margin-left: -71px;
}
<%@include file="/WEB-INF/views/classementTopStyle.css"%>
</style>

<div class="row">
	<div class="col-1"></div>
	<div class="col-10 text-center">
		<br></br>
		<div>
			<h1 align="center">
				Classement TOPS <i class="fas fa-medal"></i>
			</h1>
		</div>
		<div>
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">Classement</th>
						<th scope="col">Titre</th>
						<th scope="col">Cat�gorie</th>
						<th scope="col">Note</th>
						<th scope="col">Nombre de votes</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${topIdea}" var="idea">
						<tr>
							<td><c:forEach var="i" begin="1" end="${topIdea.size()}">
									<c:out value="${i}" />
								</c:forEach></td>
							<td>${idea.title}</td>
							<td>${idea.category.title}</td>
							<td>${idea.content}</td>
							<td></td>
<!-- 							<td> -->
<!-- 								Button trigger modal -->
<!-- 								<div align="center"> -->
<!-- 									<button type="button" class="btn btn-primary" -->
<%-- 										data-toggle="modal" data-target="#exampleModalLong-${idea.id}">Visualiser</button> --%>
<!-- 								</div> Modal -->
<%-- 								<div class="modal fade" id="exampleModalLong-${idea.id}" --%>
<!-- 									tabindex="-1" role="dialog" -->
<!-- 									aria-labelledby="exampleModalLongTitle" aria-hidden="true"> -->
<!-- 									<div class="modal-dialog" role="document"> -->
<!-- 										<div class="modal-content"> -->
<!-- 											<div class="modal-header"> -->
<!-- 												<h5 class="modal-title" id="exampleModalLongTitle" -->
<%-- 													align="center">${idea.title}/${idea.category.title}/ --%>
<%-- 													${idea.user.firstName} / ${idea.user.lastName}</h5> --%>

<!-- 												<button type="button" class="close" data-dismiss="modal" -->
<!-- 													aria-label="Close"> -->
<!-- 													<span aria-hidden="true">&times;</span> -->
<!-- 												</button> -->
<!-- 											</div> -->
<!-- 											<div class="modal-body"> -->
<!-- 												<div class="card h-100 border-0"> -->
<!-- 													<a href="#"><img class="card-img-top" -->
<%-- 														src="${idea.picture}" alt=""></a> --%>
<!-- 													<div class="perso"> -->
<!-- 														<div class="card-body"> -->
<!-- 															<h4 class="card-title" align="center"> -->
<%-- 																<a>${idea.title}</a> --%>
<!-- 															</h4> -->
<%-- 															<p class="card-text" align="justify">${idea.content}</p> --%>
<%-- 															<span class="date sub-text">${idea.creationDate}</span> --%>
<!-- 														</div> -->
<!-- 														<div align="center"> -->
<%-- 															<a href="/topaidi/ideas/${idea.id}/addReport" --%>
<!-- 																class="btn btn-primary btn-lg active" role="button"> -->
<!-- 																<i class="fas fa-exclamation-circle"></i> -->
<!-- 															</a> -->
<%-- <%-- 															<span> ${fn:length(idea.usersReport)}</span> --%> --%>
<!-- 															 <a -->
<%-- 																href="/topaidi/ideas/${idea.id}/addReport" --%>
<!-- 																class="btn btn-primary btn-lg active" role="button"> -->
<!-- 																<i class="fas fa-user-slash"></i> -->
<%-- 															</a> <a href="/topaidi/ideas/${idea.id}/addVoteTop" --%>
<!-- 																class="btn btn-primary btn-lg active" role="button"><i -->
<!-- 																class="fas fa-thumbs-up"></i></a><span> nb Vote </span> <a -->
<%-- 																href="/topaidi/ideas/${idea.id}/addVoteFlop" --%>
<!-- 																class="btn btn-primary btn-lg active" role="button" -->
<!-- 																aria-pressed="true"><i class="fas fa-thumbs-down"></i></a><span> -->
<!-- 																nb Vote</span> -->
<!-- 														</div> -->

<!-- 														<div class="titleBox"> -->
<!-- 															<label><i class="far fa-comment"></i> -->
<!-- 																Commentaires </label> -->
<%-- 															<form:form method="POST" action="${idea.id}/addComment" --%>
<%-- 																modelAttribute="comment"> --%>
<%-- 																<form:input path="content" --%>
<%-- 																	placeholder="Votre commentaire..." type="text" --%>
<%-- 																	style="height: 50px" class="form-control" /> --%>
<!-- 																<div align="left"> -->
<!-- 																	<div align="right"> -->
<!-- 																		<input type="submit" class="btn btn-primary" -->
<!-- 																			value="Ajouter Commentaire" /> -->
<!-- 																	</div> -->
<!-- 																</div> -->
<%-- 															</form:form> --%>
<%-- 															<c:forEach items="${idea.comments}" var="comment"> --%>
<%-- 																<p>${comment.user.firstName} --%>
<%-- 																	${comment.user.lastName} : </br> ${comment.title} --%>
<%-- 																	${comment.content} --%>
<!-- 																</p> -->
<%-- 															</c:forEach> --%>
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</td> -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-1"></div>
</div>

<jsp:include page="include/footer.jsp"></jsp:include>