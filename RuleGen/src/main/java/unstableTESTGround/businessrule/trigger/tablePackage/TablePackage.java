package unstableTESTGround.businessrule.trigger.tablePackage;

import org.json.JSONArray;
import org.json.JSONObject;
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
    private boolean supported = false;

    public TablePackage(String name, String databasetype, String table, String initials, String message, TemplateService templateService, String databasename) {
        this.name = name;
        this.databasetype = databasetype;
        this.table = table;
        this.initials = initials;
        Message = message;
        this.templateService = templateService;

        supported = templateService.checkPackageSupport(databasetype);
        if (!supported) {
            this.name = databasename;
        }
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

    public String getCode() {
//        TODO: Check on Package-support
        String code = getSpecificationCode();
        code += "\n";

        code += getBodyCode();
        return code;
    }

    private String getSpecificationCode() {
        String code = templateService.getPackageHeaderStartCode(databasetype, name);
        if (!supported) {
            return "";
        }else { code += "\n";}
        for (Procedure p : procedures.values()) {
            code += p.getPackageSpecificationCode() + "\n";
        }
        code += templateService.getPackageEndCode(databasetype, name);
        return code;
    }

    private String getBodyCode() {
        String code = templateService.getPackageBodyStartCode(databasetype, name);
        for (Procedure P : procedures.values()) {
            code += "\n" + P.getCode() + "\n";
        }
        code += templateService.getPackageBodyEndCode(databasetype, name);
        return code;
    }


    public String getDeclarationCode(TriggerMoment moment) {
        String code = "";
        for (List<TriggerMoment> moments : procedures.keySet()) {
            if (moments.contains(moment)) {
                code += procedures.get(moments).getExcecutionCode() + "\n";
            }
        }
        return code;
    }
    public JSONObject getStatus() {
        JSONObject status = new JSONObject();
        status.put("Table", table);
        status.put("Message", Message);
        JSONArray procedurestatus = new JSONArray();
        for (Procedure P : procedures.values()) {
            procedurestatus.put(P.getStatus());
        }
        return status;
    }


    public String getTable() {
        return table;
    }
}
