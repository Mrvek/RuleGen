/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainGeneric.project;

import domainGeneric.supported_units.SupportedDatatypes;

/**
 *
 * @author Matthias
 */
public class Attribute {
    private int id;
    private String name;
    private Table table;
    private SupportedDatatypes supporteddatatype;

    public Attribute(int id, String name, Table table, SupportedDatatypes supporteddatatype) {
        this.id = id;
        this.name = name;
        this.table = table;
        this.supporteddatatype = supporteddatatype;
    }

    public Attribute() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public SupportedDatatypes getSupporteddatatype() {
        return supporteddatatype;
    }

    public void setSupporteddatatype(SupportedDatatypes supporteddatatype) {
        this.supporteddatatype = supporteddatatype;
    }
}
