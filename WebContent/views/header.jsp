<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
									<c:choose>
										<c:when test="${sessionScope.mail != null}">
											<a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${sessionScope.mail}"></c:out> <b class="caret"></b></a>
										</c:when>
										<c:otherwise>
											<a href="#" class="dropdown-toggle" data-toggle="dropdown">Compte <b class="caret"></b></a>
										</c:otherwise>
									</c:choose>
									<ul class="dropdown-menu">
										<li>
											<c:choose>
												<c:when test="${sessionScope.mail != null}">
													<a href="deconnexion">Déconnexion</a>
												</c:when>
												<c:otherwise>
													<a href="#myModal" data-toggle="modal">Connexion</a>
												</c:otherwise>
											</c:choose>
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

  	<s:form action="connexion">

	  	<div class="modal-body">
	    	<s:textfield label="Email" name="mail" required="required"/>

			<s:password label="Mot de passe" name="mdp" required="required"/>
			
			<s:submit key="Valider" name="submitPart" class="btn btn-large btn-primary"/>
	  	</div>

	</s:form> 

</div>