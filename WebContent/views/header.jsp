<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<div class="row-fluid">

		<div class="span6">
			<a href="" class="logo"></a>
		</div>
  
		<div class="span6">
			<div class="social-icons pull-right clearfix">

				<div class="header-text" id="herder-compte" style="">
							<ul id="compte" class="nav">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">Compte <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li>
												<a href="#myModal" data-toggle="modal">Connection</a>
										</li>
										<li>
												<a href="inscription">Nouveau</a>
										</li>
									</ul>
								</li>
							</ul>
					</div>

					<div id="recherche">
						<form id="search" class="navbar-search pull-left">
							<input type="text" class="search-query" placeholder="Recherche">
						</form>
					</div>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="modal hide fade" id="myModal">

  	<div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h3>Se connecter</h3>
  	</div>

  	<form method="post" action="page">

	  	<div class="modal-body">
	    	<label for="emailMod">Email</label>
			<input type="text" id="emailMod" name="emailMod" value="<c:out value="${param.emailMod}"/>" size="20" maxlength="20" /> 
				<span class="erreur">${erreursMod['emailMod']}</span>
			<br />

			<label for="mdpMod">Mot de passe</label>
			<input type="text" id="mdpMod" name="mdpMod" value="<c:out value="${param.mdpMod}"/>" size="20" maxlength="20" />
				<span class="erreur">${erreursMod['mdpMod']}</span>
	  	</div>

	</form> 

	  	<div class="modal-footer">
	  		<div class="sansLabel">
	  			<form method="post" action="page">
	  			
	    			<a href="#" class="btn" data-dismiss="modal">Annuler</a>
					<input type="submit" name="subMod" value="Se connecter" class="btn btn-primary" />

				</form> 
			</div>
	  	</div>  

</div>