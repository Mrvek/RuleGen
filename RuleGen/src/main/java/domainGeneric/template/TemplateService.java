package domainGeneric.template;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateService {
/** THIS CLASS IS ONLY TEMPORARY FOR UNLINKING THE DEPENDENCY CHAIN*/

    public String getDeleteMomentCode(String databasetype) {
        return null;
    }

    public String getUpdateMomentCode(String databasetype) {
        return null;
    }

    public String getInsertMomentCode(String databasetype) {
        return null;
    }

    public String getTriggerStartCode(String databasetype) {
        return null;
    }

    public String getTriggerDeclarationCode(String databasetype) {
        return null;
    }

    public String getRuleTypeCompareConstraintCode(String databasetype, String target, String operator, String compareWith) {
        return null;
    }

    public String getRuleTypeCompareProcedureCode(String databasetype, String target, String operator, String compareWith) {
        return null;
    }

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        return null;
    }

    public String getRuleTypeListProcedureCode(String databasetype, String target, String operator, List<String> values) {
        return null;
    }

    public String getRuleTypeOtherConstraintCode(String databasetype, String booleanStatement) {
        return null;
    }

    public String getRuleTypeOtherProcedureCode(String databasetype, String booleanStatement) {
        return null;
    }

    public String getRuleTypeRangeConstraintCode(String databasetype, String target, String from, String operator, String to) {
        return null;
    }

    public String getRuleTypeRangeProcedureCode(String databasetype, String from, String operator, String to, String target) {
        return null;
    }

    public String getPackageHeaderStartCode(String databasetype, String name) {
        return null;
    }

    public String getPackageEndCode(String databasetype, String name) {
        return null;
    }

    public boolean checkPackageSupport(String databasetype) {
        return false;
    }

    public String getPackageBodyStartCode(String databasetype, String name) {
        return null;
    }

    public String getPackageBodyEndCode(String databasetype, String name) {
        return null;
    }

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode, String databasetype) {
        return null;
    }

    public String getTriggerEndCode(String databasetype, String name) {
        return null;
    }

    public String getProcedureExecutionCode(String databasetype, String name, String Target,  String exceptionParameters) {
        return null;
    }

    public String getExceptionExceptStartCode(String databasetype) {
        return null;
    }

    public String getExceptionExceptErrorCode(String databasetype, String errorStackName, String errorExceptionName) {
        return null;
    }

    public String getExceptionRaiseErrorCode(String databasetype, String errorStackName, String errorExceptionName) {
        return null;
    }

    public String getExceptionExceptWarningCode(String databasetype, String errorStackName, String errorExceptionName) {
        return null;
    }

    public String getExceptionRaiseWarningCode(String databasetype, String warningStackName, String warningExceptionName) {
        return null;
    }

    public String getAddStringToExceptionStackCode(String databasetype, String exceptionStackName, String message, Map<String, String> tokens) {
        return null;
    }

    public String getExceptionParameters(String databasetype, String warningStackName, String errorStackName) {
        return null;
    }

    public String getExceptionTriggerDeclarationCode(String databasetype, String warningStackName, String warningExceptionName, String errorStackName, String errorExceptionName) {
        return null;
    }

    public String getProcedureBodyStartCode(String databasetype, String name) {
        return null;
    }

    public String getProcedureBodyDeclarationCode(String databasetype, String passedName) {
        return null;
    }

    public String getProcedureBodyEndCode(String databasetype, String name) {
        return null;
    }

    public String getParameterRuleTypeACMPCode(String databasetype, String target) {
        return null;
    }

    public String getParameterRuleTypeLSTCode(String databasetype, String target) {
        return null;
    }

    public String getParameterRuleTypeTHRCode(String databasetype, String target) {
        return null;
    }

    public String getParameterRuleTypeRNGCode(String databasetype, String target) {
        return null;
    }
}
