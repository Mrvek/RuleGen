package dataAccess.dto.template;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Template {
    private String triggerCode;
    private String warningCode;
    private String errorCode;
    private String constraintCode;
    private String ruleTypeCompareConstraintCode;
    private String ruleTypeCompareTriggerCode;
    private String ruleTypeRangeConstraintCode;
    private String ruleTypeRangeTriggerCode;
    private Map<String, String> operatorTraslations;
    private String ruleTypeOtherConstraintCode;
    private String ruleTypeOtherTriggerCode;
    private String ruleTypeListConstraintCode;
    private String ruleTypeListTriggerCode;

    public Template(String triggerCode, String warningCode, String errorCode, String constraintCode, String ruleTypeCompareConstraintCode, String ruleTypeCompareTriggerCode, String ruleTypeRangeConstraintCode, String ruleTypeRangeTriggerCode, Map<String, String> operatorTraslations, String ruleTypeOtherConstraintCode, String ruleTypeOtherTriggerCode, String ruleTypeListConstraintCode, String ruleTypeListTriggerCode) {
        this.triggerCode = triggerCode;
        this.warningCode = warningCode;
        this.errorCode = errorCode;
        this.constraintCode = constraintCode;
        this.ruleTypeCompareConstraintCode = ruleTypeCompareConstraintCode;
        this.ruleTypeCompareTriggerCode = ruleTypeCompareTriggerCode;
        this.ruleTypeRangeConstraintCode = ruleTypeRangeConstraintCode;
        this.ruleTypeRangeTriggerCode = ruleTypeRangeTriggerCode;
        this.operatorTraslations = operatorTraslations;
        this.ruleTypeOtherConstraintCode = ruleTypeOtherConstraintCode;
        this.ruleTypeOtherTriggerCode = ruleTypeOtherTriggerCode;
        this.ruleTypeListConstraintCode = ruleTypeListConstraintCode;
        this.ruleTypeListTriggerCode = ruleTypeListTriggerCode;
    }

    public String getTriggerCode(String triggerName, List<String> triggermoment, String tableName) {
        String result = triggerCode;
        result = result.replaceFirst("\\?", triggerName);
        String trigger = null;
        for (String t : triggermoment) {
            if (trigger == null || trigger.isEmpty()) {
                trigger = t;
            }else {
                trigger += ", " + t;
            }
        }
        result = result.replaceFirst("\\?", trigger);
        result = result.replaceFirst("\\?", tableName);
        return result;
    }

    public String getWarningCode(String message, Map<String, String> tokens) {
        String result = warningCode;
        String mymessage = message;
        for (String id : tokens.keySet()) {
            mymessage = mymessage.replace(id, tokens.get(id));
        }
        result = result.replaceFirst("\\?", mymessage);
        return result;
    }

    public String getErrorCode(String message, Map<String, String> tokens) {
        String result = errorCode;
        String mymessage = message;
        for (String id : tokens.keySet()) {
            mymessage = mymessage.replace(id, tokens.get(id));
        }
        result = result.replaceFirst("\\?", mymessage);
        return result;
    }

    public String getConstraintCode(String tablename, String name, String rule, String target) {
        String result = constraintCode;
        result = result.replaceFirst("\\?", name);
        result = result.replaceFirst("\\?", tablename);
        result = result.replaceFirst("\\?", rule);
        return result;
    }

    public String getRuleTypeCompareConstraintCode(String target, String operator, String compareWith) {
        String result = ruleTypeCompareConstraintCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{Target}", target);
        result = result.replaceFirst("\\{Operator}", operator);
        result = result.replaceFirst("\\?", compareWith);
        return result;
    }


    public String getRuleTypeCompareTriggerCode(String table, String target, String operator, String compareWith) {
        String result = ruleTypeCompareTriggerCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{Table}", table);
        result = result.replaceFirst("\\{Operator}", operator);
        result = result.replaceFirst("\\{Target}", target);
        result = result.replaceFirst("\\?", compareWith);
        return result;
    }

    public String getRuleTypeRangeConstraintCode(String target , String first, String operator, String second) {
        String result = ruleTypeRangeConstraintCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{Target}", target);
        result = result.replaceFirst("\\{From}", first);
        result = result.replaceFirst("\\{Operator}", operator);
        result = result.replaceFirst("\\{To}", second);
        return result;
    }

    public String getRuleTypeRangeTriggerCode(String first, String operator, String second, String target, String table) {
        String result = ruleTypeRangeTriggerCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{Target}", target);
        result = result.replaceFirst("\\{Table}", table);
        result = result.replaceFirst("\\{Operator}", operator);
        result = result.replaceFirst("\\{From}", first);
        result = result.replaceFirst("\\{To}", second);
        return result;
    }

    public String getRuleTypeOtherConstraintCode(String booleanStatement) {
        String result = ruleTypeOtherConstraintCode;
        result = result.replaceFirst("\\?", booleanStatement);
        return result;
    }

    public String getRuleTypeOtherTriggerCode(String booleanStatement) {
        String result = ruleTypeOtherTriggerCode;
        result = result.replaceFirst("\\?", booleanStatement);
        return result;
    }

    public String getRuleTypeListConstraintCode(String target, List<String> values, String operator) {
        operator = translateOperator(operator);
        String result = ruleTypeListConstraintCode;
        result = result.replaceFirst("\\{Target}", target);
        result = result.replaceFirst("\\{Operator}", operator);
        String value = createValuesList(values);
        result = result.replaceFirst("\\?", value);
        return result;
    }

    public String getRuleTypeListTriggerCode(String table, String target, String operator, List<String> values) {
        operator = translateOperator(operator);
        String result = ruleTypeListTriggerCode;
        result = result.replaceFirst("\\{Table}", table);
        result = result.replaceFirst("\\{Target}", target);
        result = result.replaceFirst("\\{Operator}", operator);
        String value = createValuesList(values);
        result = result.replaceFirst("\\?", value);
        return result;
    }

    private String createValuesList(List<String> values) {
        String value = "";
        for (String V : values) {
            if (value.isEmpty()) {
                value += V;
            }else {
                value += "," + V;
            }
        }
        return value;
    }

    private String translateOperator(String operator) {
        String result = operator;
        for (String i : operatorTraslations.keySet()) {
            if (i.equals(operator)) {
                result = operatorTraslations.get(i);
            }
        }
        return result;
    }
}
