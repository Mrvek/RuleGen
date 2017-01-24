package dataAccess.persistence;


import dataAccess.persistence.oracle.TargetAnalysisController;
import domainGeneric.project.Attribute;
import domainGeneric.project.Table;
import domainGeneric.supported_units.SupportedDatabases;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Matthias
 */
public class Test {


    public static void main(String[] args) {
        TargetAnalysisController tac = new TargetAnalysisController("ondora02.hu.nl", "8521", "cursus02.hu.nl", "tosad_2016_2a_team3_target", "tosad_2016_2a_team3_target");
        SupportedDatabases sdbs = new SupportedDatabases(1, "Oracle 12c");

        HashMap<Table, ArrayList<Attribute>> a = tac.getTargetDatabaseStructure(sdbs);

        for (Table t : a.keySet()) {
            System.out.println(t.getName());
        }

    }
}