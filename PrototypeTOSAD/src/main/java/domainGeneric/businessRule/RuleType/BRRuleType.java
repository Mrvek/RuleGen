package domainGeneric.businessRule.RuleType;

import domainGeneric.Template.TemplateService;

/**
 * Created by Mitchell on 19/01/2017.
 */
public abstract class BRRuleType {
    protected String operator;
    protected TemplateService manager;
    protected String databasetype;
    protected String shortname;

    public abstract String getShortname();
    public abstract String getConstraintCode();
    public abstract String getTriggerCode();
}
