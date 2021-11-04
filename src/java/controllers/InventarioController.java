/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataaccess.DbHelper;
import dtos.InventarioDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tama
 */
public class InventarioController {
    
    
    private DbHelper _db;

    public InventarioController() {
        _db = new DbHelper();
    }
    
    public ArrayList<InventarioDto> getInventarioSucursal(String cod_sucursal) {
        ArrayList<InventarioDto> _lstSuministros = new ArrayList<>();
        
        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(cod_sucursal);
        
        ResultSet _result = _db.callProcedure("sp_get_inventario", spParams);
        
        if (_result != null) {
            try {
                while (_result.next()){
                    _lstSuministros.add(new InventarioDto(_result.getString("codigo"),_result.getString("suministro"),_result.getInt("cantidad")));
                }
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return _lstSuministros;
    }
}
