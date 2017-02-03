package domainGeneric.template;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateService {
    private TemplateManager factory = new TemplateManager();


    public String getDeleteMomentCode(String databasetype) {
        return factory.getDeleteMomentCode(databasetype);
    }

    public String getUpdateMomentCode(String databasetype) {
        return factory.getUpdateMomentCode(databasetype);
    }

    public String getInsertMomentCode(String databasetype) {
        return factory.getInsertMomentCode(databasetype);
    }

    public String getTriggerStartCode(String databasetype, String name, String table) {
        return factory.getTriggerStartCode(databasetype, name, table);
    }

    public String getTriggerDeclarationCode(String databasetype) {
        return factory.getTriggerDeclarationCode(databasetype);
    }

    public String getRuleTypeACMPConstraintCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeCompareConstraintCode(databasetype, target, operator, compareWith);
    }

    public String getRuleTypeACMPProcedureCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeACMPProcedureCode(databasetype, target, operator, compareWith);
    }

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        return factory.getRuleTypeListConstraintCode(databasetype, target, values, operator);
    }

    public String getRuleTypeListProcedureCode(String databasetype, String target, String operator, List<String> values) {
        return factory.getRuleTypeLSTProcedureCode(databasetype, target, operator, values);
    }

    public String getRuleTypeOtherConstraintCode(String databasetype, String booleanStatement) {
        return factory.getRuleTypeOtherConstraintCode(databasetype, booleanStatement);
    }

    public String getRuleTypeOtherProcedureCode(String databasetype, String booleanStatement) {
        return factory.getRuletypeOTHProcedureCode(databasetype, booleanStatement);
    }

    public String getRuleTypeRangeConstraintCode(String databasetype, String target, String from, String operator, String to) {
        return factory.getRuleTypeRangeConstraintCode(databasetype, target, from, operator, to);
    }

    public String getRuleTypeRangeProcedureCode(String databasetype, String from, String operator, String to, String target) {
        return factory.getRuleTypeRNGProcedureCode(databasetype, from, operator, to, target);
    }

    public String getPackageHeaderStartCode(String databasetype, String name) {
        return factory.getPackageHeaderStartCode(databasetype, name);
    }

    public String getPackageEndCode(String databasetype, String name) {
        return factory.getPackageEndCode(databasetype, name);
    }

    public boolean checkPackageSupport(String databasetype) {
        return factory.checkPackageSupport(databasetype);
    }

    public String getPackageBodyStartCode(String databasetype, String name, String table) {
        return factory.getPackageBodyStartCode(databasetype, name, table);
    }

    public String getPackageBodyEndCode(String databasetype, String name) {
        return factory.getPackageBodyEndCode(databasetype, name);
    }

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode, String databasetype, String table) {
        return factory.getProcedureSpecification(name, exceptionProcedureDeclarations, parameterCode, databasetype,table);
    }

    public String getTriggerEndCode(String databasetype, String name) {
        return factory.getTriggerEndCode(databasetype, name);
    }

    public String getProcedureExecutionCode(String databasetype, String name, String Target,  String exceptionParameters) {
        return factory.getProcedureExcecutionCode(databasetype, name, Target, exceptionParameters);
    }

    public String getExceptionExceptStartCode(String databasetype) {
        return factory.getExceptionExceptStartCode(databasetype);
    }

    public String getExceptionExceptErrorCode(String databasetype, String errorStackName, String errorExceptionName) {
        return factory.getExceptionExceptErrorCode(databasetype, errorStackName, errorExceptionName);
    }

    public String getExceptionRaiseErrorCode(String databasetype, String errorStackName, String errorExceptionName) {
        return factory.getExceptionRaiseErrorCode(databasetype, errorStackName, errorExceptionName);
    }

    public String getExceptionExceptWarningCode(String databasetype, String errorStackName, String errorExceptionName) {
        return factory.getExceptionExceptWarningCode(databasetype, errorStackName, errorExceptionName);
    }

    public String getExceptionRaiseWarningCode(String databasetype, String warningStackName, String warningExceptionName) {
        return factory.getExceptionRaiseWarningCode(databasetype, warningStackName, warningExceptionName);
    }

    public String getAddStringToExceptionStackCode(String databasetype, String exceptionStackName, String message, Map<String, String> tokens) {
        return factory.getAddStringToExceptionStackCode(databasetype, exceptionStackName, message, tokens);
    }

    public String getExceptionParameters(String databasetype, String warningStackName, String errorStackName) {
        return factory.getExceptionParameters(databasetype, warningStackName, errorStackName);
    }

    public String getExceptionTriggerDeclarationCode(String databasetype, String warningStackName, String warningExceptionName, String errorStackName, String errorExceptionName) {
        return factory.getExceptionTriggerDeclarationCode(databasetype, warningStackName, warningExceptionName, errorStackName, errorExceptionName);
    }

    public String getProcedureBodyStartCode(String databasetype, String name, String attribute, String table) {
        return factory.getProcedureBodyStartCode(databasetype, name, attribute, table);
    }

    public String getProcedureBodyDeclarationCode(String databasetype, String passedName) {
        return factory.getProcedureBodyDeclarationCode(databasetype, passedName);
    }

    public String getProcedureBodyEndCode(String databasetype, String name) {
        return factory.getProcedureBodyEndCode(databasetype, name);
    }

    public String getParameterRuleTypeACMPCode(String databasetype, String target, String table) {
        return factory.getRuleTypeACMPCode(databasetype, target, table);
    }

    public String getParameterRuleTypeLSTCode(String databasetype, String target, String table) {
        return factory.getParameterRuleTypeLSTCode(databasetype, target, table);
    }

    public String getParameterRuleTypeTHRCode(String databasetype, String target, String table) {
        return factory.getParameterRuleTypeOTHCode(databasetype, target, table);
    }

    public String getParameterRuleTypeRNGCode(String databasetype, String target, String table) {
        return factory.getParameterRuleTypeRNGCode(databasetype, target, table);
    }

    public String getRuleTypeEOTHProcedureCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeEOTHProcedureCode(databasetype, target, operator, compareWith);
    }

    public String getParameterRuleTypeEOTHCode(String databasetype, String target, String table) {
        return factory.getParameterRuleTypeEOTHCode(databasetype, target, table);
    }

    public String getRuleTypeICMPProcedureCode(String databasetype, String target, String operator, String compareWithColumn, String compareWithTable, String targetTable) {
        return factory.getRuleTypeICMPProcedureCode(databasetype, target, operator, compareWithColumn, compareWithTable, targetTable);
    }

    public String getParameterRuleTypeTCMPCode(String databasetype, String target, String compareWithTable, String table) {
        return factory.getParameterRuleTypeTCMPCode(databasetype, target, compareWithTable, table);
    }

    public String getParameterRuleTypeICMPCode(String databasetype, String target, String compareWithTable, String compareWithColumn, String table) {
        return factory.getParameterRuleTypeICMPCode(databasetype, target, compareWithTable, compareWithColumn, table);
    }

    public String getRuleTypeMODIProcedureCode(String databasetype, String target, String operator, String compareWithColumn) {
        return factory.getRuleTypeMODIProcedureCode(databasetype, target, operator, compareWithColumn);
    }

    public String getParameterRuleTypeMODICode(String databasetype, String target, String compareWithColumn, String table) {
        return factory.getParameterRuleTypeMODICode(databasetype, target, compareWithColumn, table);
    }

    public String getRuleTypeTCMPConstraintCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeTCMPConstraintCode(databasetype, target, operator, compareWith);
    }

    public String getRuleTypeTCMPProcedureCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeTCMPProcedureCode(databasetype, target, operator, compareWith);
    }

    public String getRuleTypeTOTHProcedureCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeTOTHProcedureCode(databasetype, target, operator, compareWith);
    }

    public String getParameterRuleTypeTOTHCode(String databasetype, String target, String table) {
        return factory.getParameterRuleTypeTOTHCode(databasetype, target, table);
    }
}
