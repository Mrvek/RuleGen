package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 25/01/2017.
 */
public class AttributeOther extends BRRuleType {
    private String booleanStatement;
    private String table;

    public AttributeOther(String operator, String databasetype, String booleanStatement, String target, String table) {
        super(operator, databasetype, "AOTH", target);
        this.booleanStatement = booleanStatement;
        this.table = table;
    }

    @Override
    public String getConstraintCode() {
        return "I_Passed VARCHAR2;\n" + booleanStatement;
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeOtherProcedureCode(databasetype, booleanStatement);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeTHRCode(databasetype, target, table);
    }
}
