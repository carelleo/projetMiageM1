<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="navbar">
   <div class="navbar-inner">
      <div class="container">
     
         <!-- NOTE: Do not remove this. It is the navigation dropdown for mobile devices. It only shows on small screens-->
         <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
         </a>
		
         <div class="nav-collapse collapse">
            <ul class="nav">
           
              	<!--Accueil-->
               <li <c:choose>
                     <c:when test="${page==null}">
                        class="active"
                     </c:when>
                     <c:otherwise>
                        class=""
                     </c:otherwise>   
                  </c:choose>
               >
                  <a href="index" data-description="page d'acceuil">Acceuil</a>
               </li>

               <!--A propos-->
               <li <c:choose>
                     <c:when test="${page=='about'}">
                        class="active"
                     </c:when>
                     <c:otherwise>
                        class=""
                     </c:otherwise>   
                  </c:choose>
               >
                  <a href=
                     "<c:url value='index'>
                        <c:param name="page" value="about" />
                     </c:url>"
                  data-description="qui sommes nous ?">A propos</a>
               </li>

               <!--Calendrier-->
               <li <c:choose>
                     <c:when test="${page=='calendrier'}">
                        class="active"
                     </c:when>
                     <c:otherwise>
                        class=""
                     </c:otherwise>   
                  </c:choose>
               >
                  <a href=
                     "<c:url value='calendrier'>
                        <c:param name="page" value="calendrier" />
                     </c:url>"
                  data-description="voir son calendrier">Calendrier</a>
               </li>

               <!--Finances-->
               <li   <c:choose>
                        <c:when test="${page=='factures'}">
                           class="active dropdown"
                        </c:when>
                        <c:when test="${page=='budget'}">
                           class="active dropdown"
                        </c:when>
                        <c:otherwise>
                           class="dropdown"
                        </c:otherwise>   
                     </c:choose> 
               >
                  <a href=
                     "<c:url value='index'>
                        <c:param name="page" value="factures" />
                     </c:url>" 
                  data-description="gérer les finances" class="dropdown-toggle" data-toggle="dropdown" >Finances  <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                     <li><a href=
                        "<c:url value='index'>
                           <c:param name="page" value="factures" />
                        </c:url>"
                     >Factures</a></li>
                     <li><a href=
                           "<c:url value='index'>
                              <c:param name="page" value="budget" />
                           </c:url>"
                     >Budget Prévisionnel</a></li>
                  </ul>
               </li>
               
               <!-- Demandes -->
               <li   <c:choose>
                        <c:when test="${page=='travaux'}">
                           class="active dropdown"
                        </c:when>
                        <c:when test="${page=='reclamation'}">
                           class="active dropdown"
                        </c:when>
                        <c:otherwise>
                           class="dropdown"
                        </c:otherwise>   
                     </c:choose> 
               >
                  <a href=
                     "<c:url value='demandeTravaux'>
                        <c:param name="page" value="travaux" />
                     </c:url>" 
                  data-description="demandes diverses" class="dropdown-toggle" data-toggle="dropdown" >Demandes  <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                     <li><a href=
                        "<c:url value='demandeTravaux'>
                           <c:param name="page" value="travaux" />
                        </c:url>"
                     >Travaux</a></li>
                     <li><a href=
                           "<c:url value='demandeReclamation'>
                              <c:param name="page" value="reclamation" />
                           </c:url>"
                     >Réclamations</a></li>
                  </ul>
               </li>
                
               <!--Aide avec tous les éléments-->
               <li   <c:choose>
                        <c:when test="${page=='portfolio'}">
                           class="active"
                        </c:when>
                        <c:otherwise>
                           class=""
                        </c:otherwise>   
                     </c:choose>
               >
                  <a href=
                     "<c:url value='index'>
                        <c:param name="page" value="portfolio" />
                     </c:url>" 
                  data-description="tous les éléments">Aide </a>
               </li><!--/.dropdown -->
          
               <!--Contact-->
               <li <c:choose>
                     <c:when test="${page=='contact'}">
                        class="active"
                     </c:when>
                     <c:otherwise>
                        class=""
                     </c:otherwise>   
                  </c:choose>
               >
                  <a href=
                     "<c:url value='index'>
                        <c:param name="page" value="contact" />
                     </c:url>"
                  data-description="nous contacter">Contact</a>
               </li>

               <!--Mon compte-->
               <li <c:choose>
                        <c:when test="${page=='mail'}">
                           class="active dropdown"
                        </c:when>
                        <c:when test="${page=='information'}">
                           class="active dropdown"
                        </c:when>
                        <c:when test="${page=='copropriete'}">
                           class="active dropdown"
                        </c:when>
                        <c:when test="${page=='membre-conseil'}">
                           class="active dropdown"
                        </c:when>
                        <c:otherwise>
                           class="dropdown"
                        </c:otherwise>   
                     </c:choose>
                  >
                  <a href=
                     "<c:url value='index'>
                        <c:param name="page" value="mail" />
                     </c:url>" 
                     data-description="mon espace" class="dropdown-toggle" data-toggle="dropdown" >Mon compte <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                     <li><a href=
                        "<c:url value='index'>
                           <c:param name="page" value="mail" />
                        </c:url>"
                        >Mon mail</a></li>
                     <li><a href=
                        "<c:url value='index'>
                           <c:param name="page" value="information" />
                        </c:url>"
                        >Mes informations</a></li>
                     <li><a href=
                        "<c:url value='index'>
                           <c:param name="page" value="copropriete" />
                        </c:url>"
                        >Ma copropriété</a></li>
                     <li><a href=
                        "<c:url value='index'>
                           <c:param name="page" value="membre-conseil" />
                        </c:url>"
                        >Membres du conseil</a></li>
                  </ul>
               </li>

               <!--Style/couleurs-->
               <li class="dropdown ">
                  <a href="#" data-description="6 styles" class="dropdown-toggle" data-toggle="dropdown">Styles <b class="caret"></b></a>
                  <ul class="dropdown-menu style-switcher">
                     <li><a href="javascript:chooseStyle('none', 60)" checked="checked"><span class="style" style="background-color:#0088CC;"></span> Style 1</a></li>
                     <li><a href="javascript:chooseStyle('style2', 60)"><span class="style" style="background-color:#e42e5d;"></span> Style 2</a></li>
                     <li><a href="javascript:chooseStyle('style3', 60)"><span class="style" style="background-color:#c80681;"></span> Style 3</a></li>
                     <li><a href="javascript:chooseStyle('style4', 60)"><span class="style" style="background-color:#51a351;"></span> Style 4</a></li>
                     <li><a href="javascript:chooseStyle('style5', 60)"><span class="style" style="background-color:#b88006;"></span> Style 5</a></li>
                     <li><a href="javascript:chooseStyle('style6', 60)"><span class="style" style="background-color:#f9630f;"></span> Style 6</a></li>
                  </ul>
               </li>

         	</ul>      
         </div>
      </div>
   </div>
</div>