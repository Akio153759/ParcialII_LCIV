<%-- 
    Document   : despachos_entrantes
    Created on : 9 nov. 2021, 20:59:14
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
                            <h4>Despachos entrantes a sucursal </h4>
                            <table id="tabla_despachos_entrantes">
                                <thead>
                                    <tr>
                                        <th>Código</th>
                                        <th>Sucursal origen</th>
                                        <th>Empleado generó</th>
                                        <th>FH Generación</th>
                                        <th>Empleado recepcionó</th>
                                        <th>FH recepción</th>
                                        <th>Transportista</th>
                                        <th>Estado</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${sessionScope.despachos}" var="despacho">
                                        <tr style="background: #1b2a47!important;">
                                            <td>${despacho.codigo}</td>
                                            <td>${despacho.sucOrigen}</td>
                                            <td>${despacho.empGenero}</td>
                                            <td>${despacho.fhGeneracion}</td>
                                            <td>${despacho.empRecepciono}</td>
                                            <td>${despacho.fhRecepcion}</td>
                                            <td>${despacho.empresaTransportista}</td>
                                            <td>${despacho.estado}</td>
                                            <c:if test="${despacho.estado == 'Pendiente'}">
                                                <td><a href="DetalleDespacho?cod=${despacho.codigo}"><i style="cursor: pointer" class="fa fa-eye" aria-hidden="true"></i></a></td>
                                            </c:if>
                                            <c:if test="${despacho.estado == 'Confirmado'}">
                                                <td></td>
                                            </c:if>
                                            
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
        <script src="${pageContext.request.contextPath}/js/despachos_entrantes.js"></script>

    </body>
</html>
