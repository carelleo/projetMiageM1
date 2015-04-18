<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	 <head>
        <meta charset="utf-8"/>
        <title>CoproManager - Mes informations</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Christopher Boudier">
        
        <meta http-equiv="imagetoolbar" content="no" />
        <meta name="MSSmartTagsPreventParsing" content="true" />

        <!-- the styles -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-responsive.min.css" />">
        <link rel='stylesheet' type='text/css' href="<c:url value="http://fonts.googleapis.com/css?family=Pontano+Sans" />">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/nivo-slider/themes/default/default.css" />" media="screen" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/nivo-slider/nivo-slider.css" />" >
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/lightbox/css/lightbox.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/template.css" />" media="screen">   
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style1.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style2" href="<c:url value="/resources/css/style2.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style3" href="<c:url value="/resources/css/style3.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style4" href="<c:url value="/resources/css/style4.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style5" href="<c:url value="/resources/css/style5.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style6" href="<c:url value="/resources/css/style6.css" />" />
    
    
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/swfobject/swfobject.js" />"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/lightbox/js/lightbox.js" />"></script>

        <!-- style switcher -->
        <script type="text/javascript" src="<c:url value="/resources/js/styleswitcher.js" />"></script>
        

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        

        <!-- The fav and touch icons -->
        <link rel="shortcut icon" href="<c:url value="/resources/img/ico/favicon.ico" />">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/resources/img/ico/apple-touch-icon-144-precomposed.png" />">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/resources/img/ico/apple-touch-icon-114-precomposed.png" />">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/resources/img/ico/apple-touch-icon-72-precomposed.png" />">
        <link rel="apple-touch-icon-precomposed" href="<c:url value="/resources/img/ico/apple-touch-icon-57-precomposed.png" />">
    </head>

	 <body>
		<section id="header">
        <!-- Include the header bar -->
            <%@include file="header.jsp"%>
        <!-- /.container -->  
        </section><!-- /#header -->
         
        <section id="navigation-main">   
        	<!-- Include the navigation bar -->
        	<%@include file="navigation.jsp"%>
        </section><!-- /#navigation-main -->

		<!-- Include the content pages -->
		<section class="main-body">
			<div class="container">
				<div class="row-fluid">
	         		<div class="span12">
						<div class="span12">
					   		<h3 class="header">Détails
					            <span class="header-line"></span> 
					        </h3>
					    </div>
				  		
				  		<h4>Nom</h4>
				  		<p><c:out value="${sessionScope.utilisateur.getNom()}"/></p>
				  		<br>
				  		
				  		<h4>Prénom</h4>
				  		<p><c:out value="${sessionScope.utilisateur.getPrenom()}"/></p>
				  		<br>
				  		
				  		<h4>Mail</h4>
				  		<p><c:out value="${sessionScope.utilisateur.getMail()}"/></p>
				  		<br>
				  		
				  		<h4>Mot de passe</h4>
				  		<p><c:out value="${sessionScope.utilisateur.getMdp()}"/></p>
				  		<br>
				  		
				  		<h4>Numéro de téléphone fixe</h4>
				  		<p><c:out value="${sessionScope.utilisateur.getTeleF()}"/></p>
				  		<br>
				  		
				  		<h4>Numéro de téléphone portable</h4>
				  		<p><c:out value="${sessionScope.utilisateur.getTeleP()}"/></p>
				  		<br>
	         		</div>
	         		
	         		<a href="#modalModif" role="button" class="btn btn-success" data-toggle="modal">Modifier</a>
	         		<hr>
		      	</div>
			</div>
		</section>
			
		<%@include file="footer.jsp"%> 

		<!-- Modal Modif-->
		<div class="modal hide fade" id="modalModif">
		
		  	<div class="modal-header">
		    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		    	<h3>Modifier ses informations</h3>
		  	</div>
		
		  	<s:form action="informationForm">
		
			  	<div class="modal-body">
					<c:choose>
						<c:when test="${sessionScope.type == 'proprietaire' || sessionScope.type == 'locataire'}">
						
							<c:if test="${sessionScope.type == 'proprietaire'}">
								<s:select label="Type" name="c.type" size="1" list="#{'proprietaire':'Proprietaire', 'locataire':'Locataire'}" multiple="false" required="required"/>
							</c:if>
							<c:if test="${sessionScope.type == 'locataire'}">
								<s:select label="Type" name="c.type" size="1" list="#{'locataire':'Locataire', 'proprietaire':'Proprietaire'}" multiple="false" required="required"/>
							</c:if>
							
							<s:textfield label="Nom" name="c.nom" value="%{#attr['c'].getNom()}" requiered="requiered"/>
							
							<s:textfield label="Prénom" name="c.prenom" value="%{#attr['c'].getPrenom()}" requiered="requiered"/>
							
							<s:textfield label="Mail" name="c.mail" value="%{#attr['c'].getMail()}" requiered="requiered"/>
							
							<s:textfield label="Mot de passe" name="c.mdp" value="%{#attr['c'].getMdp()}" requiered="requiered"/>
							
							<s:textfield label="Confirmation mdp" name="c.mdpc" value="%{#attr['c'].getMdpc()}" requiered="requiered"/>
							
							<s:textfield label="Téléphone fixe" name="c.teleF" value="%{#attr['c'].getTeleF()}" requiered="requiered"/>
							
							<s:textfield label="Téléphone portable" name="c.teleP" value="%{#attr['c'].getTeleP()}" requiered="requiered"/>
							
						</c:when>
						
						<c:when test="${sessionScope.type == 'syndic'}">
							<s:textfield label="Nom" name="s.nom" value="%{#attr['s'].getNom()}" requiered="requiered"/>
							
							<s:textfield label="Prénom" name="s.prenom" value="%{#attr['s'].getPrenom()}" requiered="requiered"/>
							
							<s:textfield label="Mail" name="s.mail" value="%{#attr['s'].getMail()}" requiered="requiered"/>
							
							<s:textfield label="Mot de passe" name="s.mdp" value="%{#attr['s'].getMdp()}" requiered="requiered"/>
							
							<s:textfield label="Confirmation mdp" name="s.mdpc" value="%{#attr['s'].getMdpc()}" requiered="requiered"/>
							
							<s:textfield label="Téléphone fixe" name="s.teleF" value="%{#attr['s'].getTeleF()}" requiered="requiered"/>
							
							<s:textfield label="Téléphone portable" name="s.teleP" value="%{#attr['s'].getTeleP()}" requiered="requiered"/>
							
						</c:when>
						
						<c:otherwise>
							<s:textfield label="Nom" name="a.nom" value="%{#attr['a'].getNom()}" requiered="requiered"/>
							
							<s:textfield label="Prénom" name="a.prenom" value="%{#attr['a'].getPrenom()}" requiered="requiered"/>
							
							<s:textfield label="Mail" name="a.mail" value="%{#attr['a'].getMail()}" requiered="requiered"/>
							
							<s:textfield label="Mot de passe" name="a.mdp" value="%{#attr['a'].getMdp()}" requiered="requiered"/>
							
							<s:textfield label="Confirmation mdp" name="a.mdpc" value="%{#attr['a'].getMdpc()}" requiered="requiered"/>
							
							<s:textfield label="Téléphone fixe" name="a.teleF" value="%{#attr['a'].getTeleF()}" requiered="requiered"/>
							
							<s:textfield label="Téléphone portable" name="a.teleP" value="%{#attr['a'].getTeleP()}" requiered="requiered"/>
							
						</c:otherwise>
					</c:choose>
					
					<s:submit value="Valider" name="submitAj" class="btn btn-large btn-primary"/>
			  	</div>
		
			</s:form> 		
		</div>

		<!-- Le javascript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		  
	  	<script src="<c:url value="/resources/js/bootstrap-transition.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-alert.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-modal.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-dropdown.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-scrollspy.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-tab.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-tooltip.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-popover.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-button.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-collapse.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-carousel.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-typeahead.js" />"></script>   
        <script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js" />"></script>
         
	</body>
</html>