<%-- 
    Document   : detalle_despacho
    Created on : 9 nov. 2021, 21:11:45
    Author     : Tama
--%>

<%@page contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" />
    <body>
        <jsp:include page="body_header.jsp" />
        <div class="all-content-wrapper">
            <jsp:include page="container_header.jsp" />
            <br>
            
            <!-- Container page -->
            <!-- Single pro tab start-->
            <div class="single-product-tab-area mg-b-30">
                <!-- Single pro tab review Start-->
                <div class="single-pro-review-area">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="product-status-wrap">
                                        <h4>Recibir despacho N° ${requestScope.despacho.codigo}</h4>
                                    <div class="add-product">
                                        <a href="ListadoDespachosEntrantes">Regresar</a>
                                    </div>
                                    <br>
                                    <form method="POST">
                                        <div id="myTabContent" class="tab-content custom-product-edit">
                                            <div class="product-tab-list tab-pane fade active in" id="description">
                                                <div class="row">
                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="review-content-section">
                                                            <div class="form-group">
                                                                <label>Fecha y hora generación:</label>
                                                                 <h2>${requestScope.despacho.fhGeneracion}</h2>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Sucursal Origen</label>
                                                                 <h2>${requestScope.despacho.sucOrigen}</h2>
                                                            </div>
                                                           <div class="form-group">
                                                                <label>Empleado generó:</label>
                                                                 <h2>${requestScope.despacho.empGenero}</h2>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="review-content-section">
                                                            <div class="form-group">
                                                                <label>Fecha y hora recepción</label>
                                                                 <h2>-</h2>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Sucursal Destino:</label>
                                                                 <h2>${requestScope.despacho.sucDestino}</h2>
                                                            </div>
                                                           <div class="form-group">
                                                                <label>Empresa transportista:</label>
                                                                 <h2>${requestScope.despacho.empresaTransportista}</h2>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                                <br>
                                                <br>
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                        <div class="review-content-section">
                                                            <h4>Detalle del despacho</h4>
                                                            <table id="tabla_stock_sucursal">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Suministro</th>
                                                                        <th>Cantidad</th>        
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <c:forEach items="${requestScope.despacho.detalle}" var="suministro">
                                                                        <tr style="background: #1b2a47!important;">
                                                                            <td>${suministro.suministro}</td>
                                                                            <td>${suministro.cantidad}</td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </tbody>
                                                            </table>
                                                            
                                                        </div>
                                                    </div>

                                                        <div class="row">
                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 2rem;">
                                                                <div class="text-center custom-pro-edt-ds">
                                                                    <a href="ConfirmarDespacho?cod=${requestScope.despacho.codigo}"><button type="button" class="btn btn-ctl-bt waves-effect waves-light m-r-10">Confirmar recepción
                                                                        </button></a>
                                                                </div>
                                                            </div>
                                                        </div>

                                                </div>
                                            </div>

                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="body_footer.jsp" />
    </body>
</html>

