<%-- 
    Document   : menu
    Created on : 29 oct. 2021, 23:57:56
    Author     : Tama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Dashboard V.2 | Nalika - Material Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
	<!-- nalika Icon CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nalika-icon.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

    <div class="left-sidebar-pro">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
                <a href="${pageContext.request.contextPath}/index.html"><img class="main-logo" src="${pageContext.request.contextPath}/img/logo/logo.png" alt="" /></a>
                <strong><img src="${pageContext.request.contextPath}/img/logo/logosn.png" alt="" /></strong>
            </div>
			<div class="nalika-profile">
				<div class="profile-dtl">
					<a href="#"><img src="${pageContext.request.contextPath}/img/notification/4.jpg" alt="" /></a>
					<h2>Akio <span class="min-dtn">Tamashiro</span></h2>
				</div>

			</div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
                        <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false"><i class="icon nalika-smartphone-call icon-wrap"></i> <span class="mini-click-non">Admin. de datos</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Notifications" href="notifications.html"><span class="mini-sub-pro">Suministros</span></a></li>
                                <li><a title="Alerts" href="alerts.html"><span class="mini-sub-pro">Tipos de Suministro</span></a></li>
                                <li><a title="Modals" href="modals.html"><span class="mini-sub-pro">Empleados</span></a></li>
                                <li><a title="Buttons" href="buttons.html"><span class="mini-sub-pro">Transportistas</span></a></li>
                            </ul>
                        </li>
                        <li><a href="mailbox.html" aria-expanded="false"><i class="icon nalika-smartphone-call icon-wrap"></i> <span class="mini-click-non">Despachos</span></a></li>

                    </ul>
                </nav>
            </div>
        </nav>
    </div>
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="logo-pro">
                        <a href="${pageContext.request.contextPath}/index.html"><img class="main-logo" src="${pageContext.request.contextPath}/img/logo/logo.png" alt="" /></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-advance-area">
            <div class="header-top-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="header-top-wraper">
                                <div class="row">
                                    <div class="col-lg-1 col-md-0 col-sm-1 col-xs-12">
                                        <div class="menu-switcher-pro">
                                            <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
													<i class="fa fa-bars"></i>
												</button>
                                        </div>
                                    </div>

                                    <div class="col-lg-11 col-md-11 col-sm-12 col-xs-12">
                                        <div class="header-right-info">
                                            <ul class="nav navbar-nav mai-top-nav header-right-menu">
                       
                                  
                                                <li class="nav-item">
                                                    <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle">
															<i class="fa fa-user" aria-hidden="true"></i>
															<span class="admin-name">Akio Tamashiro</span>
															<i class="fa fa-bars"></i>
														</a>
                                                    <ul role="menu" class="dropdown-header-top author-log dropdown-menu animated zoomIn">
                                                        <li><a href="register.html"><span class="icon nalika-home author-log-ic"></span> Register</a>
                                                        </li>
                                                        <li><a href="#"><span class="icon nalika-user author-log-ic"></span> My Profile</a>
                                                        </li>
                                                        <li><a href="lock.html"><span class="icon nalika-diamond author-log-ic"></span> Lock</a>
                                                        </li>
                                                        <li><a href="#"><span class="icon nalika-settings author-log-ic"></span> Settings</a>
                                                        </li>
                                                        <li><a href="login.html"><span class="icon nalika-unlocked author-log-ic"></span> Log Out</a>
                                                        </li>
                                                    </ul>
                                                </li>
                                  
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        
    </div>

    <!-- jquery
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/metisMenu/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/metisMenu/metisMenu-active.js"></script>
    <!-- sparkline JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/sparkline/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sparkline/jquery.charts-sparkline.js"></script>
    <!-- calendar JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/calendar/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/calendar/fullcalendar.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/calendar/fullcalendar-active.js"></script>
	<!-- float JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/flot/jquery.flot.js"></script>
    <script src="${pageContext.request.contextPath}/js/flot/jquery.flot.resize.js"></script>
    <script src="${pageContext.request.contextPath}/js/flot/curvedLines.js"></script>
    <script src="${pageContext.request.contextPath}/js/flot/flot-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>