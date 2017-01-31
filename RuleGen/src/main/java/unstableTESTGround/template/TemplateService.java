package unstableTESTGround.template;

import unstableTESTGround.template.TemplateManager;

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

    public String getTriggerStartCode(String databasetype) {
        return factory.getTriggerStartCode(databasetype);
    }

    public String getTriggerDeclarationCode(String databasetype) {
        return factory.getTriggerDeclarationCode(databasetype);
    }

    public String getRuleTypeCompareConstraintCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeCompareConstraintCode(databasetype, target, operator, compareWith);
    }

    public String getRuleTypeCompareProcedureCode(String databasetype, String target, String operator, String compareWith) {
        return factory.getRuleTypeCompareProcedureCode(databasetype, target, operator, compareWith);
    }

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        return factory.getRuleTypeListConstraintCode(databasetype, target, values, operator);
    }

    public String getRuleTypeListProcedureCode(String databasetype, String target, String operator, List<String> values) {
        return factory.getRuleTypeListProcedureCode(databasetype, target, operator, values);
    }

    public String getRuleTypeOtherConstraintCode(String databasetype, String booleanStatement) {
        return factory.getRuleTypeOtherConstraintCode(databasetype, booleanStatement);
    }

    public String getRuleTypeOtherProcedureCode(String databasetype, String booleanStatement) {
        return factory.getRuletypeOtherProcedureCode(databasetype, booleanStatement);
    }

    public String getRuleTypeRangeConstraintCode(String databasetype, String target, String from, String operator, String to) {
        return factory.getRuleTypeRangeConstraintCode(databasetype, target, from, operator, to);
    }

    public String getRuleTypeRangeProcedureCode(String databasetype, String from, String operator, String to, String target) {
        return factory.getRuleTypeRangeProcedureCode(databasetype, from, operator, to, target);
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

    public String getPackageBodyStartCode(String databasetype, String name) {
        return factory.getPackageBodyStartCode(databasetype, name);
    }

    public String getPackageBodyEndCode(String databasetype, String name) {
        return factory.getPackageBodyEndCode(databasetype, name);
    }

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode) {
        return factory.getProcedureSpecification(name, exceptionProcedureDeclarations, parameterCode);
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

    public String getProcedureBodyStartCode(String databasetype, String name) {
        return factory.getProcedureBodyStartCode(databasetype, name);
    }

    public String getProcedureBodyDeclarationCode(String databasetype, String passedName) {
        return factory.getProcedureBodyDeclarationCode(databasetype, passedName);
    }

    public String getProcedureBodyEndCode(String databasetype, String name) {
        return factory.getProcedureBodyEndCode(databasetype, name);
    }

    public String getParameterRuleTypeACMPCode(String databasetype, String target) {
        return factory.getRuleTypeACMPCode(databasetype, target);
    }

    public String getParameterRuleTypeLSTCode(String databasetype, String target) {
        return factory.getParameterRuleTypeLSTCode(databasetype, target);
    }

    public String getParameterRuleTypeTHRCode(String databasetype, String target) {
        return factory.getParameterRuleTypeTHRCode(databasetype, target);
    }

    public String getParameterRuleTypeRNGCode(String databasetype, String target) {
        return factory.getParameterRuleTypeRNGCode(databasetype, target);
    }
}
