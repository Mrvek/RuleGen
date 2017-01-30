package dataAccess.persistence.oracle.toolsdb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import dto.project.DatabaseSchema;
import dto.supported_units.SupportedDatabases;

/**
 * Created by Mitchell on 23/01/2017.
 */
public class DBConfig {
    
	//TODO MitchellCheck
	//TODO Maak een lijst en dan itereer later
    private static String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "dataAccess" + File.separator + "persistence" + File.separator + "oracle" + File.separator + "toolsdb" + File.separator + "ToolDBConfig.properties";
   
    private static Properties DBConfigReader() {
    	Properties prop = new Properties();
		try {
			Reader reader = new FileReader(path);
			reader = new FileReader(path);
	        prop.load(reader);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
        return prop;
    }    
    //Both load the properties file into a databaseschema and supporteddatabases object respectively  
    
    public static DatabaseSchema DBConfigToSchema() {
    	DatabaseSchema dbs = null;
    	Properties prop = DBConfigReader();
    	//TODO REMOVE THESE SYSOUT FOR OBVIOUS REASONS
    	System.out.println("reading configuration for tools database...");
    	System.out.println("\tdatabase: " + prop.getProperty("database"));
    	System.out.println("\tdbuser: " + prop.getProperty("dbuser"));
    	System.out.println("\tdbpassword: " + prop.getProperty("dbpassword") + "\n");
    	dbs= new DatabaseSchema(0, prop.getProperty("database"), prop.getProperty("characterset"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"), prop.getProperty("dbport"), prop.getProperty("dbservicename"), prop.getProperty("dbhost"));
    	return dbs;
    }
    public static SupportedDatabases DBConfigToSupportedDatabases() {    	
    	SupportedDatabases sdb = null;
    	Properties prop = DBConfigReader();
    	//TODO REMOVE THESE SYSOUT FOR OBVIOUS REASONS
    	System.out.println("reading configuration for tools database...");
    	System.out.println("\tdatabase: " + prop.getProperty("database"));
    	System.out.println("\tabbreviation: " + prop.getProperty("abbreviation"));
    	System.out.println("\tdbdriver: " + prop.getProperty("dbdriver") + "\n");
    	System.out.println("\tdbconprefix: " + prop.getProperty("dbconprefix") + "\n");
    	sdb= new SupportedDatabases(0, prop.getProperty("database"), prop.getProperty("abbreviation"), prop.getProperty("dbdriver"), prop.getProperty("dbconprefix"));
    	return sdb;
    }

}
