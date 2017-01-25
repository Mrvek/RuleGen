package dataAccess.persistence.oracle;


import dataAccess.persistence.oracle.targetdb.TargetAnalysisService;
import dataAccess.dto.project.*;
import dataAccess.dto.supported_units.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Matthias
 */
public class Test {


    public static void main(String[] args) {
        TargetAnalysisService tac = new TargetAnalysisService("ondora02.hu.nl", "8521", "cursus02.hu.nl", "tosad_2016_2a_team3_target", "tosad_2016_2a_team3_target");
        SupportedDatabases sdbs = new SupportedDatabases(1, "Oracle 12c");

        ArrayList<Table> a = tac.getTargetDatabaseStructure(sdbs);

        for (Table t : a) {
            System.out.println(t.getName());
        }

    }
}