package dataAccess.toolsDB;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRDefinition {
    public String jdbc;
    public List<String> values;
    public String operator;
    public String databasetype;
    public String BRRuleType;
    public String target;
    public List<String> trigger;
    public String exceptionMessage;
    public Map<String, String> tokens;
    public String Severity;
    public String tablename;


    public BRDefinition(String jdbc, List<String> values, String operator, String databasetype, String BRRuleType, String target, List<String> trigger, String exceptionMessage, Map<String, String> tokens, String severity, String tablename) {
        this.jdbc = jdbc;
        this.values = values;
        this.operator = operator;
        this.databasetype = databasetype;
        this.BRRuleType = BRRuleType;
        this.target = target;
        this.trigger = trigger;
        this.exceptionMessage = exceptionMessage;
        this.tokens = tokens;
        Severity = severity;
        this.tablename = tablename;
    }
}
