package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 31/01/2017.
 */
public class InterEntityCompare extends BRRuleType {
    private String compareWithColumn;
    private String compareWithTable;
    private String targetTable;
    private String table;

    public InterEntityCompare(String operator, String databasetype, String compareWith, String compareWithTable, String target, String targetTable, String table) {
        super(operator, databasetype, "ICMP", target);
        this.compareWithColumn = compareWith;
        this.compareWithTable = compareWithTable;
        this.targetTable = targetTable;
        this.table = table;
    }

    @Override
    public String getConstraintCode() {
        return null;
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeICMPProcedureCode(databasetype, target, operator, compareWithColumn, compareWithTable, targetTable);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeICMPCode(databasetype, target, compareWithTable, compareWithColumn, table);
    }
}
