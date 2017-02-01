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
    	System.out.println("IS IT WORKING AS INTENDED 0?");
    	Project project = ToolDbService.getPService().getProject(project_id);
        System.out.println("IS IT WORKING AS INTENDED 1?");
        TargetAnalysisService tac = new TargetAnalysisService(project); 
        System.out.println("IS IT WORKING AS INTENDED 2?");
        ArrayList<Table> targetTables = tac.getTargetDatabaseStructure(project.getSupporteddatabase());
        System.out.println("IS IT WORKING AS INTENDED 3?");
        ToolDbService.getPService().updateProject(project_id, targetTables);
        System.out.println("IS IT WORKING AS INTENDED 4?");
        return null;
    }
    
    public JSONArray updateProject() {
        System.out.println("Not Ready");
        return null;
    }
}
