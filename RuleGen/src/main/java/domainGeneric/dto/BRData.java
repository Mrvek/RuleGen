package domainGeneric.dto;

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
    private int primarykey;
    private String databasetype;
    private String target;
    private String tablename;
    private String databaseshortname;
    private String BRRuleType;
    private List<String> values;
    private String operator; 
    private String comparisonTarget;

    public BRData(String triggerMoment, String severity, String exceptionMessage, Map<String, String> tokens, int primarykey, String databasetype, String target, String tablename, String databaseshortname, String BRRuleType, List<String> values, String operator, String comparisonTarget) {
        this.triggerMoment = triggerMoment;
        this.severity = severity;
        this.exceptionMessage = exceptionMessage;
        this.tokens = tokens;
        this.primarykey = primarykey;
        this.databasetype = databasetype;
        this.target = target;
        this.tablename = tablename;
        this.databaseshortname = databaseshortname;
        this.BRRuleType = BRRuleType;
        this.values = values;
        this.operator = operator;
        this.comparisonTarget = comparisonTarget;
    }

    public BRData() {
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

    public int getPrimarykey() {
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

    public List<String> getValues() {
        return values;
    }

    public String getOperator() {
        return operator;
    }

    public String getComparisonTarget() {
        return comparisonTarget;
    }

    public String getValue(int i) {
        return values.get(i);
    }

    public void setTriggerMoment(String triggerMoment) {
        this.triggerMoment = triggerMoment;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public void setTokens(Map<String, String> tokens) {
        this.tokens = tokens;
    }

    public void setPrimarykey(int primarykey) {
        this.primarykey = primarykey;
    }

    public void setDatabasetype(String databasetype) {
        this.databasetype = databasetype;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public void setDatabaseshortname(String databaseshortname) {
        this.databaseshortname = databaseshortname;
    }

    public void setBRRuleType(String BRRuleType) {
        this.BRRuleType = BRRuleType;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setComparisonTarget(String comparisonTarget) {
        this.comparisonTarget = comparisonTarget;
    }
    
    
}
