package unstableTESTGround.businessrule.trigger;

import org.json.JSONObject;
import unstableTESTGround.template.TemplateService;
import unstableTESTGround.businessrule.trigger.tablePackage.TablePackage;

import java.lang.*;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class TriggerOnTable {
    private String name;
    private String projectid;
    private String databasetype;
    private String table;
    private String initials;
    private String Message = "not yet initiated";
    private TemplateService templateService = new TemplateService();
    private TablePackage apackage;
    private Exception exception;

    public TriggerOnTable(String name, String projectid, String databasetype, String table, String initials, TemplateService templateService, TablePackage apackage, Exception exception) {
        this.name = name;
        this.projectid = projectid;
        this.databasetype = databasetype;
        this.table = table;
        this.initials = initials;
        this.templateService = templateService;
        this.apackage = apackage;
        this.exception = exception;
    }

    public String getCode() {
        String code = getStartCode();
        code += getDeclerationCode();
        code += getInsertMomentCode();
        code += getUpdateMomentCode();
        code += getDeleteMomentCode();
        code += exception.getExceptionTriggerEnd();
        code += getEndCode();
        Message = "Trigger Succesfully made";
        return code;
    }

    private String getStartCode() {
        String code = templateService.getTriggerStartCode(databasetype) + "\n";
        code += exception.getExceptionTriggerDeclarations();
        return code;
    }

    private String getDeclerationCode() {
        String code = templateService.getTriggerDeclarationCode(databasetype);
        return code;
    }

    private String getInsertMomentCode() {
        String code = templateService.getInsertMomentCode(databasetype) + "\n";
        code += apackage.getDeclarationCode(TriggerMoment.INSERT) + "\n";
        return code;
    }

    private String getUpdateMomentCode() {
        String code = templateService.getUpdateMomentCode(databasetype);
        code += apackage.getDeclarationCode(TriggerMoment.UPDATE) + "\n";
        return code;
    }

    private String getDeleteMomentCode() {
        String code = templateService.getDeleteMomentCode(databasetype);
        code += apackage.getDeclarationCode(TriggerMoment.DELETE) + "\n";
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
