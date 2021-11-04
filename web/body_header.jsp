<%-- 
    Document   : body_header
    Created on : 30 oct. 2021, 01:12:32
    Author     : Tama
--%>

<%@page contentType="text/html" %>
<!DOCTYPE html>
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
                                <li><a title="Notifications" href="ListadoSuministros"><span class="mini-sub-pro">Suministros</span></a></li>
                                <li><a title="Alerts" href="alerts.html"><span class="mini-sub-pro">Tipos de Suministro</span></a></li>
                                <li><a title="Modals" href="modals.html"><span class="mini-sub-pro">Empleados</span></a></li>
                                <li><a title="Buttons" href="buttons.html"><span class="mini-sub-pro">Transportistas</span></a></li>
                            </ul>
                        </li>
                        <li><a href="ListadoDespachos" aria-expanded="false"><i class="icon nalika-smartphone-call icon-wrap"></i> <span class="mini-click-non">Despachos</span></a></li>

                    </ul>
                </nav>
            </div>
        </nav>
    </div>
