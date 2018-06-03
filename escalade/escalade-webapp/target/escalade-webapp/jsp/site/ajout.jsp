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
		<s:form class="col-lg-5 col-lg-offset-1" action="resultAction" namespace="/" method="POST" enctype="multipart/form-data">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Spot</legend>
				<div class="form-group">
					<s:label for="spot" class="espace">Nom du spot</s:label>
					<s:textfield name="spot" class="form-control" placeholder="nom du spot"/>
				</div>

				<div class="form-group">
					<s:label for="description" class="espace">Description</s:label>
					<s:textarea class="form-control" rows="5" id="comment"></s:textarea>
				</div>

				<div class="form-group">
					<label for="sel1">Selection du pays:</label> <select
						class="form-control" id="sel1">
						<option>France</option>
						<option>Angleterre</option>
						<option>Italie</option>
						<option>Afrique du Sud</option>
					</select>
				</div>

				<div class="form-group">
					<label for="sel1">Selection de la ville:</label> <select
						class="form-control" id="sel1">
						<option>Le Verdon</option>
						<option>Fontainebleau</option>
						<option>Sardeigne</option>
						<option>Capetown</option>
					</select>

				</div>

				<s:file name="fileUpload" label="Selectionnez le spot" size="40" class="btn btn-secondary"/>

				<div class="form-group">
					<label for="voie">Nom de la voie</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						placeholder="nom de la voie"> <label for="sel1">Cotation:</label>
					<select class="form-control" id="sel1">
						<option>3A</option>
						<option>3B</option>
						<option>3C</option>
						<option>4A</option>
					</select>
				</div>

				<s:submit value="submit" name="Valider le spot" class="btn btn-primary center-block" />
			</fieldset>
		</s:form>


		<s:form class="col-lg-5">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Topo</legend>
				<div class="form-group">
					<label for="exampleInputEmail1">Nom du topo</label> <input
						type="text" class="form-control" id="exampleInputEmail1"
						placeholder="nom du topo">

				</div>

				<div class="form-group">
					<label for="comment">Description:</label>
					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>

				<div class="form-group">
					<label for="sel1">Selection du spot:</label> <select
						class="form-control" id="sel1">
						<option>Le Verdon</option>
						<option>Fontainebleau</option>
						<option>Capetown</option>
					</select>
				</div>

				<input type="file" class="btn btn-secondary form-group">

				<div class="form-group btn-group" id="status" data-toggle="buttons">
					<label class="btn btn-default btn-on btn-lg active"> <input
						type="radio" value="1" name="multifeatured_module"
						checked="checked">Public
					</label> <label class="btn btn-default btn-off btn-lg"> <input
						type="radio" value="0" name="multifeatured_module">Privé
					</label>
				</div>

				<div id="espace"></div>
				<button type="submit" class="btn btn-primary center-block">Valider
					le topo</button>
			</fieldset>
		</s:form>
	</div>



	<%@include file="../_include/footer.jsp"%>
</body>
</html>