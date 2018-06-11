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
    <s:form action="topo_reserve" class="col-lg-6 col-lg-offset-3">
      <fieldset class="scheduler-border">
        <legend class="scheduler-border">Réservation</legend>
 
  <div class="form-inline">
  	<s:label for="dateDebut" class="espace">Date de début</s:label>
	<input type="date" name="dateDebut">
	
	
	
   	<s:label for="dateFin" class="espace">Date de fin</s:label>
	<input type="date"  name="dateFin">
  </div>

	<s:submit value="Réserver le topo" id="connecter" class="btn btn-primary center-block"/>
 <div>
<s:actionmessage/>
</div>
</fieldset>
</s:form>


<!-- mettre liste réservation -->
 <s:if test="%{listReservation != null}">

	<div class="col-lg-6 col-lg-offset-3">
	 <div class="text-center">
 <h3>Liste des réservations</h3>
 </div>
	<div class="table-responsive">
  		<table class="table table-hover table-border">
  		 <thead>
	      <tr>
	        <th>date début</th>
	        <th>date fin</th>
	      </tr>
   		</thead>
   		  <tbody>
		<s:iterator value="listReservation">
		 <tr>
		        <td><s:property value="dateDebut"/></td>
		        <td><s:property value="dateFin"/></td>
		 </tr>
		</s:iterator>
		<tbody>
		</table>
		</div>
		</div>
	</s:if>

    </div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>