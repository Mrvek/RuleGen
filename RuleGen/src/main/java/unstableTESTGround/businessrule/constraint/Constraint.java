package unstableTESTGround.businessrule.constraint;

import org.json.JSONObject;
import unstableTESTGround.template.TemplateService;
import unstableTESTGround.businessrule.ruleType.BRRuleType;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Constraint {
    protected String primarykey;
    protected BRRuleType ruletype;
    protected String databasetype;
    protected String target;
    protected String table;
    protected String name;
    protected TemplateService manager = new TemplateService();
    protected String Message = "not yet initiated";

    public Constraint(String primarykey, BRRuleType ruletype, String databasetype, String target, String table, String name) {
        this.primarykey = primarykey;
        this.ruletype = ruletype;
        this.databasetype = databasetype;
        this.target = target;
        this.table = table;
        this.name = name;
    }

    public String getPrimarykey() {
        return primarykey;
    }

    public String getMessage() {
        return Message;
    }

    public String getCode() {
        String code = null;
        String ruletypecode = ruletype.getConstraintCode();
        return code;
    }

    public JSONObject getStatus() {
        JSONObject status = new JSONObject();
        status.put("ID", primarykey);
        status.put("Message", Message);
        return status;
    }
}
