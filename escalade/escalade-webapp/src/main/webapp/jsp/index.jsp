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
		<s:a action="index" class="navbar-brand">Trouve la voie</s:a>
	</div>

	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><s:a action="index">Accueil</s:a></li>
			<li><s:a action="spot_list">Spot</s:a></li>
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
	<div class="container main">
		<h1 class="text-center">Trouver la voie</h1>
		<p class="text-center">Lao-Tseu a dit "Il faut trouver la voie".
			J'espère que vous la trouverai ici</p>

	</div>



	<%@include file="_include/footer.jsp"%>
</body>
</html>