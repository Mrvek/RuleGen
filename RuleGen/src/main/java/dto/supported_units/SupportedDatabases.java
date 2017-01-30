/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.supported_units;

/**
 *
 * @author Matthias
 */
public class SupportedDatabases {
    private int id;
    private String databasetype;
    private String abbreviation;
    private String dbdriver;
    private String dbcon_prefix;

    public SupportedDatabases(int id, String databasetype, String abbreviation,String dbdriver,String dbcon_prefix) {
        this.id = id;
        this.databasetype = databasetype;
        this.abbreviation = abbreviation;
        this.dbdriver = dbdriver;
        this.dbcon_prefix = dbcon_prefix;
    }

    public int getId() {
        return id;
    }

    public String getDatabasetype() {
        return databasetype;
    }

    public void setDatabasetype(String databasetype) {
        this.databasetype = databasetype;
    }
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public String getDbDriver() {
        return dbdriver;
    }

    public void setDbDriver(String dbdriver) {
        this.dbdriver = dbdriver;
    }
    
    public String getDbConnectionPrefix() {
        return dbcon_prefix;
    }

    public void setDbConnectionPrefix(String dbcon_prefix) {
        this.dbcon_prefix = dbcon_prefix;
    }
   
}
