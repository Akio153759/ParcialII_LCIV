<%-- 
    Document   : reporte_stock_por_sucursal
    Created on : 10 nov. 2021, 12:34:41
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
                            <h4>Reporte stock por sucursal</h4>
                            <div id="seccion_resultado">
                                <table id="tabla_reporte">
                                    <thead>
                                        <tr>
                                            <th>Sucursal</th>
                                            <th>Suministro</th>
                                            <th>Precio unitario</th>
                                            <th>Stock</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.reporte}" var="r">
                                            <tr style="background: #1b2a47!important;">
                                                <td>${r.sucursal}</td>
                                                <td>${r.suministro}</td>
                                                <td>$${r.precioUnitario}</td>
                                                <td>${r.cantidad}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        </div>
        <jsp:include page="body_footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/rpt_stock_sucursales.js"></script>

    </body>
</html>
