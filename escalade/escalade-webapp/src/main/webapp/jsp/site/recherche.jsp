<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../_include/head.jsp"%>
</head>
<body>
	<nav class="navbar navbar-default"> <!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" data-target="#navbarCollapse"
			data-toggle="collapse" class="navbar-toggle">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<s:a action="index" class="navbar-brand">Trouve la voie</s:a>
	</div>

	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li><s:a action="index">Accueil</s:a></li>
			<li class="active"><s:a action="spot_list">Spot</s:a></li>
			<li><s:a action="topo_list">Topo</s:a></li>
			<li><s:a action="ajout">Ajout</s:a></li>
			<li><a href="recherche">Recherche</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			 <s:if test="#session.user">
	            <li><s:a><s:property value="#session.user.pseudo" /></s:a></li>
	            <li><s:a action="logout">Déconnexion</s:a></li>
	    	</s:if>
	    	<s:else>
	        	<li><s:a action="login">Connexion</s:a></li>
				<li><s:a action="enregistrer">S'enregistrer</s:a></li>
	    	</s:else>
		</ul>
	</div>
	</nav>


<!-- Page Content -->
	 <div class="container content">
	  <fieldset>
        <legend class="text-center grossissement">Spot</legend>
        <div class="row justify-content-lg-center">
		 <div class="produit ">
			<div class="col-lg-8 col-lg-offset-2 panel panel-default">
				<div class="panel-heading"><s:property value="spot.nom"/></div>
				<img class="col-lg-8" alt="img" src="resource_image/<s:property value="spot.photo"/>">
				<div class="col-lg-4">
					<p class="lieu">Pays: <s:property value="spot.pays.nom"/></p>
					<p class=nom>Ville: <s:property value="spot.ville.nom"/>  </p>
					<p class="description">Description: <s:property value="spot.description"/><p>
					<s:a action="spot_list"><button class="btn btn-default">Retour</button></s:a>
				</div>
			</div>
		</div>
    </div>
   </fieldset>
    </div>

	<s:if test="commentaire">
	<p><s:property value="commentaire.contenue"/></p>
	</s:if>
	<s:else>
	<p>no comment</p>
	</s:else>
	

	<%@include file="../_include/footer.jsp"%>
</body>
</html>