/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.project;

import dto.supported_units.SupportedDatabases;

/**
 *
 * @author Matthias
 */
public class Project {
    private int id;
    private String projectname;
    private String abbreviation;
    private String username;
    private SupportedDatabases supporteddatabase;
    private DatabaseSchema databaseschema;

    public Project(int id, String projectname, String abbreviation, String username, SupportedDatabases supporteddatabase, DatabaseSchema databaseschema) {
        this.id = id;
        this.projectname = projectname;
        this.abbreviation = abbreviation;
        this.username = username;
        this.supporteddatabase = supporteddatabase;
        this.databaseschema = databaseschema;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SupportedDatabases getSupporteddatabase() {
        return supporteddatabase;
    }

    public void setSupporteddatabase(SupportedDatabases supporteddatabase) {
        this.supporteddatabase = supporteddatabase;
    }

    public DatabaseSchema getDatabaseschema() {
        return databaseschema;
    }

    public void setDatabaseschema(DatabaseSchema databaseschema) {
        this.databaseschema = databaseschema;
    }
}
