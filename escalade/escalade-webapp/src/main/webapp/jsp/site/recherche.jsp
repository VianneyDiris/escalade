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
				<li class="active"><s:a action="search">Recherche</s:a></li>
				<s:if test="%{#session.user.role.role=='admin'}">
					<li><s:a action="gestion_spot">Administration</s:a></li>
				</s:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<s:if test="#session.user">
					<li><s:a>
							<s:property value="#session.user.pseudo" />
						</s:a></li>
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
		<s:form action="login" class="col-lg-6 col-lg-offset-3">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Recherche topo</legend>

				<div class="form-inline" id="space-top">
				
					<s:label for="listSpot" class="espace">Spot</s:label>
					<s:select  headerKey="1" class="form-control" list="listSpot" listValue="nom" name="listSpot" />
					
					<s:label for="listPays" class="espace">Pays</s:label>
					<s:select headerKey="1"  class="form-control" list="listPays" listValue="nom" name="listPays" />
					
					<s:label for="listVille" class="espace">Ville</s:label>
					<s:select headerKey="1"  class="form-control" list="listVilles" listValue="nom" name="listVille" />
				</div>


				<s:submit value="Rechercher" id="connecter"
					class="btn btn-primary center-block" />

			</fieldset>
		</s:form>
		
		<s:form action="login" class="col-lg-8 col-lg-offset-2">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Recherche Spot</legend>

				<div class="form-inline" id="space-top">
					<s:label for="listPays" class="espace">Pays</s:label>
					<s:select headerKey="1"  class="form-control" list="listPays" listValue="nom" name="listPays" />
					
					<s:label for="listVille" class="espace">Ville</s:label>
					<s:select headerKey="1"  class="form-control" list="listVilles" listValue="nom" name="listVille" />
					
					<s:label for="listSecteur" class="espace">Secteur</s:label>
					<s:select headerKey="1"  class="form-control" list="listSecteur" listValue="nom" name="listSecteur" />
					
					<s:label for="listVoie" class="espace">Voie</s:label>
					<s:select headerKey="1"  class="form-control" list="listVoies" listValue="nom" name="listVoie" />

				</div>


				<s:submit value="Rechercher" id="connecter"
					class="btn btn-primary center-block" />

			</fieldset>
		</s:form>
	</div>




	<%@include file="../_include/footer.jsp"%>
</body>
</html>