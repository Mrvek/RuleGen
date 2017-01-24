/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainGeneric.supported_units;

/**
 *
 * @author Matthias
 */
public class SupportedDatabases {
    private int id;
    private String databasetype;

    public SupportedDatabases(int id, String databasetype) {
        this.id = id;
        this.databasetype = databasetype;
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
   
}
