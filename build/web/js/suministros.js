/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var tabla_suministros;

$(document).ready(function() {
   innitTablaSuministros();
});

function innitTablaSuministros () {
    tabla_suministros = $('#tabla_suministros').DataTable({
        language: datetable_languaje,
        pageLength: 5,
        columnDefs: [
            {
                'targets': [4],
                'searchable':false,
                'orderable':false,
                        
            },
    ],
                     
    });
}