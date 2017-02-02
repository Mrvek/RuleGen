package dataAccess.toolsdb;


import dataAccess.persistence.oracle.toolsdb.BusinessRuleService;
import dataAccess.persistence.oracle.toolsdb.ProjectService;
import dataAccess.persistence.oracle.toolsdb.SupportedUnitsService;
import dataAccess.persistence.oracle.toolsdb.ToolDbService;

import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.businessrules.BusinessruleType;
import dto.businessrules.Token;
import dto.domain.BRData;
import dto.domain.CodeReturnData;
import dto.domain.ProjectData;
import dto.domain.TemplateData;
import dto.project.Brgqueue;
import dto.project.Project;
import dto.supported_units.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPull {
//    private DBConfig config;
//TODO contains push services, refactor classname?
	
	
	//must receive templates from database and get the right ones?
    public List<TemplateData> getNewTemplates(List<String> currentTemplateNames) {
        List<TemplateData> result = new ArrayList<>();
        SupportedUnitsService sus = ToolDbService.getSUService();
        ArrayList<Template> dbtemplates = sus.getAllTemplates();
        
        for (Template x : dbtemplates) {
            TemplateData templateData = new TemplateData();
            templateData.setTemplate(x);
            templateData.setPackageTemplate(sus.getPackageTemplate(x.getId()));
            templateData.setProcedureTemplate(sus.getProcedureTemplate(x.getId()));
            templateData.setRuletypeTemplate(sus.getAllRuleTypeTemplates(x.getId()));
            templateData.setTriggerTemplate(sus.getTriggerTemplate(x.getId()));
            
            result.add(templateData);
        }

//        Data for testing:
        Template templateDTO = new Template();
        templateDTO.setName("Oracle 12c");
        templateDTO.setConstraint_code("ALTER TABLE {table} ADD CONSTRAINT {name} CHECK (?)");

        PackageTemplate packageTemplate = new PackageTemplate();
        packageTemplate.setHeaderStart("CREATE OR REPLACE PACKAGE {name} AS \n");
        packageTemplate.setHeaderEnd("END {name};");
        packageTemplate.setBodyStart("CREATE OR REPLACE PACKAGE_BODY {name} AS");
        packageTemplate.setBodyEnd("END {name};");

        ProcedureTemplate procedureTemplate = new ProcedureTemplate();
        procedureTemplate.setSpecification("PROCEDURE {name}({codeParameters}, {exceptionParameters});\n");
        procedureTemplate.setExcecution("{name}({attribute}, {exceptionParameters});");
        procedureTemplate.setBodyStart("PROCEDURE {name}({attribute}, {exceptionParameters}) IS\n");
        procedureTemplate.setBodyDecleration("{PassedName VARCHAR2;");
        procedureTemplate.setBodyEnd("END {name};");

        TriggerTemplate triggerTemplate = new TriggerTemplate();
        triggerTemplate.setInsertMoment("CASE\n \tWHEN INSERTING THEN\n");
        triggerTemplate.setUpdateMoment("\tWHEN UPDATING THEN\n");
        triggerTemplate.setDeleteMoment("\tWHEN DELETING THEN\n");
        triggerTemplate.setStart("CREATE OR REPLACE TRIGGER {name}\nBEFORE\nINSERT OR UPDATE OR DELETE\nON {table}\nFOR EACH ROW\n");
        triggerTemplate.setDecleration("DECLARE\n e_ErrorStack VARCHAR2;\n e_WarningStack VARCHAR2\n e_Error EXCEPTION\n e_warning EXCEPTION\nBEGIN\n");
        triggerTemplate.setEnd("END;");
        triggerTemplate.setExceptionExceptStart("EXCEPTION\n");
        triggerTemplate.setExceptionExceptError("WHEN {errorException} THEN\n\tRAISE_APPLICATION_ERROR(20100, {errorStack});\n");
        triggerTemplate.setExceptionRaiseError("IF ({errorStack} IS NOT NULL) THEN\n\traise {errorException};\nEND IF;");
        triggerTemplate.setExceptionExceptWarning("WHEN {warningException} THEN\n\tRAISE_APPLICATION_ERROR(20100, {warningStack});\n");
        triggerTemplate.setExceptionRaiseWarning("IF ({warningStack} IS NOT NULL) THEN\n\traise {warningException};\nEND IF;");
        triggerTemplate.setAddStringToExceptionStack("\tIF (I_Passed IS FALSE) THEN\n\t{exceptionStack} = {exceptionStack} || '{message}';\nEND IF;\n");
        triggerTemplate.setExceptionParameters("VARCHAR2 {errorStack}, VARCHAR2 {warningStack}");
        triggerTemplate.setExceptionTriggerDeclaration("TEST");

        ArrayList<RuletypeTemplate> ruletypeTemplates = new ArrayList<>();

        RuletypeTemplate ACMP = new RuletypeTemplate();
        ACMP.setBusinessruleType(new BusinessruleType());
        ACMP.getBusinessruleType().setType("ATTRIBUTE_COMPARE_RULE");
        ACMP.setConstraintCode("{target} {operator} ?");
        ACMP.setParameterCode("{target} novaluetype...");
        ACMP.setProcedureCode("{target} {operator} ?");

        RuletypeTemplate LST = new RuletypeTemplate();
        LST.setBusinessruleType(new BusinessruleType());
        LST.getBusinessruleType().setType("ATTRIBUTE_LIST_RULE");
        LST.setConstraintCode("{target} {operator} ?");
        LST.setParameterCode("{target} novaluetype...");
        LST.setProcedureCode("{target} {operator} ?");

        RuletypeTemplate RNG = new RuletypeTemplate();
        RNG.setBusinessruleType(new BusinessruleType());
        RNG.getBusinessruleType().setType("ATTRIBUTE_RANGE_RULE");
        RNG.setConstraintCode("{target} {operator} {from} AND {to}");
        RNG.setParameterCode("{target} novaluetype...");
        RNG.setProcedureCode("{target} {operator} {from} AND {to}");

        RuletypeTemplate AOTH = new RuletypeTemplate();
        AOTH.setBusinessruleType(new BusinessruleType());
        AOTH.getBusinessruleType().setType("ATTRIBUTE_OTHER_RULE");
        AOTH.setConstraintCode("?");
        AOTH.setParameterCode("{target} novaluetype...");
        AOTH.setProcedureCode("?");

        RuletypeTemplate TCMP = new RuletypeTemplate();
        TCMP.setBusinessruleType(new BusinessruleType());
        TCMP.getBusinessruleType().setType("TUPLE_COMPARE_RULE");
        TCMP.setConstraintCode("{target} {operator} {comparison}");
        TCMP.setParameterCode("{target} novaluetype...");
        TCMP.setProcedureCode("{target} {operator} {comparison}");

        RuletypeTemplate TOTH = new RuletypeTemplate();
        TOTH.setBusinessruleType(new BusinessruleType());
        TOTH.getBusinessruleType().setType("TUPLE_OTHER_RULE");
        TOTH.setParameterCode("{target} novaluetype...");
        TOTH.setProcedureCode("{code}");

        RuletypeTemplate ICMP = new RuletypeTemplate();
        ICMP.setBusinessruleType(new BusinessruleType());
        ICMP.getBusinessruleType().setType("INTER-ENTITY COMPARE RULE");
        ICMP.setParameterCode("{target} novaluetype...");
        ICMP.setProcedureCode("cursor lc_{compareTable} is\n" +
                "select {compareTable}.{compareAttribute}\n" +
                "from {compareTable}\n" +
                "where {table}.{attribute} = :NEW.{attribute};\n" +
                "l_{compareAttribute} {compareTable}.{compareAttribute}%type;\n" +
                "BEGIN\n" +
                "open lc_{compareTable};\n" +
                "fetch lc_{compareTable} into l_{compareAttribute};\n" +
                "close lc_{compareTable};\n" +
                "I_Passed := {attribute} >= l_{compareAttribute};\n");

        RuletypeTemplate EOTH = new RuletypeTemplate();
        EOTH.setBusinessruleType(new BusinessruleType());
        EOTH.getBusinessruleType().setType("ENTITY_OTHER_RULE");
        EOTH.setParameterCode("{target} novaluetype...");
        EOTH.setProcedureCode("l_{attribute} pls_integer;\n" +
                "BEGIN\n" +
                "select count(*)\n" +
                "into l_{attribute}\n" +
                "from {table}\n" +
                "where {attribute} = :NEW.{attribute};\n" +
                "I_Passed := l_{attribute} <= {comparison};\n");

        RuletypeTemplate MODI = new RuletypeTemplate();
        MODI.setBusinessruleType(new BusinessruleType());
        MODI.getBusinessruleType().setType("MODIFY_RULE");
        MODI.setParameterCode("{target} novaluetype...");
        MODI.setProcedureCode("cursor lc_{table}\n" +
                "select {attribute}\n" +
                "from {table}\n" +
                "where {table}.id = :NEW.id;\n" +
                "l_{attribute} {table}.{attribute}%type;\n" +
                "BEGIN\n" +
                "open lc_{table};\n" +
                "fetch lc_{table} into l_{attribute};" +
                "close lc_{table};\n" +
                "I_Passed := l_{attribute} {operator} ?;\n");

        ruletypeTemplates.add(ACMP);
        ruletypeTemplates.add(AOTH);
        ruletypeTemplates.add(EOTH);
        ruletypeTemplates.add(ICMP);
        ruletypeTemplates.add(LST);
        ruletypeTemplates.add(MODI);
        ruletypeTemplates.add(RNG);
        ruletypeTemplates.add(TCMP);
        ruletypeTemplates.add(TOTH);

        TemplateData templateData = new TemplateData(templateDTO, triggerTemplate, ruletypeTemplates, procedureTemplate, packageTemplate);
        result.add(templateData);
        return result;
    }

    public ProjectData getBusinessRule(int ticketId) {
        BusinessRuleService brs = ToolDbService.getBRService();
        ProjectService prs = ToolDbService.getPService();
        
        ArrayList<Brgqueue> brgsList = prs.getAllBrgqueue(ticketId);
        
        int projectId = brgsList.get(0).getLinBusinessrules().getProject().getId();
        int supportedDatabase = brgsList.get(0).getLinBusinessrules().getProject().getSupporteddatabase().getId();
        
        ArrayList<BRData> BRdataList = new ArrayList<>();
        
        //BRdata mapping...
        for (Brgqueue x : brgsList) {
            Businessrule businessrule = x.getLinBusinessrules().getBusinessrule();
            Project project = x.getLinBusinessrules().getProject();
            
            BRData brdata = new BRData();
            brdata.setPrimarykey(businessrule.getId());
            brdata.setOperator(businessrule.getKoppeloperator().getSupportedoperator().getOperator());
            brdata.setBRRuleType(businessrule.getBusinessruletype().getType());
            brdata.setTriggerMoment(businessrule.getPosibleTriggerEvents().getEvent());
            brdata.setSeverity(businessrule.getFailurehandling().getSeverity());
            brdata.setExceptionMessage(businessrule.getFailurehandling().getMessageText());
            brdata.setDatabasetype(project.getSupporteddatabase().getDatabasetype());
            brdata.setDatabaseshortname(project.getSupporteddatabase().getAbbreviation());
            
            ArrayList<Token> dbtokens = businessrule.getFailurehandling().getToken();
            HashMap<String, String> tokens = new HashMap<>();
            
            dbtokens.forEach((y) -> {
                tokens.put(y.getName(), y.getExpression());
            });
            brdata.setTokens(tokens);
            
            ArrayList<BusinessValues> busv = brs.getAllBusinessValues(businessrule);
            ArrayList<String> values = new ArrayList<>();
            for (BusinessValues y : busv) {
                int attributeCount = 0;
                if (y.getAttribute() != null && attributeCount == 0) {
                    attributeCount = attributeCount + 1;
                    brdata.setTablename(y.getAttribute().getTable().getName());
                    brdata.setTableID(y.getAttribute().getTable().getId());
                    brdata.setTarget(y.getAttribute().getName());
                } else if(y.getAttribute() != null && attributeCount > 0) {
                    brdata.setComparisonTable(y.getAttribute().getTable().getName());
                    brdata.setComparisonTarget(y.getAttribute().getName());
                } else {
                    values.add(y.getValue());
                }
            }
            brdata.setValues(values);
            
            
            BRdataList.add(brdata);
        }
        
        ProjectData projectdata = new ProjectData(projectId, supportedDatabase, BRdataList);
//        data = new ProjectData();
        return projectdata;
    }

    public boolean pushCode(List<CodeReturnData> code) {
    	// is secretly a push thing, don't tell the classname
    	BusinessRuleService bs = ToolDbService.getBRService();
    	boolean check = bs.insertTableTriggers(code);
        return check;
    }

    public String getTableCode(Integer tableID) {
        return null;
    }
}
