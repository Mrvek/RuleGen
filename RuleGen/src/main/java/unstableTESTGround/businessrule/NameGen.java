package unstableTESTGround.businessrule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class NameGen {
    private String initials = "BRG";
    private Map<String, Integer> names = new HashMap<>();

    public String getTriggerName(String databaseName, String tableName) {
        String name = initials + "_" +
                databaseName + "_" +
                tableName + "_" +
                "TRIGGER";
        return name;
    }

    public String getProcedureName(String databaseName, String tableName, String ruleType, int number) {
        String name = initials + "_" +
                databaseName + "_" +
                tableName + "_" +
                ruleType ;
        int versionNumber = getVersionNumber(name);
        name += name + "_" + versionNumber;
        return name;
    }

    public String getTablePackageName(String databaseName, String tableName) {
        String name = initials + "_" +
                databaseName + "_" +
                tableName + "_" +
                "PACKAGE";
        return name;
    }

    public String getConstraintName(String databaseshortname, String tablename, String ruleType, String target) {
        String name = initials + "_" +
                databaseshortname + "_" +
                tablename + "_" +
                ruleType + "_" +
                target + "_" +
                "CONSTRAINT";
        int versionNumber = getVersionNumber(name);
        name += name + "_" + versionNumber;
        return name;
    }

    private int getVersionNumber(String name) {
        int number = 1;
        for (String nm : names.keySet()) {
            if (nm.equals(name)) {
               number = names.get(nm) + 1;
            }
        }
        names.put(name, number);
        return number;
    }
}
