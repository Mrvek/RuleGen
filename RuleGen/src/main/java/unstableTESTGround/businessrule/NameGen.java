package unstableTESTGround.businessrule;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class NameGen {
    private String initials = "brg";

    public String getTriggerName(String databaseName, String tableName) {
        String name = initials + "_" +
                databaseName + "_" +
                tableName + "_" +
                "trigger";
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
                "package";
        return name;
    }
}
