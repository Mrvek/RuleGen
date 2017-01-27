package unstableTESTGround.businessrule.trigger.tablePackage;

import unstableTESTGround.template.TemplateService;
import unstableTESTGround.businessrule.trigger.TriggerMoment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class TablePackage {
    private String name;
    private String projectid;
    private String databasetype;
    private String table;
    private String initials;
    private String Message = "not yet initiated";
    private TemplateService templateService;
    private Map<List<TriggerMoment>, Procedure> procedures = new HashMap();

    public TablePackage(String name, String projectid, String databasetype, String table, String initials, String message, TemplateService templateService) {
        this.name = name;
        this.projectid = projectid;
        this.databasetype = databasetype;
        this.table = table;
        this.initials = initials;
        Message = message;
        this.templateService = templateService;
    }

    public void addProcedure(List<TriggerMoment> triggerMoments, Procedure procedure) {
        procedures.put(triggerMoments, procedure);
    }

    public List<String> getDeclarationCode(TriggerMoment moment) {
        return null;
    }

    public String getCode() {
        return null;
    }


}
