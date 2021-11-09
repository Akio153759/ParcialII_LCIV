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
import models.EmpresaTransportista;

/**
 *
 * @author Tama
 */
public class EmpresaTransportistaController {
    
    private DbHelper _db;

    public EmpresaTransportistaController() {
        _db = new DbHelper();
    }
    
    
    public ArrayList<EmpresaTransportista> getEmpresasTransportistas() {
        
        ArrayList<EmpresaTransportista> _lstEmpresasTransportistas = new ArrayList<>();
        
        ResultSet _result = _db.callProcedure("sp_get_empresas_transportistas");
        
        if (_result != null) {
            try {
                while (_result.next()){
                    EmpresaTransportista empresaTransportista = new EmpresaTransportista();
                    
                    empresaTransportista.setCodigo(_result.getString("codigo"));
                    empresaTransportista.setNombre(_result.getString("nombre"));
                    
                    _lstEmpresasTransportistas.add(empresaTransportista);
                }
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return _lstEmpresasTransportistas;
    }
}
