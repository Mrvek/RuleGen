/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.dto.supported_units;

/**
 *
 * @author Matthias
 */
public class SupportedDatatypes {
    private int id;
    private String datatype;
    private SupportedDatabases database;

    public SupportedDatatypes(int id, String datatype, SupportedDatabases database) {
        this.id = id;
        this.datatype = datatype;
        this.database = database;
    }

    public SupportedDatatypes(String datatype) {
        this.datatype = datatype;
    }

    public int getId() {
        return id;
    }
    
    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public SupportedDatabases getDatabase() {
        return database;
    }

    public void setDatabase(SupportedDatabases database) {
        this.database = database;
    }
    
    
}
