package domainGeneric.template;

import dto.domain.TemplateData;
import dto.supported_units.PackageTemplate;
import dto.supported_units.ProcedureTemplate;
import dto.supported_units.RuletypeTemplate;
import dto.supported_units.TriggerTemplate;

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

    public String getTriggerStartCode(String databasetype, String name, String table) {
        Template t = templates.get(databasetype);
        return t.getTriggerStartCode(name, table);
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

    public String getPackageBodyStartCode(String databasetype, String name, String table) {
        Template t = templates.get(databasetype);
        return t.getPakageBodyStartCode(name, table);
    }

    public String getPackageBodyEndCode(String databasetype, String name) {
        Template t = templates.get(databasetype);
        return t.getPackageBodyEndCode(name);
    }

    public String getProcedureSpecification(String name, String exceptionProcedureDeclarations, String parameterCode, String databasetype, String table) {
        Template t = templates.get(databasetype);
        return t.getProcedureSpecification(name, exceptionProcedureDeclarations, parameterCode, table);
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

    public String getRuleTypeACMPCode(String databasetype, String target, String table) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeACMPCode(target, table);
    }

    public String getParameterRuleTypeLSTCode(String databasetype, String target, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeLSTCode(target, table);
    }

    public String getParameterRuleTypeOTHCode(String databasetype, String target, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeOTHCode(target, table);
    }

    public String getParameterRuleTypeRNGCode(String databasetype, String target, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeRNGCode(target, table);
    }

    public String getParameterRuleTypeTOTHCode(String databasetype, String target, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeTOTHCode(target, table);
    }

    public String getRuleTypeTOTHProcedureCode(String databasetype, String target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeTOTHProcedureCode(target, operator, compareWith);
    }

    public String getRuleTypeTCMPProcedureCode(String databasetype, String target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeTCMPProcedureCode(target, operator, compareWith);
    }

    public String getRuleTypeTCMPConstraintCode(String databasetype, String target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeTCMPConstraintCode(target, operator, compareWith);
    }

    public String getParameterRuleTypeMODICode(String databasetype, String target, String compareWithColumn, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeMODICode(target, table, compareWithColumn);
    }

    public String getRuleTypeMODIProcedureCode(String databasetype, String target, String operator, String compareWithColumn) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeMODIProcedureCode(target,operator, compareWithColumn);
    }

    public String getParameterRuleTypeICMPCode(String databasetype, String target, String compareWithTable, String compareWithColumn, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeICMPCode(target, table, compareWithTable, compareWithColumn);
    }

    public String getParameterRuleTypeTCMPCode(String databasetype, String target, String compareWithTable, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeTCMPCode(target, table, compareWithTable);
    }

    public String getRuleTypeICMPProcedureCode(String databasetype, String target, String operator, String compareWithColumn, String compareWithTable, String targetTable) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeICMPProcedureCode(target, operator, compareWithColumn, compareWithTable, targetTable);
    }

    public String getParameterRuleTypeEOTHCode(String databasetype, String target, String table) {
        Template t = templates.get(databasetype);
        return t.getParameterRuleTypeEOTHCode(target, table);
    }

    public String getRuleTypeEOTHProcedureCode(String databasetype, String target, String operator, String compareWith) {
        Template t = templates.get(databasetype);
        return t.getRuleTypeEOTHProcedureCode(target, operator, compareWith);
    }

    public static void addTemplate(TemplateData td) {
        boolean packagesupport = false;
        if (td.getPackageTemplate() != null) {
            packagesupport = true;
        }
        TriggerTemplate trigger = td.getTriggerTemplate();
        PackageTemplate packaget = td.getPackageTemplate();
        ProcedureTemplate procedure = td.getProcedureTemplate();
        ArrayList<RuletypeTemplate> ruletypes = td.getRuletypeTemplate();

        Template template = new Template(packagesupport, td.getTemplate().getConstraint_code(), trigger.getDeleteMoment(), trigger.getUpdateMoment(), trigger.getInsertMoment(), trigger.getStart(), trigger.getDecleration(), packaget.getHeaderStart(), packaget.getHeaderEnd(), packaget.getBodyStart(), packaget.getBodyEnd(), procedure.getSpecification(), trigger.getEnd(), procedure.getExcecution(), trigger.getExceptionExceptStart(), trigger.getExceptionExceptError(), trigger.getExceptionRaiseError(), trigger.getExceptionExceptWarning(), trigger.getExceptionRaiseWarning(), trigger.getAddStringToExceptionStack(), trigger.getExceptionParameters(), trigger.getExceptionTriggerDeclaration(), procedure.getBodyStart(), procedure.getBodyDecleration(), procedure.getBodyEnd());

        for (RuletypeTemplate type : ruletypes) {
            switch (type.getBusinessruleType().getType()) {
                case ("ATTRIBUTE_RANGE_RULE"):
                    template.setParameterRuleTypeRNGCode(type.getParameterCode());
                    template.setRuleTypeRangeConstraintCode(type.getConstraintCode());
                    template.setRuleTypeRangeTriggerCode(type.getProcedureCode());
                    break;
                case ("ATTRIBUTE_COMPARE_RULE"):
                    template.setRuleTypeCompareConstraintCode(type.getConstraintCode());
                    template.setRuleTypeCompareTriggerCode(type.getProcedureCode());
                    template.setRuleTypeACMPCode(type.getParameterCode());
                    break;
                case ("ATTRIBUTE_LIST_RULE"):
                    template.setRuleTypeListConstraintCode(type.getConstraintCode());
                    template.setRuleTypeListTriggerCode(type.getProcedureCode());
                    template.setParameterRuleTypeLSTCode(type.getParameterCode());
                    break;
                case ("ATTRIBUTE_OTHER_RULE"):
                    template.setRuleTypeOtherConstraintCode(type.getConstraintCode());
                    template.setRuleTypeOtherTriggerCode(type.getProcedureCode());
                    template.setParameterRuleTypeOTHCode(type.getParameterCode());
                    break;
                case ("TUPLE_COMPARE_RULE"):
                    template.setRuleTypeTCMPConstraintCode(type.getConstraintCode());
                    template.setRuleTypeTCMPProcedureCode(type.getProcedureCode());
                    template.setParameterRuleTypeTCMPCode(type.getParameterCode());
                    break;
                case ("INTER-ENTITY_COMPARE_RULE"):
                    template.setParameterRuleTypeICMPCode(type.getParameterCode());
                    template.setRuleTypeICMPProcedureCode(type.getProcedureCode());
                    break;
                case ("ENTITY_OTHER_RULE"):
                    template.setRuleTypeEOTHProcedureCode(type.getProcedureCode());
                    template.setParameterRuleTypeEOTHCode(type.getParameterCode());
                    break;
                case ("TUPLE_OTHER_RULE"):
                    template.setRuleTypeTOTHProcedureCode(type.getProcedureCode());
                    template.setParameterRuleTypeTOTHCode(type.getParameterCode());
                    break;
                case ("MODIFY_RULE"):
                    template.setRuleTypeMODIProcedureCode(type.getProcedureCode());
                    template.setParameterRuleTypeMODICode(type.getParameterCode());
                default:
                    break;

            }
        }
        addTemplate(td.getTemplate().getName(), template);
    }

}
