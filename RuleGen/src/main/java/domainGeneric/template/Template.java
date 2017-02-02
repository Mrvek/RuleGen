package domainGeneric.template;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Template {
    private boolean packageSupport;
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
    private String addStringToExceptionStackCode;
    private String exceptionParameters;
    private String exceptionTriggerDeclarationCode;
    private String procedureBodyStartCode;
    private String procedureBodyDeclarationCode;
    private String procedureBodyEndCode;
    private String ruleTypeACMPCode;
    private String parameterRuleTypeLSTCode;
    private String parameterRuleTypeOTHCode;
    private String parameterRuleTypeRNGCode;
    private String parameterRuleTypeTOTHCode;
    private String ruleTypeTOTHProcedureCode;
    private String ruleTypeTCMPProcedureCode;
    private String ruleTypeTCMPConstraintCode;
    private String parameterRuleTypeMODICode;
    private String ruleTypeMODIProcedureCode;
    private String parameterRuleTypeICMPCode;
    private String parameterRuleTypeTCMPCode;
    private String ruleTypeICMPProcedureCode;
    private String parameterRuleTypeEOTHCode;
    private String ruleTypeEOTHProcedureCode;

    public Template(boolean packageSupport, String constraintCode, String deleteMomentCode, String updateMomentCode, String insertMomentCode, String triggerStartCode, String triggerDeclarationCode, String packageHeaderStartCode, String packageEndCode, String packageBodyStartCode, String packageBodyEndCode, String procedureSpecification, String triggerEndCode, String procedureExcecutionCode, String exceptionExceptStartCode, String exceptionExceptErrorCode, String exceptionRaiseErrorCode, String exceptionWarningCode, String exceptionRaiseWarningCode, String addStringToExceptionStackCode, String exceptionParameters, String exceptionTriggerDeclarationCode, String procedureBodyStartCode, String procedureBodyDeclarationCode, String procedureBodyEndCode) {
        this.packageSupport = packageSupport;
        this.constraintCode = constraintCode;
        this.deleteMomentCode = deleteMomentCode;
        this.updateMomentCode = updateMomentCode;
        this.insertMomentCode = insertMomentCode;
        this.triggerStartCode = triggerStartCode;
        this.triggerDeclarationCode = triggerDeclarationCode;
        this.packageHeaderStartCode = packageHeaderStartCode;
        this.packageEndCode = packageEndCode;
        this.packageBodyStartCode = packageBodyStartCode;
        this.packageBodyEndCode = packageBodyEndCode;
        this.procedureSpecification = procedureSpecification;
        this.triggerEndCode = triggerEndCode;
        this.procedureExcecutionCode = procedureExcecutionCode;
        this.exceptionExceptStartCode = exceptionExceptStartCode;
        this.exceptionExceptErrorCode = exceptionExceptErrorCode;
        this.exceptionRaiseErrorCode = exceptionRaiseErrorCode;
        this.exceptionWarningCode = exceptionWarningCode;
        this.exceptionRaiseWarningCode = exceptionRaiseWarningCode;
        this.addStringToExceptionStackCode = addStringToExceptionStackCode;
        this.exceptionParameters = exceptionParameters;
        this.exceptionTriggerDeclarationCode = exceptionTriggerDeclarationCode;
        this.procedureBodyStartCode = procedureBodyStartCode;
        this.procedureBodyDeclarationCode = procedureBodyDeclarationCode;
        this.procedureBodyEndCode = procedureBodyEndCode;
    }

    public Template(boolean packageSupport, String constraintCode, String ruleTypeCompareConstraintCode, String ruleTypeCompareTriggerCode, String ruleTypeRangeConstraintCode, String ruleTypeRangeTriggerCode, Map<String, String> operatorTranslations, String ruleTypeOtherConstraintCode, String ruleTypeOtherTriggerCode, String ruleTypeListConstraintCode, String ruleTypeListTriggerCode, String deleteMomentCode, String updateMomentCode, String insertMomentCode, String triggerStartCode, String triggerDeclarationCode, String packagHeaderStartCode, String packagEndCode, String pakageBodyStartCode, String packageBodyEndCode, String procedureSpecification, String triggerEndCode, String procedureExcecutionCode, String exceptionExceptStartCode, String exceptionExceptErrorCode, String exceptionRaiseErrorCode, String exceptionWarningCode, String exceptionRaiseWarningCode, String addStringTExceptionStackCode, String exceptionParameters, String exceptionTrigerDeclarationCode, String procedureBodyStartCode, String procedureBodyDeclarationCode, String procedureBodyEndCode, String ruleTypeACMPCode, String parameterRuleTypeLSTCode, String parameterRuleTypeOTHCode, String parameterRuleTypeRNGCode) {
        this.packageSupport = packageSupport;
        this.constraintCode = constraintCode;
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
        this.addStringToExceptionStackCode = addStringTExceptionStackCode;
        this.exceptionParameters = exceptionParameters;
        this.exceptionTriggerDeclarationCode = exceptionTrigerDeclarationCode;
        this.procedureBodyStartCode = procedureBodyStartCode;
        this.procedureBodyDeclarationCode = procedureBodyDeclarationCode;
        this.procedureBodyEndCode = procedureBodyEndCode;

        this.ruleTypeACMPCode = ruleTypeACMPCode;
        this.parameterRuleTypeLSTCode = parameterRuleTypeLSTCode;
        this.parameterRuleTypeOTHCode = parameterRuleTypeOTHCode;
        this.parameterRuleTypeRNGCode = parameterRuleTypeRNGCode;
        this.ruleTypeCompareConstraintCode = ruleTypeCompareConstraintCode;
        this.ruleTypeCompareTriggerCode = ruleTypeCompareTriggerCode;
        this.ruleTypeRangeConstraintCode = ruleTypeRangeConstraintCode;
        this.ruleTypeRangeTriggerCode = ruleTypeRangeTriggerCode;
        this.operatorTranslations = operatorTranslations;
        this.ruleTypeOtherConstraintCode = ruleTypeOtherConstraintCode;
        this.ruleTypeOtherTriggerCode = ruleTypeOtherTriggerCode;
        this.ruleTypeListConstraintCode = ruleTypeListConstraintCode;
        this.ruleTypeListTriggerCode = ruleTypeListTriggerCode;
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
        result = result.replaceFirst("\\{target}", target);
        result = result.replaceFirst("\\{operator}", operator);
        result = result.replaceFirst("\\?", compareWith);
        return result;
    }


    public String getRuleTypeACMPProcedureCode(String target, String operator, String compareWith) {
        String result = ruleTypeCompareTriggerCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{operator}", operator);
        result = result.replaceFirst("\\{target}", target);
        result = result.replaceFirst("\\?", compareWith);
        return result;
    }

    public String getRuleTypeRangeConstraintCode(String target, String first, String operator, String second) {
        String result = ruleTypeRangeConstraintCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{target}", target);
        result = result.replaceFirst("\\{from}", first);
        result = result.replaceFirst("\\{operator}", operator);
        result = result.replaceFirst("\\{to}", second);
        return result;
    }

    public String getRuleTypeRNGProcedureCode(String first, String operator, String second, String target) {
        String result = ruleTypeRangeTriggerCode;
        operator = this.translateOperator(operator);
        result = result.replaceFirst("\\{target}", target);
        result = result.replaceFirst("\\{operator}", operator);
        result = result.replaceFirst("\\{from}", first);
        result = result.replaceFirst("\\{to}", second);
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
        result = result.replaceFirst("\\{target}", target);
        result = result.replaceFirst("\\{operator}", operator);
        String value = createValuesList(values);
        result = result.replaceFirst("\\?", value);
        return result;
    }

    public String getRuleTypeLSTProcedureCode(String target, String operator, List<String> values) {
        operator = translateOperator(operator);
        String result = ruleTypeListTriggerCode;
        result = result.replaceFirst("\\{target}", target);
        result = result.replaceFirst("\\{operator}", operator);
        String value = createValuesList(values);
        result = result.replaceFirst("\\?", value);
        return result;
    }

    private String createValuesList(List<String> values) {
        String value = "";
        for (String V : values) {
            if (value.isEmpty()) {
                value += V;
            } else {
                value += "," + V;
            }
        }
        return value;
    }

    private String translateOperator(String operator) {
        String result = operator;
        if (operatorTranslations != null) {
            for (String i : operatorTranslations.keySet()) {
                if (i.equals(operator)) {
                    result = operatorTranslations.get(i);
                }
            }
        }

        return result;
    }

//    TODO: return code with the values replaced( values in template are   ?    names and other strings are      {name}

    public String getDeleteMomentCode() {
        return deleteMomentCode;
    }

    public String getUpdateMomentCode() {
        return updateMomentCode;
    }

    public String getInsertMomentCode() {
        return insertMomentCode;
    }

    public String getTriggerStartCode(String name, String table) {
        String code = triggerStartCode;
        code = code.replaceAll("\\{name}", name);
        code = code.replaceAll("\\{table}", table);
        return code;
    }

    public String getTriggerDeclarationCode() {
        return triggerDeclarationCode;
    }

    public String getPackagHeaderStartCode(String name) {
        String code = packageHeaderStartCode;
        code = code.replaceAll("\\{name}", name);
        return code;
    }

    public String getPackagEndCode(String name) {
        String code = packageEndCode;
        code = code.replaceAll("\\{name}", name);
        return code;
    }

    public boolean checkPackageSupport() {
        return packageSupport;
    }

    public String getPakageBodyStartCode(String name) {
        String code = packageBodyStartCode;
        code = code.replaceAll("\\{name}", name);
        return code;
    }

    public String getPackageBodyEndCode(String name) {
        String code = packageBodyEndCode;
        code = code.replaceAll("\\{name}", name);
        return code;
    }

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode) {
        String code = procedureSpecification;
        code = code.replaceAll("\\{name}", name);
        code = code.replaceAll("\\{exceptionParameters}", exceptionProcedureDeclarations);
        code = code.replaceAll("\\{codeParameters}", parameterCode);
        return code;
    }

    public String getTriggerEndCode() {
        return triggerEndCode;
    }

    public String getProcedureExcecutionCode(String name, String target, String exceptionParameters) {
        String code = procedureExcecutionCode;
        code = code.replaceAll("\\{name}", name);
        code = code.replaceAll("\\{attribute}", target);
        code = code.replaceAll("\\{exceptionParameters}", exceptionParameters);
        return code;
    }

    public String getExceptionExceptStartCode() {
        return exceptionExceptStartCode;
    }

    public String getExceptionExceptErrorCode(String errorStackName, String errorExceptionName) {
        String code = exceptionExceptErrorCode;
        code = code.replaceAll("\\{errorStack}", errorStackName);
        code = code.replaceAll("\\{errorException}", errorExceptionName);
        return code;
    }

    public String getExceptionRaiseErrorCode(String errorStackName, String errorExceptionName) {
        String code = exceptionRaiseErrorCode;
        code = code.replaceAll("\\{errorStack}", errorStackName);
        code = code.replaceAll("\\{errorException}", errorExceptionName);
        return code;
    }

    public String getExceptionWarningCode(String errorStackName, String errorExceptionName) {
        String code = exceptionWarningCode;
        code = code.replaceAll("\\{warningStack}", errorStackName);
        code = code.replaceAll("\\{warningException}", errorExceptionName);
        return code;
    }

    public String getExceptionRaiseWarningCode(String warningStackName, String warningExceptionName) {
        String code = exceptionRaiseWarningCode;
        code = code.replaceAll("\\{warningStack}", warningStackName);
        code = code.replaceAll("\\{warningException}", warningExceptionName);
        return code;
    }

    public String getAddStringTExceptionStackCode(String exceptionStackName, String message, Map<String, String> tokens) {
        String code = addStringToExceptionStackCode;
        code = code.replaceAll("\\{exceptionStack}", exceptionStackName);
        String mymessage = message;
        for (String id : tokens.keySet()) {
            mymessage = mymessage.replace(id, tokens.get(id));
        }
        code = code.replaceAll("\\{message}", mymessage);
        return code;
    }

    public String getExceptionParameters(String warningStackName, String errorStackName) {
        String code = exceptionParameters;
        code = code.replaceAll("\\{warningStack}", warningStackName);
        code = code.replaceAll("\\{errorStack}", errorStackName);
        return code;
    }

    public String getExceptionTrigerDeclarationCode(String warningStackName, String warningExceptionName, String errorStackName, String errorExceptionName) {
        String code = exceptionTriggerDeclarationCode;
        code = code.replaceAll("\\{warningException}", warningExceptionName);
        code = code.replaceAll("\\{errorException}", errorExceptionName);
        code = code.replaceAll("\\{warningStack}", warningStackName);
        code = code.replaceAll("\\{errorStack}", errorStackName);
        return code;
    }

    public String getProcedureBodyStartCode(String name) {
        String code = procedureBodyStartCode;
        code = code.replaceAll("\\{name}", name);
        return code;
    }

    public String getProcedureBodyDeclarationCode(String passedName) {
        String code = procedureBodyDeclarationCode;
        code = code.replaceAll("\\{checkName}", passedName);
        return code;
    }

    public String getProcedureBodyEndCode(String name) {
        String code = procedureBodyEndCode;
        code = code.replaceAll("\\{name}", name);
        return code;
    }

    public String getRuleTypeACMPCode(String target) {
        String code = ruleTypeACMPCode;
        code = code.replaceAll("\\{attribute}", target);
        return code;
    }

    public String getParameterRuleTypeLSTCode(String target) {
        String code = parameterRuleTypeLSTCode;
        code = code.replaceAll("\\{attribute}", target);
        return code;
    }

    public String getParameterRuleTypeOTHCode(String target) {
        String code = parameterRuleTypeOTHCode;
        code = code.replaceAll("\\{attribute}", target);
        return code;
    }

    public String getParameterRuleTypeRNGCode(String target) {
        String code = parameterRuleTypeRNGCode;
        code = code.replaceAll("\\{attribute}", target);
        return code;
    }

    public String getParameterRuleTypeTOTHCode(String target) {
        String code =  parameterRuleTypeTOTHCode;
        code = code.replaceAll("\\{atttribute}", target);
        return code;
    }

    public String getRuleTypeTOTHProcedureCode(String target, String operator, String compareWith) {
        String code = ruleTypeTOTHProcedureCode;
        code = code.replaceAll("\\{code}", compareWith);
        code = code.replaceAll("\\{target}", target);
        code = code.replaceAll("\\{operator}", operator);
        return code;
    }

    public String getRuleTypeTCMPProcedureCode(String target, String operator, String compareWith) {
        String code =  ruleTypeTCMPProcedureCode;
        code = code.replaceAll("\\{target}", target);
        code = code.replaceAll("\\{operator}", operator);
        code = code.replaceAll("\\{comparison}", compareWith);
        return code;
    }

    public String getRuleTypeTCMPConstraintCode(String target, String operator, String compareWith) {
        String code = ruleTypeTCMPConstraintCode;
        code = code.replaceAll("\\{target}", target);
        code = code.replaceAll("\\{operator}", operator);
        code = code.replaceAll("\\{comparison}", compareWith);
        return code;
    }

    public String getParameterRuleTypeMODICode(String target, String compareWithColumn) {
        String code = parameterRuleTypeMODICode;
        code = code.replaceAll("\\{attribute}", target);
        code = code.replaceAll("\\{code}", compareWithColumn);
        return code;
    }

    public String getRuleTypeMODIProcedureCode(String target, String operator, String compareWithColumn) {
        String code = ruleTypeMODIProcedureCode;
        code = code.replaceAll("\\{attribute}", target);
        code = code.replaceAll("\\{code}", compareWithColumn);
        return code;
    }

    public String getParameterRuleTypeICMPCode(String target, String compareWithTable, String compareWithColumn) {
        String code = parameterRuleTypeICMPCode;
        code = code.replaceAll("\\{attribute}", target);
        code = code.replaceAll("\\{compareTable}", compareWithTable);
        code = code.replaceAll("\\{compareAttribute}", compareWithColumn);
        return code;
    }

    public String getParameterRuleTypeTCMPCode(String target, String compareWithTable) {
        String code = parameterRuleTypeTCMPCode;
        code = code.replaceAll("\\{attribute}", target);
        code = code.replaceAll("\\{compareAttribute}", compareWithTable);
        return code;
    }

    public String getRuleTypeICMPProcedureCode(String target, String operator, String compareWithColumn, String compareWithTable, String targetTable) {
        String code = ruleTypeICMPProcedureCode;
        code = code.replaceAll("\\{attribute}", target);
        code = code.replaceAll("\\{operator}", operator);
        code = code.replaceAll("\\{compareAttribute}", compareWithColumn);
        code = code.replaceAll("\\{compareTable}", compareWithTable);
        code = code.replaceAll("\\{table}", targetTable);
        return code;
    }

    public String getParameterRuleTypeEOTHCode(String target) {
        String code = parameterRuleTypeEOTHCode;
        code = code.replaceAll("\\{attribute}", target);
        return code;
    }

    public String getRuleTypeEOTHProcedureCode(String target, String operator, String compareWith) {
        String code = ruleTypeEOTHProcedureCode;
        code = code.replaceAll("\\{target}", target);
        code = code.replaceAll("\\{operator}", operator);
        code = code.replaceAll("\\{comparison}", compareWith);
        return code;
    }

    public void setRuleTypeCompareConstraintCode(String ruleTypeCompareConstraintCode) {
        this.ruleTypeCompareConstraintCode = ruleTypeCompareConstraintCode;
    }

    public void setRuleTypeCompareTriggerCode(String ruleTypeCompareTriggerCode) {
        this.ruleTypeCompareTriggerCode = ruleTypeCompareTriggerCode;
    }

    public void setRuleTypeRangeConstraintCode(String ruleTypeRangeConstraintCode) {
        this.ruleTypeRangeConstraintCode = ruleTypeRangeConstraintCode;
    }

    public void setRuleTypeRangeTriggerCode(String ruleTypeRangeTriggerCode) {
        this.ruleTypeRangeTriggerCode = ruleTypeRangeTriggerCode;
    }

    public void setOperatorTranslations(Map<String, String> operatorTranslations) {
        this.operatorTranslations = operatorTranslations;
    }

    public void setRuleTypeOtherConstraintCode(String ruleTypeOtherConstraintCode) {
        this.ruleTypeOtherConstraintCode = ruleTypeOtherConstraintCode;
    }

    public void setRuleTypeOtherTriggerCode(String ruleTypeOtherTriggerCode) {
        this.ruleTypeOtherTriggerCode = ruleTypeOtherTriggerCode;
    }

    public void setRuleTypeListConstraintCode(String ruleTypeListConstraintCode) {
        this.ruleTypeListConstraintCode = ruleTypeListConstraintCode;
    }

    public void setRuleTypeListTriggerCode(String ruleTypeListTriggerCode) {
        this.ruleTypeListTriggerCode = ruleTypeListTriggerCode;
    }

    public void setRuleTypeACMPCode(String ruleTypeACMPCode) {
        this.ruleTypeACMPCode = ruleTypeACMPCode;
    }

    public void setParameterRuleTypeLSTCode(String parameterRuleTypeLSTCode) {
        this.parameterRuleTypeLSTCode = parameterRuleTypeLSTCode;
    }

    public void setParameterRuleTypeOTHCode(String parameterRuleTypeOTHCode) {
        this.parameterRuleTypeOTHCode = parameterRuleTypeOTHCode;
    }

    public void setParameterRuleTypeRNGCode(String parameterRuleTypeRNGCode) {
        this.parameterRuleTypeRNGCode = parameterRuleTypeRNGCode;
    }

    public void setParameterRuleTypeTOTHCode(String parameterRuleTypeTOTHCode) {
        this.parameterRuleTypeTOTHCode = parameterRuleTypeTOTHCode;
    }

    public void setRuleTypeTOTHProcedureCode(String ruleTypeTOTHProcedureCode) {
        this.ruleTypeTOTHProcedureCode = ruleTypeTOTHProcedureCode;
    }

    public void setRuleTypeTCMPProcedureCode(String ruleTypeTCMPProcedureCode) {
        this.ruleTypeTCMPProcedureCode = ruleTypeTCMPProcedureCode;
    }

    public void setRuleTypeTCMPConstraintCode(String ruleTypeTCMPConstraintCode) {
        this.ruleTypeTCMPConstraintCode = ruleTypeTCMPConstraintCode;
    }

    public void setParameterRuleTypeMODICode(String parameterRuleTypeMODICode) {
        this.parameterRuleTypeMODICode = parameterRuleTypeMODICode;
    }

    public void setRuleTypeMODIProcedureCode(String ruleTypeMODIProcedureCode) {
        this.ruleTypeMODIProcedureCode = ruleTypeMODIProcedureCode;
    }

    public void setParameterRuleTypeICMPCode(String parameterRuleTypeICMPCode) {
        this.parameterRuleTypeICMPCode = parameterRuleTypeICMPCode;
    }

    public void setParameterRuleTypeTCMPCode(String parameterRuleTypeTCMPCode) {
        this.parameterRuleTypeTCMPCode = parameterRuleTypeTCMPCode;
    }

    public void setRuleTypeICMPProcedureCode(String ruleTypeICMPProcedureCode) {
        this.ruleTypeICMPProcedureCode = ruleTypeICMPProcedureCode;
    }

    public void setParameterRuleTypeEOTHCode(String parameterRuleTypeEOTHCode) {
        this.parameterRuleTypeEOTHCode = parameterRuleTypeEOTHCode;
    }

    public void setRuleTypeEOTHProcedureCode(String ruleTypeEOTHProcedureCode) {
        this.ruleTypeEOTHProcedureCode = ruleTypeEOTHProcedureCode;
    }
}

