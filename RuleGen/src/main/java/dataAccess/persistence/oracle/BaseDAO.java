/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Matthias
 */
public class BaseDAO {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String DB_CONNECTION;
    private static String DB_USER;
    private static String DB_PASSWORD;
    
    public BaseDAO(String hostname, String port, String serviceName, String username, String password) {
        // Established with the Thin-style Service Name Syntax
        // jdbc:oracle:thin: + @//host_name:port_number/service_name
        DB_CONNECTION = "jdbc:oracle:thin:@//" + hostname + ":" + port + "/" + serviceName;
        DB_USER = username;
        DB_PASSWORD = password;
         
    }
    
    protected static Connection getConnection() {

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

    public static String getDB_USER() {
        return DB_USER;
    }
    
}
