<%-- 
    Document   : container_header
    Created on : 30 oct. 2021, 01:21:15
    Author     : Tama
--%>

<%@page contentType="text/html" %>
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
