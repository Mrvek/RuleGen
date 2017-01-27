package unstableTESTGround.businessrule.ruleType;

import unstableTESTGround.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeCompare extends BRRuleType {
    private String Target;
    private String CompareWith;

    public AttributeCompare(String valueOne, String valueTwo, String operator, String databasetype) {
        super(operator, new TemplateService(), databasetype, "CMPR");
        this.Target = valueOne;
        this.CompareWith = valueTwo;
    }


    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeCompareConstraintCode(databasetype, Target, operator, CompareWith);
    }

    @Override
    public String getTriggerCode() {
        return manager.getRuleTypeCompareTriggerCode(databasetype, Target, operator, CompareWith);
    }
}
