/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsDB;

import dataAccess.persistence.oracle.BaseDAO;
import dataAccess.persistence.oracle.StructureDAO;
import dataAccess.toolsDB.DBConfig;
import domainGeneric.supported_units.SupportedDatabases;
import domainGeneric.supported_units.SupportedDatatypes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthias
 */
public class SupportedUnitsDAO extends BaseDAO {
    
    private static DBConfig dbc = new DBConfig();
    
    public SupportedUnitsDAO() { 
        super(dbc.getDbhost(), dbc.getDbport(), dbc.getDbservicename(), dbc.getDbuser(), dbc.getDbpassword());
    }
    
    public ArrayList<SupportedDatabases> getAllSupportedDatabases() {
        ArrayList<SupportedDatabases> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDDATABASES.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID," +
                                                                    "SUPPORTEDDATABASES.DATABASETYPE as DATABASETYPE" +
                                                                    " from SUPPORTEDDATABASES SUPPORTEDDATABASES");
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatabases database = new SupportedDatabases(dbResultSet.getInt("SUPPORTEDDATABASES_ID"), 
                                                                            dbResultSet.getString("DATABASETYPE"));
                result.add(database);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
    public SupportedDatabases getSupportedDatabaseById(int id) {

        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDDATABASES.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID," +
                                                                    "SUPPORTEDDATABASES.DATABASETYPE as DATABASETYPE" +
                                                                    " from SUPPORTEDDATABASES SUPPORTEDDATABASES WHERE "
                                                                    + "SUPPORTEDDATABASES.SUPPORTEDDATABASES_ID = ?");
            ps.setInt(1, id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatabases database = new SupportedDatabases(dbResultSet.getInt("SUPPORTEDDATABASES_ID"), 
                                                                            dbResultSet.getString("DATABASETYPE"));
                return database;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<SupportedDatatypes> getSupportedDataTypesByDB(int id) {
        ArrayList<SupportedDatatypes> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDDATATYPES.SUPPORTEDDATATYPES_ID as SUPPORTEDDATATYPES_ID," +
                                                                " SUPPORTEDDATATYPES.DATATYPE as DATATYPE," +
                                                                " SUPPORTEDDATATYPES.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID " +
                                                                " from SUPPORTEDDATATYPES SUPPORTEDDATATYPES" +
                                                                " WHERE SUPPORTEDDATATYPES.SUPPORTEDDATABASES_ID = ?");
            ps.setInt(1, id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatatypes datatype = new SupportedDatatypes(dbResultSet.getInt("SUPPORTEDDATATYPES_ID"), 
                                                                  dbResultSet.getString("DATATYPE"),
                                                                  getSupportedDatabaseById(dbResultSet.getInt("SUPPORTEDDATABASES_ID")));
                result.add(datatype);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public SupportedDatatypes getSupportedDataTypesByID(int id) {
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDDATATYPES.SUPPORTEDDATATYPES_ID as SUPPORTEDDATATYPES_ID," +
                                                                " SUPPORTEDDATATYPES.DATATYPE as DATATYPE," +
                                                                " SUPPORTEDDATATYPES.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID " +
                                                                " from SUPPORTEDDATATYPES SUPPORTEDDATATYPES" +
                                                                " WHERE SUPPORTEDDATATYPES.SUPPORTEDDATATYPES_ID = ?");
            ps.setInt(1, id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatatypes datatype = new SupportedDatatypes(dbResultSet.getInt("SUPPORTEDDATATYPES_ID"), 
                                                                  dbResultSet.getString("DATATYPE"),
                                                                  getSupportedDatabaseById(dbResultSet.getInt("SUPPORTEDDATABASES_ID")));
                return datatype;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
