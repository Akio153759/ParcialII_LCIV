<%-- 
    Document   : filtro_rpt_entregas_recibidas
    Created on : 10 nov. 2021, 10:25:23
    Author     : Tama
--%>

<%@page contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<br>
<h4>Resultado</h4>
<table id="tabla_reporte">
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
        <c:forEach items="${requestScope.reporte}" var="despacho">
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
<script>
    $('#tabla_reporte').DataTable({
        language: datetable_languaje,
        pageLength: 10,
        columnDefs: [
            {
                'targets': [4],
                'searchable':false,
                'orderable':false,
                        
            },
    ],
                     
    });
</script>
