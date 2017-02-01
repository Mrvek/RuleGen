package domainGeneric.dto;

import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateData {
    private String databaseName;
    private boolean packageSupport;
    private String triggerCode;
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
    private String executeStatementCode;


    public TemplateData(String databaseName, boolean packageSupport, String triggerCode, String constraintCode, String ruleTypeCompareConstraintCode, String ruleTypeCompareTriggerCode, String ruleTypeRangeConstraintCode, String ruleTypeRangeTriggerCode, Map<String, String> operatorTranslations, String ruleTypeOtherConstraintCode, String ruleTypeOtherTriggerCode, String ruleTypeListConstraintCode, String ruleTypeListTriggerCode, String deleteMomentCode, String updateMomentCode, String insertMomentCode, String triggerStartCode, String triggerDeclarationCode, String packageHeaderStartCode, String packageEndCode, String packageBodyStartCode, String packageBodyEndCode, String procedureSpecification, String triggerEndCode, String procedureExcecutionCode, String exceptionExceptStartCode, String exceptionExceptErrorCode, String exceptionRaiseErrorCode, String exceptionWarningCode, String exceptionRaiseWarningCode, String addStringTExceptionStackCode, String exceptionParameters, String exceptionTriggerDeclarationCode, String procedureBodyStartCode, String procedureBodyDeclarationCode, String procedureBodyEndCode, String ruleTypeACMPCode, String parameterRuleTypeLSTCode, String parameterRuleTypeOTHCode, String parameterRuleTypeRNGCode, String executeStatementCode) {
        this.databaseName = databaseName;
        this.packageSupport = packageSupport; //true if databasetype supports packages, else false
        this.triggerCode = triggerCode;
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
        this.addStringTExceptionStackCode = addStringTExceptionStackCode;
        this.exceptionParameters = exceptionParameters;
        this.exceptionTriggerDeclarationCode = exceptionTriggerDeclarationCode;
        this.procedureBodyStartCode = procedureBodyStartCode;
        this.procedureBodyDeclarationCode = procedureBodyDeclarationCode;
        this.procedureBodyEndCode = procedureBodyEndCode;
        this.ruleTypeACMPCode = ruleTypeACMPCode;
        this.parameterRuleTypeLSTCode = parameterRuleTypeLSTCode;
        this.parameterRuleTypeOTHCode = parameterRuleTypeOTHCode;
        this.parameterRuleTypeRNGCode = parameterRuleTypeRNGCode;
        this.executeStatementCode = executeStatementCode;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public boolean isPackageSupport() {
        return packageSupport;
    }

    public String getTriggerCode() {
        return triggerCode;
    }

    public String getConstraintCode() {
        return constraintCode;
    }

    public String getRuleTypeCompareConstraintCode() {
        return ruleTypeCompareConstraintCode;
    }

    public String getRuleTypeCompareTriggerCode() {
        return ruleTypeCompareTriggerCode;
    }

    public String getRuleTypeRangeConstraintCode() {
        return ruleTypeRangeConstraintCode;
    }

    public String getRuleTypeRangeTriggerCode() {
        return ruleTypeRangeTriggerCode;
    }

    public Map<String, String> getOperatorTranslations() {
        return operatorTranslations;
    }

    public String getRuleTypeOtherConstraintCode() {
        return ruleTypeOtherConstraintCode;
    }

    public String getRuleTypeOtherTriggerCode() {
        return ruleTypeOtherTriggerCode;
    }

    public String getRuleTypeListConstraintCode() {
        return ruleTypeListConstraintCode;
    }

    public String getRuleTypeListTriggerCode() {
        return ruleTypeListTriggerCode;
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

    public String getPackageHeaderStartCode() {
        return packageHeaderStartCode;
    }

    public String getPackageEndCode() {
        return packageEndCode;
    }

    public String getPackageBodyStartCode() {
        return packageBodyStartCode;
    }

    public String getPackageBodyEndCode() {
        return packageBodyEndCode;
    }

    public String getProcedureSpecification() {
        return procedureSpecification;
    }

    public String getTriggerEndCode() {
        return triggerEndCode;
    }

    public String getProcedureExcecutionCode() {
        return procedureExcecutionCode;
    }

    public String getExceptionExceptStartCode() {
        return exceptionExceptStartCode;
    }

    public String getExceptionExceptErrorCode() {
        return exceptionExceptErrorCode;
    }

    public String getExceptionRaiseErrorCode() {
        return exceptionRaiseErrorCode;
    }

    public String getExceptionWarningCode() {
        return exceptionWarningCode;
    }

    public String getExceptionRaiseWarningCode() {
        return exceptionRaiseWarningCode;
    }

    public String getAddStringTExceptionStackCode() {
        return addStringTExceptionStackCode;
    }

    public String getExceptionParameters() {
        return exceptionParameters;
    }

    public String getExceptionTriggerDeclarationCode() {
        return exceptionTriggerDeclarationCode;
    }

    public String getProcedureBodyStartCode() {
        return procedureBodyStartCode;
    }

    public String getProcedureBodyDeclarationCode() {
        return procedureBodyDeclarationCode;
    }

    public String getProcedureBodyEndCode() {
        return procedureBodyEndCode;
    }

    public String getRuleTypeACMPCode() {
        return ruleTypeACMPCode;
    }

    public String getParameterRuleTypeLSTCode() {
        return parameterRuleTypeLSTCode;
    }

    public String getParameterRuleTypeOTHCode() {
        return parameterRuleTypeOTHCode;
    }

    public String getParameterRuleTypeRNGCode() {
        return parameterRuleTypeRNGCode;
    }

    public String getExecuteStatementCode() {
        return executeStatementCode;
    }
}
