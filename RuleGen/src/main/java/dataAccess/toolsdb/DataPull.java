package dataAccess.toolsdb;


import dataAccess.persistence.oracle.toolsdb.BusinessRuleService;
import dataAccess.persistence.oracle.toolsdb.ProjectService;
import dataAccess.persistence.oracle.toolsdb.SupportedUnitsService;
import dataAccess.persistence.oracle.toolsdb.ToolDbService;
import domainGeneric.dto.BRData;
import domainGeneric.dto.ProjectData;
import domainGeneric.dto.TemplateData;
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
//    private DBConfig config;

    public List<TemplateData> getNewTemplates(List<String> currentTemplateNames) {
        List<TemplateData> templates = new ArrayList<>();
        config();
//        TODO: get data out of database.
//        TODO: write method so a filled TemplateData class can will be returned
        TemplateData data = null;

//        temporary data for testing
        if (!currentTemplateNames.contains("Oracle 11g")) {
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
        /** config (re)moved? */
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
                    brdata.setTarget(y.getAttribute().getName());
                } else if(y.getAttribute() != null && attributeCount > 0) {
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

    public boolean pushCode(String code, int table_id, int supportedDatabases) {
//        TODO: push code to the DB.table_trigger (find a way to get the table_id and supportedDatabases. BRData DTO might be changed)
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
