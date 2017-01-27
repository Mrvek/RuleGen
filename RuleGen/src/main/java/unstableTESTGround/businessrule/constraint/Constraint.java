package unstableTESTGround.businessrule.constraint;

import unstableTESTGround.template.TemplateService;
import unstableTESTGround.businessrule.ruleType.BRRuleType;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Constraint {
    protected String primarykey;
    protected String projectid;
    protected BRRuleType ruletype;
    protected String databasetype;
    protected String target;
    protected String table;
    protected String name;
    protected String initials;
    protected TemplateService manager;
    protected String Message = "not yet initiated";

    public Constraint(String primarykey, String projectid, BRRuleType ruletype, String databasetype, String target, String table, String name, String initials, TemplateService manager, String message) {
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

    public String getPrimarykey() {
        return primarykey;
    }

    public String getProjectid() {
        return projectid;
    }

    public String getMessage() {
        return Message;
    }

    public String getCode() {
        String code = null;
        String ruletypecode = ruletype.getConstraintCode();
        return code;
    }
}
