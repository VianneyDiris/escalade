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
				<li><s:a action="gestion_user">Gestion Utilisateur</s:a></li>
				<li class="active"><s:a action="gestion_comment">Gestion Commentaire</s:a></li>
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
	<div class="col-lg-8 col-lg-offset-2">
	<div class="table-responsive">
  		<table class="table table-hover table-border">
  		 <thead>
	      <tr>
	        <th>Posté par</th>
	        <th>Contenue</th>
	        <th>Modifier</th>
	        <th>Supprimer</th>
	      </tr>
   		</thead>
   		  <tbody>
   		  <s:iterator value="listCommentaires">
		      <tr>
		        <td><s:property value="utilisateur.pseudo"/></td>
		        <td><s:property value="contenue"/></td>
		        <td><s:a action="detail_comment"><s:param name="id" value="id" /><button class="btn btn-warning">modifier</button></s:a></td>
		        <td><s:a action="delete_comment"><s:param name="id" value="id" /><button class="btn btn-danger">supprimer</button></s:a></td>
		      </tr>
		    </s:iterator>
		   </tbody>
   
  		</table>
	</div>
	</div>
	</div>




	<%@include file="../_include/footer.jsp"%>
</body>
</html>