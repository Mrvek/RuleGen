package dataAccess.toolsDB;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by Mitchell on 23/01/2017.
 */
public class DBConfig {
    public String database;
    public String dbuser;
    public String dbpassword;
    private String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "dataAccess" + File.separator + "toolsDB" + File.separator + "ToolDBConfig.properties";

    public DBConfig() {
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            Reader reader = new FileReader(path);
            prop.load(reader);

            //get the property value and print it out
            System.out.println("reading configuration for tools database:");
            System.out.println("database: " + prop.getProperty("database"));
            System.out.println("dbuser: " + prop.getProperty("dbuser"));
            System.out.println("dbpassword: " + prop.getProperty("dbpassword"));

            this.database = prop.getProperty("database");
            this.dbuser = prop.getProperty("dbuser");
            this.dbpassword = prop.getProperty("dbpassword");

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
