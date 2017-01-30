package unstableTESTGround.businessrule;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 30/01/2017.
 */
public class BRData {
    private String triggerMoment;
    private String severity;
    private String exceptionMessage;
    private Map<String, String> tokens;
    private List<String> trigger;
    private String primarykey;
    private String databasetype;
    private String target;
    private String tablename;
    private String databaseshortname;
    private String BRRuleType;
    private List<String> values;
    private String operator;


    public BRData(String triggerMoment, String severity, String exceptionMessage, Map<String, String> tokens, List<String> trigger, String primarykey, String databasetype, String target, String tablename, String databaseshortname, String BRRuleType, List<String> values, String operator) {
        this.triggerMoment = triggerMoment;
        this.severity = severity;
        this.exceptionMessage = exceptionMessage;
        this.tokens = tokens;
        this.trigger = trigger;
        this.primarykey = primarykey;
        this.databasetype = databasetype;
        this.target = target;
        this.tablename = tablename;
        this.databaseshortname = databaseshortname;
        this.BRRuleType = BRRuleType;
        this.values = values;
        this.operator = operator;
    }

    public String getTriggerMoment() {
        return triggerMoment;
    }

    public String getSeverity() {
        return severity;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public Map<String, String> getTokens() {
        return tokens;
    }

    public List<String> getTrigger() {
        return trigger;
    }

    public String getPrimarykey() {
        return primarykey;
    }

    public String getDatabasetype() {
        return databasetype;
    }

    public String getTarget() {
        return target;
    }

    public String getTablename() {
        return tablename;
    }

    public String getDatabaseshortname() {
        return databaseshortname;
    }

    public String getBRRuleType() {
        return BRRuleType;
    }

    public String getValue(int i) {
        return values.get(i);
    }

    public String getOperator() {
        return operator;
    }

    public List<String> getValues() {
        return values;
    }
}
