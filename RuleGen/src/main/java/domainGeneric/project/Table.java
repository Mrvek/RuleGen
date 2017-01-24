/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainGeneric.project;

/**
 *
 * @author Matthias
 */
public class Table {
    private int id;
    private String name;
    private DatabaseSchema databaseSchema;

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
    
}
