package domainGeneric.businessrule.ruletype;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeRange extends BRRuleType {
    private String from;
    private String to;
    private String target;


    public AttributeRange(String from, String to, String operator, String databasetype, String target) {
        super(operator, new TemplateService(), databasetype, "RNG");
        this.from = from;
        this.to = to;
        this.target = target;
    }

    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeRangeConstraintCode(databasetype, target , from, operator, to);
    }

    @Override
    public String getTriggerCode() {
        return manager.getRuleTypeRangeTriggerCode(databasetype, from, operator, to, target);
    }
}