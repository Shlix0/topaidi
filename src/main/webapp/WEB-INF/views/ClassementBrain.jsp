<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>

<!-- Custom styles for this template -->
<link href="ClassementBrainStyle.css" rel="stylesheet">

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
				Classement BRAINS <i class="fas fa-medal"></i>
			</h1>
		</div>
		<div>
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">Classement</th>
						<th scope="col">Utilisateur</th>
						<th scope="col">Nombre d'idées</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${artisteList}" var="aL">
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-1"></div>
</div>

<jsp:include page="include/footer.jsp"></jsp:include>