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
public class BusinessruleType {
    private int id;
    private Category category;
    private String type;

    public BusinessruleType(int id, Category category, String type) {
        this.id = id;
        this.category = category;
        this.type = type;
    }

    public BusinessruleType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
