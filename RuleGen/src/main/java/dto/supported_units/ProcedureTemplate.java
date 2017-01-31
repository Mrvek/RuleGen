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
public class ProcedureTemplate {
    private Template template;
    private String specification;
    private String excecution;
    private String bodyStart;
    private String bodyDecleration;
    private String bodyEnd;

    public ProcedureTemplate(Template template, String specification, String excecution, String bodyStart, String bodyDecleration, String bodyEnd) {
        this.template = template;
        this.specification = specification;
        this.excecution = excecution;
        this.bodyStart = bodyStart;
        this.bodyDecleration = bodyDecleration;
        this.bodyEnd = bodyEnd;
    }

    public ProcedureTemplate() {
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getExcecution() {
        return excecution;
    }

    public void setExcecution(String excecution) {
        this.excecution = excecution;
    }

    public String getBodyStart() {
        return bodyStart;
    }

    public void setBodyStart(String bodyStart) {
        this.bodyStart = bodyStart;
    }

    public String getBodyDecleration() {
        return bodyDecleration;
    }

    public void setBodyDecleration(String bodyDecleration) {
        this.bodyDecleration = bodyDecleration;
    }

    public String getBodyEnd() {
        return bodyEnd;
    }

    public void setBodyEnd(String bodyEnd) {
        this.bodyEnd = bodyEnd;
    }
    
}
