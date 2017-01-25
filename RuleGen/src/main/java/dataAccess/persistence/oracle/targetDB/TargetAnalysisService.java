/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.targetDB;

import dataAccess.persistence.oracle.toolsDB.SupportedUnitsDAO;
import dataAccess.dto.project.Attribute;
import dataAccess.dto.project.Table;
import dataAccess.dto.supported_units.SupportedDatabases;
import dataAccess.dto.supported_units.SupportedDatatypes;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class TargetAnalysisService {
    private String hostname;
    private String port;
    private String serviceName;
    private String username;
    private String password;
    private StructureDAO sdao;

    public TargetAnalysisService(String hostname, String port, String serviceName, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.serviceName = serviceName;
        this.username = username;
        this.password = password;
        sdao = new StructureDAO(hostname, port, serviceName, username, password);
    }
    
    public ArrayList<Table> getTargetDatabaseStructure(SupportedDatabases database) {
        ArrayList<Table> results = sdao.getTables();
        
        // Insert all attributes from each table.
        for (Table s : results) {
            ArrayList<Attribute> atrs = sdao.getAttribute(s, database);
            
            for (Attribute a : atrs) {
                s.addAttribute(a);
            }
        }
        
        SupportedUnitsDAO sudao = new SupportedUnitsDAO();
        ArrayList<SupportedDatatypes> sdt = sudao.getSupportedDataTypesByDB(database);
        
        //Link all supporteddatatypes with each attribute.
        for (Table s : results) {
            for (Attribute x : s.getAllAttributes()) {
                for (SupportedDatatypes z : sdt) {
                    if (x.getSupporteddatatype().getDatatype().equals(z.getDatatype())) {
                        x.setSupporteddatatype(z); //Linking datatype Z with attribute X.
                        break; //Break when datatype has been linked.
                    }
                }
                        
            }
        }
        
        return results;
    }
}
