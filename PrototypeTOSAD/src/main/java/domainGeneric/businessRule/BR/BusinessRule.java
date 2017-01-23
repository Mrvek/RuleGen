package domainGeneric.businessRule.BR;

import domainGeneric.businessRule.RuleType.BRRuleType;
import domainGeneric.Template.TemplateService;

/**
 * Created by Mitchell on 19/01/2017.
 */
public abstract class BusinessRule {
    protected BRRuleType ruletype;
    protected String databasetype;
    protected String target;
    protected String table;
    protected NameGen name;
    protected String initials;
    protected TemplateService manager;


    public abstract String getCode();
}
