/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.businessrules;

import dto.supported_units.SupportedOperators;

/**
 *
 * @author Matthias
 */
public class KoppelOperator {
    private int id;
    private SupportedOperators supportedoperator;
    private BusinessruleType businessruletype;

    public KoppelOperator(int id, SupportedOperators supportedoperator, BusinessruleType businessruletype) {
        this.id = id;
        this.supportedoperator = supportedoperator;
        this.businessruletype = businessruletype;
    }

    public KoppelOperator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SupportedOperators getSupportedoperator() {
        return supportedoperator;
    }

    public void setSupportedoperator(SupportedOperators supportedoperator) {
        this.supportedoperator = supportedoperator;
    }

    public BusinessruleType getBusinessruletype() {
        return businessruletype;
    }

    public void setBusinessruletype(BusinessruleType businessruletype) {
        this.businessruletype = businessruletype;
    }
    
    
}
