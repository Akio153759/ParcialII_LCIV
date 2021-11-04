/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataaccess.DbHelper;
import dtos.DespachoDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Despacho;
import models.Empleado;
import models.Sucursal;

/**
 *
 * @author Tama
 */
public class DespachoController {
    
    private DbHelper _db;

    public DespachoController() {
        _db = new DbHelper();
    }
    
    public ArrayList<DespachoDto> getDespachosSalientes(String codigoSucursal) {
        ArrayList<DespachoDto> _lstDespachos = new ArrayList<>();
        
        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(codigoSucursal);
           
        ResultSet _result = _db.callProcedure("sp_get_despachos_salientes",spParams);
        
        if (_result != null) {
            
            try {
                while(_result.next()) {
                    DespachoDto _despacho = new DespachoDto();
                    
                    _despacho.setCodigo(_result.getString("codigo"));
                    _despacho.setSucOrigen(_result.getString("sucursal_origen"));
                    _despacho.setEmpGenero(_result.getString("empleado_generacion"));
                    _despacho.setFhGeneracion(_result.getString("fecha_generacion"));
                    _despacho.setSucDestino(_result.getString("sucursal_destino"));
                    _despacho.setEmpRecepciono(_result.getString("empleado_recepcion"));
                    _despacho.setFhRecepcion(_result.getString("fecha_recepcion"));
                    _despacho.setEmpresaTransportista(_result.getString("empresa_transportista"));
                    _despacho.setEstado(_result.getString("estado"));
                    
                    
                    _lstDespachos.add(_despacho);
                }
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(DespachoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return _lstDespachos;
    }
}
