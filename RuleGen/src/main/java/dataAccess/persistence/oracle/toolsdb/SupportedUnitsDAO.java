/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsdb;

import dataAccess.persistence.oracle.BaseDAO;
import dataAccess.persistence.oracle.targetdb.StructureDAO;
import dataAccess.toolsdb.DBConfig;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import dto.supported_units.SupportedOperators;
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
    private static String dbhost = dbc.getDbhost();
    private static String dbport = dbc.getDbport();
    private static String dbservicename = dbc.getDbservicename();
    private static String dbuser = dbc.getDbuser();
    private static String dbpassword = dbc.getDbpassword();   
    
    public SupportedUnitsDAO() { 
        super(dbhost, dbport, dbservicename, dbuser, dbpassword);
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
    
    public ArrayList<SupportedDatatypes> getSupportedDataTypesByDB(SupportedDatabases database) {
        ArrayList<SupportedDatatypes> result = new ArrayList<>();
            
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDDATATYPES.SUPPORTEDDATATYPES_ID as SUPPORTEDDATATYPES_ID," +
                                                                " SUPPORTEDDATATYPES.DATATYPE as DATATYPE," +
                                                                " SUPPORTEDDATATYPES.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID " +
                                                                " from SUPPORTEDDATATYPES SUPPORTEDDATATYPES" +
                                                                " WHERE SUPPORTEDDATATYPES.SUPPORTEDDATABASES_ID = ?");
            ps.setInt(1, database.getId());
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
    
    public ArrayList<SupportedOperators> getAllSupportedOperators() {
        ArrayList<SupportedOperators> result = new ArrayList<>();
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDOPERATORS.SUPPORTEDOPERATORS_ID as SUPPORTEDOPERATORS_ID," +
                                                                "    SUPPORTEDOPERATORS.OPERATOR as OPERATOR" +
                                                                " from SUPPORTEDOPERATORS SUPPORTEDOPERATORS");
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedOperators supoperator = new SupportedOperators(dbResultSet.getInt("SUPPORTEDOPERATORS_ID"), 
                                                                  dbResultSet.getString("OPERATOR"));
                result.add(supoperator);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public SupportedOperators getSupportedOperator(int id) {
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDOPERATORS.SUPPORTEDOPERATORS_ID as SUPPORTEDOPERATORS_ID," +
                                                                "    SUPPORTEDOPERATORS.OPERATOR as OPERATOR" +
                                                                " from SUPPORTEDOPERATORS SUPPORTEDOPERATORS" +
                                                                " where SUPPORTEDOPERATORS.SUPPORTEDOPERATORS_ID = ?");
            ps.setInt(1, id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedOperators supoperator = new SupportedOperators(dbResultSet.getInt("SUPPORTEDOPERATORS_ID"), 
                                                                  dbResultSet.getString("OPERATOR"));
                return supoperator;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
