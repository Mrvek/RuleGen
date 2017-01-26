package domainGeneric.businessrule.ruletype;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 19/01/2017.
 */
public abstract class BRRuleType {
    protected String operator;
    protected TemplateService manager;
    protected String databasetype;
    protected String shortname;

    protected BRRuleType(String operator, TemplateService manager, String databasetype, String shortname) {
        this.operator = operator;
        this.manager = manager;
        this.databasetype = databasetype;
        this.shortname = shortname;
    }

    public String getShortname() {
        return shortname;
    }
    public abstract String getConstraintCode();
    public abstract String getTriggerCode();
}