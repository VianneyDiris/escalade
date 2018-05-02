<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../_include/head.jsp"%>
</head>
<body>
	<nav class="navbar navbar-default">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<s:a action="index" class="navbar-brand">Trouve la voie</s:a>
		</div>

		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><s:a action="index">Accueil</s:a></li>
				<li><s:a action="spot_list">Spot</s:a></li>
				<li><s:a action="topo_list">Topo</s:a></li>
				<li><s:a action="ajout">Ajout</s:a></li>
				<li><a href="#">Recherche</a></li>
				<li class="active">Erreur</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><s:a action="connexion">Connexion</s:a></li>
				<li><s:a action="enregistrer">S'enregistrer</s:a></li>
			</ul>
		</div>
	</nav>

	<h2></h2>
	<div class="container content">
		<fieldset>
			<legend class="text-center grossissement">Topo</legend>
			<div class="row justify-content-lg-center">
				<div class="produit ">
					<div class="col-lg-6 col-lg-offset-3 panel panel-default">
						<div class="panel-heading">Une erreur s'est produite</div>
						<p><s:actionerror /><p>
					</div>
				</div>
			</div>
		</fieldset>
	</div>

</body>
</html>