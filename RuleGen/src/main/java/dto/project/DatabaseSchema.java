/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.project;

/**
 *
 * @author Matthias
 */
public class DatabaseSchema {
    private int id;
    private String name;
    private String characterset;
    private String dbuser;
    private String dbpassword;
    private String dpport;
    private String dbservicename;
    private String dbhost;

    public DatabaseSchema(int id, String name, String characterset, String dbuser, String dbpassword, String dpport, String dbservicename, String dbhost) {
        this.id = id;
        this.name = name;
        this.characterset = characterset;
        this.dbuser = dbuser;
        this.dbpassword = dbpassword;
        this.dpport = dpport;
        this.dbservicename = dbservicename;
        this.dbhost = dbhost;
    }

//    public DatabaseSchema() {
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterset() {
        return characterset;
    }

    public void setCharacterset(String characterset) {
        this.characterset = characterset;
    }

    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public String getDbport() {
        return dpport;
    }

    public void setDpport(String dpport) {
        this.dpport = dpport;
    }

    public String getDbservicename() {
        return dbservicename;
    }

    public void setDbservicename(String dbservicename) {
        this.dbservicename = dbservicename;
    }

    public String getDbhost() {
        return dbhost;
    }

    public void setDbhost(String dbhost) {
        this.dbhost = dbhost;
    }

    
}
