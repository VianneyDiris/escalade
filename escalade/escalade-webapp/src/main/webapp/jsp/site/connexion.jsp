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
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><s:a action="connexion">Connexion</s:a></li>
				<li><s:a action="enregistrer">S'enregistrer</s:a></li>
			</ul>
		</div>
	</nav>


	    <!-- Page Content -->
    <div class="container content">
    <form class="col-lg-6 col-lg-offset-3">
      <fieldset class="scheduler-border">
        <legend class="scheduler-border">Se connecter</legend>
 
  <div class="form-inline" id="space-top">
    <label for="exampleInputPassword1"class="espace">Pseudo</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="pseudo">

    <label for="exampleInputPassword1" id="space-right" class="espace">Mot de passe</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="**********">
  </div>
  


 
  <button type="submit" class="btn btn-primary center-block" id="connecter">Connecter</button>
</fieldset>
</form>
    </div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>