package domainGeneric.businessRule.RuleType;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 25/01/2017.
 */
public class AttributeList extends BRRuleType {
    protected AttributeList(String operator, TemplateService manager, String databasetype, String shortname) {
        super(operator, manager, databasetype, shortname);
    }

    @Override
    public String getShortname() {
        return null;
    }

    @Override
    public String getConstraintCode() {
        return null;
    }

    @Override
    public String getTriggerCode() {
        return null;
    }
}
