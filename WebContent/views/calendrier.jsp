<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>CoproManager - Calendrier</title>
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
		<section class="container">			
			<div class="row-fluid">
	           	<div class="span12">	           		
					<div id="calendrier">		           		
						<div class="annee">
							<c:out value="${date.getCalendrier()[0][0][0].getYear()}"/>
							<p id="modAj">
								<a href="#modalAjoutEv" role="button" class="btn btn-primary" data-toggle="modal">Ajouter Evenement</a>
			                </p>
			                <p id="modSuppr">
			                  	<a href="#modalSupprEv" role="button" class="btn" data-toggle="modal">Supprimer Evenement</a>
			                </p>
						</div>
						
						<div class="tabbable">
							<ul class="nav nav-tabs">
								<c:forEach var="m" begin="0" end="11">
									<li
										<c:choose>
						                     <c:when test="${date.getD().getMonthOfYear() == m+1}">
						                        class="active"
						                     </c:when>
						                     <c:otherwise>
						                        class=""
						                     </c:otherwise>   
						                 </c:choose>
									>
										<a href="#tab${m}" data-toggle="tab">
											<c:out value="${date.getMois()[m]}"/>
										</a>
									</li>
								</c:forEach>
						  	</ul>
						  	
						  	<div class="tab-content">
							  	<c:forEach var="m" begin="0" end="11">
									<div id="tab${m}" 
										<c:choose>
						                     <c:when test="${date.getD().getMonthOfYear() == m+1}">
						                        class="tab-pane active"
						                     </c:when>
						                     <c:otherwise>
						                        class="tab-pane"
						                     </c:otherwise>   
						                 </c:choose>
					                  >
							      		<table>
											<thead>
												<tr>
													<c:forEach var="jSem" begin="0" end="6">
														<th id="jourSem">
															<c:out value="${date.getJourSem()[jSem+1]}"/>
														</th>
													</c:forEach>
												</tr>
											</thead>
											<tbody>
												<tr>
													<c:forEach var="j" begin="0" end="30">
														<c:choose>
															<c:when test="${date.getCalendrier()[0][m][j].equals(date.getDException()) && date.getCalendrier()[0][m][j-1].getDayOfWeek() == 7}">
															</c:when>
															<c:when test="${date.getCalendrier()[0][m][j].equals(date.getDException())}">
																<td colspan="${7-date.getCalendrier()[0][m][j-1].getDayOfWeek()}" class="jourVide"></td>
															</c:when>
															<c:otherwise>
																<c:if test="${date.getCalendrier()[0][m][j].getDayOfMonth() == 1 && date.getCalendrier()[0][m][j].getDayOfWeek() != 1}">
																	<td colspan="${date.getCalendrier()[0][m][j].getDayOfWeek()-1}" class="jourVide"></td>
																</c:if>
																<td>
																	<div class="relative">
																		<div class="jour">
																			<c:choose>
																				<c:when test="${date.getCalendrier()[0][m][j].equals(date.getD())}">
																					<a href="#" id="aujourdhui">
																				    	<c:out value="${date.getCalendrier()[0][m][j].toString('dd')}"/>
																				    </a>
																				</c:when>
																				<c:otherwise>
																				    <a href="#" id="jour">
																				    	<c:out value="${date.getCalendrier()[0][m][j].toString('dd')}"/>
																				    </a>
																			    </c:otherwise>
																		    </c:choose>
																    	</div>
																    </div>
																    <div class="jTitre">
																    	<c:out value="${date.getCalendrier()[0][m][j].toString('EE dd MMM')}"/>
																    </div>
																    <ul class="evenements">
																    	<c:forEach var="event" items="${tabE}">
																    		<c:if test="${event.getInterval().contains(date.getCalendrier()[0][m][j])}">
																				<li>
																					<c:out value="${event.getTitre()}"/>
																				</li>
																			</c:if>
																		</c:forEach>
																    </ul>
																</td>
																<c:if test="${date.getCalendrier()[0][m][j].getDayOfWeek() == 7}">
																	</tr><tr>
																</c:if>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</tr>
											</tbody>								
										</table>
							    	</div>
							    </c:forEach>
						  	</div>
						</div>
					</div>
				</div>
			</div>
			
		</section>
			
		<%@include file="footer.jsp"%>
		
		
		<!-- Modal Aj-->
		<div class="modal hide fade" id="modalAjoutEv">
		
		  	<div class="modal-header">
		    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		    	<h3>Ajouter un évenement</h3>
		  	</div>
		
		  	<s:form action="calendrierFormAj">
		
			  	<div class="modal-body">
			    	<s:textfield label="Titre" name="event.titre" required="required"/>
					
					<s:textfield label="Date de début" name="event.dateD" class="datepicker" disabled="isDisabled" required="required"/>
					
					<s:textfield label="Date de fin" name="event.dateF" class="datepicker" disabled="isDisabled" required="required"/>
					
					<s:submit value="Valider" name="submitAj" class="btn btn-large btn-primary"/>
			  	</div>
		
			</s:form> 		
		</div>	
		
		<!-- Modal Suppr-->
		<div class="modal hide fade" id="modalSupprEv">
		
		  	<div class="modal-header">
		    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		    	<h3>Supprimer un évenement</h3>
		  	</div>
		
		  	<s:form action="calendrierFormSup">
		
			  	<div class="modal-body">
			    	<s:textfield label="Titre" name="titre" required="required"/>
						
					<s:submit value="Valider" name="submitAj" class="btn btn-large btn-primary"/>
			  	</div>
		
			</s:form> 
		</div>	

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        
        <script src="<c:url value="/resources/js/bootstrap-transition.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-dtpk.js" />"></script>
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
