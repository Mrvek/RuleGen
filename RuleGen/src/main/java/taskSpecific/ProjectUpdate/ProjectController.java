/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskSpecific.ProjectUpdate;

import dataAccess.dto.project.Table;
import dataAccess.dto.supported_units.SupportedDatabases;
import dataAccess.persistence.oracle.targetdb.TargetAnalysisService;
import dataAccess.persistence.oracle.toolsdb.ProjectService;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class ProjectController {
    
    public void initialiseProject(int project_id) {
        TargetAnalysisService tac = new TargetAnalysisService("ondora02.hu.nl", 
                                                                    "8521", 
                                                                    "cursus02.hu.nl", 
                                                                    "tosad_2016_2a_team3_target", 
                                                                    "tosad_2016_2a_team3_target"); //TODO: do something!?
        
        SupportedDatabases database = new SupportedDatabases(1, "Oracle 12c"); //TODO: do something!?
        ArrayList<Table> targetTables = tac.getTargetDatabaseStructure(database);
        
        ProjectService pc = new ProjectService();
        pc.updateProject(project_id, targetTables);
    }
    
    public void updateProject() {
        System.out.println("Not Ready");
    }
}
