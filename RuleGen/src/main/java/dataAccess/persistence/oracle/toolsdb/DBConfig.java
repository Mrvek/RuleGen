package dataAccess.persistence.oracle.toolsdb;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import dto.project.DatabaseSchema;

/**
 * Created by Mitchell on 23/01/2017.
 */
public class DBConfig {
    
	//TODO MitchellCheck
	//TODO Maak een lijst en dan itereer later
    private static String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "dataAccess" + File.separator + "persistence" + File.separator + "oracle" + File.separator + "toolsdb" + File.separator + "ToolDBConfig.properties";
    //TODO needs better name probably lol
    public static DatabaseSchema DBConfigToSchema() {
    	DatabaseSchema dbs = null; 
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            Reader reader = new FileReader(path);
            prop.load(reader);

            //get the property value and print it out
            //TODO CHANGE OF ORDER INSIDE PROPERTIES FILE TO MATCH DATABASESCHEMA?
            System.out.println("reading configuration for tools database...");
            System.out.println("\tdatabase: " + prop.getProperty("database"));
            System.out.println("\tdbuser: " + prop.getProperty("dbuser"));
            System.out.println("\tdbpassword: " + prop.getProperty("dbpassword") + "\n");                                 
            //TODO CHARACTERSET CHANGE
            dbs= new DatabaseSchema(0, prop.getProperty("database"), "UTF-8", prop.getProperty("dbuser"), prop.getProperty("dbpassword"), prop.getProperty("dbport"), prop.getProperty("dbservicename"), prop.getProperty("dbhost"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
		return dbs;
    }

}
