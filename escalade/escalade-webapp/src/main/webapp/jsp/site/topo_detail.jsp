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
			<li><s:a action="spot_list">Spot</s:a></li>
			<li class="active"><s:a action="topo_list">Topo</s:a></li>
			<li><s:a action="ajout">Ajout</s:a></li>
			<li><s:a action="search">Recherche</s:a></li>
			<s:if test="%{#session.user.role.role=='admin'}">
				<li><s:a action="gestion_spot">Administration</s:a></li>
			</s:if>
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
        <legend class="text-center grossissement">Topo</legend>
        <div class="row justify-content-lg-center">
		 <div class="produit col-lg-8 col-lg-offset-2 ">
			<div class="panel panel-default">
				<div class="panel-heading"><s:property value="topo.nom"/></div>
				<div class="panel-body">
				<img class="col-lg-8" alt="img" src="resource_image/<s:property value="topo.photo"/>">
				<div class="col-lg-4">
					<p class="lieu">Pays: <s:property value="topo.spot.pays.nom"/></p>
					<p class=nom>Ville: <s:property value="topo.spot.ville.nom"/>  </p>
					<p class="description">Description: <s:property value="topo.description"/><p>
					<s:a action="topo_list"><button class="btn btn-default">Retour</button></s:a>
				</div>
				</div>
			</div>
		</div>
    </div>
   </fieldset>
   
   <div  class="text-center">
   <s:if test="%{topo.prive==true}">
   	<s:if test="#session.user"  >
   	<s:a action="topo_reserve"><button class="btn btn-primary">Reservation</button></s:a>
   	</s:if>
   	<s:else>
   		<h3>Vous devez être connecté pour réservé ce topo</h3>
   	</s:else>
   </s:if>
    </div>
    </div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>