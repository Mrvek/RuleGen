/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.businessrules;

/**
 *
 * @author Matthias
 */
public class Businessrule {
    private int id;
    private String name;
    private String description;
    private BusinessruleType businessruletype;
    private KoppelOperator koppeloperator;
    private PosibleTriggerEvents posibleTriggerEvents;
    private Failurehandling failurehandling;

    public Businessrule(int id, String name, String description, BusinessruleType businessruletype, KoppelOperator koppeloperator, PosibleTriggerEvents posibleTriggerEvents, Failurehandling failurehandling) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.businessruletype = businessruletype;
        this.koppeloperator = koppeloperator;
        this.posibleTriggerEvents = posibleTriggerEvents;
        this.failurehandling = failurehandling;
    }

    public Businessrule() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BusinessruleType getBusinessruletype() {
        return businessruletype;
    }

    public void setBusinessruletype(BusinessruleType businessruletype) {
        this.businessruletype = businessruletype;
    }

    public KoppelOperator getKoppeloperator() {
        return koppeloperator;
    }

    public void setKoppeloperator(KoppelOperator koppeloperator) {
        this.koppeloperator = koppeloperator;
    }

    public PosibleTriggerEvents getPosibleTriggerEvents() {
        return posibleTriggerEvents;
    }

    public void setPosibleTriggerEvents(PosibleTriggerEvents posibleTriggerEvents) {
        this.posibleTriggerEvents = posibleTriggerEvents;
    }

    public Failurehandling getFailurehandling() {
        return failurehandling;
    }

    public void setFailurehandling(Failurehandling failurehandling) {
        this.failurehandling = failurehandling;
    }

}
