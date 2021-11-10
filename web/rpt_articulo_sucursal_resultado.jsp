<%-- 
    Document   : rpt_articulo_sucursal_resultado
    Created on : 10 nov. 2021, 15:27:33
    Author     : Tama
--%>

<%@page contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="au-card-inner">
    <h4>Comparativo por sucursal</h4>
    <canvas id="chartRptArticulos"></canvas>
</div>
<script>
    $(document).ready(function(){
    
    var lstCantidades = [];
    var lstSucursales = [];
    
    <c:forEach items="${requestScope.sucursales}" var="sucursal">
            lstSucursales.push("${sucursal.nombre}");     
            lstCantidades.push(0);
    </c:forEach>
    
    for (var i = 0; i < lstSucursales.length; i++) {
        <c:forEach items="${requestScope.reporte}" var="r">
                if (lstSucursales[i] == "${r.sucursal}"){
                    lstCantidades[i] = ${r.cantidad}
                }
          </c:forEach>
    }
    
        
    var ctx = document.getElementById("chartRptArticulos");
    if (ctx) {
      ctx.height = 110;
      var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: lstSucursales,
          datasets: [
            {
              label: "${requestScope.articulo}",
              data: lstCantidades,
              borderColor: "rgba(0, 119, 215, 0.9)",
              borderWidth: "2",
              backgroundColor: "rgba(0, 70, 133, 0.5)"
            }
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          scales: {
            xAxes: [{
              ticks: {
                fontFamily: "Poppins"

              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                fontFamily: "Poppins"
              }
            }]
          }
        }
      });
    }
})
</script>