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
import models.TipoSuministro;
import models.UnidadMedida;

/**
 *
 * @author Tama
 */
public class UnidadesMedidaController {
    
    private DbHelper _db;

    public UnidadesMedidaController() {
        _db = new DbHelper();
    }
    
    public ArrayList<UnidadMedida> getUnidadesMedida ()
    {
        ArrayList<UnidadMedida> _lstUnidadesMedida = new ArrayList<>();
        
        ResultSet _result = _db.executeSimpleQuery("UnidadesMedida", "descripcion");
        
        if (_result != null)
        {
            try {
                while (_result.next())
                {
                    UnidadMedida _unidadMedida = new UnidadMedida();
                    
                    _unidadMedida.setId(_result.getInt("id"));
                    _unidadMedida.setDescripcion(_result.getString("descripcion"));
                    _unidadMedida.setAbreviacion(_result.getString("abreviacion"));
                    
                    _lstUnidadesMedida.add(_unidadMedida);
                }
                
                _result.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(UnidadesMedidaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                _db.disconnectDB();
            }
        }
        
        return _lstUnidadesMedida;
    }
    
    
}
