/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataaccess.DbHelper;
import dtos.DespachoDto;
import dtos.StockDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tama
 */
public class ReportController {
    
    private DbHelper _db;

    public ReportController() {
        _db = new DbHelper();
    }
    
    public ArrayList<DespachoDto> rptEntregasRecibidas(String codSucursal) {
        ArrayList<DespachoDto> _lstResultado = new ArrayList<>();
        
        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(codSucursal);
           
        ResultSet _result = _db.callProcedure("sp_rpt_entregas_recibidas",spParams);
        
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
                    
                    
                    _lstResultado.add(_despacho);
                }
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return _lstResultado;
    }
    
    
    public ArrayList<StockDto> rptStockSucursales(){
        ArrayList<StockDto> _lstResultado = new ArrayList<>();
           
        ResultSet _result = _db.callProcedure("sp_rpt_stock_por_sucursal");
        
        if (_result != null) {
            
            try {
                while(_result.next()) {
                    StockDto _stock = new StockDto();
                    
                    _stock.setSucursal(_result.getString("sucursal"));
                    _stock.setSuministro(_result.getString("suministro"));
                    _stock.setPrecioUnitario(_result.getFloat("precio_unitario"));
                    _stock.setCantidad(_result.getInt("cantidad"));
                    
                    _lstResultado.add(_stock);
                }
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return _lstResultado;
    }
    
    
    public ArrayList<StockDto> rptStockArticuloSucursales(String codSuministro){
        ArrayList<StockDto> _lstResultado = new ArrayList<>();
        
        ArrayList<Object> spParams = new ArrayList<>();
        
        spParams.add(codSuministro);
           
        ResultSet _result = _db.callProcedure("sp_rpt_stock_articulo_sucursales", spParams);
        
        if (_result != null) {
            
            try {
                while(_result.next()) {
                    StockDto _stock = new StockDto();
                    
                    _stock.setSucursal(_result.getString("sucursal"));
                    _stock.setSuministro(_result.getString("suministro"));
                    _stock.setCantidad(_result.getInt("cantidad"));
                    
                    _lstResultado.add(_stock);
                }
                
                _result.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                _db.disconnectDB();
            }
        }
        
        return _lstResultado;
    }
}
