/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.businessrules;

import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class Failurehandling {
    private int id;
    private String severity;
    private String messageText;
    private ArrayList<Token> token;

    public Failurehandling(int id, String severity, String messageText, ArrayList<Token> token) {
        this.id = id;
        this.severity = severity;
        this.messageText = messageText;
        this.token = token;
    }
    
    public Failurehandling() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public ArrayList<Token> getToken() {
        return token;
    }

    public void setToken(ArrayList<Token> token) {
        this.token = token;
    }
    
}
