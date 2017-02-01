package dataAccess.toolsdb;


import dataAccess.persistence.oracle.toolsdb.BusinessRuleService;
import dataAccess.persistence.oracle.toolsdb.ProjectService;
import dataAccess.persistence.oracle.toolsdb.SupportedUnitsService;
import dataAccess.persistence.oracle.toolsdb.ToolDbService;
import domainGeneric.dto.BRData;
import domainGeneric.dto.CodeReturnData;
import domainGeneric.dto.ProjectData;
import domainGeneric.dto.TemplateData;
import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.businessrules.GeneratedTrigger;
import dto.businessrules.Token;
import dto.project.Brgqueue;
import dto.project.Project;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.Template;
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
//TODO contains push services, refactor classname?
	
	
	//must receive templates from database en get the right ones?
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
        
        return result;
    }

//    private void config() {
//        /** config (re)moved? */
//        if (config == null) {
//            config = new DBConfig();
//        }
//    }

    public ProjectData getBusinessRule(int ticketId) {
    	//TODO Comparison table moet er komen en gevuld worden en ingevuld worden als comparisontarget aanwezig
    	//TODO BR data ook een nieuwe attribute komen genaam 
        
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
//        TODO: push code to the DB.table_trigger (find a way to get the table_id and supportedDatabases. BRData DTO might be changed)
    	//TODO Figure out if that todo above here it's last sentence still makes sense.
    	// is secretly a push thing, don't tell the classname
    	BusinessRuleService bs = ToolDbService.getBRService();
    	boolean check = bs.insertTableTriggers(code);
        return check;
    }

}
