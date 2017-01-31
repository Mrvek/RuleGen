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
public class Template {
    private int id;
    private String name;
    private SupportedDatabases supportedDatabases;
    private String constraint_code;

    public Template(int id, String name, SupportedDatabases supportedDatabases, String constraint_code) {
        this.id = id;
        this.name = name;
        this.supportedDatabases = supportedDatabases;
        this.constraint_code = constraint_code;
    }

    public Template() {
    }

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

    public SupportedDatabases getSupportedDatabases() {
        return supportedDatabases;
    }

    public void setSupportedDatabases(SupportedDatabases supportedDatabases) {
        this.supportedDatabases = supportedDatabases;
    }

    public String getConstraint_code() {
        return constraint_code;
    }

    public void setConstraint_code(String constraint_code) {
        this.constraint_code = constraint_code;
    }
    
}
