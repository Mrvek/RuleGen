/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle;

import dataAccess.dto.project.Attribute;
import dataAccess.dto.project.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matthias
 */
public class StructureChangeAlgorithm {
    private ArrayList<Table> targetTables;
    private ArrayList<Table> toolsTables;
    private HashMap<Integer, String> errorMap;

    public StructureChangeAlgorithm(ArrayList<Table> targetTables, ArrayList<Table> toolsTables) {
        this.targetTables = targetTables;
        this.toolsTables = toolsTables;
        this.errorMap = new HashMap<>();
        
        errorMap.put(1, "Not found, is a new table.");
        errorMap.put(2, "Not found, table is removed.");
        errorMap.put(3, "Not found, is a new attribute.");
        errorMap.put(4, "Not found, attribute is removed.");
        errorMap.put(5, "Datatype has been changed.");
        
    }
    
    public Map<Table, Integer> checkTables() {
        Map<Table, Integer> incorrectTables = new HashMap<>();
        
        for (Table x : targetTables) {
            boolean exists = false;
            for (Table z : toolsTables) {
                if (x.getName().toUpperCase().equals(z.getName().toUpperCase())) {
                    //Table does still exist!
                    exists = true;
                    break;
                }
            }
            //If the table does not not exist, it will become an incorrect table.
            if (!exists) {
                incorrectTables.put(x, 1); //Not found, is a new table.
            }
        }
        
        for (Table x : toolsTables) {
            boolean exists = false;
            for (Table z : targetTables) {
                if (x.getName().toUpperCase().equals(z.getName().toUpperCase())) {
                    //Table does still exist!
                    exists = true;
                    break;
                }
            }
            //If the table does not not exist, it will become an incorrect table.
            if (!exists) {
                incorrectTables.put(x, 2); //Not found, table is removed.
            }
        }
        
//        for (Table t : incorrectTables.keySet()) {
//            System.out.println("Incorrect table: " + t.getName() + " " + errorMap.get(incorrectTables.get(t)));
//        }
        return incorrectTables;
    }
    
    public Map<Attribute, Integer> checkAttributes() {
        Map<Attribute, Integer> incorrectAttributes = new HashMap<>();
        
        for (Table x : targetTables) {
            for (Attribute y : x.getAllAttributes()) {
                boolean exists = false;
                for (Table z : toolsTables) {
                    if (x.getName().toUpperCase().equals(z.getName().toUpperCase())) {
                        int error = 3; //Not found, is a new attribute.
                        for (Attribute q : z.getAllAttributes()) {
                            if (q.getName().toUpperCase().equals(y.getName().toUpperCase())
                                    && q.getSupporteddatatype().getId() == y.getSupporteddatatype().getId()) {
                                exists = true;
                                break; //Attribute was found.
                            } else if (q.getName().toUpperCase().equals(y.getName().toUpperCase())
                                    && q.getSupporteddatatype().getId() != y.getSupporteddatatype().getId()) {
                                error = 5; //Datatype has been changed.
                            }
                            
                        }
                        if (!exists) {
                            incorrectAttributes.put(y, error);
                        }
                        break; //Table was found and compared, get back to other attributes.
                    }
                    
                }
            }
        }
        
        for (Table x : toolsTables) {
            for (Attribute y : x.getAllAttributes()) {
                boolean exists = false;
                for (Table z : targetTables) {
                    if (x.getName().toUpperCase().equals(z.getName().toUpperCase())) {
                        int error = 4; //Not found, attribute is removed.
                        for (Attribute q : z.getAllAttributes()) {
                            if (q.getName().toUpperCase().equals(y.getName().toUpperCase())
                                    && q.getSupporteddatatype().getId() == y.getSupporteddatatype().getId()) {
                                exists = true;
                                break; //Attribute was found.
                            } else if (q.getName().toUpperCase().equals(y.getName().toUpperCase())
                                    && q.getSupporteddatatype().getId() != y.getSupporteddatatype().getId()) {
                                exists = true; //Already catched in the check above.
                            }
                            
                        }
                        if (!exists) {
                            incorrectAttributes.put(y, error);
                        }
                        break; //Table was found and compared, get back to other attributes.
                    }
                    
                }
            }
        }
        
//        for (Attribute t : incorrectAttributes.keySet()) {
//            System.out.println("Incorrect attribute: " + t.getName() + " " + errorMap.get(incorrectAttributes.get(t)));
//        }
        return incorrectAttributes;
    }
    
    
}
