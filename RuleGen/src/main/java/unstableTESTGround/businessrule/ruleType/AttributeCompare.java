package unstableTESTGround.businessrule.ruleType;

import unstableTESTGround.template.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeCompare extends BRRuleType {
    private String Target;
    private String CompareWith;

    public AttributeCompare(String valueOne, String valueTwo, String operator, String databasetype) {
        super(operator, new TemplateService(), databasetype, "ACMP");
        this.Target = valueOne;
        this.CompareWith = valueTwo;
    }


    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeCompareConstraintCode(databasetype, Target, operator, CompareWith);
    }

    @Override
    public String getProcedureCode() {
        return manager.getRuleTypeCompareTriggerCode(databasetype, Target, operator, CompareWith);
    }
}
