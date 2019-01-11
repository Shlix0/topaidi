<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>
	  <div class="container">
    <div class="row">
<div class="card">
  <div class="card-header">
    Artist
  </div>
  <div class="card-body">
    <h5 class="card-title">Manage Artist</h5>
    <p class="card-text">You can acces to all Artist and modify them...</p>
    <a href="artists/list" class="btn btn-primary">LIST OF ARTIST</a>
  </div>
</div>
	</div>
	</div>
		  <div class="container">
    <div class="row">
<div class="card">
  <div class="card-header">
    CD
  </div>
  <div class="card-body">
    <h5 class="card-title">Manage CD</h5>
    <p class="card-text">You can acces to all CD...</p>
    <a href="cds/list" class="btn btn-primary">CD</a>
  </div>
</div>
	</div>
	</div>


<jsp:include page="include/footer.jsp"></jsp:include>