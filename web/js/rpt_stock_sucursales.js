/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var tabla_reporte;

$(document).ready(function() {
   innitTablaReporte();
});

function innitTablaReporte () {
    tabla_reporte = $('#tabla_reporte').DataTable({
        language: datetable_languaje,
        pageLength: 10,
                     
    });
}