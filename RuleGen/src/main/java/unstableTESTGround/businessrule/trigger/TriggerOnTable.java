package unstableTESTGround.businessrule.trigger;

import unstableTESTGround.TemplateService;
import unstableTESTGround.businessrule.trigger.tablePackage.Procedure;
import unstableTESTGround.businessrule.trigger.tablePackage.TablePackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String getCode() {
        String code = getStartCode();
        code += getDeclerationCode();
        code += getInsertMomentCode();
        code += getUpdateMomentCode();
        code += getDeleteMomentCode();
        code += getExceptionEndCode();
        return code;
    }

    private String getStartCode() {
        String code = templateService.getTriggerStartCode();
        return code;
    }

    private String getDeclerationCode() {
        String code = templateService.getTriggerDeclarationCode();
        return code;
    }

    private String getInsertMomentCode() {
        String code = templateService.getInsertMomentCode();
        for (String declaration : apackage.getDeclarationCode(TriggerMoment.INSERT)) {
            code += "\t" + declaration + "\n";
        }
        return code;
    }

    private String getUpdateMomentCode() {
        String code = templateService.getInsertMomentCode();
        for (String declaration : apackage.getDeclarationCode(TriggerMoment.UPDATE)) {
            code += "\t" + declaration + "\n";
        }
        return code;
    }

    private String getDeleteMomentCode() {
        String code = templateService.getInsertMomentCode();
        for (String declaration : apackage.getDeclarationCode(TriggerMoment.DELETE)) {
            code += "\t" + declaration + "\n";
        }
        return code;
    }

    private String getExceptionEndCode() {
        String code = templateService.getTriggerExceptionCode();
        return code;
    }
}
