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
			<li><a href="#">Recherche</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><s:a action="connexion">Connexion</s:a></li>
			<li><s:a action="enregistrer">S'enregistrer</s:a></li>
		</ul>
	</div>
	</nav>


	<!-- Page Content -->
	 <div class="container content">
    <article class="produit_detail col-lg-12">
       <h2><s:property value="nom"/></h2>
      <img alt="img" src="resource_image/<s:property value="photo"/>" width=200 height=150>
       <p class="lieu">Lieu du spot: FontaineBleau</p>
       <p class="voie">Voie Préféré : La Via Gregoria</p>
       <p class="cotation">Cotation de la voie : 5B</p>
       <p class="description">site d'escalade proche de Fontainebleau</p>
     <s:a action="spot_list"><button class="btn btn-default">Retour</button></s:a>
     </article>
    </div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>