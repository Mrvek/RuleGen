package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeCompare extends BRRuleType {
    private String CompareWith;

    public AttributeCompare(String operator, String databasetype, String target, String compareWith) {
        super(operator, databasetype, "ACMP", target);
        CompareWith = compareWith;
    }

    @Override
    public String getConstraintCode() {
        return templateService.getRuleTypeACMPConstraintCode(databasetype, target, operator, CompareWith);
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeACMPProcedureCode(databasetype, target, operator, CompareWith);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeACMPCode(databasetype, target);
    }

}
