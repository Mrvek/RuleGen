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
public class PosibleTriggerEvents {
    private int id;
    private String event;

    public PosibleTriggerEvents(int id, String event) {
        this.id = id;
        this.event = event;
    }

    public PosibleTriggerEvents() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
    
}
