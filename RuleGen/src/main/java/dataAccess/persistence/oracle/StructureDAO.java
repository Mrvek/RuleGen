/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle;

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
    
    public ArrayList<String> getTables() {
        ArrayList<String> result = new ArrayList<>();
        
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT table_name as table_name FROM all_tables where owner = ?");
            ps.setString(1, super.getDB_USER().toUpperCase());
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                result.add(dbResultSet.getString("table_name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Map<String, String> getColumns(String tablename) {
        Map<String, String> results = new HashMap<>();
        try (Connection con = super.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT column_name, data_type from user_tab_columns where table_name = ?");
            ps.setString(1, tablename);
            ResultSet dbResultSet = ps.executeQuery();
            
            while (dbResultSet.next()) {
                results.put(dbResultSet.getString("column_name"), dbResultSet.getString("data_type"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StructureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
