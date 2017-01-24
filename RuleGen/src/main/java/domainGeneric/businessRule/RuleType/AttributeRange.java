package domainGeneric.businessRule.RuleType;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeRange extends BRRuleType {
    private String from;
    private String to;
    private String operator;
    private String shortname = "RNG";
    private String databasetype;
    private TemplateService manager = new TemplateService();
    private String target;


    public AttributeRange(String from, String to, String operator, String databasetype, String target) {
        this.from = from;
        this.to = to;
        this.operator = operator;
        this.databasetype = databasetype;
        this.target = target;
        this.shortname = "RNG";
        this.manager = new TemplateService();
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
