package domainGeneric.businessrule.CType;

import domainGeneric.businessrule.ruletype.BRRuleType;
import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 19/01/2017.
 */
public abstract class CodeType {
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

    public CodeType(String primarykey, String projectid, BRRuleType ruletype, String databasetype, String target, String table, NameGen name, String initials, TemplateService manager, String message) {
        this.primarykey = primarykey;
        this.projectid = projectid;
        this.ruletype = ruletype;
        this.databasetype = databasetype;
        this.target = target;
        this.table = table;
        this.name = name;
        this.initials = initials;
        this.manager = manager;
        Message = message;
    }

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
