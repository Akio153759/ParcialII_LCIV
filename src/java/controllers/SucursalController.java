/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataaccess.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Sucursal;

/**
 *
 * @author Tama
 */
public class SucursalController {
    
    private DbHelper _db;

    public SucursalController() {
        _db = new DbHelper();
    }
    
    
    public ArrayList<Sucursal> getSucursales() {
        
        ArrayList<Sucursal> _lstSucursales = new ArrayList<>();
         
        ResultSet _result = _db.callProcedure("sp_get_sucursales");
        
        if (_result != null) {
            try {
                while (_result.next()){
                    Sucursal sucursal = new Sucursal();
                    
                    sucursal.setCodigo(_result.getString("codigo"));
                    sucursal.setNombre(_result.getString("nombre"));
                    
                    _lstSucursales.add(sucursal);
                }
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return _lstSucursales;
    }
    
    
}
