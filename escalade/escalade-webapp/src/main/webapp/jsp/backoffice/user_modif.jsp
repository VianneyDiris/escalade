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
				<li><s:a action="gestion_spot">Gestion Spot</s:a></li>
				<li><s:a action="gestion_topo">Gestion Topo</s:a></li>
				<li class="active"><s:a action="gestion_user">Gestion Utilisateur</s:a></li>
				<li><s:a action="gestion_comment">Gestion Commentaire</s:a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<s:if test="#session.user">
					<li><s:a>
							<s:property value="#session.user.pseudo" />
						</s:a></li>
					<li><s:a action="logout">Déconnexion</s:a></li>
				</s:if>
			</ul>
		</div>
	</nav>


	<!-- Page Content -->
	<div class="container content center">
	 <s:form action="update_user" class="col-lg-6 col-lg-offset-3">
	  <s:hidden name="id" value="%{user.id}"/>
      <fieldset class="scheduler-border">
        <legend class="scheduler-border">Modification de l'utilisateur</legend>
 
		<div class="form-group">
			<div class="form-group">
			<s:label for="nom" class="espace">Nom</s:label>
			<s:textfield name="nom" class="form-control" value="%{user.nom}"/>
			</div>
			
			<div class="form-group">
			<s:label for="prenom" class="espace">Prénom</s:label>
			<s:textfield name="prenom" class="form-control" value="%{user.prenom}"/>
			</div>
			
			<div class="form-group">
			<s:label for="pseudo" class="espace">Pseudo</s:label>
			<s:textfield name="pseudo" class="form-control" value="%{user.pseudo}"/>
			</div>
			
			<div class="form-group">
			<s:label for="mail" class="espace">Mail</s:label>
			<s:textfield name="mail" class="form-control" value="%{user.mail}"/>
			</div>
			
			<div class="form-group">
			<s:label for="password" class="espace">Password</s:label>
			<s:password name="password" class="form-control"/>
			</div>
			
			<div class="form-group">
			<s:label for="role" class="espace">Role</s:label>
			<s:select headerKey="0" class="form-control" list="listRole" listKey="id" listValue="role" name="userStringRole" />
			</div>
			
			
			
		</div>

	<s:submit value="Sauver modification" class="btn btn-primary center-block"/>
 
</fieldset>
</s:form>
	</div>




	<%@include file="../_include/footer.jsp"%>
</body>
</html>