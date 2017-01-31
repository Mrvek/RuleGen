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
public class PackageTemplate {
    private Template template;
    private String headerStart;
    private String headerEnd;
    private String bodyStart;
    private String bodyEnd;
    
    public PackageTemplate(Template template, String headerStart, String headerEnd, String bodyStart, String bodyEnd) {
        this.template = template;
        this.headerStart = headerStart;
        this.headerEnd = headerEnd;
        this.bodyStart = bodyStart;
        this.bodyEnd = bodyEnd;
    }

    public PackageTemplate() {
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getHeaderStart() {
        return headerStart;
    }

    public void setHeaderStart(String headerStart) {
        this.headerStart = headerStart;
    }

    public String getHeaderEnd() {
        return headerEnd;
    }

    public void setHeaderEnd(String headerEnd) {
        this.headerEnd = headerEnd;
    }

    public String getBodyStart() {
        return bodyStart;
    }

    public void setBodyStart(String bodyStart) {
        this.bodyStart = bodyStart;
    }

    public String getBodyEnd() {
        return bodyEnd;
    }

    public void setBodyEnd(String bodyEnd) {
        this.bodyEnd = bodyEnd;
    }
    
}
