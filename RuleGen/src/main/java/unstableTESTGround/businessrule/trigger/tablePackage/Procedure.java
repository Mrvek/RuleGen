package unstableTESTGround.businessrule.trigger.tablePackage;

import unstableTESTGround.TemplateService;
import unstableTESTGround.businessrule.ruleType.BRRuleType;

import java.util.Map;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class Procedure {
    private String primarykey;
    private String projectid;
    private BRRuleType ruletype;
    private String databasetype;
    private String attribute;
    private String table;
    private String initials;
    private TemplateService manager;
    private String name;
    private String Message = "not yet initiated";
    private String severity;
    private String ExceptionMessage;
    private Map<String, String> tokens;

    public String getExcecutionCode() {
        return null;
    }

    public String getCode() {
        return null;
    }
}
