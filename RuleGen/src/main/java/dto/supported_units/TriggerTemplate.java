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
public class TriggerTemplate {
    private Template template;
    private String insertMoment;
    private String updateMoment;
    private String deleteMoment;
    private String start;
    private String decleration;
    private String end;
    private String exceptionExceptStart;
    private String exceptionExceptError;
    private String exceptionRaiseError;
    private String exceptionExceptWarning;
    private String exceptionRaiseWarning;
    private String addStringToExceptionStack;
    private String exceptionParameters;
    private String exceptionTriggerDeclaration;

    public TriggerTemplate(Template template, String insertMoment, String updateMoment, String deleteMoment, String start, String decleration, String end, String exceptionExceptStart, String exceptionExceptError, String exceptionRaiseError, String exceptionExceptWarning, String exceptionRaiseWarning, String addStringToExceptionStack, String exceptionParameters, String exceptionTriggerDeclaration) {
        this.template = template;
        this.insertMoment = insertMoment;
        this.updateMoment = updateMoment;
        this.deleteMoment = deleteMoment;
        this.start = start;
        this.decleration = decleration;
        this.end = end;
        this.exceptionExceptStart = exceptionExceptStart;
        this.exceptionExceptError = exceptionExceptError;
        this.exceptionRaiseError = exceptionRaiseError;
        this.exceptionExceptWarning = exceptionExceptWarning;
        this.exceptionRaiseWarning = exceptionRaiseWarning;
        this.addStringToExceptionStack = addStringToExceptionStack;
        this.exceptionParameters = exceptionParameters;
        this.exceptionTriggerDeclaration = exceptionTriggerDeclaration;
    }

    public TriggerTemplate() {
    }
    
    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getInsertMoment() {
        return insertMoment;
    }

    public void setInsertMoment(String insertMoment) {
        this.insertMoment = insertMoment;
    }

    public String getUpdateMoment() {
        return updateMoment;
    }

    public void setUpdateMoment(String updateMoment) {
        this.updateMoment = updateMoment;
    }

    public String getDeleteMoment() {
        return deleteMoment;
    }

    public void setDeleteMoment(String deleteMoment) {
        this.deleteMoment = deleteMoment;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDecleration() {
        return decleration;
    }

    public void setDecleration(String decleration) {
        this.decleration = decleration;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getExceptionExceptStart() {
        return exceptionExceptStart;
    }

    public void setExceptionExceptStart(String exceptionExceptStart) {
        this.exceptionExceptStart = exceptionExceptStart;
    }

    public String getExceptionExceptError() {
        return exceptionExceptError;
    }

    public void setExceptionExceptError(String exceptionExceptError) {
        this.exceptionExceptError = exceptionExceptError;
    }

    public String getExceptionRaiseError() {
        return exceptionRaiseError;
    }

    public void setExceptionRaiseError(String exceptionRaiseError) {
        this.exceptionRaiseError = exceptionRaiseError;
    }

    public String getExceptionExceptWarning() {
        return exceptionExceptWarning;
    }

    public void setExceptionExceptWarning(String exceptionExceptWarning) {
        this.exceptionExceptWarning = exceptionExceptWarning;
    }

    public String getExceptionRaiseWarning() {
        return exceptionRaiseWarning;
    }

    public void setExceptionRaiseWarning(String exceptionRaiseWarning) {
        this.exceptionRaiseWarning = exceptionRaiseWarning;
    }

    public String getAddStringToExceptionStack() {
        return addStringToExceptionStack;
    }

    public void setAddStringToExceptionStack(String addStringToExceptionStack) {
        this.addStringToExceptionStack = addStringToExceptionStack;
    }

    public String getExceptionParameters() {
        return exceptionParameters;
    }

    public void setExceptionParameters(String exceptionParameters) {
        this.exceptionParameters = exceptionParameters;
    }

    public String getExceptionTriggerDeclaration() {
        return exceptionTriggerDeclaration;
    }

    public void setExceptionTriggerDeclaration(String exceptionTriggerDeclaration) {
        this.exceptionTriggerDeclaration = exceptionTriggerDeclaration;
    }
    
}
