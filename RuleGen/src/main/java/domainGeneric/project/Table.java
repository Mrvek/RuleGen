/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainGeneric.project;

import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class Table {
    private int id;
    private String name;
    private DatabaseSchema databaseSchema;
    private ArrayList<Attribute> attributes = new ArrayList<>();

    public Table(int id, String name, DatabaseSchema databaseSchema) {
        this.id = id;
        this.name = name;
        this.databaseSchema = databaseSchema;
    }

    public Table() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DatabaseSchema getDatabaseSchema() {
        return databaseSchema;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDatabaseSchema(DatabaseSchema databaseSchema) {
        this.databaseSchema = databaseSchema;
    }
    
    public void addAttribute(Attribute atr) {
        if (!attributes.contains(atr)) {
            attributes.add(atr); 
        }
        atr.setTable(this);
    }
    
    public void removeAttribute(Attribute atr) {
        attributes.remove(atr);
        atr.setTable(null);
    }
    
    public ArrayList<Attribute> getAllAttributes() {
        return attributes;
    }
    
}
