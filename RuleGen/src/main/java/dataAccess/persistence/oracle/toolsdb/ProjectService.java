/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsdb;

import dataAccess.dto.project.Attribute;
import dataAccess.dto.project.Table;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class ProjectService {
    private ProjectDAO pdao;

    public ProjectService() {
        pdao = new ProjectDAO();
    }
    
    //More like project init:
    public void updateProject(int project_id, ArrayList<Table> targetTables) {
        //This method will only update projects that DO NOT have any tables/attributes.
        //targetTables are the tables that are stored in Java, already linked with the attributes which contains all verified datatypes.   
        
        ArrayList<Table> toolsTables = pdao.getAllTablesFromProject(project_id);
        int schema_id = pdao.getSchemaId(project_id);
        
        //A project must exist in order to create tables/attributes for that specific project.
        //toolsTables must best empty because this method does only instert tables into an empty (tools) project.
        //When targetTables are empty there is nothing to commit.
        if (pdao.projectExists(project_id) && toolsTables.isEmpty() && !targetTables.isEmpty()) {
            
            pdao.insertTables(schema_id, targetTables); // Insert all targetTables
            ArrayList<Table> createdToolTables = pdao.getAllTablesFromProject(project_id); //Receive the inserted targetTables (with ids).
            // Link all new (createdToolTable) ids with the local stored targetTables.
            for (Table x : targetTables) {
                for (Table z : createdToolTables) {
                    System.out.println("Z: " + z.getName());
                    if (x.getName().equals(z.getName())) {
                        x.setId(z.getId());
                        
                        break; //Id has been found, execute next targetTable...
                    }
                }
            }
            
            //Insert all attributes:
            for (Table x : targetTables) {
                pdao.insertAttributes(x, x.getAllAttributes());
            }   
        }

        
    }
}
