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
				<s:if test="#session.user">
		            <li><s:a><s:property value="#session.user.pseudo" /></s:a></li>
		            <li><s:a action="logout">Déconnexion</s:a></li>
    			</s:if>
		    	<s:else>
		        	<li class="active"><s:a action="login">Connexion</s:a></li>
					<li><s:a action="enregistrer">S'enregistrer</s:a></li>
		    	</s:else>
			</ul>
		</div>
	</nav>


	    <!-- Page Content -->
    <div class="container content">
    <s:form action="login" class="col-lg-6 col-lg-offset-3">
      <fieldset class="scheduler-border">
        <legend class="scheduler-border">Se connecter</legend>
 
  <div class="form-inline" id="space-top">
  	<s:label for="pseudo" class="espace">Pseudo</s:label>
	<s:textfield name="pseudo" class="form-control" placeholder="pseudo"/>
   
   	<s:label for="password"  class="espace">Mot de passe</s:label>
	<s:password name="password" class="form-control" placeholder="*********"/>
  </div>
  

	<s:submit value="Connecter" id="connecter" class="btn btn-primary center-block"/>
 
</fieldset>
</s:form>

<s:actionerror/>
<s:actionmessage/>
    </div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>