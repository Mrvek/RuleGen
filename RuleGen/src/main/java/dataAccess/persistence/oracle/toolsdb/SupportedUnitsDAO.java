/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsdb;

import dataAccess.persistence.oracle.targetdb.StructureDAO;
import dto.project.DatabaseSchema;
import dto.supported_units.PackageTemplate;
import dto.supported_units.ProcedureTemplate;
import dto.supported_units.RuletypeTemplate;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import dto.supported_units.SupportedOperators;
import dto.supported_units.Template;
import dto.supported_units.TriggerTemplate;
import java.sql.Clob;
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
    	
        private BusinessRuleService brs = ToolDbService.getBRService();
   
    public SupportedUnitsDAO() {    	
        super();        
    }
    
    public ArrayList<SupportedDatabases> getAllSupportedDatabases() {
        ArrayList<SupportedDatabases> result = new ArrayList<>();
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("select SUPPORTEDDATABASES.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID," +
                                                                    " SUPPORTEDDATABASES.DATABASETYPE as DATABASETYPE," +
                                                                    " SUPPORTEDDATABASES.ABBREVIATION as ABBREVIATION," +
                                                                    " SUPPORTEDDATABASES.DBDRIVER as DBDRIVER," +
                                                                    " SUPPORTEDDATABASES.DBCON_PREFIX as DBCON_PREFIX" +
                                                                    " from SUPPORTEDDATABASES SUPPORTEDDATABASES");
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatabases database = new SupportedDatabases(dbResultSet.getInt("SUPPORTEDDATABASES_ID"), 
                                                                            dbResultSet.getString("DATABASETYPE"),
                                                                            dbResultSet.getString("ABBREVIATION"),
                                                                            dbResultSet.getString("DBDRIVER"),
                                                                            dbResultSet.getString("DBCON_PREFIX"));
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
                                                                    " SUPPORTEDDATABASES.DATABASETYPE as DATABASETYPE," +
                                                                    " SUPPORTEDDATABASES.ABBREVIATION as ABBREVIATION," +
                                                                    " SUPPORTEDDATABASES.DBDRIVER as DBDRIVER," +
                                                                    " SUPPORTEDDATABASES.DBCON_PREFIX as DBCON_PREFIX" +
                                                                    " from SUPPORTEDDATABASES SUPPORTEDDATABASES WHERE "
                                                                    + "SUPPORTEDDATABASES.SUPPORTEDDATABASES_ID = ?");
            ps.setInt(1, id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedDatabases database = new SupportedDatabases(dbResultSet.getInt("SUPPORTEDDATABASES_ID"), 
                                                                            dbResultSet.getString("DATABASETYPE"),
                                                                            dbResultSet.getString("ABBREVIATION"),
                                                                            dbResultSet.getString("DBDRIVER"),
                                                                            dbResultSet.getString("DBCON_PREFIX"));
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
    
    public Template getTemplate(int template_id) {
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement(" select TEMPLATE.TEMPLATE_ID as TEMPLATE_ID," +
                                                                "    TEMPLATE.NAME as NAME," +
                                                                "    TEMPLATE.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID," +
                                                                "    TEMPLATE.CONSTRAINT_CODE as CONSTRAINT_CODE " +
                                                                " from TEMPLATE TEMPLATE" +
                                                                " WHERE TEMPLATE.TEMPLATE_ID = ?");
            ps.setInt(1, template_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Template template = new Template(dbResultSet.getInt("TEMPLATE_ID"),
                                                dbResultSet.getString("NAME"),
                                                this.getSupportedDatabaseById(dbResultSet.getInt("SUPPORTEDDATABASES_ID")),
                                                dbResultSet.getString("CONSTRAINT_CODE"));
                return template;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Template> getAllTemplates() {
        ArrayList<Template> results = new ArrayList<>();
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement(" select TEMPLATE.TEMPLATE_ID as TEMPLATE_ID," +
                                                                "    TEMPLATE.NAME as NAME," +
                                                                "    TEMPLATE.SUPPORTEDDATABASES_ID as SUPPORTEDDATABASES_ID," +
                                                                "    TEMPLATE.CONSTRAINT_CODE as CONSTRAINT_CODE " +
                                                                " from TEMPLATE TEMPLATE");
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Template template = new Template(dbResultSet.getInt("TEMPLATE_ID"),
                                                dbResultSet.getString("NAME"),
                                                this.getSupportedDatabaseById(dbResultSet.getInt("SUPPORTEDDATABASES_ID")),
                                                dbResultSet.getString("CONSTRAINT_CODE"));
                results.add(template);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    
    public RuletypeTemplate getRuleTypeTemplate(int ruletype_id, int template_id) {
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement(" select RULETYPE_TEMPLATE.BUSINESSRULETYPE_ID as BUSINESSRULETYPE_ID," +
                                                                "    RULETYPE_TEMPLATE.DATABASE_TEMPLATE_ID as DATABASE_TEMPLATE_ID," +
                                                                "    RULETYPE_TEMPLATE.PROCEDURE_CODE as PROCEDURE_CODE," +
                                                                "    RULETYPE_TEMPLATE.CONSTRAINT_CODE as CONSTRAINT_CODE," +
                                                                "    RULETYPE_TEMPLATE.PARAMETER_CODE as PARAMETER_CODE " +
                                                                " from RULETYPE_TEMPLATE RULETYPE_TEMPLATE" +
                                                                " WHERE RULETYPE_TEMPLATE.BUSINESSRULETYPE_ID = ? " +
                                                                " and RULETYPE_TEMPLATE.DATABASE_TEMPLATE_ID = ?");
            ps.setInt(1, ruletype_id);
            ps.setInt(2, template_id);
            ResultSet dbResultSet = ps.executeQuery();
   
            while (dbResultSet.next()) {
                
                Clob PROCEDURE_CODE = dbResultSet.getClob("PROCEDURE_CODE");
                String svalue = null;
                if (PROCEDURE_CODE != null) {
                    svalue = PROCEDURE_CODE.getSubString(1, (int) PROCEDURE_CODE.length());
                } 
                
                Clob CONSTRAINT_CODE = dbResultSet.getClob("CONSTRAINT_CODE");
                String svalue2 = null;
                if (CONSTRAINT_CODE != null) {
                    svalue = CONSTRAINT_CODE.getSubString(1, (int) CONSTRAINT_CODE.length());
                } 
                
                RuletypeTemplate rtemplate = new RuletypeTemplate(this.getTemplate(dbResultSet.getInt("DATABASE_TEMPLATE_ID")),
                                                                    brs.getBusinessRuleType(dbResultSet.getInt("BUSINESSRULETYPE_ID")),
                                                                    svalue,
                                                                    svalue2,
                                                                    dbResultSet.getString("PARAMETER_CODE"));
                return rtemplate;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<RuletypeTemplate> getAllRuleTypeTemplates(int template_id) {
        ArrayList<RuletypeTemplate> results = new ArrayList<>();
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement(" select RULETYPE_TEMPLATE.BUSINESSRULETYPE_ID as BUSINESSRULETYPE_ID," +
                                                                "    RULETYPE_TEMPLATE.DATABASE_TEMPLATE_ID as DATABASE_TEMPLATE_ID," +
                                                                "    RULETYPE_TEMPLATE.PROCEDURE_CODE as PROCEDURE_CODE," +
                                                                "    RULETYPE_TEMPLATE.CONSTRAINT_CODE as CONSTRAINT_CODE," +
                                                                "    RULETYPE_TEMPLATE.PARAMETER_CODE as PARAMETER_CODE " +
                                                                " from RULETYPE_TEMPLATE RULETYPE_TEMPLATE" +
                                                                " WHERE RULETYPE_TEMPLATE.DATABASE_TEMPLATE_ID = ? ");
            ps.setInt(1, template_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Clob PROCEDURE_CODE = dbResultSet.getClob("PROCEDURE_CODE");
                String svalue = null;
                if (PROCEDURE_CODE != null) {
                    svalue = PROCEDURE_CODE.getSubString(1, (int) PROCEDURE_CODE.length());
                } 
                
                Clob CONSTRAINT_CODE = dbResultSet.getClob("CONSTRAINT_CODE");
                String svalue2 = null;
                if (CONSTRAINT_CODE != null) {
                    svalue = CONSTRAINT_CODE.getSubString(1, (int) CONSTRAINT_CODE.length());
                } 
                
                RuletypeTemplate rtemplate = new RuletypeTemplate(this.getTemplate(dbResultSet.getInt("DATABASE_TEMPLATE_ID")),
                                                                    brs.getBusinessRuleType(dbResultSet.getInt("BUSINESSRULETYPE_ID")),
                                                                    svalue,
                                                                    svalue2,
                                                                    dbResultSet.getString("PARAMETER_CODE"));
                results.add(rtemplate);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    
    public ProcedureTemplate getProcedureTemplate(int template_id) {
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement(" select PROCEDURE_TEMPLATE.TEMPLATE_ID as TEMPLATE_ID," +
                                                                "    PROCEDURE_TEMPLATE.SPECIFICATION as SPECIFICATION," +
                                                                "    PROCEDURE_TEMPLATE.EXCECUTION as EXCECUTION," +
                                                                "    PROCEDURE_TEMPLATE.BODY_START as BODY_START," +
                                                                "    PROCEDURE_TEMPLATE.BODY_DECLARATION as BODY_DECLARATION," +
                                                                "    PROCEDURE_TEMPLATE.BODY_END as BODY_END " +
                                                                " from PROCEDURE_TEMPLATE PROCEDURE_TEMPLATE" +
                                                                " WHERE PROCEDURE_TEMPLATE.TEMPLATE_ID = ?");
            ps.setInt(1, template_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                ProcedureTemplate ptemplate = new ProcedureTemplate(this.getTemplate(dbResultSet.getInt("DATABASE_TEMPLATE_ID")),
                                                                    dbResultSet.getString("SPECIFICATION"),
                                                                    dbResultSet.getString("EXCECUTION"),
                                                                    dbResultSet.getString("BODY_START"),
                                                                    dbResultSet.getString("BODY_DECLARATION"),
                                                                    dbResultSet.getString("BODY_END"));
                return ptemplate;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public PackageTemplate getPackageTemplate(int template_id) {
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement(" select PACKAGE_TEMPLATE.TEMPLATE_ID as TEMPLATE_ID," +
                                                                "    PACKAGE_TEMPLATE.HEADER_START as HEADER_START," +
                                                                "    PACKAGE_TEMPLATE.HEADER_END as HEADER_END," +
                                                                "    PACKAGE_TEMPLATE.BODY_START as BODY_START," +
                                                                "    PACKAGE_TEMPLATE.BODY_END as BODY_END " +
                                                                " from PACKAGE_TEMPLATE PACKAGE_TEMPLATE" +
                                                                " WHERE PACKAGE_TEMPLATE.TEMPLATE_ID = ?");
            ps.setInt(1, template_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                PackageTemplate packtemplate = new PackageTemplate(this.getTemplate(dbResultSet.getInt("DATABASE_TEMPLATE_ID")),
                                                                    dbResultSet.getString("HEADER_START"),
                                                                    dbResultSet.getString("HEADER_END"),
                                                                    dbResultSet.getString("BODY_START"),
                                                                    dbResultSet.getString("BODY_END"));
                return packtemplate;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public TriggerTemplate getTriggerTemplate(int template_id) {
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement(" select TRIGGER_TEMPLATE.TEMPLATE_ID as TEMPLATE_ID," +
                                                                "    TRIGGER_TEMPLATE.INSERT_MOMENT as INSERT_MOMENT," +
                                                                "    TRIGGER_TEMPLATE.UPDATE_MOMENT as UPDATE_MOMENT," +
                                                                "    TRIGGER_TEMPLATE.DELETE_MOMENT as DELETE_MOMENT," +
                                                                "    TRIGGER_TEMPLATE.\"start\" as \"start\"," +
                                                                "    TRIGGER_TEMPLATE.DECLARATION as DECLARATION," +
                                                                "    TRIGGER_TEMPLATE.END as END," +
                                                                "    TRIGGER_TEMPLATE.EXCEPTION_EXCEPT_START as EXCEPTION_EXCEPT_START," +
                                                                "    TRIGGER_TEMPLATE.EXCEPTION_EXCEPT_ERROR as EXCEPTION_EXCEPT_ERROR," +
                                                                "    TRIGGER_TEMPLATE.EXCEPTION_RAISE_ERROR as EXCEPTION_RAISE_ERROR," +
                                                                "    TRIGGER_TEMPLATE.EXCEPTION_EXCEPT_WARNING as EXCEPTION_EXCEPT_WARNING," +
                                                                "    TRIGGER_TEMPLATE.EXCEPTION_RAISE_WARNING as EXCEPTION_RAISE_WARNING," +
                                                                "    TRIGGER_TEMPLATE.ADD_STRING_TO_EXCEPTION_STACK as ADD_STRING_TO_EXCEPTION_STACK," +
                                                                "    TRIGGER_TEMPLATE.EXCEPTION_PARAMETERS as EXCEPTION_PARAMETERS," +
                                                                "    TRIGGER_TEMPLATE.EXCEPTION_TRIGGER_DECLERATION as EXCEPTION_TRIGGER_DECLERATION " +
                                                                " from TRIGGER_TEMPLATE TRIGGER_TEMPLATE" +
                                                                " WHERE TRIGGER_TEMPLATE.TEMPLATE_ID = ?");
            ps.setInt(1, template_id);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                TriggerTemplate trtemplate = new TriggerTemplate(this.getTemplate(dbResultSet.getInt("DATABASE_TEMPLATE_ID")),
                                                                    dbResultSet.getString("INSERT_MOMENT"),
                                                                    dbResultSet.getString("UPDATE_MOMENT"),
                                                                    dbResultSet.getString("DELETE_MOMENT"),
                                                                    dbResultSet.getString("start"), //Does this parse correctly?
                                                                    dbResultSet.getString("DECLARATION"),
                                                                    dbResultSet.getString("END"),
                                                                    dbResultSet.getString("EXCEPTION_EXCEPT_START"),
                                                                    dbResultSet.getString("EXCEPTION_EXCEPT_ERROR"),
                                                                    dbResultSet.getString("EXCEPTION_RAISE_ERROR"),
                                                                    dbResultSet.getString("EXCEPTION_EXCEPT_WARNING"),
                                                                    dbResultSet.getString("EXCEPTION_RAISE_WARNING"),
                                                                    dbResultSet.getString("ADD_STRING_TO_EXCEPTION_STACK"),
                                                                    dbResultSet.getString("EXCEPTION_PARAMETERS"),
                                                                    dbResultSet.getString("EXCEPTION_TRIGGER_DECLERATION"));
                return trtemplate;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
}
