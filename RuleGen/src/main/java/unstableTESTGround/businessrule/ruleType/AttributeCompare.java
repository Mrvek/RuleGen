package unstableTESTGround.businessrule.ruleType;

import unstableTESTGround.template.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeCompare extends BRRuleType {
    private String Target;
    private String CompareWith;

    public AttributeCompare(String target, String compareWith, String operator, String databasetype) {
        super(operator, new TemplateService(), databasetype, "ACMP");
        this.Target = target;
        this.CompareWith = compareWith;
    }


    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeCompareConstraintCode(databasetype, Target, operator, CompareWith);
    }

    @Override
    public String getProcedureCode() {
        return manager.getRuleTypeCompareTriggerCode(databasetype, Target, operator, CompareWith);
    }

    @Override
    public String getParameterCode() {
        return null;
    }

}
