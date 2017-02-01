/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsdb;

import dataAccess.persistence.oracle.targetdb.StructureDAO;
import dto.project.Attribute;
import dto.project.Brgqueue;
import dto.project.DatabaseSchema;
import dto.project.LinkedBusinessrules;
import dto.project.Project;
import dto.project.Table;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
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
	
	private SupportedUnitsService sus = ToolDbService.getSUService();
        private BusinessRuleService brs = ToolDbService.getBRService();
   
    public ProjectDAO() { 
        super();
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
                DatabaseSchema dbs = this.getDatabaseSchema(dbResultSet.getInt("DATABASESCHEMA_ID")); //Still working?
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
    //TODO Boolean?
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
    
    public DatabaseSchema getDatabaseSchema (int databaseSchema_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select DATABASESCHEMA.DATABASESCHEMA_ID as DATABASESCHEMA_ID," +
                                                        "    DATABASESCHEMA.NAME as NAME," +
                                                        "    DATABASESCHEMA.CHARACTERSET as CHARACTERSET," +
                                                        "    DATABASESCHEMA.DBUSER as DBUSER," +
                                                        "    DATABASESCHEMA.DBPASSWORD as DBPASSWORD," +
                                                        "    DATABASESCHEMA.DBPORT as DBPORT," +
                                                        "    DATABASESCHEMA.DBSERVICENAME as DBSERVICENAME," +
                                                        "    DATABASESCHEMA.DBHOST as DBHOST " +
                                                        " from DATABASESCHEMA DATABASESCHEMA" +
                                                        " WHERE DATABASESCHEMA.DATABASESCHEMA_ID = ?");
            ps.setInt(1, databaseSchema_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                
                DatabaseSchema dbs = new DatabaseSchema(dbResultSet.getInt("DATABASESCHEMA_ID"), 
                        dbResultSet.getString("NAME"), 
                        dbResultSet.getString("CHARACTERSET"), 
                        dbResultSet.getString("DBUSER"), 
                        dbResultSet.getString("DBPASSWORD"), 
                        dbResultSet.getString("DBPORT"), 
                        dbResultSet.getString("DBSERVICENAME"), 
                        dbResultSet.getString("DBHOST"));
                return dbs;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Table getTable (int table_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select \"table\".TABLE_ID as TABLE_ID," +
                                                        "    \"table\".DATABASESCHEMA_ID as DATABASESCHEMA_ID," +
                                                        "    \"table\".NAME as NAME " +
                                                        " from \"table\" \"table\"" +
                                                        " WHERE \"table\".TABLE_ID = ?");
            ps.setInt(1, table_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                DatabaseSchema dbs = this.getDatabaseSchema(dbResultSet.getInt("DATABASESCHEMA_ID"));
                Table table = new Table(dbResultSet.getInt("TABLE_ID"), dbResultSet.getString("NAME"),dbs);
                
                ArrayList<Attribute> atr = this.getAllAttributes(dbResultSet.getInt("TABLE_ID"));
                for (Attribute x : atr) {
                    table.addAttribute(x);
                }
 
                return table;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Specific use for method getTable() and getAttribute()
    private ArrayList<Attribute> getAllAttributes (int table_id) {
        ArrayList<Attribute> result = new ArrayList<>();
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select ATTRIBUTE.ATTRIBUTE_ID as ATTRIBUTE_ID," +
                                                        "    ATTRIBUTE.TABLE_ID as TABLE_ID," +
                                                        "    ATTRIBUTE.SUPPORTEDDATATYPES_ID as SUPPORTEDDATATYPES_ID," +
                                                        "    ATTRIBUTE.NAME as NAME " +
                                                        " from ATTRIBUTE ATTRIBUTE" +
                                                        " WHERE ATTRIBUTE.TABLE_ID = ?");
            ps.setInt(1, table_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatatypes supdatatype = sus.getSupportedDataTypesByID(dbResultSet.getInt("SUPPORTEDDATATYPES_ID"));
                
                Attribute attribute = new Attribute(dbResultSet.getInt("ATTRIBUTE_ID"), dbResultSet.getString("NAME"), supdatatype);
                
                result.add(attribute);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Attribute getAttribute (int atr_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select ATTRIBUTE.ATTRIBUTE_ID as ATTRIBUTE_ID," +
                                                        "    ATTRIBUTE.SUPPORTEDDATATYPES_ID as SUPPORTEDDATATYPES_ID," +
                                                        "    ATTRIBUTE.NAME as NAME," +
                                                        "    \"table\".TABLE_ID as TABLE_ID," +
                                                        "    \"table\".DATABASESCHEMA_ID as DATABASESCHEMA_ID," +
                                                        "    \"table\".NAME as NAME " +
                                                        " from \"table\" \"table\"," +
                                                        "    ATTRIBUTE ATTRIBUTE " +
                                                        " where ATTRIBUTE.TABLE_ID=\"table\".TABLE_ID" +
                                                        " and ATTRIBUTE.ATTRIBUTE_ID = ?");
            ps.setInt(1, atr_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatatypes supdatatype = sus.getSupportedDataTypesByID(dbResultSet.getInt("SUPPORTEDDATATYPES_ID"));
                DatabaseSchema dbs = this.getDatabaseSchema(dbResultSet.getInt("DATABASESCHEMA_ID"));
                Table table = new Table(dbResultSet.getInt("TABLE_ID"), dbResultSet.getString("NAME"), dbs);
                
                ArrayList<Attribute> atr = this.getAllAttributes(dbResultSet.getInt("TABLE_ID"));
                for (Attribute x : atr) {
                    table.addAttribute(x);
                }
                
                Attribute attribute = new Attribute(dbResultSet.getInt("ATTRIBUTE_ID"), dbResultSet.getString("NAME"), table, supdatatype);
                
                return attribute;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Project getProject (int project_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select PROJECT.PROJECT_ID as PROJECT_ID," +
                                                        "    PROJECT.PROJECTNAME as PROJECTNAME," +
                                                        "    PROJECT.ABBREVIATION as ABBREVIATION," +
                                                        "    PROJECT.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID," +
                                                        "    PROJECT.ACCOUNT_ID as USERNAME," +
                                                        "    PROJECT.DATABASESCHEMA_ID as DATABASESCHEMA_ID " +
                                                        " from PROJECT PROJECT" +
                                                        " WHERE PROJECT.PROJECT_ID = ?");
            ps.setInt(1, project_id);
            ResultSet dbResultSet = ps.executeQuery();
            while (dbResultSet.next()) {
            	System.out.println("voor toevoegen supdatabases");
                SupportedDatabases sdb = sus.getSupportedDatabaseById(dbResultSet.getInt("SUPPORTEDDATABASES_ID"));
                System.out.println("voor toevoegen schema");
                DatabaseSchema ds = this.getDatabaseSchema(dbResultSet.getInt("DATABASESCHEMA_ID"));
                System.out.println("voor toevoegen project");
                Project project = new Project(dbResultSet.getInt("PROJECT_ID"),
                                              dbResultSet.getString("PROJECTNAME"),
                                              dbResultSet.getString("ABBREVIATION"),
                                              Integer.toString(dbResultSet.getInt("USERNAME")),
                                               sdb, ds);
                
                System.out.println("na toevoegen project");
                return project;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public LinkedBusinessrules getLinkedBusinessrules (int linkedbs_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select LINKED_BUSINESSRULES.LINKED_BUSINESSRULES_ID as LINKED_BUSINESSRULES_ID," +
                                                        "    LINKED_BUSINESSRULES.PROJECT_ID as PROJECT_ID," +
                                                        "    LINKED_BUSINESSRULES.BUSINESSRULE_ID as BUSINESSRULE_ID" +
                                                        " from LINKED_BUSINESSRULES LINKED_BUSINESSRULES" +
                                                        " WHERE LINKED_BUSINESSRULES.LINKED_BUSINESSRULES_ID = ?");
            ps.setInt(1, linkedbs_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                LinkedBusinessrules lbs = new LinkedBusinessrules(dbResultSet.getInt("LINKED_BUSINESSRULES_ID"),
                        this.getProject(dbResultSet.getInt("PROJECT_ID")),
                        brs.getBusinessrule(dbResultSet.getInt("BUSINESSRULE_ID")));

                return lbs;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Brgqueue getBrgqueue (int brgq_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement(" select BRGQUEUE.BRGQUEUE_ID as BRGQUEUE_ID," +
                                                        "    BRGQUEUE.TICKET_ID as TICKET_ID," +
                                                        "    BRGQUEUE.LINKED_BUSINESSRULES_ID as LINKED_BUSINESSRULES_ID," +
                                                        "    BRGQUEUE.RESPONSE_MESSAGE as RESPONSE_MESSAGE" +
                                                        " from BRGQUEUE BRGQUEUE" +
                                                        " WHERE BRGQUEUE.BRGQUEUE_ID = ?");
            ps.setInt(1, brgq_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Brgqueue brgq = new Brgqueue(dbResultSet.getInt("BRGQUEUE_ID"),
                                            dbResultSet.getInt("TICKET_ID"),
                                            this.getLinkedBusinessrules(dbResultSet.getInt("LINKED_BUSINESSRULES_ID")),
                                            dbResultSet.getString("RESPONSE_MESSAGE"));

                return brgq;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Brgqueue> getAllBrgqueue (int ticket_id) {
        ArrayList<Brgqueue> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement(" select BRGQUEUE.BRGQUEUE_ID as BRGQUEUE_ID," +
                                                        "    BRGQUEUE.TICKET_ID as TICKET_ID," +
                                                        "    BRGQUEUE.LINKED_BUSINESSRULES_ID as LINKED_BUSINESSRULES_ID," +
                                                        "    BRGQUEUE.RESPONSE_MESSAGE as RESPONSE_MESSAGE" +
                                                        " from BRGQUEUE BRGQUEUE" +
                                                        " WHERE BRGQUEUE.TICKET_ID = ?");
            ps.setInt(1, ticket_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Brgqueue brgq = new Brgqueue(dbResultSet.getInt("BRGQUEUE_ID"),
                                            dbResultSet.getInt("TICKET_ID"),
                                            this.getLinkedBusinessrules(dbResultSet.getInt("LINKED_BUSINESSRULES_ID")),
                                            dbResultSet.getString("RESPONSE_MESSAGE"));
                
                result.add(brgq);   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
