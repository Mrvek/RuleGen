package unstableTESTGround.businessrule.trigger;

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
        return code;
    }

    private String getStartCode() {
        String code = templateService.getTriggerStartCode(databasetype);
        return code;
    }

    private String getDeclerationCode() {
        String code = templateService.getTriggerDeclarationCode(databasetype);
        return code;
    }

    private String getInsertMomentCode() {
        String code = templateService.getInsertMomentCode(databasetype);
        for (String declaration : apackage.getDeclarationCode(TriggerMoment.INSERT)) {
            code += "\t" + declaration + "\n";
        }
        return code;
    }

    private String getUpdateMomentCode() {
        String code = templateService.getUpdateMomentCode(databasetype);
        for (String declaration : apackage.getDeclarationCode(TriggerMoment.UPDATE)) {
            code += "\t" + declaration + "\n";
        }
        return code;
    }

    private String getDeleteMomentCode() {
        String code = templateService.getDeleteMomentCode(databasetype);
        for (String declaration : apackage.getDeclarationCode(TriggerMoment.DELETE)) {
            code += "\t" + declaration + "\n";
        }
        return code;
    }

    public String getTable() {
        return table;
    }
}
