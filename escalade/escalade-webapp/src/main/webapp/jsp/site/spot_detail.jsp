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
        <legend class="text-center grossissement">Spot</legend>
        <div class="row justify-content-lg-center">
		 <div class="produit col-lg-8 col-lg-offset-2">
			<div class="panel panel-default">
				<div class="panel-heading"><s:property value="spot.nom"/></div>
				<div class="panel-body">
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
    </div>
   </fieldset>
    


	<s:if test="%{commentaire != null}">
	<div class="col-lg-8 col-lg-offset-2">
	<div class="table-responsive">
  		<table class="table table-hover table-border">
  		 <thead>
	      <tr>
	        <th>Pseudo</th>
	        <th>Contenue</th>
	      </tr>
   		</thead>
   		  <tbody>
		<s:iterator value="commentaire">
		 <tr>
		        <td><s:property value="utilisateur.pseudo"/></td>
		        <td><s:property value="contenue"/></td>
		 </tr>
		</s:iterator>
		<tbody>
		</table>
		</div>
		</div>
	</s:if>

	
	 <s:if test="#session.user">
	  <s:form action="spot_commentaire" class="col-lg-8 col-lg-offset-3">
	  <s:hidden name="id" value="%{spot.id}"/>
	  	<div class="form-inline">
			<s:label for="newComment" class="espace">Commentaire</s:label>
			<s:textfield name="newComment" class="form-control" value=""/>
			  <s:submit value="poster commentaire" class="btn btn-primary"/>
			</div>
	
	  </s:form>
	 </s:if>
	
	
</div>
	<%@include file="../_include/footer.jsp"%>
</body>
</html>