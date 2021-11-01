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

/**
 *
 * @author Tama
 */
public class TipoSuministroController {
    
    private DbHelper _db;

    public TipoSuministroController() {
        _db = new DbHelper();
    }
    
    public ArrayList<TipoSuministro> getTiposSuministro ()
    {
        ArrayList<TipoSuministro> _lstTiposSuministro = new ArrayList<>();
        
        ResultSet _result = _db.executeSimpleQuery("TiposSuministro", "descripcion");
        
        if (_result != null)
        {
            try {
                while (_result.next())
                {
                    TipoSuministro _tipoSuministro = new TipoSuministro();
                    
                    _tipoSuministro.setId(_result.getInt("id"));
                    _tipoSuministro.setDescripcion(_result.getString("descripcion"));
                    
                    _lstTiposSuministro.add(_tipoSuministro);
                }
                
                _result.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(TipoSuministroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                _db.disconnectDB();
            }
        }
        
        return _lstTiposSuministro;
    }
    
}
