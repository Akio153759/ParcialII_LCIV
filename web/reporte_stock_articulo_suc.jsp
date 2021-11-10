<%-- 
    Document   : reporte_stock_articulo_suc
    Created on : 10 nov. 2021, 13:29:53
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
            <div class="product-status mg-b-30">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-status-wrap">
                            <h4>Reporte suministro por sucursal</h4>
                            <form action="POST">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="review-content-section">
                                            <select name="cmbSuministro" id="cmbSuministro" class="form-control pro-edt-select form-control-primary mg-b-pro-edt">
                                                    <option value="0">Seleccione el suministro</option>
                                                     <c:forEach items="${requestScope.suministros}" var="suministro">
                                                        <option value="${suministro.codigo}">${suministro.nombre}</option>
                                                    </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                 <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 2rem;">
                                        <div class="text-center custom-pro-edt-ds">
                                            <button id="btnVerReporte" type="button" class="btn btn-ctl-bt waves-effect waves-light m-r-10">Ver reporte
                                                                                                        </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div id="seccion_resultado">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        </div>
        <jsp:include page="body_footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/reporte_articulo_sucursal.js"></script>

    </body>
</html>
