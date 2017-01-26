/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsdb;

import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.businessrules.BusinessruleType;
import dto.businessrules.Category;
import dto.businessrules.GeneratedTrigger;
import dto.businessrules.KoppelOperator;
import dto.project.Attribute;
import dto.project.DatabaseSchema;
import dto.project.Table;
import dto.supported_units.SupportedOperators;
import dataAccess.persistence.oracle.BaseDAO;
import dataAccess.persistence.oracle.targetdb.StructureDAO;

import java.sql.Clob;
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
public class BusinessRuleDAO extends BaseDAO { 
    
    public BusinessRuleDAO() { 
        super();
    }
    
    public Category getCategory(int cat_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select CATEGORY.CATEGORY_ID as CATEGORY_ID," +
                                                        "    CATEGORY.TYPE as TYPE " +
                                                        " from CATEGORY CATEGORY" +
                                                        " WHERE CATEGORY.CATEGORY_ID = ?");
            ps.setInt(1, cat_id);
            
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {

                Category cat = new Category(dbResultSet.getInt("CATEGORY_ID") , dbResultSet.getString("TYPE"));
                
                return cat;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public BusinessruleType getBusinessRuleType(int bsrt_id) {        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select BUSINESSRULETYPE.BUSINESSRULETYPE_ID as BUSINESSRULETYPE_ID," +
                                                        "    BUSINESSRULETYPE.CATEGORY_ID as CATEGORY_ID," +
                                                        "    BUSINESSRULETYPE.TYPE as TYPE " +
                                                        " from BUSINESSRULETYPE BUSINESSRULETYPE" +
                                                        " WHERE BUSINESSRULETYPE.BUSINESSRULETYPE_ID = ?");
            ps.setInt(1, bsrt_id);
            
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Category cat = this.getCategory(dbResultSet.getInt("CATEGORY_ID"));
                BusinessruleType bsrt = new BusinessruleType(dbResultSet.getInt("BUSINESSRULETYPE_ID"), cat, dbResultSet.getString("TYPE"));
                return bsrt;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public KoppelOperator getKoppelOperator(int koppel_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select KOPPELOPERATOR.KOPPELOPERATOR_ID as KOPPELOPERATOR_ID," +
                                                        "    KOPPELOPERATOR.BUSINESSRULETYPE_ID as BUSINESSRULETYPE_ID," +
                                                        "    KOPPELOPERATOR.SUPPORTEDOPERATORS_ID as SUPPORTEDOPERATORS_ID " +
                                                        " from KOPPELOPERATOR KOPPELOPERATOR" +
                                                        " WHERE KOPPELOPERATOR.KOPPELOPERATOR_ID = ?");
            ps.setInt(1, koppel_id);
            
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                SupportedUnitsDAO sdao = new SupportedUnitsDAO();
                SupportedOperators supportedOperator = sdao.getSupportedOperator(dbResultSet.getInt("SUPPORTEDOPERATORS_ID"));
                BusinessruleType bsrt = this.getBusinessRuleType(dbResultSet.getInt("BUSINESSRULETYPE_ID"));
                
                KoppelOperator koppeloperator = new KoppelOperator(dbResultSet.getInt("KOPPELOPERATOR_ID"), supportedOperator, bsrt);
                
                return koppeloperator;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public Businessrule getBusinessrule(int businessrule_id) {
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select BUSINESSRULE.BUSINESSRULE_ID as BUSINESSRULE_ID," +
                                                        "    BUSINESSRULE.NAME as NAME," +
                                                        "    BUSINESSRULE.DESCRIPTION as DESCRIPTION," +
                                                        "    BUSINESSRULE.BUSINESSRULETYPE_ID as BUSINESSRULETYPE_ID," +
                                                        "    BUSINESSRULE.KOPPEOPERATOR_ID as KOPPEOPERATOR_ID " +
                                                        " from BUSINESSRULE BUSINESSRULE" +
                                                        " WHERE BUSINESSRULE.BUSINESSRULE_ID = ?");
            ps.setInt(1, businessrule_id);
            
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Businessrule bsr = new Businessrule(dbResultSet.getInt("BUSINESSRULE_ID"), 
                                                    dbResultSet.getString("NAME"), 
                                                    "not implemented", 
                                                    this.getBusinessRuleType(dbResultSet.getInt("BUSINESSRULE_ID")), 
                                                    this.getKoppelOperator(dbResultSet.getInt("KOPPEOPERATOR_ID")));
                return bsr;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public ArrayList<BusinessValues> getAllBusinessValues(Businessrule businessrule) {
        ArrayList<BusinessValues> results = new ArrayList<>();
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select BUSINESSVALUES.BUSINESSVALUES_ID as BUSINESSVALUES_ID," +
                                                        "    BUSINESSVALUES.BUSINESSRULE_ID as BUSINESSRULE_ID," +
                                                        "    BUSINESSVALUES.ATTRIBUTE_ID as ATTRIBUTE_ID," +
                                                        "    BUSINESSVALUES.TYPE as TYPE," +
                                                        "    BUSINESSVALUES.POSITION as POSITION," +
                                                        "    BUSINESSVALUES.BVALUES as BVALUES " +
                                                        " from BUSINESSVALUES BUSINESSVALUES" +
                                                        " WHERE BUSINESSVALUES.BUSINESSRULE_ID = ?");
            ps.setInt(1, businessrule.getId());
            
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                ProjectDAO pjd = new ProjectDAO();
                
                Clob value = dbResultSet.getClob("BVALUES");
                String svalue = null;
                if (value != null) {
                    svalue = value.getSubString(1, (int) value.length());
                } 

                BusinessValues bsv = new BusinessValues(dbResultSet.getInt("BUSINESSVALUES_ID"), 
                                                        dbResultSet.getString("TYPE"), 
                                                        dbResultSet.getInt("POSITION"), 
                                                        svalue, 
                                                        this.getBusinessrule(dbResultSet.getInt("BUSINESSRULE_ID")), 
                                                        pjd.getAttribute(dbResultSet.getInt("ATTRIBUTE_ID")));
                
                results.add(bsv);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
        
    }
    
    public boolean insertTrigger (GeneratedTrigger generatedtrigger) {
        try (Connection con = super.getConnection()) {
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO GENERATEDTRIGGER (DATETIME, BUSINESSRULE_ID, "
                                                        + "SUPPORTEDDATABASES_ID, CODE, EVENT) VALUES (SYSDATE, ?, ?, ?, ?)");
            ps.setInt(1, generatedtrigger.getBusinessrule().getId());
            ps.setInt(2, generatedtrigger.getSupporteddatabase().getId());
            ps.setString(3, generatedtrigger.getCode());
            ps.setString(4, generatedtrigger.getEvent());

            return ps.executeUpdate() == 1;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
