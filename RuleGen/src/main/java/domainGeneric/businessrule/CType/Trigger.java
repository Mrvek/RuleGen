package domainGeneric.businessrule.CType;

import domainGeneric.businessrule.NameGen;
import domainGeneric.businessrule.ruletype.BRRuleType;
import domainGeneric.TemplateService;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Trigger extends CodeType {
    private String severity;
    private String ExceptionMessage;
    private Map<String, String> tokens;
    private List<String> trigger;

    public Trigger(String primarykey, String projectid, BRRuleType ruletype, String databasetype, String target, String table, String severity, String exceptionMessage, Map<String, String> tokens, List<String> trigger) {
        super(primarykey, projectid, ruletype, databasetype, target, table, new NameGen(ruletype.getShortname(), databasetype), "TRG", new TemplateService());
        this.severity = severity;
        ExceptionMessage = exceptionMessage;
        this.tokens = tokens;
        this.trigger = trigger;
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
        Message = "Code Generated";
        return result;
    }

    public String getDeclerationCode() {
        return "HELLO WORLD";
    }

    public String getValidationCode() {
        return null;
    }

    public String getExceptionCode() {
        return null;
    }
}
