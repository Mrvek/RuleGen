package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 31/01/2017.
 */
public class Modify extends BRRuleType {
    private String compareWithColumn;


    public Modify(String operator, String databasetype, String compareWith, String target) {
        super(operator, databasetype, "MODI", target);
        this.compareWithColumn = compareWith;
    }

    @Override
    public String getConstraintCode() {
        return null;
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeMODIProcedureCode(databasetype, target, operator, compareWithColumn);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeMODICode(databasetype, target, compareWithColumn);
    }
}
