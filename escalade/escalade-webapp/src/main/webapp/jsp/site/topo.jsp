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
			<li><a href="#">Recherche</a></li>
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
  <div class="container content center">
      <fieldset>
        <legend class="text-center grossissement">Topo</legend>
        <div class="row justify-content-lg-center">

	<s:iterator value="listTopos">
	<div class="produit col-lg-3">
		<div class="col-lg-12 panel panel-default">
			<div class="panel-heading"><s:property value="nom"/></div>
			<img alt="img" src="resource_image/<s:property value="photo"/>" width=200 height=150>
			<p class="lieu">Pays: <s:property value="spot.pays.nom"/></p>
			<p class=nom>Ville: <s:property value="spot.ville.nom"/>  </p>
			<p><p>
			<s:a action="topo_detail"><s:param name="id" value="id" /><button class="btn btn-default">Voir détails</button></s:a>
		</div>
	</div>
	</s:iterator>
  

     </div>
   </fieldset>
    </div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>