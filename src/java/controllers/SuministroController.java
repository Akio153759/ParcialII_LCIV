/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataaccess.DbHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Suministro;
import models.TipoSuministro;
import models.UnidadMedida;

/**
 *
 * @author Tama
 */
public class SuministroController {
    
    private DbHelper _db;
    
    public SuministroController() {
        _db = new DbHelper();
    }
    
    public ArrayList<Suministro> getSuministros ()
    {
        ArrayList<Suministro> _lstSuministros = new ArrayList<>();
        
        String _sQuery = "";
        
        ResultSet _result = _db.callProcedure("sp_get_suministros");
        
        if (_result != null)
        {
            try {
                while (_result.next())
                {
                    TipoSuministro _tipoSuministro = new TipoSuministro(_result.getInt("tipoSuministroId"),_result.getString("tipoSuministroDesc"));
                    UnidadMedida _unidadMedida = new UnidadMedida(_result.getInt("unidadMedidaId"), _result.getString("unidadMedidaDesc"),_result.getString("unidadMedidaAbrv"));
                    
                    Suministro _suministro = new Suministro();
                    
                    _suministro.setCodigo(_result.getString("codigo"));
                    _suministro.setNombre(_result.getString("nombre"));
                    _suministro.setDescripcion(_result.getString("descripcion"));
                    _suministro.setVentaLibre(_result.getBoolean("ventaLibre"));
                    _suministro.setPrecioUnitario(_result.getFloat("precioUnitario"));
                    _suministro.setContenidoNeto(_result.getFloat("contenidoNeto"));
                    
                    _suministro.setTipoSuministro(_tipoSuministro);
                    _suministro.setUnidadMedida(_unidadMedida);
                    
                    
                    _lstSuministros.add(_suministro);
                }
                
                _result.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SuministroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                _db.disconnectDB();
            }
        }
        
        return _lstSuministros;
    }
    
    
    public Suministro getSuministro(String codigo) {
        Suministro _suministro = null;
        
        ArrayList<Object> spParam = new ArrayList<>();
        spParam.add(codigo);
        
        ResultSet _result = _db.callProcedure("sp_get_suministro", spParam);
        
        if (_result != null) {
            
            try {
                _result.next();
                
                _suministro = new Suministro(
                        _result.getString("codigo"),
                        _result.getString("nombre"),
                        _result.getString("descripcion"),
                        _result.getBoolean("ventaLibre"),
                        _result.getFloat("precioUnitario"),
                        new TipoSuministro(_result.getInt("tipoSuministroId"),
                                           _result.getString("tipoSuministroDesc")),
                        _result.getFloat("contenidoNeto"),
                        new UnidadMedida(_result.getInt("unidadMedidaId"),
                                         _result.getString("unidadMedidaDesc"),
                                         _result.getString("unidadMedidaAbrv"))
                );
                
                 _result.close();
                
            }
            catch(SQLException ex) {
                Logger.getLogger(SuministroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                _db.disconnectDB();
            }
        }
        
        return _suministro;
    }
    
    
    public boolean registrarSuministro(Suministro suministro)
    {
        boolean _bResult = false;
        
        ResultSet _spResult;
        
        ArrayList<Object> _lstParams = new ArrayList<>();
        
        _lstParams.add(suministro.getNombre());
        _lstParams.add(suministro.getDescripcion());
        _lstParams.add(suministro.isVentaLibre());
        _lstParams.add(suministro.getPrecioUnitario());
        _lstParams.add(suministro.getTipoSuministro().getId());
        _lstParams.add(suministro.getContenidoNeto() == 0 ? null : suministro.getContenidoNeto());
        _lstParams.add(suministro.getUnidadMedida().getId() == 0 ? null :suministro.getUnidadMedida().getId());
        
        
        _spResult = _db.callProcedure("sp_nuevo_suministro", _lstParams);
        
        
        if (_spResult != null)
        {
            try {
                _spResult.next();
                
                if (_spResult.getString("resultado").equals("OK")) {
                   _bResult = true;
                }
                
                _spResult.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SuministroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                _db.disconnectDB();
            }
        }
        
        return _bResult;
    }
    
    public boolean eliminarSuministro(String codigo) {   
        
        return _db.deleteData("Suministros", "codigo", codigo);
    }
    
    
    public boolean editarSuministro(Suministro suministro) {
        boolean _bResult = false;
        
        ResultSet _spResult;
        
        ArrayList<Object> _lstParams = new ArrayList<>();
        
        _lstParams.add(suministro.getCodigo());
        _lstParams.add(suministro.getDescripcion());
        _lstParams.add(suministro.isVentaLibre());
        _lstParams.add(suministro.getPrecioUnitario());
        _lstParams.add(suministro.getContenidoNeto() == 0 ? null : suministro.getContenidoNeto());
        _lstParams.add(suministro.getUnidadMedida().getId() == 0 ? null :suministro.getUnidadMedida().getId());
        
        
        _spResult = _db.callProcedure("sp_editar_suministro", _lstParams);
        
        
        if (_spResult != null)
        {
            try {
                _spResult.next();
                
                if (_spResult.getString("resultado").equals("OK")) {
                   _bResult = true;
                }
                
                _spResult.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SuministroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                _db.disconnectDB();
            }
        }
        
        return _bResult;
    }
    
}
