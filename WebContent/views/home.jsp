<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--Carousel-->
<div class="slider-bootstrap">
   <div class="container">
      <div class="slider-wrapper theme-default">
         <div id="slider-nivo" class="nivoSlider">
            <img src="<c:url value="/resources/img/slider/flickr/s10.jpg" />" data-thumb="<c:url value="/resources/img/slider/flickr/s10.jpg" />" alt="" title="" />
            <img src="<c:url value="/resources/img/slider/flickr/s11.jpg" />" data-thumb="<c:url value="/resources/img/slider/flickr/s11.jpg" />" alt="" title="" />
            <img src="<c:url value="/resources/img/slider/flickr/s12.jpg" />" data-thumb="<c:url value="/resources/img/slider/flickr/s12.jpg" />" alt="" title="" data-transition="slideInLeft" />
         </div>
      </div>
   </div>
</div>

<div class="container shout-box">
   <div class="shout-text">
      <h1>CoproManager</h1>
      <p>Application simple et gratuite pour gérer sa copropriété. <br> Que vous soyez un particulier ou un syndic, restez informé bien au chaud chez vous.</p>
   </div>
</div>


<section class="main-body">
   <div class="container">
      <div class="row-fluid">
         <ul class="thumbnails center">

            <li class="span6">
               <div class="thumbnail">
                  <h3>Fonctionne sur toutes les plateformes</h3>
                  <div class="round_background r-grey-light">
                     <img src="<c:url value="/resources/img/icons/smashing/30px-01.png" />" alt="" class="">
                  </div>
                  <p>Restez connecté où que vous soyez et gérez votre copropriété en toute sécurité.</p>
               </div>
            </li>

            <li class="span6">
               <div class="thumbnail">
                  <h3>Personnalisez votre application</h3>
                  <div class="round_background r-yellow">
                     <img src="<c:url value="/resourcesinc/img/icons/smashing/30px-41.png" />" alt="" class="">
                  </div>
                  <p>il existe un panel de couleur afin de rendre votre application la plus agréable possible.</p>
               </div>
            </li>

         </ul>
      </div>

      <hr>

      <div class="row-fluid">
         <div class="span12">
            <blockquote>
               <h2>Article 1</h2>
               <p>news numero 1 ...</p>
            </blockquote>
         </div>
      </div>

      <hr>

      <div class="row-fluid">
         <div class="span12">
            <blockquote>
               <h2>Article 1</h2>
               <p>news numero 1 ...</p>
            </blockquote>
         </div>
      </div>

      <hr>

      <div class="row-fluid">
         <div class="span12">
            <blockquote>
               <h2>Article 1</h2>
               <p>news numero 1 ...</p>
            </blockquote>
         </div>
      </div>

      <hr>      

      <h3 class="header">Partenaires
         <span class="header-line"></span>  
      </h3>
      <div class="row-fluid center customers">
         <div class="span3 ">
            <img src="<c:url value="/resources/img/customers/themeforest.png" />" alt="Themeforest" />
         </div>
         <div class="span3">
            <img src="<c:url value="/resources/img/customers/codecanyon.png" />" alt="Codecanyon" />
         </div>
         <div class="span3">
            <img src="<c:url value="/resources/img/customers/graphicriver.png" />" alt="Graphicriver" />
         </div>
         <div class="span3">
            <img src="<c:url value="/resources/img/customers/photodune.png" />" alt="Photodune" />
         </div>
      </div>

      <script type="text/javascript" src="<c:url value="/resources/js/nivo-slider/jquery.nivo.slider.pack.js" />"></script>

      <script type="text/javascript">
         $(function() {
            $('#slider-nivo').nivoSlider({
               effect: 'boxRandom',
               manualAdvance:false,
               controlNav: false
            });
         });
      </script> 
      <!--
         <script type="text/javascript">
            $(document).ready(function() {
            $('#slider-nivo2').nivoSlider();
            });
         </script>
      -->
   </div>
</section>