package unstableTESTGround.businessrule;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class NameGen {
    private String initials = "BRG";

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
                ruleType + "_" +
                number;
        return name;
    }

    public String getTablePackageName(String databaseName, String tableName) {
        String name = initials + "_" +
                databaseName + "_" +
                tableName + "_" +
                "PACKAGE";
        return name;
    }
}
