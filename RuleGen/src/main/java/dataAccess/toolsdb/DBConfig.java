package dataAccess.toolsdb;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by Mitchell on 23/01/2017.
 */
public class DBConfig {
    private String database;
    private String dbuser;
    private String dbpassword;
    private String dbport;
    private String dbservicename;
    private String dbhost;
    
    private String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "dataAccess" + File.separator + "toolsDB" + File.separator + "ToolDBConfig.properties";

    public DBConfig() {
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            Reader reader = new FileReader(path);
            prop.load(reader);

            //get the property value and print it out
            System.out.println("reading configuration for tools database...");
            System.out.println("\tdatabase: " + prop.getProperty("database"));
            System.out.println("\tdbuser: " + prop.getProperty("dbuser"));

            this.database = prop.getProperty("database");
            this.dbuser = prop.getProperty("dbuser");
            this.dbpassword = prop.getProperty("dbpassword");
            this.dbport = prop.getProperty("dbport");
            this.dbservicename = prop.getProperty("dbservicename");
            this.dbhost = prop.getProperty("dbhost");

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDatabase() {
        return database;
    }

    public String getDbuser() {
        return dbuser;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public String getDbport() {
        return dbport;
    }

    public String getDbservicename() {
        return dbservicename;
    }

    public String getDbhost() {
        return dbhost;
    }
}
