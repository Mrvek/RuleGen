package domainGeneric.businessRule.BR;

import domainGeneric.businessRule.RuleType.BRRuleType;
import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 19/01/2017.
 */
public abstract class BusinessRule {
    protected String primarykey;
    protected String projectid;
    protected BRRuleType ruletype;
    protected String databasetype;
    protected String target;
    protected String table;
    protected NameGen name;
    protected String initials;
    protected TemplateService manager;
    protected String Message = "not yet initiated";


    public abstract String getCode();

    public String getPrimarykey() {
        return primarykey;
    }

    public String getProjectid() {
        return projectid;
    }

    public String getMessage() {
        return Message;
    }
}
