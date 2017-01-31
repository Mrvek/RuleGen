/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.toolsdb;

import dto.project.Attribute;
import dto.project.Brgqueue;
import dto.project.DatabaseSchema;
import dto.project.LinkedBusinessrules;
import dto.project.Project;
import dto.project.Table;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class ProjectService {
	private static ProjectDAO pdao = new ProjectDAO();

//    public ProjectService() {
//        pdao = new ProjectDAO();
//    }
    
	public static ProjectDAO getProject(){		
		return pdao;
	}
	public ArrayList<Table> getAllTablesFromProject(int project_id) {
		return pdao.getAllTablesFromProject(project_id);
	}
	public ArrayList<Attribute> getAllAttributesFromTableAndProjectID(Table table, int project_id) {
		return pdao.getAllAttributesFromTableAndProjectID(table,project_id);
	}
	public int getSchemaId(int project_id) {
		return pdao.getSchemaId(project_id);
	}
	public boolean projectExists(int project_id) {
		return pdao.projectExists(project_id);
	}
	public void insertTables(int database_schema_id, ArrayList<Table> tables) {
		pdao.insertTables(database_schema_id,tables);
	}
	public void insertAttributes(Table table, ArrayList<Attribute> attributes) {
		pdao.insertAttributes(table,attributes);
	}
	public DatabaseSchema getDatabaseSchema(int databaseSchema_id) {
		return pdao.getDatabaseSchema(databaseSchema_id);
	}
	public Table getTable(int table_id) {
		return pdao.getTable(table_id);
	}
	public Attribute getAttribute (int atr_id) {
		return pdao.getAttribute(atr_id);
	}
	public Project getProject (int project_id) {
		return pdao.getProject(project_id);
	}
        public LinkedBusinessrules getLinkedBusinessrules (int linkedbs_id) {
            return pdao.getLinkedBusinessrules(linkedbs_id);
        }
        public Brgqueue getBrgqueue (int brgq_id) {
            return pdao.getBrgqueue(brgq_id);
        }
        public ArrayList<Brgqueue> getAllBrgqueue (int ticket_id) {
            return pdao.getAllBrgqueue(ticket_id);
        }
	
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
