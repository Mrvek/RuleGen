package domainGeneric.businessRule.RuleType;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeRange extends BRRuleType {
    private String from;
    private String to;
    private TemplateService manager = new TemplateService();
    private String target;


    public AttributeRange(String from, String to, String operator, String databasetype, String target) {
        super(operator, new TemplateService(), databasetype, "RNG");
        this.from = from;
        this.to = to;
        this.target = target;
    }

    @Override
    public String getShortname() {
        return shortname;
    }

    @Override
    public String getConstraintCode() {
        String result = manager.getRuleTypeRangeConstraintCode(databasetype, from, operator, to);
        return result;
    }

    @Override
    public String getTriggerCode() {
        String result = manager.getRuleTypeRangeTriggerCode(databasetype, from, operator, to, target);
        return result;
    }
}
