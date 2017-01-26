package domainGeneric.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class TemplateManager {
    static private Map<String, Template> templates = new HashMap<>();

    static void addTemplate(String DBType, Template template) {
        templates.put(DBType, template);
    }

    static void resetTemplates() {
        templates.clear();
    }


    public String getConstraintCode(String name, String table, String ruletypecode, String databasetype, String target) {
        Template t = templates.get(databasetype);
        return t.getConstraintCode(name, table, ruletypecode, target);
    }

    public String getRuleTypeCompareConstraintCode(String databasetype, String target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeCompareConstraintCode(target, operator, compareWith);
    }

    public String getRuleTypeCompareTriggerCode(String databasetype, String Target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeCompareTriggerCode(Target, operator, compareWith);
    }

    public String getRuleTypeRangeConstraintCode(String databasetype, String target , String from, String operator, String to) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeRangeConstraintCode(target , from, operator, to);
    }

    public String getRuleTypeRangeTriggerCode(String databasetype, String from, String operator, String to, String target) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeRangeTriggerCode(from, operator, to, target);
    }

    public String getTriggerCode(List<String> trigger, String name, String table, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getTriggerCode(name, trigger, table);
    }

    public String getWarningCode(Map<String, String> tokens, String exceptionMessage, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getWarningCode(exceptionMessage, tokens);
    }

    public String getErrorCode(Map<String, String> tokens, String exceptionMessage, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getErrorCode(exceptionMessage, tokens);
    }

    public static List<String> getTemplateNames() {
        List<String> names = new ArrayList<>();
        names.addAll(templates.keySet());
        return names;
    }

    public String getRuleTypeOtherConstraintCode(String databasetype, String booleanStatement) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeOtherConstraintCode(booleanStatement);
    }

    public String getRuleTypeOtherTriggerCode(String databasetype, String booleanStatement) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeOtherTriggerCode(booleanStatement);
    }

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeListConstraintCode(target, values, operator);
    }

    public String getRuleTypeListTriggerCode(String databasetype, String target, String operator, List<String> values) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeListTriggerCode(target, operator, values);
    }
}
