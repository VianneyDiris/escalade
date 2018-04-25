<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="_include/head.jsp"%>
</head>
<body>
	<nav class="navbar navbar-default"> <!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" data-target="#navbarCollapse"
			data-toggle="collapse" class="navbar-toggle">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="#" class="navbar-brand">Trouve la voie</a>
	</div>

	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.html">Accueil</a></li>
			<li><s:a action="spot_list">Spot</s:a></li>
			<li><a href="#">Topo</a></li>
			<li><a href="ajout.html">Ajout</a></li>
			<li><a href="#">Recherche</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="connexion.html">Connexion</a></li>
			<li><a href="enregistrer.html">S'enregistrer</a></li>
		</ul>
	</div>
	</nav>


	<!-- Page Content -->
	<div class="container main">
		<h1 class="text-center">Trouver la voie</h1>
		<p class="text-center">Lao-Tseu a dit "Il faut trouver la voie".
			J'espère que vous la trouverai ici</p>

	</div>



	<%@include file="_include/footer.jsp"%>
</body>
</html>