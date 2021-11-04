/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tama
 */
public class DbHelper {
    private final String url = "jdbc:sqlserver://DESKTOP-QLHIA4G:1433;databaseName=ParcialIILCIV";
    private final String user = "sa";
    private final String pass = "TamaSQLSERVERUTN";
    
    private Connection _objConnection;

    public Connection getObjConnection() {
        return _objConnection;
    }

    public DbHelper() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    
    public boolean connectDB() {
        
        boolean _bResult = false;
        
        try {
            _objConnection = DriverManager.getConnection(url, user, pass);
            _bResult = true;
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return _bResult;
    }
    
    
    public void disconnectDB(){
        try {
            _objConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ResultSet executeSimpleQuery(String tableName, String columnNameOrderBy)
    {
       
        ResultSet _objResult = null;
        
        PreparedStatement _objPStatement = null;
        
        try {
            if (connectDB())
            {   
                String _sQuery = String.format("SELECT * FROM %s ORDER BY %s", tableName, columnNameOrderBy);
                
                _objPStatement = _objConnection.prepareStatement(_sQuery);
                
                _objResult = _objPStatement.executeQuery();
                                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return _objResult;
    }
    
    public ResultSet getCustomQuery(String sql)
    {
        ResultSet _result = null;
        
        PreparedStatement _objPreparedStatement = null;
        
        
         try {
            if (connectDB())
            {   
                _objPreparedStatement = _objConnection.prepareStatement(sql);
                
                _result = _objPreparedStatement.executeQuery();    
                
            }    
            
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        return _result;
    }
    
    public ResultSet callProcedure(String spName, ArrayList<Object> spParams) {
        ResultSet _result = null;
        
        String _sParams = "";
        
        for (int i = 0; i < spParams.size(); i++) {
            _sParams += "?,";
        }
        
        _sParams =  _sParams.substring(0, _sParams.length() - 1);
        
        String _sQuerySP = String.format("EXEC %s %s", spName, _sParams);
        
        PreparedStatement _objPreparedStatement = null;
        
        try {
            if (connectDB())
            {   
                _objPreparedStatement = _objConnection.prepareStatement(_sQuerySP);
                
                for (int i = 0; i < spParams.size(); i++)
                    {
                        if (spParams.get(i) instanceof String)
                        {
                            _objPreparedStatement.setString(i+1, (String)(spParams.get(i)));
                        }
                        else if (spParams.get(i) instanceof Integer)
                        {
                            _objPreparedStatement.setInt(i+1, (int)(spParams.get(i)));
                        }
                        else if (spParams.get(i) instanceof Float)
                        {
                            _objPreparedStatement.setFloat(i+1, (float)(spParams.get(i)));
                        }
                        else if (spParams.get(i) instanceof Boolean)
                        {
                            _objPreparedStatement.setBoolean(i+1, (boolean)(spParams.get(i)));
                        }
                        else if (spParams.get(i) == null)
                        {
                            _objPreparedStatement.setNull(i+1, 1);
                        }
                        
                    }
                
                _result = _objPreparedStatement.executeQuery();    
                
            }    
            
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return _result;
    }
    
    public ResultSet callProcedure(String spName) {
        ResultSet _result = null;
        
        String _sQuerySP = String.format("EXEC %s", spName);
        
        PreparedStatement _objPreparedStatement = null;
        
        try {
            if (connectDB())
            {   
                _objPreparedStatement = _objConnection.prepareStatement(_sQuerySP);
                
                _result = _objPreparedStatement.executeQuery();    
                
            }    
            
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return _result;
    }
    
    public boolean insertData(String tableName, ArrayList<String> lstColumns, ArrayList<Object> lstValues )
    {
        boolean _bResult = false;
        
        if (lstColumns.size() == lstValues.size())
        {
            PreparedStatement _objPS = null;
            String _sCampos = "";
            String _sValues = "";
            
            
            for (String campo : lstColumns) 
            {
                _sCampos += String.format("%s,", campo);
            }
            
            _sCampos = _sCampos.substring(0, _sCampos.length() - 1);
    
            
            for (Object valor : lstValues) 
            {
                _sValues += "?,";
            }
            
            _sValues = _sValues.substring(0, _sValues.length() - 1);
         
            
            
            String _sQuery = String.format("INSERT INTO %s(%s) VALUES(%s)", tableName, _sCampos, _sValues);
            
  
            try 
            {
                if (connectDB())
                {
                    _objPS = _objConnection.prepareStatement(_sQuery);
                    
                    for (int i = 0; i < lstValues.size(); i++)
                    {
                        if (lstValues.get(i) instanceof String)
                        {
                            _objPS.setString(i+1, (String)(lstValues.get(i)));
                        }
                        else if (lstValues.get(i) instanceof Integer)
                        {
                            _objPS.setInt(i+1, (int)(lstValues.get(i)));
                        }
                         else if (lstValues.get(i) instanceof Float)
                        {
                            _objPS.setFloat(i+1, (float)(lstValues.get(i)));
                        }
                        
                    }
                    
                    _objPS.executeUpdate();
                    
                    _objPS.close();
                    
                    _bResult = true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                disconnectDB();
            }
            
            
        }
        
  
        return _bResult;
    }
    
    // Baja lógica
    public boolean deleteData(String tableName, String pkColumn, Object pkValue) {
        boolean _bResult = false;
        PreparedStatement _objPreparedStatement = null;
        
        String _sQuery = String.format("update %s set activo = 0, fh_baja = GETDATE() where %s = ?", tableName, pkColumn);
        
        try 
            {
                if (connectDB())
                {
                    _objPreparedStatement = _objConnection.prepareStatement(_sQuery);
                    
                    if (pkValue instanceof String) {
                        _objPreparedStatement.setString(1, (String)(pkValue));
                    }
                    else if (pkValue instanceof Integer) {
                        _objPreparedStatement.setInt(1, (Integer)(pkValue));
                    }
                    
                    _objPreparedStatement.executeUpdate();
                    
                    _objPreparedStatement.close();
                    
                    _bResult = true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                disconnectDB();
            }
        
        return _bResult;
    }
    
}
