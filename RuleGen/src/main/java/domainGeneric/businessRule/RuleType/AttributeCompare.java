package domainGeneric.businessRule.RuleType;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeCompare extends BRRuleType {
    private String Target;
    private String CompareWith;
    private String table;

    public AttributeCompare(String table, String valueOne, String valueTwo, String operator, String databasetype) {
        super(operator, new TemplateService(), databasetype, "CMPR");
        this.Target = valueOne;
        this.CompareWith = valueTwo;
        this.table = table;
    }


    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeCompareConstraintCode(databasetype, Target, operator, CompareWith);
    }

    @Override
    public String getTriggerCode() {
        return manager.getRuleTypeCompareTriggerCode(table, databasetype, Target, operator, CompareWith);
    }
}
