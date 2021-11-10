/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
  $('#btnVerReporte').click(function(){
        verReporte();
  });
});


function verReporte(){
    
    let codSucursal = $('#cmbSucursal').val();
    
    $.ajax({
        url: "ReporteEntregasRecibidas",
        type: 'POST',
        datatype: 'json',
        data: {codSucursal: codSucursal},
        statusCode: {
            200: function (data) {  
                $('#seccion_resultado').html(data);
            },
            500: function () {
               
            }
        }
    });
}