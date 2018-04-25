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
		<a href="#" class="navbar-brand">Trouve la voie</a>
	</div>

	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="index.html">Accueil</a></li>
			<li class="active"><a href="spot.html">Spot</a></li>
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
	  <div class="container content center">
      <fieldset>
        <legend class="text-center grossissement">Spot</legend>
        <div class="row justify-content-lg-center">

	<s:iterator value="listPays">
	<div class="produit col-lg-3">
		<div class="col-lg-12 panel panel-default">
			<div class="panel-heading"><s:property value="nom"/></div>
			<img alt="img" src="" width=200 height=150>
			<p class="lieu"></p>
			<p class=voie></p>
			<p class="cotation"></p>
			<s:action name="spot_detail"><button class="btn btn-default">Voir détails</button></s:action>
		</div>
	</div>
	</s:iterator>
  

     </div>
   </fieldset>
    </div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>