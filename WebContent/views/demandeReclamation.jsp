<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>CoproManager - Demande de Réclamations</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Christopher Boudier">
        
        <meta http-equiv="imagetoolbar" content="no" />
        <meta name="MSSmartTagsPreventParsing" content="true" />

        <!-- the styles -->
        <link rel="stylesheet" type="text/css" href="inc/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="inc/css/bootstrap-responsive.min.css">
        <link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Pontano+Sans'>
        <link rel="stylesheet" type="text/css" href="inc/js/nivo-slider/themes/default/default.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="inc/js/nivo-slider/nivo-slider.css" >
        <link rel="stylesheet" type="text/css" href="inc/js/lightbox/css/lightbox.css" />
        <link rel="stylesheet" type="text/css" href="inc/css/template.css" media="screen">   
        <link rel="stylesheet" type="text/css" href="inc/css/style1.css" />
        <link rel="stylesheet" type="text/css" href="inc/css/datepicker.css">
        
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style2" href="inc/css/style2.css" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style3" href="inc/css/style3.css" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style4" href="inc/css/style4.css" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style5" href="inc/css/style5.css" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="style6" href="inc/css/style6.css" />        
        
    	<script type="text/javascript" src="inc/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="inc/js/swfobject/swfobject.js"></script>
    	<script type="text/javascript" src="inc/js/lightbox/js/lightbox.js"></script>

        <!-- style switcher -->
        <script type="text/javascript" src="inc/js/styleswitcher.js"></script>
        

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        
        <!-- The fav and touch icons -->
        <link rel="shortcut icon" href="inc/img/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="inc/img/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="inc/img/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="inc/img/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="inc/img/ico/apple-touch-icon-57-precomposed.png">
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
			   		<h3 class="header">Demandes de Réclamations
			            <span class="header-line"></span> 
			        </h3>
	           		<table class="table table-striped table-bordered table-hover">
						<thead>
	                        <tr>
	                          <th>Sujet</th>
	                          <th>Date</th>
	                          <th>Etat</th>
	                          <th>Actions</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                        </tr>
	                        <tr>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                        </tr>
	                        <tr>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                        </tr>
	                        <tr>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                        </tr>
	                    </tbody>
					</table>
	           	</div>
          	</div>
			
		</section>
			
		<%@include file="footer.jsp"%>

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        
        <script src="inc/js/bootstrap-transition.js"></script>
        <script src="inc/js/bootstrap-alert.js"></script>
        <script src="inc/js/bootstrap-modal.js"></script>
        <script src="inc/js/bootstrap-dropdown.js"></script>
        <script src="inc/js/bootstrap-scrollspy.js"></script>
        <script src="inc/js/bootstrap-tab.js"></script>
        <script src="inc/js/bootstrap-tooltip.js"></script>
        <script src="inc/js/bootstrap-popover.js"></script>
        <script src="inc/js/bootstrap-button.js"></script>
        <script src="inc/js/bootstrap-collapse.js"></script>
        <script src="inc/js/bootstrap-carousel.js"></script>
        <script src="inc/js/bootstrap-typeahead.js"></script>  
        <script src="inc/js/bootstrap-datepicker.js"></script> 
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>
             
    </body>
</html>
