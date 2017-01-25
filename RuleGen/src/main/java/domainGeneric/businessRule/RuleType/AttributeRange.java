package domainGeneric.businessRule.RuleType;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeRange extends BRRuleType {
    private String from;
    private String to;
    private String target;
    private String table;


    public AttributeRange(String from, String to, String operator, String databasetype, String target, String table) {
        super(operator, new TemplateService(), databasetype, "RNG");
        this.from = from;
        this.to = to;
        this.target = target;
        this.table = table;
    }

    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeRangeConstraintCode(databasetype, target , from, operator, to);
    }

    @Override
    public String getTriggerCode() {
        return manager.getRuleTypeRangeTriggerCode(databasetype, from, operator, to, target, table);
    }
}
