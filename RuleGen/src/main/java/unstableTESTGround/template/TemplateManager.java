package unstableTESTGround.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class TemplateManager {
    static private Map<String, Template> templates = new HashMap<>();

    public static void addTemplate(String DBType, Template template) {
        templates.put(DBType, template);
    }

    public static void resetTemplates() {
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

    public String getRuleTypeRangeConstraintCode(String databasetype, String target , String from, String operator, String to) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeRangeConstraintCode(target , from, operator, to);
    }

    public String getTriggerCode(List<String> trigger, String name, String table, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getTriggerCode(name, trigger, table);
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

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeListConstraintCode(target, values, operator);
    }


    public String getDeleteMomentCode(String databasetype) {
        Template t = templates.get(databasetype);
        return t.getDeleteMomentCode();
    }

    public String getUpdateMomentCode(String databasetype) {
        Template t = templates.get(databasetype);
        return t.getUpdateMomentCode();
    }

    public String getInsertMomentCode(String databasetype) {
        Template t = templates.get(databasetype);
        return t.getInsertMomentCode();
    }

    public String getTriggerStartCode(String databasetype) {
        Template t = templates.get(databasetype);
        return t.getTriggerStartCode();
    }

    public String getTriggerDeclarationCode(String databasetype) {
        Template t = templates.get(databasetype);
        return t.getTriggerDeclarationCode();
    }

    public String getRuleTypeACMPProcedureCode(String databasetype, String target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeACMPProcedureCode(target, operator, compareWith);
    }

    public String getRuleTypeLSTProcedureCode(String databasetype, String target, String operator, List<String> values) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeLSTProcedureCode(target, operator, values);
    }

    public String getRuletypeOTHProcedureCode(String databasetype, String booleanStatement) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeOTHProcedureCode(booleanStatement);
    }

    public String getRuleTypeRNGProcedureCode(String databasetype, String from, String operator, String to, String target) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeRNGProcedureCode(from, operator, to, target);
    }

    public String getPackageHeaderStartCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getPackagHeaderStartCode(name);
    }

    public String getPackageEndCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getPackagEndCode(name);
    }

    public boolean checkPackageSupport(String databasetype) {
        Template t = templates.get(databasetype);
        return t.checkPackageSupport();
    }

    public String getPackageBodyStartCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getPakageBodyStartCode(name);
    }

    public String getPackageBodyEndCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getPackageBodyEndCode(name);
    }

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getProcedureSpecification(name, exceptionProcedureDeclarations, parameterCode);
    }

    public String getTriggerEndCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getTriggerEndCode();
    }

    public String getProcedureExcecutionCode(String databasetype, String name, String target, String exceptionParameters) {
        Template t = templates.get(databasetype);
        return t.getProcedureExcecutionCode(name, target, exceptionParameters);
    }

    public String getExceptionExceptStartCode(String databasetype) {
        Template t = templates.get(databasetype);
        return t.getExceptionExceptStartCode();
    }

    public String getExceptionExceptErrorCode(String databasetype, String errorStackName, String errorExceptionName) {
        Template t = templates.get(databasetype);
        return t.getExceptionExceptErrorCode(errorStackName, errorExceptionName);
    }

    public String getExceptionRaiseErrorCode(String databasetype, String errorStackName, String errorExceptionName) {
        Template t = templates.get(databasetype);
        return t.getExceptionRaiseErrorCode(errorStackName, errorExceptionName);
    }

    public String getExceptionExceptWarningCode(String databasetype, String errorStackName, String errorExceptionName) {
        Template t = templates.get(databasetype);
        return t.getExceptionWarningCode(errorStackName, errorExceptionName);
    }

    public String getExceptionRaiseWarningCode(String databasetype, String warningStackName, String warningExceptionName) {
        Template t = templates.get(databasetype);
        return t.getExceptionRaiseWarningCode(warningStackName, warningExceptionName);
    }

    public String getAddStringToExceptionStackCode(String databasetype, String exceptionStackName, String message, Map<String, String> tokens) {
        Template t = templates.get(databasetype);
        return t.getAddStringTExceptionStackCode(exceptionStackName, message, tokens);
    }

    public String getExceptionParameters(String databasetype, String warningStackName, String errorStackName) {
        Template t = templates.get(databasetype);
        return t.getExceptionParameters(warningStackName, errorStackName);
    }

    public String getExceptionTriggerDeclarationCode(String databasetype, String warningStackName, String warningExceptionName, String errorStackName, String errorExceptionName) {
        Template t = templates.get(databasetype);
        return t.getExceptionTrigerDeclarationCode(warningStackName, warningExceptionName, errorStackName, errorExceptionName);
    }

    public String getProcedureBodyStartCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getProcedureBodyStartCode(name);
    }

    public String getProcedureBodyDeclarationCode(String databasetype, String passedName) {
        Template t = templates.get(databasetype);
        return t.getProcedureBodyDeclarationCode(passedName);
    }

    public String getProcedureBodyEndCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getProcedureBodyEndCode(name);
    }

    public String getRuleTypeACMPCode(String databasetype, String target) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeACMPCode(target);
    }

    public String getParameterRuleTypeLSTCode(String databasetype, String target) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeLSTCode(target);
    }

    public String getParameterRuleTypeOTHCode(String databasetype, String target) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeOTHCode(target);
    }

    public String getParameterRuleTypeRNGCode(String databasetype, String target) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeRNGCode(target);
    }
}
