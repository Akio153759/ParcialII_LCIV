/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataaccess.DbHelper;
import dtos.DespachoDto;
import dtos.DespachoDtoInsert;
import dtos.DetalleDespachoDtoInsert;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public boolean confirmarDespacho(String codDespacho){
        boolean _bResult = false;

        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(codDespacho);
           
        ResultSet _result = _db.callProcedure("sp_get_confirmar_despacho",spParams);
        
        if (_result != null)
        {
            try {
                _result.next();
                
                if (_result.getString("resultado").equals("OK")) {
                   _bResult = true;
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
        
        return _bResult;
    }
    
    
    public ArrayList<DespachoDto> getDespachosEntrantes(String codigoSucursal) {
        ArrayList<DespachoDto> _lstDespachos = new ArrayList<>();
        
        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(codigoSucursal);
           
        ResultSet _result = _db.callProcedure("sp_get_despachos_entrantes",spParams);
        
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
    
    
    public DespachoDto getDespachoDetalle(DespachoDto despacho) {
        

        
        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(despacho.getCodigo());
        
        ArrayList<DetalleDespachoDtoInsert> detalle = new ArrayList<>();
           
        ResultSet _result = _db.callProcedure("sp_get_despacho_detalle",spParams);
        
        if (_result != null) {
            
            try {
                while(_result.next()) {
                    DetalleDespachoDtoInsert d = new DetalleDespachoDtoInsert();
                    
                    d.setSuministro(_result.getString("suministro"));
                    d.setCantidad(_result.getInt("cantidad"));
                    
                    detalle.add(d);
                }
                
                despacho.setDetalle(detalle);
                
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(DespachoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return despacho;
    }
    
    
    public boolean registrarDespacho(DespachoDtoInsert despacho) throws SQLException
    {
        boolean _bResult = false;
        
        String codDespacho = generarCodigoDespacho();
        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(codDespacho);
        spParams.add(despacho.getSucOrigen());
        spParams.add("atamashiro");
        spParams.add(despacho.getSucDestino());
        spParams.add(despacho.getEmpresaTransp());
        
        // Dejo preparado el Bulk insert del detalle -----
        ArrayList<String> lstColumns = new ArrayList<>();
        
        lstColumns.add("cod_despacho");
        lstColumns.add("cod_suministro");
        lstColumns.add("cantidad");
        
        
        ArrayList<ArrayList<Object>> lstDetalles = new ArrayList<>();
        
        for (DetalleDespachoDtoInsert detalle : despacho.getDetalle()) {
            ArrayList<Object> lstValores = new ArrayList<>();
            
            lstValores.add(codDespacho);
            lstValores.add(detalle.getSuministro());
            lstValores.add(detalle.getCantidad());
            
            lstDetalles.add(lstValores);
        }
        
        // ----
        
        if (_db.connectDB()) {
            Connection connection = _db.getObjConnection();
            
            try {
                
                connection.setAutoCommit(false);
                ResultSet _result = _db.callProcedure("sp_generar_despacho_cabecera", spParams);

                if (_result != null) {
                    _result.next();

                    if (_result.getString("resultado").equals("OK")) {
                        // --- si la cabecera se genera ok, genero el detalle
                        if (_db.insertBatchData("DetallesDespacho", lstColumns, lstDetalles)) {

                            // -- si todo se genero ok, commiteo
                            connection.commit();

                            _bResult = true;
                        }
                        else {
                            connection.rollback();
                        }
                    }
                    else {
                        connection.rollback();
                        System.err.println("Error en sp_generar_despacho_cabecera: " + _result.getString("resultado"));
                    }

                }
            } catch (SQLException ex) {
                connection.rollback();
                Logger.getLogger(DespachoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (Exception e) {
                System.out.println(String.format("Error: %s", e.getMessage()));
            }
            finally {

                _db.disconnectDB();
            }
        }
        
        
        
        return _bResult;
    }
    
    
    private String generarCodigoDespacho() {
        Date now = new Date();
        return new SimpleDateFormat("yyyyMMddhhmmss").format(now);
    }
}
