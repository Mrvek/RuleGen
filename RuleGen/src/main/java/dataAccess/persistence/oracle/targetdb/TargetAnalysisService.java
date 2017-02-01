/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence.oracle.targetdb;

import dataAccess.persistence.oracle.toolsdb.SupportedUnitsDAO;
import dto.project.Attribute;
import dto.project.DatabaseSchema;
import dto.project.Project;
import dto.project.Table;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class TargetAnalysisService {
    private StructureDAO sdao;

    public TargetAnalysisService(Project project) {
        sdao = new StructureDAO(project);
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
