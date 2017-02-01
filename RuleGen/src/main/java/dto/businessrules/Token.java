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
public class Token {
    private int id;
    private String name;
    private String expression;

    public Token(int id, String name, String expression) {
        this.id = id;
        this.name = name;
        this.expression = expression;
    }

    public Token() {
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

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
    
}
