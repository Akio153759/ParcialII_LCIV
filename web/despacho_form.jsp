<%-- 
    Document   : despacho_form
    Created on : 2 nov. 2021, 20:58:04
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
                                        <h4>Nuevo despacho</h4>
                                    <div class="add-product">
                                        <a href="ListadoDespachos">Regresar</a>
                                    </div>
                                    <br>
                                    <form method="POST">
                                        <div id="myTabContent" class="tab-content custom-product-edit">
                                            <div class="product-tab-list tab-pane fade active in" id="description">
                                                <div class="row">
                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="review-content-section">
                                                            <select name="cmbSucursalOrigen" class="form-control pro-edt-select form-control-primary mg-b-pro-edt">
                                                                    <option value="0">Seleccione la sucursal de origen</option>
                                                            </select>
                                                            <select name="cmbEmpresaTransportista" class="form-control pro-edt-select form-control-primary mg-b-pro-edt">
                                                                    <option value="0">Seleccione la empresa transportista</option>
                                                            </select>
                                                        </div>
                                                    </div>

                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="review-content-section">
                                                             <select name="cmbSucursalDestino" class="form-control pro-edt-select form-control-primary mg-b-pro-edt">
                                                                 <option value="0">Seleccione la sucursal de destino</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br>
                                                <br>
                                                <div class="row">
                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="review-content-section">
                                                            <h4>Stock de sucursal local</h4>
                                                            <table id="tabla_stock_sucursal">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Código</th>
                                                                        <th>Suministro</th>
                                                                        <th>Cant. Disponible</th>           
                                                                        <th>Cant. a cargar</th>     
                                                                        <th></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <c:forEach items="${requestScope.stock}" var="suministro">
                                                                        <tr style="background: #1b2a47!important;">
                                                                            <td>${suministro.codigo}</td>
                                                                            <td>${suministro.suministro}</td>
                                                                            <td>${suministro.cantidad}</td>
                                                                            <td><input id="${suministro.codigo}" style="width: 50%!important; background: transparent" type="number" id=""></td>
                                                                            <td><i style="cursor: pointer" class="fa fa-plus-square" onclick="cargarSuministro($('#${suministro.codigo}'),'${suministro.codigo}','${suministro.suministro}',$('#${suministro.codigo}').val());" aria-hidden="true"></i></td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </tbody>
                                                            </table>
                                                            
                                                        </div>
                                                    </div>

                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="review-content-section">
                                                            <h4>Suministros a despachar</h4>
                                                            <table id="tabla_suministros_despachar">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Código</th>
                                                                        <th>Suministro</th>
                                                                        <th>Cant. Cargada</th> 
                                                                        <th></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                   
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>

                                                        <div class="row">
                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 2rem;">
                                                                <div class="text-center custom-pro-edt-ds">
                                                                    <button type="submit" class="btn btn-ctl-bt waves-effect waves-light m-r-10">Grabar
                                                                                                                                </button>
                                                                    <button type="button"  class="btn btn-ctl-bt waves-effect waves-light"><a href="ListadoSuministros">Cancelar</a>
                                                                                                                                </button>
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
        <script src="${pageContext.request.contextPath}/js/despacho_form.js"></script>
    </body>
</html>
