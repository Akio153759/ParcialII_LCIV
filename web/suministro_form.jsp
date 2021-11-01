<%-- 
    Document   : suministro_form
    Created on : 30 oct. 2021, 17:55:52
    Author     : Tama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    <c:choose>
                                        <c:when test="${action == 'new'}">
                                            <h4>Nuevo suministro</h4>
                                        </c:when>    
                                        <c:otherwise>
                                            <h4>Editar suministro</h4>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                    <div class="add-product">
                                        <a href="ListadoSuministros">Regresar</a>
                                    </div>
                                    <br>
                                    <form method="POST">
                                        <div id="myTabContent" class="tab-content custom-product-edit">
                                            <div class="product-tab-list tab-pane fade active in" id="description">
                                                <div class="row">
                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="review-content-section">
                                                            <div class="input-group mg-b-pro-edt">
                                                                <span class="input-group-addon"><i class="fa fa-cart-plus" aria-hidden="true"></i></span>
                                                                <input required <c:if test="${action == 'edit'}"> value="${suministro.nombre}" </c:if> type="text" name="txtNombre" class="form-control" placeholder="Nombre suministro">
                                                            </div>
                                                            <div class="input-group mg-b-pro-edt">
                                                                <span class="input-group-addon"></span>
                                                                <textarea name="txtDescripcion"  style="resize: none;" rows="4" class="form-control" placeholder="Descripción"><c:if test="${action == 'edit'}"> ${suministro.descripcion} </c:if></textarea>
                                                            </div>
                                                            <div class="form-group-inner">
                                                                <div class="row">
                                                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                        <div class="bt-df-checkbox">
                                                                            <label for="chkVentaLibre" class="pull-right" style="color: #fff;">Venta libre</label>
                                                                            <input <c:if test="${action == 'edit'}"> <c:if test="${suministro.ventaLibre}"> checked </c:if> </c:if>  <c:if test="${action == 'new'}"> checked </c:if>  name="chkVentaLibre" class="pull-right"  style=" margin-right: .7rem;" type="checkbox">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>

                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="review-content-section">
                                                                <div class="input-group mg-b-pro-edt">
                                                                    <span class="input-group-addon"><i class="fa fa-usd" aria-hidden="true"></i></span>
                                                                    <input required name="txtPrecio" <c:if test="${action == 'edit'}"> value="${suministro.precioUnitario}" </c:if> type="number" class="form-control" placeholder="Precio unitario">
                                                                </div>
                                                                 <select name="cmbTipoSuministro" class="form-control pro-edt-select form-control-primary mg-b-pro-edt">
                                                                        <c:forEach items="${requestScope.tipos_suministro}" var="ts">
                                                                            <option <c:if test="${action == 'edit'}"> <c:if test="${suministro.tipoSuministro.id == ts.id}"> selected </c:if> </c:if> value="${ts.id}">${ts.descripcion}</option>
                                                                        </c:forEach>
                                                                </select>
                                                                <select name="cmbUnidadMedida" class="form-control pro-edt-select form-control-primary mg-b-pro-edt">
                                                                        <option value="0">Seleccione unidad de medida</option>
                                                                        <c:forEach items="${requestScope.unidades_medida}" var="um">
                                                                            <option <c:if test="${action == 'edit'}"> <c:if test="${suministro.unidadMedida.id == um.id}"> selected </c:if> </c:if> value="${um.id}">${um.descripcion}</option>
                                                                        </c:forEach>
                                                                </select>
                                                                <div class="input-group mg-b-pro-edt">
                                                                    <span class="input-group-addon"><i class="fa fa-balance-scale" aria-hidden="true"></i></span>
                                                                    <input <c:if test="${action == 'edit'}"> value="${suministro.contenidoNeto}" </c:if> type="text" name="txtContenidoNeto" class="form-control" placeholder="Contenido neto">
                                                                </div>

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
        
    </body>
</html>
