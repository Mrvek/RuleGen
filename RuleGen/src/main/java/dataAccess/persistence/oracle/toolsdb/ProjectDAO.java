/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsdb;

import dataAccess.persistence.oracle.BaseDAO;
import dataAccess.persistence.oracle.targetdb.StructureDAO;
import dataAccess.toolsdb.DBConfig;
import dataAccess.dto.project.Attribute;
import dataAccess.dto.project.DatabaseSchema;
import dataAccess.dto.project.Table;
import dataAccess.dto.supported_units.SupportedDatatypes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthias
 */
public class ProjectDAO extends BaseDAO {
    private static DBConfig dbc = new DBConfig();
    private static String dbhost = dbc.getDbhost();
    private static String dbport = dbc.getDbport();
    private static String dbservicename = dbc.getDbservicename();
    private static String dbuser = dbc.getDbuser();
    private static String dbpassword = dbc.getDbpassword();   
    
    public ProjectDAO() { 
        super(dbhost, dbport, dbservicename, dbuser, dbpassword);
    }
    
    public ArrayList<Table> getAllTablesFromProject(int project_id) {
        ArrayList<Table> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select \"table\".TABLE_ID as TABLE_ID," +
                                                        "    \"table\".DATABASESCHEMA_ID as DATABASESCHEMA_ID," +
                                                        "    \"table\".NAME as NAME," +
                                                        "    DATABASESCHEMA.NAME as SNAME" +
                                                        " from DATABASESCHEMA DATABASESCHEMA," +
                                                        "    PROJECT PROJECT," +
                                                        "    \"table\" \"table\" " +
                                                        " where \"table\".DATABASESCHEMA_ID=PROJECT.DATABASESCHEMA_ID" +
                                                        "    and \"table\".DATABASESCHEMA_ID=DATABASESCHEMA.DATABASESCHEMA_ID" +
                                                        "	and PROJECT.PROJECT_ID = ?");
            ps.setInt(1, project_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                DatabaseSchema dbs = new DatabaseSchema(dbResultSet.getInt("DATABASESCHEMA_ID"), dbResultSet.getString("SNAME"));
                Table database = new Table(dbResultSet.getInt("TABLE_ID"), dbResultSet.getString("NAME"), dbs);
                                                                            
                result.add(database);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
    public ArrayList<Attribute> getAllAttributesFromTableAndProjectID(Table table, int project_id) {
        ArrayList<Attribute> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select ATTRIBUTE.ATTRIBUTE_ID as ATTRIBUTE_ID," +
                                                                "    ATTRIBUTE.NAME as NAME," +
                                                                "    SUPPORTEDDATATYPES.SUPPORTEDDATATYPES_ID as SUPPORTEDDATATYPES_ID," +
                                                                "    SUPPORTEDDATATYPES.DATATYPE as DATATYPE " +
                                                                " from SUPPORTEDDATATYPES SUPPORTEDDATATYPES," +
                                                                "    DATABASESCHEMA DATABASESCHEMA," +
                                                                "    ATTRIBUTE ATTRIBUTE," +
                                                                "    \"table\" \"table\"," +
                                                                "    PROJECT PROJECT " +
                                                                " where PROJECT.DATABASESCHEMA_ID=DATABASESCHEMA.DATABASESCHEMA_ID " +
                                                                "    and \"table\".TABLE_ID=ATTRIBUTE.TABLE_ID " +
                                                                "    and DATABASESCHEMA.DATABASESCHEMA_ID=\"table\".DATABASESCHEMA_ID " +
                                                                "    and ATTRIBUTE.SUPPORTEDDATATYPES_ID=SUPPORTEDDATATYPES.SUPPORTEDDATATYPES_ID " +
                                                                "	and PROJECT.PROJECT_ID = ? " +
                                                                "	and ATTRIBUTE.TABLE_ID = ?");
            ps.setInt(1, project_id);
            ps.setInt(2, table.getId());
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatatypes sdtype = new SupportedDatatypes(dbResultSet.getInt("SUPPORTEDDATATYPES_ID"), dbResultSet.getString("DATATYPE"), null);
                Attribute atr = new Attribute(dbResultSet.getInt("ATTRIBUTE_ID"), dbResultSet.getString("NAME"), table, sdtype);
                                                     
                result.add(atr);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
    public int getSchemaId(int project_id) {
        int schema_id = 0;
        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select PROJECT.DATABASESCHEMA_ID as DATABASESCHEMA_ID" +
                                                        " from PROJECT PROJECT" +
                                                        " WHERE PROJECT.PROJECT_ID = ?");
            ps.setInt(1, project_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                schema_id = dbResultSet.getInt("DATABASESCHEMA_ID");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schema_id;
    }
    
    public boolean projectExists(int project_id) {
        boolean result = false;
        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select PROJECT.DATABASESCHEMA_ID as DATABASESCHEMA_ID" +
                                                        " from PROJECT PROJECT" +
                                                        " WHERE PROJECT.PROJECT_ID = ?");
            ps.setInt(1, project_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                result = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public void insertTables(int database_schema_id, ArrayList<Table> tables) {
        try (Connection con = super.getConnection()) {
            for (Table table : tables) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO \"table\" (DATABASESCHEMA_ID, NAME) VALUES (?, ?)");
                ps.setInt(1, database_schema_id);
                ps.setString(2, table.getName());
                
                ps.executeUpdate();
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertAttributes(Table table, ArrayList<Attribute> attributes) {
        try (Connection con = super.getConnection()) {
            for (Attribute atr : attributes) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO ATTRIBUTE (TABLE_ID, SUPPORTEDDATATYPES_ID, NAME) VALUES (?, ?, ?)");
                ps.setInt(1, table.getId());
                ps.setInt(2, atr.getSupporteddatatype().getId());
                ps.setString(3, atr.getName());

                ps.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
