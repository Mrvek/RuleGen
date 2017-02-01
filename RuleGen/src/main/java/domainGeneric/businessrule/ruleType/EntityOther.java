package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 31/01/2017.
 */
public class EntityOther extends BRRuleType {
    private String compareWith;

    public EntityOther(String operator, String databasetype, String target, String compareWith) {
        super(operator, databasetype, "EOTH", target);
        this.compareWith = compareWith;
    }

    @Override
    public String getConstraintCode() {
        return null;
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeEOTHProcedureCode(databasetype, target, operator, compareWith);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeEOTHCode(databasetype, target);
    }
}
