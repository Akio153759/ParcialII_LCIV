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
    
    let codSuministro = $('#cmbSuministro').val();
    let nomSuministro = $('#cmbSuministro option:selected').text();
    
    $.ajax({
        url: "ReporteArticuloSucursal",
        type: 'POST',
        datatype: 'json',
        data: {codSuministro: codSuministro, nomSuministro: nomSuministro},
        statusCode: {
            200: function (data) {  
                $('#seccion_resultado').html(data);
            },
            500: function () {
               
            }
        }
    });
}