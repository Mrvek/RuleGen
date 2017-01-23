package domainGeneric.Template;

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

    public Template(String triggerCode, String warningCode, String errorCode, String constraintCode, String ruleTypeCompareConstraintCode, String ruleTypeCompareTriggerCode, String ruleTypeRangeConstraintCode, String ruleTypeRangeTriggerCode, Map<String, String> operatorTraslations) {
        this.triggerCode = triggerCode;
        this.warningCode = warningCode;
        this.errorCode = errorCode;
        this.constraintCode = constraintCode;
        this.ruleTypeCompareConstraintCode = ruleTypeCompareConstraintCode;
        this.ruleTypeCompareTriggerCode = ruleTypeCompareTriggerCode;
        this.ruleTypeRangeConstraintCode = ruleTypeRangeConstraintCode;
        this.ruleTypeRangeTriggerCode = ruleTypeRangeTriggerCode;
        this.operatorTraslations = operatorTraslations;
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

    public String getRuleTypeCompareConstraintCode(String first, String operator, String second) {
        String result = ruleTypeCompareConstraintCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\?", first);
        result = result.replaceFirst("\\?", operator);
        result = result.replaceFirst("\\?", second);
        return result;
    }


    public String getRuleTypeCompareTriggerCode(String first, String operator, String second) {
        String result = ruleTypeCompareTriggerCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\?", operator);
        result = result.replaceFirst("\\?", first);
        result = result.replaceFirst("\\?", second);
        return result;
    }

    public String getRuleTypeRangeConstraintCode(String first, String operator, String second) {
        String result = ruleTypeRangeConstraintCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\?", first);
        result = result.replaceFirst("\\?", operator);
        result = result.replaceFirst("\\?", second);
        return result;
    }

    public String getRuleTypeRangeTriggerCode(String first, String operator, String second, String target) {
        String result = ruleTypeRangeTriggerCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\?", target);
        result = result.replaceFirst("\\?", operator);
        result = result.replaceFirst("\\?", first);
        result = result.replaceFirst("\\?", second);
        return result;
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
