package domainGeneric.businessrule.tableTrigger.tablePackage;

import domainGeneric.businessrule.constraint.Constraint;
import domainGeneric.businessrule.standaloneTrigger.Trigger;
import domainGeneric.businessrule.tableTrigger.TriggerMoment;
import domainGeneric.template.TemplateService;
import org.json.JSONArray;
import org.json.JSONObject;

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
    private int tableID;
    private String Message = "not yet initiated";
    private TemplateService templateService;
    private Map<List<TriggerMoment>, Procedure> procedures = new HashMap();
    private boolean supported = false;
    private List<Trigger> lonelyTriggers = new ArrayList<>();
    private List<Constraint> constraints = new ArrayList<>();

    public TablePackage(String name, String databasetype, String table, String databasename, int tableID) {
        this.name = name;
        this.databasetype = databasetype;
        this.table = table;
        this.tableID = tableID;
        this.templateService = new TemplateService();

        supported = templateService.checkPackageSupport(databasetype);
        if (!supported) {
            this.name = databasename;
        }
    }

    public void addProcedure(List<String> triggerList, Procedure procedure) {
        List<TriggerMoment> triggermoments = new ArrayList<>();
        for (String moment : triggerList) {
            if (moment.equals("INSERT")) {
                triggermoments.add(TriggerMoment.INSERT);
            }
            if (moment.equals("UPDATE")) {
                triggermoments.add(TriggerMoment.UPDATE);
            }
            if (moment.equals("DELETE")) {
                triggermoments.add(TriggerMoment.DELETE);
            }
        }
    procedures.put(triggermoments, procedure);
    }

    public String getCode() {
//        TODO: Check on Package-support
        String code = getSpecificationCode();
        code += "\n/\n";

        code += getBodyCode() + "\n/\n";
        for (Trigger T : lonelyTriggers) {
            code += T.getCode() + "\n/\n";
        }
        return code;
    }

    private String getSpecificationCode() {
        String code = templateService.getPackageHeaderStartCode(databasetype, name);
        if (!supported) {
            return "";
        }
        for (Procedure p : procedures.values()) {
            code += p.getPackageSpecificationCode();
        }
        code += templateService.getPackageEndCode(databasetype, name);
        return code;
    }

    private String getBodyCode() {
        String code = templateService.getPackageBodyStartCode(databasetype, name, table);
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

    public int getTableID() {
        return tableID;
    }

    public void addStandaloneTrigger(Trigger trigger) {
        lonelyTriggers.add(trigger);
    }
    public void addConstraint(Constraint constraint) {constraints.add(constraint);}

    public String getTriggerCodes() {
        String code = "";
        for (Constraint C : constraints) {
            code += C.getCode() + "\n/\n";
        }
        return code;
    }

    public String getConstraintCodes() {
        String code = "";
        for (Trigger T : lonelyTriggers) {
            code += T.getCode() + "\n/\n";
        }
        return code;
    }
}
