/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.persistence;


import dataAccess.persistence.oracle.StructureDAO;
import dataAccess.persistence.oracle.TargetAnalysisController;
import dataAccess.persistence.oracle.toolsDB.ProjectDAO;
import dataAccess.persistence.oracle.toolsDB.SupportedUnitsDAO;
import domainGeneric.project.Attribute;
import domainGeneric.project.DatabaseSchema;
import domainGeneric.project.Table;
import domainGeneric.supported_units.SupportedDatabases;
import domainGeneric.supported_units.SupportedDatatypes;
import java.util.ArrayList;



/**
 *
 * @author Matthias
 */
public class Test {
    
    
    public static void main(String[] args) {
        TargetAnalysisController tac = new TargetAnalysisController("ondora02.hu.nl", "8521", "cursus02.hu.nl", "tosad_2016_2a_team3_target", "tosad_2016_2a_team3_target");
        SupportedDatabases sdbs = new SupportedDatabases(1, "Oracle 12c");
        
//        ArrayList<Table> a = tac.getTargetDatabaseStructure(sdbs);
        
//        StructureDAO sdao = new StructureDAO("ondora02.hu.nl", "8521", "cursus02.hu.nl", "tosad_2016_2a_team3_target", "tosad_2016_2a_team3_target");
//        DatabaseSchema dbs = new DatabaseSchema(1, "test");
//        Table table = new Table(1, "Attribute", dbs);
//        sdao.getColumns(table, sdbs);
        
//        for (Table t : a) {
//            System.out.println(t.getName());
//            for (Attribute g : t.getAllAttributes()) {
//                System.out.println(" -" + g.getSupporteddatatype().getDatatype());
//            }
//        }

//       SupportedUnitsDAO sudao = new SupportedUnitsDAO();
//       ArrayList<SupportedDatatypes> abc = sudao.getSupportedDataTypesByDB(sdbs);
//       
//       for (SupportedDatatypes t : abc) {
//           System.out.println("ABC " + t.getDatatype());
//       }

        ProjectDAO pdao = new ProjectDAO();
        ArrayList<Table> tables = pdao.getAllTablesFromProject(1);
        System.out.println("Count: " + tables.size());
        
    }
}