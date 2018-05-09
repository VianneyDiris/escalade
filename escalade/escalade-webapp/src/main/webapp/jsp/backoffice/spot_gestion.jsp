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
				<li class="active"><s:a action="spot_list">Gestion Spot</s:a></li>
				<li><s:a action="topo_list">Gestion Topo</s:a></li>
				<li><s:a action="ajout">Gestion Utilisateur</s:a></li>
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
		<fieldset>
			<legend class="text-center grossissement">Spot</legend>
			<s:iterator value="listSpots">
				<s:form action="login">
					<div class="form-inline" id="space-top">
						<s:property value="nom"/>
						<s:property value="description"/>
						<s:submit value="modifier" id="connecter"
						class="btn btn-warning" />
						<s:submit value="supprimer" id="connecter"
						class="btn btn-danger" />
						
					</div>


					


				</s:form>
			</s:iterator>

		</fieldset>
	</div>




	<%@include file="../_include/footer.jsp"%>
</body>
</html>