/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskSpecific.ProjectUpdate;

import dto.project.Project;
import dto.project.Table;
import dto.supported_units.SupportedDatabases;
import dataAccess.persistence.oracle.targetdb.TargetAnalysisService;
import dataAccess.persistence.oracle.toolsdb.ProjectService;
import dataAccess.persistence.oracle.toolsdb.ToolDbService;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class ProjectController {
    //TODO SYSOUT REMOVAL
    public JSONArray initialiseProject(int project_id) {
    	System.out.println("Starting Project Service");
    	Project project = ToolDbService.getPService().getProject(project_id);
        System.out.println("Starting Analysis Service");
        TargetAnalysisService tac = new TargetAnalysisService(project); 
        System.out.println("Starting Analysis on target database");
        ArrayList<Table> targetTables = tac.getTargetDatabaseStructure(project.getSupporteddatabase());
        System.out.println("Starting to push tables to ToolsDB");
        ToolDbService.getPService().updateProject(project_id, targetTables);
        System.out.println("Completed push to ToolsDB?");
        return null;
    }
    
    public JSONArray updateProject() {
        System.out.println("Not Ready");
        return null;
    }
}
