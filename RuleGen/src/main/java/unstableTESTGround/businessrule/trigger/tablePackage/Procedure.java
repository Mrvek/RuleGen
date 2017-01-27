package unstableTESTGround.businessrule.trigger.tablePackage;

import org.json.JSONObject;
import unstableTESTGround.businessrule.ruleType.BRRuleType;
import unstableTESTGround.businessrule.trigger.Exception;
import unstableTESTGround.template.TemplateService;

import java.util.Map;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class Procedure {
    private String primarykey;
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
    private Exception exception;
    private TemplateService templateService = new TemplateService();

    public Procedure(String primarykey, BRRuleType ruletype, String databasetype, String attribute, String table, String initials, TemplateService manager, String name, String severity, String exceptionMessage, Map<String, String> tokens, Exception exception) {
        this.primarykey = primarykey;
        this.ruletype = ruletype;
        this.databasetype = databasetype;
        this.attribute = attribute;
        this.table = table;
        this.initials = initials;
        this.manager = manager;
        this.name = name;
        this.severity = severity;
        ExceptionMessage = exceptionMessage;
        this.tokens = tokens;
        this.exception = exception;
    }

    public String getExcecutionCode() {
        return null;
    }

    public String getCode() {
        return null;
    }

    public JSONObject getStatus() {
        return null;
    }

    public String getPrimarykey() {
        return primarykey;
    }

    public String getMessage() {
        return Message;
    }

    public String getPackageDeclarationCode() {
        return null;
    }
}
