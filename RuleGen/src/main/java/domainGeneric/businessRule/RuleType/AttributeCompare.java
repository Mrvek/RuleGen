package domainGeneric.businessRule.RuleType;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeCompare extends BRRuleType {
    private String valueOne;
    private String valueTwo;

    public AttributeCompare(String valueOne, String valueTwo, String operator, String databasetype) {
        super(operator, new TemplateService(), databasetype, "CPR");
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Override
    public String getShortname() {
        return shortname;
    }

    @Override
    public String getConstraintCode() {
        String result = manager.getRuleTypeCompareConstraintCode(databasetype, valueOne, operator, valueTwo);
        return result;
    }

    @Override
    public String getTriggerCode() {
        String result = manager.getRuleTypeCompareTriggerCode(databasetype, valueOne, operator, valueTwo);
        return result;
    }
}
