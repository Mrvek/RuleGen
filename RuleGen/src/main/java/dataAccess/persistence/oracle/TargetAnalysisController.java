/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    
    public HashMap<String, Map<String, String>> getTargetDatabaseStructure() {
        HashMap<String, Map<String, String>> results = new HashMap<String, Map<String, String>>();
        ArrayList<String> tables = sdao.getTables();
        
        for (String s : tables) {
            results.put(s, sdao.getColumns(s));
        }
        
        return results;
    }
}
