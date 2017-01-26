/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.businessrules;

import dto.project.Attribute;

/**
 *
 * @author Matthias
 */
public class BusinessValues {
    private int id;
    private String type;
    private int position;
    private String value;
    private Businessrule businessrule;
    private Attribute attribute;

    public BusinessValues(int id, String type, int position, String value, Businessrule businessrule, Attribute attribute) {
        this.id = id;
        this.type = type;
        this.position = position;
        this.value = value;
        this.businessrule = businessrule;
        this.attribute = attribute;
    }

    public BusinessValues() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Businessrule getBusinessrule() {
        return businessrule;
    }

    public void setBusinessrule(Businessrule businessrule) {
        this.businessrule = businessrule;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    } 
    
}
