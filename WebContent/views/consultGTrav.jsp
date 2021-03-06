<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	 <head>
        <meta charset="utf-8"/>
        <title>CoproManager - Consultation de Travaux</title>
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
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dtpk.css" /> ">
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style2" href="<c:url value="/resources/css/style2.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style3" href="<c:url value="/resources/css/style3.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style4" href="<c:url value="/resources/css/style4.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style5" href="<c:url value="/resources/css/style5.css" />" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style6" href="<c:url value="/resources/css/style6.css" />" />
    
    
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
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
					   		<h3 class="header">Gros Travaux
					            <span class="header-line"></span> 
					        </h3>
					    </div>
				  		
				  		<h4>Sujet</h4>
				  		<p><c:out value="${sessionScope.grt.getSujet()}"/></p>
				  		<br>
				  		
				  		<h4>Contenu</h4>
				  		<p><c:out value="${sessionScope.grt.getContenu()}"/></p>
				  		<br>
				  		
				  		<h4>Créée par</h4>
				  		<p><c:out value="${prop}"/></p>
				  		<br>
	         		</div>
	         		
	         		<div class="span12">
						<div class="span12">
					   		<h3 class="header">Devis
					            <span class="header-line"></span> 
					        </h3>
					    </div>
				  		<div class="span11" id="travaux">
			           		<table class="table table-striped table-bordered table-hover">
								<thead>
			                        <tr>
			                          	<th class="entreprise">Entreprise</th>
			                          	<th class="date">Date début</th>
			                          	<th class="date">Date fin</th>
			                          	<th class="montant">Montant</th>
			                          	<th class="avis">Action</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    	<c:forEach var="d" items="${listD}">
			                    		<c:choose>
			                    			<c:when test="${d == null}"></c:when>
			                    			<c:otherwise>
			                    				<tr>
						                          	<td class="entreprise">
						                          		<c:out value="${d.getEntreprise()}"/>
						                          	</td>
						                          	<td class="date">
						                          		<c:out value="${d.getDateD()}"/>
						                          	</td>
						                          	<td class="date">
						                          		<c:out value="${d.getDateF()}"/>
						                          	</td>
						                          	<td class="montant">
						                          		<c:out value="${d.getMontant()}"/>
						                          	</td>
						                          	<td class="avis">
							                          	<c:if test="${(sessionScope.type == 'admin' || sessionScope.type == 'syndic') && event==false}">
								                          	<div class="suppr">
									                          	<a href="<c:url value='accepterD'><c:param name="idD" value="${d.getId()}" /></c:url>" >
								                          			<button type="button" class="btn btn-mini btn-primary">accepter</button>
								                          		</a>
								                          	</div>
							                        	</c:if>
							                        	<c:if test="${sessionScope.type == 'admin' || sessionScope.mail == prop}">
								                          	<div class="suppr">
									                          	<a href="<c:url value='supprGD'><c:param name="idD" value="${d.getId()}" /></c:url>" >
								                          			<button type="button" class="btn btn-mini">supprimer</button>
								                          		</a>
								                          	</div>
							                        	</c:if>
						                          	</td>
						                        </tr>
			                    			</c:otherwise>
			                    		</c:choose>
			                    	</c:forEach>
			                    </tbody>
							</table>
			           	</div>
	         		</div>
	         		
	         		<c:if test="${(sessionScope.type == 'admin' || sessionScope.mail == prop) && event==false}">
		         		<a href="#modalAjoutDevis" role="button" class="btn btn-primary" data-toggle="modal">Ajouter Devis</a>
		         		<hr>
	         		</c:if>
		      	</div>
			</div>
		</section>
			
		<%@include file="footer.jsp"%> 
		
		<!-- Modal Aj-->
		<div class="modal hide fade" id="modalAjoutDevis">
		
		  	<div class="modal-header">
		    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		    	<h3>Ajouter un devis</h3>
		  	</div>
		
		  	<s:form action="devisFormAjG">
		
			  	<div class="modal-body">
			    	<s:textfield label="Entreprise" name="d.entreprise" required="required"/>
					
					<s:textfield label="Montant" name="d.montant" required="required"/>
					
					<s:textfield label="Date de début" name="d.dateD" class="datepicker" disabled="isDisabled" required="required"/>
					
					<s:textfield label="Date de fin" name="d.dateF" class="datepicker" disabled="isDisabled" required="required"/>
					
					<s:textfield label="Id travaux" name="d.idT" value="%{#attr['idGT']}" readonly="true" required="required"/>
					
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
        <script src="<c:url value="/resources/js/bootstrap-dtpk.js" />"></script>  
        <script type="text/javascript" src="<c:url value="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/jquery-ui.min.js" />"></script>
		
		<script type="text/javascript">
	        $(document).ready(function () {
	                
	                $('.datepicker').datepicker({
	                	dateFormat: 'yy-mm-dd',
	                	minDate: '+0d',
	                    changeMonth: true,
	                    changeYear: false
	                });  
	            
	            });
		</script>
	</body>
</html>