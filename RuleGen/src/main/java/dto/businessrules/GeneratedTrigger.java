/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.businessrules;

import dto.supported_units.SupportedDatabases;
import java.time.LocalDateTime;

/**
 *
 * @author Matthias
 */
public class GeneratedTrigger {
    private LocalDateTime datetime;
    private String code;
    private String event;
    private Businessrule businessrule;
    private SupportedDatabases supporteddatabase;

    public GeneratedTrigger(LocalDateTime datetime, String code, String event, Businessrule businessrule, SupportedDatabases supporteddatabase) {
        this.datetime = datetime;
        this.code = code;
        this.event = event;
        this.businessrule = businessrule;
        this.supporteddatabase = supporteddatabase;
    }
    
    public GeneratedTrigger(String code, String event, Businessrule businessrule, SupportedDatabases supporteddatabase) {
        this.datetime = LocalDateTime.now();
        this.code = code;
        this.event = event;
        this.businessrule = businessrule;
        this.supporteddatabase = supporteddatabase;
    }

    public GeneratedTrigger() {
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Businessrule getBusinessrule() {
        return businessrule;
    }

    public void setBusinessrule(Businessrule businessrule) {
        this.businessrule = businessrule;
    }

    public SupportedDatabases getSupporteddatabase() {
        return supporteddatabase;
    }

    public void setSupporteddatabase(SupportedDatabases supporteddatabase) {
        this.supporteddatabase = supporteddatabase;
    }
           
}
