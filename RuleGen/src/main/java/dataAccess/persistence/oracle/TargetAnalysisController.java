/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle;

import domainGeneric.project.Attribute;
import domainGeneric.project.Table;
import domainGeneric.supported_units.SupportedDatabases;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matthias
 */
public class TargetAnalysisController {
    private String hostname;
    private String port;
    private String serviceName;
    private String username;
    private String password;
    private StructureDAO sdao;

    public TargetAnalysisController(String hostname, String port, String serviceName, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.serviceName = serviceName;
        this.username = username;
        this.password = password;
        sdao = new StructureDAO(hostname, port, serviceName, username, password);
    }
    
    public HashMap<Table, ArrayList<Attribute>> getTargetDatabaseStructure(SupportedDatabases database) {
        HashMap<Table, ArrayList<Attribute>> results = new HashMap<>();
        ArrayList<Table> tables = sdao.getTables();
        
        for (Table s : tables) {
            results.put(s, sdao.getAttribute(s, database));
        }
        
        return results;
    }
}
