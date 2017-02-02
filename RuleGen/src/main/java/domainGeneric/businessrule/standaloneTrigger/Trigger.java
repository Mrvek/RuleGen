package domainGeneric.businessrule.standaloneTrigger;

import domainGeneric.businessrule.ruleType.BRRuleType;
import domainGeneric.businessrule.tableTrigger.Exception;
import domainGeneric.businessrule.tableTrigger.tablePackage.TablePackage;
import domainGeneric.template.TemplateService;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Mitchell on 02/02/2017.
 */
public class Trigger {
    private String name;
    private int projectid;
    private String databasetype;
    private String table;
    private BRRuleType ruleType;
    private String ExceptionMessage;
    private Map<String, String> tokens;
    private String Message = "not yet initiated";
    private TemplateService templateService = new TemplateService();
    private Exception exception;

    public Trigger(String name, int projectid, String databasetype, String table, BRRuleType ruleType, String exceptionMessage, Map<String, String> tokens) {
        this.name = name;
        this.projectid = projectid;
        this.databasetype = databasetype;
        this.table = table;
        this.ruleType = ruleType;
        ExceptionMessage = exceptionMessage;
        this.tokens = tokens;
        this.templateService = new TemplateService();
        this.exception = new Exception(databasetype, templateService);
    }

    public String getCode() {
        String code = getStartCode();

        code += ruleType.getConstraintCode();

        code += exception.getExceptionTriggerEnd();
        code += getEndCode();
        Message = "Trigger Succesfully made";
        return code;
    }

    private String getStartCode() {
        String code = templateService.getTriggerStartCode(databasetype, name, table) + "\n";
        code += templateService.getTriggerDeclarationCode(databasetype);
        return code;
    }

    private String getEndCode() {
        String code = templateService.getTriggerEndCode(databasetype, name);
        return code;
    }

    public String getTable() {
        return table;
    }

    public JSONObject getStatus() {
        JSONObject status = new JSONObject();
        status.put("Table", table);
        status.put("Message", Message);
        return status;
    }
}