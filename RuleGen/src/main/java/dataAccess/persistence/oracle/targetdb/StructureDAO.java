/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.targetdb;

import dto.project.Attribute;
import dto.project.DatabaseSchema;
import dto.project.Table;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import dataAccess.persistence.oracle.BaseDAO;
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
public class StructureDAO extends BaseDAO {
         
    public StructureDAO() {
        super();
    }
    
    public ArrayList<Table> getTables() {
        ArrayList<Table> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT table_name as table_name FROM all_tables where owner = ?");
            ps.setString(1, super.getDB_USER().toUpperCase());
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Table table = new Table();
                table.setName(dbResultSet.getString("table_name"));
                result.add(table);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<Attribute> getAttribute(Table table, SupportedDatabases database) {
        ArrayList<Attribute> results = new ArrayList<>();
        
        
        
        try (Connection con = super.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT column_name, data_type from user_tab_columns where table_name = ?");
            ps.setString(1, table.getName().toUpperCase());
            ResultSet dbResultSet = ps.executeQuery();

            while (dbResultSet.next()) {
                Attribute attribute = new Attribute();
                attribute.setName(dbResultSet.getString("column_name"));
                attribute.setTable(table);
                
                String datatypestring = dbResultSet.getString("data_type");
 
                SupportedDatatypes real_sdt = new SupportedDatatypes(datatypestring);

                attribute.setSupporteddatatype(real_sdt);
                results.add(attribute);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}   
