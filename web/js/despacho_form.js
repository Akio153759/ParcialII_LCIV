/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var tabla_stock_sucursal;
var tabla_suministros_despachar;

$(document).ready(function(){
    innitTablaStockSucursal();
    innitTablaSuministrosDespachar();
    
    $('#tabla_stock_sucursal tbody').on( 'click', 'td', function () {
       
        let rowIdx = tabla_stock_sucursal.cell( this ).index().row;
        let colIdx = tabla_stock_sucursal.cell(this).index().column;  

        let codigo = tabla_stock_sucursal.rows( rowIdx ).data()[0][0] ;
        let suministro = tabla_stock_sucursal.rows( rowIdx ).data()[0][1] ;
        let cantidad_orig = tabla_stock_sucursal.rows( rowIdx ).data()[0][2] ;

     

    
    } );  
    
    $('#btnGrabarDespacho').click(function(){
        console.log('click')
        grabarDespacho();
    });
});

function cargarSuministro(component, codigo, suministro, cantidad) {
    
    if (cantidad == '' || cantidad == '0') {
        return;
    }
    
    
    tabla_stock_sucursal.rows().every(function ( rowIdx, tableLoop, rowLoop ){
        let cod_suministro = this.data()[0];
        
        if (cod_suministro === codigo) {
            let cant_anterior = this.data()[2];
            
            let restante = parseInt(cant_anterior) - parseInt(cantidad);
            
            tabla_stock_sucursal.cell(rowIdx,2).data(restante.toString()).draw();
           
        }
    });

    
    let exist = false;
    
    tabla_suministros_despachar.rows().every(function ( rowIdx, tableLoop, rowLoop ){
        let cod_suministro = this.data()[0];
        
        if (cod_suministro === codigo) {
            exist = true;
            
            let cant_anterior = parseInt(this.data()[2]);
            let cant_nueva = parseInt(cantidad) + cant_anterior;
            
            tabla_suministros_despachar.cell(rowIdx,2).data(cant_nueva.toString()).draw();
           
        }
    });
    
    if (!exist) {
        tabla_suministros_despachar.row.add([codigo, suministro, cantidad,'<i style="cursor: pointer" onclick="removerSuministro(\'' + codigo + '\',\'' + cantidad + '\')" class="fa fa-times" aria-hidden="true"></i>']).draw();
    }
    

    
    $(component).val('');
}


function removerSuministro(codigo, cantidad) {
    

    console.log('llega')
    tabla_stock_sucursal.rows().every(function ( rowIdx, tableLoop, rowLoop ){
        let cod_suministro = this.data()[0];
        
        if (cod_suministro === codigo) {
            
            let cant_anterior = this.data()[2];
            
            let restante = parseInt(cant_anterior) + parseInt(cantidad);
            
            tabla_stock_sucursal.cell(rowIdx,2).data(restante.toString()).draw();
           
        }
    });

    
    
    tabla_suministros_despachar.rows().every(function ( rowIdx, tableLoop, rowLoop ){
        let cod_suministro = this.data()[0];
        
        if (cod_suministro === codigo) {
            tabla_suministros_despachar.rows(rowIdx).remove().draw();
        }
    });
    

    
    $(component).val('');
}

function innitTablaStockSucursal() {
    tabla_stock_sucursal = $('#tabla_stock_sucursal').DataTable({
        language: datetable_languaje,
        pageLength: 10,
        columnDefs: [
                   {
                       'targets': [3,4],
                       'searchable':false,
                       'orderable':false,

                   },
           ],
                     
    });
}

function innitTablaSuministrosDespachar() {
    tabla_suministros_despachar = $('#tabla_suministros_despachar').DataTable({
        language: datetable_languaje,
        pageLength: 10,
        ordering: false,
        columnDefs: [
            {
                'targets': [1],
                'searchable':false,
                'orderable':false,
                        
            },
    ],
                     
    });
}

function grabarDespacho() {
    
    let despacho = {
        sucOrigen : 'COR000001',
        sucDestino: $('#cmbSucursalDestino option:selected').val(),
        empresaTransp : $('#cmbEmpresaTransportista option:selected').val(),
        detalle : []
    };
    
    despacho.detalle = [];
    
    tabla_suministros_despachar.rows().every(function ( rowIdx, tableLoop, rowLoop ){
        let cod_suministro = this.data()[0];
        let cantidad = this.data()[2];
        
        despacho.detalle.push({
            suministro : cod_suministro,
            cantidad: cantidad
        });
        
    });
   
    
    
     $.ajax({
        url: "NuevoDespacho",
        type: 'POST',
        datatype: 'json',
        data: {detalle: JSON.stringify(despacho)},
        statusCode: {
            200: function () {  
                window.location = 'Parcial_II/ListadoDespachos';
            },
            500: function () {
               
            }
        }
    });
}