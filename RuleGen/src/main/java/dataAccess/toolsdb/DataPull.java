package dataAccess.toolsdb;


import dataAccess.persistence.oracle.toolsdb.BusinessRuleService;
import dataAccess.persistence.oracle.toolsdb.DBConfig;
import dataAccess.persistence.oracle.toolsdb.ProjectService;
import dataAccess.persistence.oracle.toolsdb.SupportedUnitsService;
import dataAccess.persistence.oracle.toolsdb.ToolDbService;
import domainGeneric.dto.BRData;
import domainGeneric.dto.ProjectData;
import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.businessrules.GeneratedTrigger;
import dto.businessrules.Token;
import dto.project.Brgqueue;
import dto.project.Project;
import dto.supported_units.SupportedDatabases;
import dto.template.TemplateDummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPull {
    private DBConfig config;

    public List<TemplateDummy> getNewTemplates(List<String> templateNames) {
        List<TemplateDummy> templates = new ArrayList<>();
        config();
//        TODO: get data out of database.

//        temporary data for testing
        if (!templateNames.contains("Oracle 11g")) {
            Map<String, String> optranslators = new HashMap<>();
            optranslators.put("=", "==");
            TemplateDummy data = new TemplateDummy("Oracle 12c", optranslators,
                    "CREATE OR REPLACE TRIGGER ? BEFORE ? ON ? FOR EACH ROW DECLARE E_except Exception; ",
                    "BEGIN IF (!I_passed) THEN RAISE E_Except; END IF; EXCEPTION when E_except then raise_application_error(-20100, ?); END; ",
                    "BEGIN IF (!I_passed) THEN RAISE E_Except; END IF; EXCEPTION when E_except then raise_application_error(-20200, ?); END; ",
                    "ALTER TABLE ? ADD CONSTRAINT ? CHECK (?); ",
                    "{Target} {Operator} ?",
                    "I_passed := :NEW.{Target} {Operator} ?; ",
                    "{Target} {Operator} {From} and {To}",
                    "I_passed := :NEW.{Target} {Operator} {From} and {To}; ",
                    "?",
                    "I_passed := ? ",
                    "{Target} {Operator} (?)",
                    "I_passed := :NEW.{Target} {Operator} (?) ");
            templates.add(data);
        }

        return templates;
    }

    private void config() {
        if (config == null) {
            config = new DBConfig();
        }
    }

    public ProjectData getBusinessRule(int ticketId) {
        
        SupportedUnitsService sus = ToolDbService.getSUService();
        BusinessRuleService brs = ToolDbService.getBRService();
        ProjectService prs = ToolDbService.getPService();
        
        ArrayList<Brgqueue> brgsList = prs.getAllBrgqueue(ticketId);
        
        int projectId = brgsList.get(0).getLinBusinessrules().getProject().getId();
        
        ArrayList<BRData> BRdataList = new ArrayList<>();
        
        //BRdata mapping...
        for (Brgqueue x : brgsList) {
            Businessrule businessrule = x.getLinBusinessrules().getBusinessrule();
            Project project = x.getLinBusinessrules().getProject();
            
            BRData brdata = new BRData();
            brdata.setPrimarykey(businessrule.getId()); //PrimaryKey of BusinessRule?
            brdata.setOperator(businessrule.getKoppeloperator().getSupportedoperator().getOperator());
            brdata.setBRRuleType(businessrule.getBusinessruletype().getType());
            brdata.setTriggerMoment(businessrule.getPosibleTriggerEvents().getEvent());
            brdata.setSeverity(businessrule.getFailurehandling().getSeverity());
            brdata.setExceptionMessage(businessrule.getFailurehandling().getMessageText());
            brdata.setDatabasetype(project.getSupporteddatabase().getDatabasetype());
            brdata.setDatabaseshortname(project.getSupporteddatabase().getAbbreviation());
            brdata.setTarget(project.getDatabaseschema().getName()); //Target is the DatabaseSchemaname?
            
            ArrayList<Token> dbtokens = businessrule.getFailurehandling().getToken();
            HashMap<String, String> tokens = new HashMap<>();
            
            dbtokens.forEach((y) -> {
                tokens.put(y.getName(), y.getExpression());
            });
            brdata.setTokens(tokens);
            
            ArrayList<BusinessValues> busv = brs.getAllBusinessValues(businessrule);
            ArrayList<String> values = new ArrayList<>();
            for (BusinessValues y : busv) {
                values.add(y.getValue());
                
                if (y.getAttribute() != null) {
                    brdata.setTablename(y.getAttribute().getTable().getName());
                    brdata.setComparisonTarget(y.getAttribute().getName()); //ComparisonTarget is the linked attribute?
                }
            }
            brdata.setValues(values);
            
            
            BRdataList.add(brdata);
        }
        
        ProjectData projectdata = new ProjectData(Integer.toString(projectId), BRdataList);
//        data = new ProjectData();
        return projectdata;
    }

    public boolean pushCode(String code, String primaryKey, String projectid, String name) {
        changename(Integer.parseInt(primaryKey), name);
        BaseService bs = new BaseService();
        SupportedDatabases DB = bs.getProject(Integer.parseInt(projectid)).getSupporteddatabase();
        Businessrule brs = bs.getBusinessrule(Integer.parseInt(primaryKey));
        GeneratedTrigger gtrigger = new GeneratedTrigger(code, "Hi!", brs, DB);
        bs.insertTrigger(gtrigger);
        return true;
    }

    private void changename(int primaryKey, String name) {
        BaseService bs = new BaseService();
        bs.setBusinessRuleName(primaryKey, name);
    }
}
