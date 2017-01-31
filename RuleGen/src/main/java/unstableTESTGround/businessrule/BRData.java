package unstableTESTGround.businessrule;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 30/01/2017.
 */
public class BRData {
    private List<String> triggerMoment;
    private String severity;
    private String exceptionMessage;
    private Map<String, String> tokens;
    private String primarykey;
    private String databasetype;
    private String target;
    private String tablename;
    private String databaseshortname;
    private String BRRuleType;
    private List<String> values;
    private String operator;

    public List<String> getTriggerMoment() {
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

    public List<String> getValues() {
        return values;
    }

    public String getOperator() {
        return operator;
    }
}