/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.targetdb;

import dataAccess.persistence.oracle.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import dataAccess.persistence.oracle.toolsdb.DBConfig;
import dto.project.DatabaseSchema;

/**
 *
 * @author Matthias
 */
public class StructurebaseDAO {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static DatabaseSchema dbc = new DatabaseSchema(5000, "Oracle 12c", 
                "Oracle 12c", "tosad_2016_2a_team3_target", "tosad_2016_2a_team3_target", 
                "8521", "cursus02.hu.nl", "ondora02.hu.nl");	
    private String DB_CONNECTION;
    private String DB_USER;
    private String DB_PASSWORD;
    
    public StructurebaseDAO() {
        // Established with the Thin-style Service Name Syntax
        // jdbc:oracle:thin: + @//host_name:port_number/service_name
        DB_CONNECTION = "jdbc:oracle:thin:@//" + dbc.getDbhost() + ":" + dbc.getDbport() + "/" + dbc.getDbservicename();
        DB_USER = dbc.getDbuser();
        DB_PASSWORD = dbc.getDbpassword();
        
    }
    
    protected Connection getConnection() {

        Connection dbConnection = null;

        try {

                Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

                System.out.println(e.getMessage());

        }

        try {
            
                dbConnection = DriverManager.getConnection(
                                DB_CONNECTION, DB_USER,DB_PASSWORD);
                return dbConnection;

        } catch (SQLException e) {

                System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    public String getDB_USER() {
        return DB_USER;
    }
    
}