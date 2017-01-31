/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.project;

/**
 *
 * @author Matthias
 */
public class Brgqueue {
    private int id;
    private int ticktetId;
    private LinkedBusinessrules linBusinessrules;
    private String responseMessage;

    public Brgqueue(int id, int ticktetId, LinkedBusinessrules linBusinessrules, String responseMessage) {
        this.id = id;
        this.ticktetId = ticktetId;
        this.linBusinessrules = linBusinessrules;
        this.responseMessage = responseMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicktetId() {
        return ticktetId;
    }

    public void setTicktetId(int ticktetId) {
        this.ticktetId = ticktetId;
    }

    public LinkedBusinessrules getLinBusinessrules() {
        return linBusinessrules;
    }

    public void setLinBusinessrules(LinkedBusinessrules linBusinessrules) {
        this.linBusinessrules = linBusinessrules;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
