/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle;

import dataAccess.persistence.oracle.toolsDB.SupportedUnitsDAO;
import domainGeneric.project.Attribute;
import domainGeneric.project.Table;
import domainGeneric.supported_units.SupportedDatabases;
import domainGeneric.supported_units.SupportedDatatypes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthias
 */
public class StructureDAO extends BaseDAO {
         
    public StructureDAO(String hostname, String port, String serviceName, String username, String password) {
        super(hostname, port, serviceName, username, password);
    }
    
    public ArrayList<Table> getTables() {
        ArrayList<Table> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT table_name as table_name FROM all_tables where owner = ?");
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
        SupportedUnitsDAO sdao = new SupportedUnitsDAO();
        ArrayList<Attribute> results = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT column_name, data_type from user_tab_columns where table_name = ?");
            ps.setString(1, table.getName());
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                Attribute attribute = new Attribute();
                attribute.setName(dbResultSet.getString("column_name"));
                attribute.setTable(table);
                
                String datatypestring = dbResultSet.getString("data_type");
                
                ArrayList<SupportedDatatypes> sdt = sdao.getSupportedDataTypesByDB(database.getId());
                
                SupportedDatatypes real_sdt = null;
                
                for (SupportedDatatypes x : sdt) {
                    if (x.getDatatype().equals(datatypestring)) {
                        real_sdt = x;
                        break;
                    }
                }
                
                attribute.setSupporteddatatype(real_sdt);
                results.add(attribute);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
