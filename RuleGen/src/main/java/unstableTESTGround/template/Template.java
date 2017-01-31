package unstableTESTGround.template;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Template {
    private boolean packageSupport;
    private String triggerCode;
    private String warningCode;
    private String errorCode;
    private String constraintCode;
    private String ruleTypeCompareConstraintCode;
    private String ruleTypeCompareTriggerCode;
    private String ruleTypeRangeConstraintCode;
    private String ruleTypeRangeTriggerCode;
    private Map<String, String> operatorTranslations;
    private String ruleTypeOtherConstraintCode;
    private String ruleTypeOtherTriggerCode;
    private String ruleTypeListConstraintCode;
    private String ruleTypeListTriggerCode;
    private String deleteMomentCode;
    private String updateMomentCode;
    private String insertMomentCode;
    private String triggerStartCode;
    private String triggerDeclarationCode;
    private String packageHeaderStartCode;
    private String packageEndCode;
    private String packageBodyStartCode;
    private String packageBodyEndCode;
    private String procedureSpecification;
    private String triggerEndCode;
    private String procedureExcecutionCode;
    private String exceptionExceptStartCode;
    private String exceptionExceptErrorCode;
    private String exceptionRaiseErrorCode;
    private String exceptionWarningCode;
    private String exceptionRaiseWarningCode;
    private String addStringTExceptionStackCode;
    private String exceptionParameters;
    private String exceptionTriggerDeclarationCode;
    private String procedureBodyStartCode;
    private String procedureBodyDeclarationCode;
    private String procedureBodyEndCode;
    private String ruleTypeACMPCode;
    private String parameterRuleTypeLSTCode;
    private String parameterRuleTypeOTHCode;
    private String parameterRuleTypeRNGCode;

    public Template(boolean packageSupport, String triggerCode, String warningCode, String errorCode, String constraintCode, String ruleTypeCompareConstraintCode, String ruleTypeCompareTriggerCode, String ruleTypeRangeConstraintCode, String ruleTypeRangeTriggerCode, Map<String, String> operatorTranslations, String ruleTypeOtherConstraintCode, String ruleTypeOtherTriggerCode, String ruleTypeListConstraintCode, String ruleTypeListTriggerCode, String deleteMomentCode, String updateMomentCode, String insertMomentCode, String triggerStartCode, String triggerDeclarationCode, String packagHeaderStartCode, String packagEndCode, String pakageBodyStartCode, String packageBodyEndCode, String procedureSpecification, String triggerEndCode, String procedureExcecutionCode, String exceptionExceptStartCode, String exceptionExceptErrorCode, String exceptionRaiseErrorCode, String exceptionWarningCode, String exceptionRaiseWarningCode, String addStringTExceptionStackCode, String exceptionParameters, String exceptionTrigerDeclarationCode, String procedureBodyStartCode, String procedureBodyDeclarationCode, String procedureBodyEndCode, String ruleTypeACMPCode, String parameterRuleTypeLSTCode, String parameterRuleTypeOTHCode, String parameterRuleTypeRNGCode) {
        this.packageSupport = packageSupport;
        this.triggerCode = triggerCode;
        this.warningCode = warningCode;
        this.errorCode = errorCode;
        this.constraintCode = constraintCode;
        this.ruleTypeCompareConstraintCode = ruleTypeCompareConstraintCode;
        this.ruleTypeCompareTriggerCode = ruleTypeCompareTriggerCode;
        this.ruleTypeRangeConstraintCode = ruleTypeRangeConstraintCode;
        this.ruleTypeRangeTriggerCode = ruleTypeRangeTriggerCode;
        this.operatorTranslations = operatorTranslations;
        this.ruleTypeOtherConstraintCode = ruleTypeOtherConstraintCode;
        this.ruleTypeOtherTriggerCode = ruleTypeOtherTriggerCode;
        this.ruleTypeListConstraintCode = ruleTypeListConstraintCode;
        this.ruleTypeListTriggerCode = ruleTypeListTriggerCode;
        this.deleteMomentCode = deleteMomentCode;
        this.updateMomentCode = updateMomentCode;
        this.insertMomentCode = insertMomentCode;
        this.triggerStartCode = triggerStartCode;
        this.triggerDeclarationCode = triggerDeclarationCode;
        this.packageHeaderStartCode = packagHeaderStartCode;
        this.packageEndCode = packagEndCode;
        this.packageBodyStartCode = pakageBodyStartCode;
        this.packageBodyEndCode = packageBodyEndCode;
        this.procedureSpecification = procedureSpecification;
        this.triggerEndCode = triggerEndCode;
        this.procedureExcecutionCode = procedureExcecutionCode;
        this.exceptionExceptStartCode = exceptionExceptStartCode;
        this.exceptionExceptErrorCode = exceptionExceptErrorCode;
        this.exceptionRaiseErrorCode = exceptionRaiseErrorCode;
        this.exceptionWarningCode = exceptionWarningCode;
        this.exceptionRaiseWarningCode = exceptionRaiseWarningCode;
        this.addStringTExceptionStackCode = addStringTExceptionStackCode;
        this.exceptionParameters = exceptionParameters;
        this.exceptionTriggerDeclarationCode = exceptionTrigerDeclarationCode;
        this.procedureBodyStartCode = procedureBodyStartCode;
        this.procedureBodyDeclarationCode = procedureBodyDeclarationCode;
        this.procedureBodyEndCode = procedureBodyEndCode;
        this.ruleTypeACMPCode = ruleTypeACMPCode;
        this.parameterRuleTypeLSTCode = parameterRuleTypeLSTCode;
        this.parameterRuleTypeOTHCode = parameterRuleTypeOTHCode;
        this.parameterRuleTypeRNGCode = parameterRuleTypeRNGCode;
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


    public String getRuleTypeACMPProcedureCode(String target, String operator, String compareWith) {
        String result = ruleTypeCompareTriggerCode;
        operator = this.translateOperator(operator);
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

    public String getRuleTypeRNGProcedureCode(String first, String operator, String second, String target) {
        String result = ruleTypeRangeTriggerCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{Target}", target);
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

    public String getRuleTypeOTHProcedureCode(String booleanStatement) {
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

    public String getRuleTypeLSTProcedureCode(String target, String operator, List<String> values) {
        operator = translateOperator(operator);
        String result = ruleTypeListTriggerCode;
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
        for (String i : operatorTranslations.keySet()) {
            if (i.equals(operator)) {
                result = operatorTranslations.get(i);
            }
        }
        return result;
    }

    public String getDeleteMomentCode() {
        return deleteMomentCode;
    }

    public String getUpdateMomentCode() {
        return updateMomentCode;
    }

    public String getInsertMomentCode() {
        return insertMomentCode;
    }

    public String getTriggerStartCode() {
        return triggerStartCode;
    }

    public String getTriggerDeclarationCode() {
        return triggerDeclarationCode;
    }

    public String getPackagHeaderStartCode(String name) {
        return packageHeaderStartCode;
    }

    public String getPackagEndCode(String name) {
        return packageEndCode;
    }

    public boolean checkPackageSupport() {
        return packageSupport;
    }

    public String getPakageBodyStartCode(String name) {
        return packageBodyStartCode;
    }

    public String getPackageBodyEndCode(String name) {
        return packageBodyEndCode;
    }

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode) {
        return procedureSpecification;
    }

    public String getTriggerEndCode() {
        return triggerEndCode;
    }

    public String getProcedureExcecutionCode(String name, String target, String exceptionParameters) {
        return procedureExcecutionCode;
    }

    public String getExceptionExceptStartCode() {
        return exceptionExceptStartCode;
    }

    public String getExceptionExceptErrorCode(String errorStackName, String errorExceptionName) {
        return exceptionExceptErrorCode;
    }

    public String getExceptionRaiseErrorCode(String errorStackName, String errorExceptionName) {
        return exceptionRaiseErrorCode;
    }

    public String getExceptionWarningCode(String errorStackName, String errorExceptionName) {
        return exceptionWarningCode;
    }

    public String getExceptionRaiseWarningCode(String warningStackName, String warningExceptionName) {
        return exceptionRaiseWarningCode;
    }

    public String getAddStringTExceptionStackCode(String exceptionStackName, String message, Map<String, String> tokens) {
        return addStringTExceptionStackCode;
    }

    public String getExceptionParameters(String warningStackName, String errorStackName) {
        return exceptionParameters;
    }

    public String getExceptionTrigerDeclarationCode(String warningStackName, String warningExceptionName, String errorStackName, String errorExceptionName) {
        return exceptionTriggerDeclarationCode;
    }

    public String getProcedureBodyStartCode(String name) {
        return procedureBodyStartCode;
    }

    public String getProcedureBodyDeclarationCode(String passedName) {
        return procedureBodyDeclarationCode;
    }

    public String getProcedureBodyEndCode(String name) {
        return procedureBodyEndCode;
    }

    public String getRuleTypeACMPCode(String target) {
        return ruleTypeACMPCode;
    }

    public String getParameterRuleTypeLSTCode(String target) {
        return parameterRuleTypeLSTCode;
    }

    public String getParameterRuleTypeOTHCode(String target) {
        return parameterRuleTypeOTHCode;
    }

    public String getParameterRuleTypeRNGCode(String target) {
        return parameterRuleTypeRNGCode;
    }
}
