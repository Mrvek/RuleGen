package domainGeneric.businessRule.BR;

import domainGeneric.businessRule.RuleType.BRRuleType;
import domainGeneric.TemplateService;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Trigger extends BusinessRule {
    private String severity;
    private String ExceptionMessage;
    private Map<String, String> tokens;
    private List<String> trigger;
    private String Message = "not yet initiated";

    public Trigger(String projectid, String primarykey, BRRuleType ruletype, String databasetype, String target, String severity, String exceptionMessage, Map<String, String> tokens, List<String> trigger, String table) {
        this.target = target;
        this.severity = severity;
        this.ExceptionMessage = exceptionMessage;
        this.tokens = tokens;
        this.trigger = trigger;
        this.table = table;
        this.databasetype = databasetype;
        this.ruletype = ruletype;
        this.name = new NameGen(ruletype.getShortname(), databasetype);
        this.manager = new TemplateService();
        this.projectid = projectid;
        this.primarykey = primarykey;
    }

    @Override
    public String getCode() {
        String result = manager.getTriggerCode(trigger, name.toString(), table, databasetype);
        result += ruletype.getTriggerCode();
        if (severity == "Warning") {
            result += manager.getWarningCode(tokens, ExceptionMessage, databasetype);
        }else {
            result += manager.getErrorCode(tokens, ExceptionMessage, databasetype);
        }
        return result;
    }

    @Override
    public String getMessage() {
        return Message;
    }
}
