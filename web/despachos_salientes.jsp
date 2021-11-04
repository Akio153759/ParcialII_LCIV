<%-- 
    Document   : despachos_salientes
    Created on : 2 nov. 2021, 19:34:28
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
                            <h4>Despachos salientes</h4>
                            <div class="add-product">
                                <a href="NuevoDespacho">Nuevo despacho</a>
                            </div>
                            <table id="tabla_despachos_salientes">
                                <thead>
                                    <tr>
                                        <th>Código</th>
                                        <th>Sucursal origen</th>
                                        <th>Sucursal destino</th>
                                        <th>Empleado generó</th>
                                        <th>FH Generación</th>
                                        <th>Empleado recepcionó</th>
                                        <th>FH recepción</th>
                                        <th>Transportista</th>
                                        <th>Estado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.despachos}" var="despacho">
                                        <tr style="background: #1b2a47!important;">
                                            <td>${despacho.codigo}</td>
                                            <td>${despacho.sucOrigen}</td>
                                            <td>${despacho.sucDestino}</td>
                                            <td>${despacho.empGenero}</td>
                                            <td>${despacho.fhGeneracion}</td>
                                            <td>${despacho.empRecepciono}</td>
                                            <td>${despacho.fhRecepcion}</td>
                                            <td>${despacho.empresaTransportista}</td>
                                            <td>${despacho.estado}</td>
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
        <jsp:include page="body_footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/despachos_salientes.js"></script>

    </body>
</html>
