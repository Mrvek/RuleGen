package unstableTESTGround.businessrule.trigger.tablePackage;

import org.json.JSONArray;
import unstableTESTGround.template.TemplateService;
import unstableTESTGround.businessrule.trigger.TriggerMoment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class TablePackage {
    private String name;
    private String databasetype;
    private String table;
    private String initials;
    private String Message = "not yet initiated";
    private TemplateService templateService;
    private Map<List<TriggerMoment>, Procedure> procedures = new HashMap();

    public TablePackage(String name, String projectid, String databasetype, String table, String initials, String message, TemplateService templateService) {
        this.name = name;
        this.databasetype = databasetype;
        this.table = table;
        this.initials = initials;
        Message = message;
        this.templateService = templateService;
    }

    public void addProcedure(List<String> triggerList, Procedure procedure) {
        List<TriggerMoment> triggermoments = new ArrayList<>();
        for (String moment : triggerList) {
            if (moment.equals("Insert")) {
                triggermoments.add(TriggerMoment.INSERT);
            }
            if (moment.equals("Update")) {
                triggermoments.add(TriggerMoment.UPDATE);
            }
            if (moment.equals("Delete")) {
                triggermoments.add(TriggerMoment.DELETE);
            }
        }
    procedures.put(triggermoments, procedure);
    }

    public String getDeclarationCode(TriggerMoment moment) {
        String code = "";
        for (List<TriggerMoment> moments : procedures.keySet()) {
            if (moments.contains(moment)) {
                code += procedures.get(moments).getExcecutionCode();
            }
        }
        return code;
    }

    public String getCode() {
//        TODO: Check on Package-support
        String code = getHeaderCode();
        code += "\n";

        code += getBodyCode();
        return code;
    }

    private String getHeaderCode() {
        String code = templateService.getPackageHeaderStartCode(databasetype, name);
        for (Procedure p : procedures.values()) {
            code += "\n" + p.getPackageDeclarationCode();
        }
        code += templateService.getPackageEndCode(databasetype, name);
        return code;
    }

    private String getBodyCode() {
        return null;
    }

    public JSONArray getStatus() {
        return null;
    }


    public String getTable() {
        return table;
    }
}
