/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.project;

import dto.businessrules.Businessrule;

/**
 *
 * @author Matthias
 */
public class LinkedBusinessrules {
    private int id;
    private Project project;
    private Businessrule businessrule;

    public LinkedBusinessrules(int id, Project project, Businessrule businessrule) {
        this.id = id;
        this.project = project;
        this.businessrule = businessrule;
    }

    public LinkedBusinessrules() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Businessrule getBusinessrule() {
        return businessrule;
    }

    public void setBusinessrule(Businessrule businessrule) {
        this.businessrule = businessrule;
    }
    
    
}
