<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp"></jsp:include>

<!-- Custom styles for this template -->
<link href="inscriptionStyle.css" rel="stylesheet">

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

<spring:url value="/user/processForm" var="processUrl" />
<form:form method="post" action="${processUrl}" modelAttribute="user"
	>

	<div class="row">
		<div
			class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form role="form">
				<h2>
					Inscrivez-vous <small>C'est gratuit et ça le restera !</small>
				</h2>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<form:input path="firstName" type="text"
								class="form-control input-lg" placeholder="Prénom" tabindex="1"
								 />
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<form:input path="lastName" type="text"
								class="form-control input-lg" placeholder="Nom" tabindex="2"
								 />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<form:input path="birthDate" type="date"
								class="form-control input-lg" placeholder="Date de naissance"
								tabindex="3"  />
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<form:input path="login.mail" type="email"
								class="form-control input-lg" placeholder="Adresse email"
								tabindex="4"  />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<form:input path="login.password" type="password"
								class="form-control input-lg" placeholder="Mot de passe"
								tabindex="5"  />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4 col-sm-3 col-md-3">
						<span class="button-checkbox">
							<button type="button" class="btn" data-color="info" tabindex="7"></button>J'accepte
							<input type="checkbox" name="t_and_c" id="t_and_c" class="hidden"
							value="1">
						</span>
					</div>
					<div class="col-xs-8 col-sm-9 col-md-9">
						En cliquant sur <strong class="label label-primary">S'inscrire</strong>,
						vous êtes d'accord avec <a href="#" data-toggle="modal"
							data-target="#t_and_c_m">les Termes et Conditions</a> mis en
						place sur ce site, incluant l'utilisation de nos cookies.
					</div>
				</div>

				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-12 col-md-6">
						<div class="col-xs-12 col-md-6">
							<button type="submit" class="btn btn-primary btn-lg active"
								value="add">S'inscrire</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">Termess & Conditions</h4>
				</div>
				<div class="modal-body">
					<p>
						ARTICLE 1 : Objet <br> Les présentes « conditions générales
						d'utilisation » ont pour objet l'encadrement juridique des
						modalités de mise à disposition des services du site [Nom du site]
						et leur utilisation par « l'Utilisateur ». Les conditions
						générales d'utilisation doivent être acceptées par tout
						Utilisateur souhaitant accéder au site. Elles constituent le
						contrat entre le site et l'Utilisateur. L’accès au site par
						l’Utilisateur signifie son acceptation des présentes conditions
						générales d’utilisation. Éventuellement : En cas de
						non-acceptation des conditions générales d'utilisation stipulées
						dans le présent contrat, l'Utilisateur se doit de renoncer à
						l'accès des services proposés par le site. [Nom du site] se
						réserve le droit de modifier unilatéralement et à tout moment le
						contenu des présentes conditions générales d'utilisation.
					</p>
					<p>
						ARTICLE 2 : Mentions légales <br> L'édition du site [Nom du
						site] est assurée par la Société [Nom de la société] [SAS / SA /
						SARL, etc.] au capital de [montant en euros] € dont le siège
						social est situé au [adresse du siège social]. [Le Directeur / La
						Directrice] de la publication est [Madame / Monsieur] [Nom &
						Prénom]. Éventuellement : [Nom de la société] est une société du
						groupe [Nom de la société] [SAS / SA / SARL, etc.] au capital de
						[montant en euros] € dont le siège social est situé au [adresse du
						siège social]. L'hébergeur du site [Nom du site] est la Société
						[Nom de la société] [SAS / SA / SARL, etc.] au capital de [montant
						en euros] € dont le siège social est situé au [adresse du siège
						social].
					</p>
					<p>
						ARTICLE 3 : Définitions <br> La présente clause a pour objet
						de définir les différents termes essentiels du contrat :
						Utilisateur : ce terme désigne toute personne qui utilise le site
						ou l'un des services proposés par le site. Contenu utilisateur :
						ce sont les données transmises par l'Utilisateur au sein du site.
						Membre : l'Utilisateur devient membre lorsqu'il est identifié sur
						le site. Identifiant et mot de passe : c'est l'ensemble des
						informations nécessaires à l'identification d'un Utilisateur sur
						le site. L'identifiant et le mot de passe permettent à
						l'Utilisateur d'accéder à des services réservés aux membres du
						site. Le mot de passe est confidentiel.
					</p>
					<p>
						ARTICLE 4 : Accès aux services <br> Le site permet à
						l'Utilisateur un accès gratuit aux services suivants : [articles
						d’information] ; [annonces classées] ; [mise en relation de
						personnes] ; [publication de commentaires / d’œuvres personnelles]
						; […]. Le site est accessible gratuitement en tout lieu à tout
						Utilisateur ayant un accès à Internet. Tous les frais supportés
						par l'Utilisateur pour accéder au service (matériel informatique,
						logiciels, connexion Internet, etc.) sont à sa charge. Selon le
						cas : L’Utilisateur non membre n'a pas accès aux services réservés
						aux membres. Pour cela, il doit s'identifier à l'aide de son
						identifiant et de son mot de passe. Le site met en œuvre tous les
						moyens mis à sa disposition pour assurer un accès de qualité à ses
						services. L'obligation étant de moyens, le site ne s'engage pas à
						atteindre ce résultat. Tout événement dû à un cas de force majeure
						ayant pour conséquence un dysfonctionnement du réseau ou du
						serveur n'engage pas la responsabilité de [Nom du site]. L'accès
						aux services du site peut à tout moment faire l'objet d'une
						interruption, d'une suspension, d'une modification sans préavis
						pour une maintenance ou pour tout autre cas. L'Utilisateur
						s'oblige à ne réclamer aucune indemnisation suite à
						l'interruption, à la suspension ou à la modification du présent
						contrat. L'Utilisateur a la possibilité de contacter le site par
						messagerie électronique à l’adresse [contact@nomdusite.com].
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">J'accepte</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</form:form>

<jsp:include page="include/footer.jsp"></jsp:include>