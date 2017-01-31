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

    public String getRuleTypeCompareTriggerCode(String databasetype, String Target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeCompareTriggerCode(Target, operator, compareWith);
    }

    public String getRuleTypeRangeConstraintCode(String databasetype, String target , String from, String operator, String to) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeRangeConstraintCode(target , from, operator, to);
    }

    public String getRuleTypeRangeTriggerCode(String databasetype, String from, String operator, String to, String target) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeRangeTriggerCode(from, operator, to, target);
    }

    public String getTriggerCode(List<String> trigger, String name, String table, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getTriggerCode(name, trigger, table);
    }

    public String getWarningCode(Map<String, String> tokens, String exceptionMessage, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getWarningCode(exceptionMessage, tokens);
    }

    public String getErrorCode(Map<String, String> tokens, String exceptionMessage, String databasetype) {
        Template t = templates.get(databasetype);
        return t.getErrorCode(exceptionMessage, tokens);
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

    public String getRuleTypeOtherTriggerCode(String databasetype, String booleanStatement) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeOtherTriggerCode(booleanStatement);
    }

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeListConstraintCode(target, values, operator);
    }

    public String getRuleTypeListTriggerCode(String databasetype, String target, String operator, List<String> values) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeListTriggerCode(target, operator, values);
    }

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

    public String getRuleTypeCompareProcedureCode(String databasetype, String target, String operator, String compareWith) {
        return null;
    }

    public String getRuleTypeListProcedureCode(String databasetype, String target, String operator, List<String> values) {
        return null;
    }

    public String getRuletypeOtherProcedureCode(String databasetype, String booleanStatement) {
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

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode) {
        return null;
    }

    public String getTriggerEndCode(String databasetype, String name) {
        return null;
    }

    public String getProcedureExcecutionCode(String databasetype, String name, String target, String exceptionParameters) {
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

    public String getRuleTypeACMPCode(String databasetype, String target) {
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
