package domainGeneric;

import domainGeneric.template.Template;
import domainGeneric.template.TemplateManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateService {
    private TemplateManager factory = new TemplateManager();

    public String getConstraintCode(String name, String table, String ruletypecode, String databasetype, String target) {
        return factory.getConstraintCode(name, table, ruletypecode,databasetype, target);
    }

    public String getRuleTypeCompareConstraintCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeCompareConstraintCode(databasetype, target, operator, compareWith);
    }

    public String getRuleTypeCompareTriggerCode(String databasetype, String Target, String operator, String compareWith) {
        return factory.getRuleTypeCompareTriggerCode(databasetype, Target, operator, compareWith);
    }

    public String getRuleTypeRangeConstraintCode(String databasetype, String target , String from, String operator, String to) {
        return factory.getRuleTypeRangeConstraintCode(databasetype, target , from, operator, to);
    }

    public String getRuleTypeRangeTriggerCode(String databasetype, String from, String operator, String to, String target) {
        return factory.getRuleTypeRangeTriggerCode(databasetype, from, operator, to, target);
    }

    public String getTriggerCode(List<String> trigger, String name, String table, String databasetype) {
        return factory.getTriggerCode(trigger, name, table, databasetype);
    }

    public String getWarningCode(Map<String, String> tokens, String exceptionMessage, String databasetype) {
        return factory.getWarningCode(tokens, exceptionMessage, databasetype);
    }

    public String getErrorCode(Map<String, String> tokens, String exceptionMessage, String databasetype) {
        return factory.getErrorCode(tokens, exceptionMessage, databasetype);
    }

    public String getRuleTypeOtherConstraintCode(String databasetype, String booleanStatement) {
        return factory.getRuleTypeOtherConstraintCode(databasetype, booleanStatement);
    }

    public String getRuleTypeOtherTriggerCode(String databasetype, String booleanStatement) {
        return factory.getRuleTypeOtherTriggerCode(databasetype, booleanStatement);
    }

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        return factory.getRuleTypeListConstraintCode(databasetype, target, values, operator);
    }

    public String getRuleTypeListTriggerCode(String databasetype, String target, String operator, List<String> values) {
        return factory.getRuleTypeListTriggerCode(databasetype, target, operator, values);
    }
}
