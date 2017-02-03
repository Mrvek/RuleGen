package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 31/01/2017.
 */
public class EntityOther extends BRRuleType {
    private String compareWith;
    private String table;

    public EntityOther(String operator, String databasetype, String target, String compareWith, String table) {
        super(operator, databasetype, "EOTH", target);
        this.compareWith = compareWith;
        this.table = table;
    }

    @Override
    public String getConstraintCode() {
        return "I_Passed VARCHAR2;\n" + compareWith;
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeEOTHProcedureCode(databasetype, target, operator, compareWith);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeEOTHCode(databasetype, target, table);
    }
}
