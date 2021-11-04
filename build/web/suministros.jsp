<%-- 
    Document   : suministros
    Created on : 30 oct. 2021, 01:25:03
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
            
            <c:if test="${not empty message}">
                <div id="infoMensaje" class="modal modal-adminpro-general fullwidth-popup-InformationproModal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-close-area modal-close-df">
                                <a class="close" data-dismiss="modal" href="#"><i class="fa fa-close"></i></a>
                            </div>
                            <div class="modal-body">
                                <span class="adminpro-icon adminpro-informatio modal-check-pro information-icon-pro"> </span>
                                <h2>Información</h2>
                                <p>${message}</p>
                            </div>
                            <div class="modal-footer">
                                <a data-dismiss="modal" href="#">Aceptar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <div id="confirmarEliminicacion" class="modal modal-adminpro-general fullwidth-popup-InformationproModal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-close-area modal-close-df">
                                <a class="close" data-dismiss="modal" href="#"><i class="fa fa-close"></i></a>
                            </div>
                            <div class="modal-body">
                                <span class="adminpro-icon adminpro-informatio modal-check-pro information-icon-pro"> </span>
                                <h2>Eliminar suministro</h2>
                                <p id="msgEliminacion"></p>
                            </div>
                            <div class="modal-footer">
                                <a data-dismiss="modal" href="#">Cancelar</a>
                                <a style="margin-left: 1rem;" id="btnConfirmar">Confirmar</a>
                            </div>
                        </div>
                    </div>
                </div>
            <br>
            <div class="product-status mg-b-30">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-status-wrap">
                            <h4>Lista de suministros</h4>
                            <div class="add-product">
                                <a href="NuevoSuministro">Nuevo suministro</a>
                            </div>
                            <table id="tabla_suministros">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Tipo de suministro</th>
                                        <th>Contenido Neto</th>
                                        <th>Precio unitario</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.suministros}" var="suministro">
                                        <tr style="background: #1b2a47!important;">
                                            <td>${suministro.nombre}</td>
                                            <td>${suministro.tipoSuministro.descripcion}</td>
                                            <td>${suministro.contenidoNeto} ${suministro.unidadMedida.abreviacion} (${suministro.unidadMedida.descripcion})</td>
                                            <td>$${suministro.precioUnitario}</td>
                                            <td>
                                                <a href="EditarSuministro?id=${suministro.codigo}"><button data-toggle="tooltip" title="Editar suministro" class="pd-setting-ed"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button></a>
                                                <button onclick="confirmarEliminacion('${suministro.codigo}','${suministro.nombre}')" data-toggle="tooltip" title="Eliminar suministro" class="pd-setting-ed"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                            </td>
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
        <script src="${pageContext.request.contextPath}/js/suministros.js"></script>
        <c:if test="${not empty message}">
            <script>
                $('#infoMensaje').modal('show');
            </script>
        </c:if>
            <script>
                function confirmarEliminacion(id, nombre) {
                    $('#msgEliminacion').text('¿Confirma la eliminación del suministro ' + nombre + '?');
                    $('#btnConfirmar').attr('href','EliminarSuministro?id=' + id);
                    $('#confirmarEliminicacion').modal('show');
                }
                
                function editarSuministro(codigo) {
                    var xhr = new XMLHttpRequest();
                    
                    xhr.open('GET', '${pageContext.request.contextPath}/EditarSuministro?id=' + codigo, true);
                    xhr.send(null);
                }
            </script>
    </body>
</html>
