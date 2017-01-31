/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.supported_units;

import dto.businessrules.BusinessruleType;

/**
 *
 * @author Matthias
 */
public class RuletypeTemplate {
    private Template template;
    private BusinessruleType businessruleType;
    private String procedureCode;
    private String constraintCode;
    private String parameterCode;

    public RuletypeTemplate(Template template, BusinessruleType businessruleType, String procedureCode, String constraintCode, String parameterCode) {
        this.template = template;
        this.businessruleType = businessruleType;
        this.procedureCode = procedureCode;
        this.constraintCode = constraintCode;
        this.parameterCode = parameterCode;
    }

    public RuletypeTemplate() {
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public BusinessruleType getBusinessruleType() {
        return businessruleType;
    }

    public void setBusinessruleType(BusinessruleType businessruleType) {
        this.businessruleType = businessruleType;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getConstraintCode() {
        return constraintCode;
    }

    public void setConstraintCode(String constraintCode) {
        this.constraintCode = constraintCode;
    }

    public String getParameterCode() {
        return parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }
    
}
