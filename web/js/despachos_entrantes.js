/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var tabla_despachos_salientes;

$(document).ready(function() {
   innitTablaDespachos();
});

function innitTablaDespachos () {
    tabla_despachos_salientes = $('#tabla_despachos_entrantes').DataTable({
        language: datetable_languaje,
        pageLength: 10,
        columnDefs: [
            {
                'targets': [8],
                'searchable':false,
                'orderable':false,
                        
            },
    ],
                     
    });
}