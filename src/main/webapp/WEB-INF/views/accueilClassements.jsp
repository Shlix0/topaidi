<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>

<!-- Custom styles for this template -->
<link href="acceuilClassementsStyle.css" rel="stylesheet">

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

<br>
<div align="center">
			<a href="/topaidi/classements/top" class="btn btn-primary btn-lg active" role="button"
				aria-pressed="true" ><i
				class="fas fa-folder-open"></i> TOPS</a> <a href="/topaidi/classements/buzz"
				class="btn btn-primary btn-lg active" role="button"
				aria-pressed="true" ><i
				class="fas fa-folder-open"></i> BUZZ</a> <a href="/topaidi/classements/brain"
				class="btn btn-primary btn-lg active" role="button"
				aria-pressed="true" ><i
				class="fas fa-folder-open"></i> BRAINS </a>
		</div>
		<br>

<jsp:include page="include/footer.jsp"></jsp:include>