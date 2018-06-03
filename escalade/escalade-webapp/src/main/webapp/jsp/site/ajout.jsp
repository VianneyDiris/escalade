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
				<li class="active"><s:a action="ajout">Ajout</s:a></li>
				<li><s:a action="search">Recherche</s:a></li>
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


	<div class="container content">
		<s:form class="col-lg-5 col-lg-offset-1" action="addSpot" namespace="/" method="POST" enctype="multipart/form-data">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Spot</legend>
				
				<div class="form-group">
					<s:label for="spot" class="espace">Nom du spot</s:label>
					<s:textfield name="spot" class="form-control" placeholder="nom du spot"/>
				</div>

				<div class="form-group">
					<s:label for="description" class="espace">Description</s:label>
					<s:textarea class="form-control" rows="5" id="comment" name="description"></s:textarea>
				</div>

			<div class="form-group">
			<s:label for="StringPays" class="espace">Pays</s:label>
			<s:select headerKey="0" name="StringPays" class="form-control" list="listPays" listValue="nom" listKey="id"/>
			</div>
			
			<div class="form-group">
			<s:label for="StringVille" class="espace">Ville</s:label>
			<s:select headerKey="0" name="StringVille" class="form-control" list="listVille" listValue="nom" listKey="id"/>
			</div>	

				<s:file name="fileUpload" label="Selectionnez le spot" size="40" class="btn btn-secondary"/>

				

				<s:submit value="Valider le spot" class="btn btn-primary center-block" />
			</fieldset>
		</s:form>

		<s:form class="col-lg-5" action="addTopo" namespace="/" method="POST" enctype="multipart/form-data">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Topo</legend>
				
				<div class="form-group">
					<s:label for="topo" class="espace">Nom du topo</s:label>
					<s:textfield name="topo" class="form-control" placeholder="nom du topo"/>
				</div>

				<div class="form-group">
					<s:label for="description" class="espace">Description</s:label>
					<s:textarea class="form-control" rows="5" id="comment" name="description"></s:textarea>
				</div>

				<div class="form-group">
			<s:label for="StringSpot" class="espace">Spot</s:label>
			<s:select headerKey="0" name="StringSpot" class="form-control" list="listSpot" listValue="nom" listKey="id"/>
			</div>	

				

				<div class="form-group">
				<s:label for="prive" class="">Privé: </s:label>
				<s:radio name="prive" list="#{'true':'Oui','false':'Non'}" />
				</div>

				<div class="form-group">
				<s:file name="fileUpload" label="Select a File to upload" size="40" />
				</div>
				<button type="submit" class="btn btn-primary center-block">Valider
					le topo</button>
			</fieldset>
		</s:form>
	</div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>