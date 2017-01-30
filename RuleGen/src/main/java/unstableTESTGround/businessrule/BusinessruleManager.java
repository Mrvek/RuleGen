package unstableTESTGround.businessrule;

import dataAccess.DataPullService;
import org.json.JSONArray;
import org.json.JSONObject;
import unstableTESTGround.businessrule.constraint.Constraint;
import unstableTESTGround.businessrule.ruleType.*;
import unstableTESTGround.businessrule.trigger.TriggerOnTable;
import unstableTESTGround.businessrule.trigger.tablePackage.Procedure;
import unstableTESTGround.businessrule.trigger.tablePackage.TablePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class BusinessruleManager {
    private Map<TriggerOnTable, TablePackage> triggers = new HashMap<>();
    private List<Constraint> constraintList = new ArrayList<>();
    private DataPullService datapuller = new DataPullService();
    private NameGen nameGen = new NameGen();
    private String projectID;

    public void createBR(int ticket) {
        ProjectData projectData = getAllData(ticket);
        this.projectID = projectData.getProjectID();
        for (BRData BR : projectData.getBusinessRules()) {
            BRRuleType ruletype = createRuleType(BR);

            if (BR.getTriggerMoment() == null || BR.getSeverity() == null || BR.getExceptionMessage() == null || BR.getTokens() == null || BR.getTokens().isEmpty()) {
                Constraint constraint = new Constraint(BR.getPrimarykey(), ruletype, BR.getDatabasetype(), BR.getTarget(), BR.getTablename(), nameGen.getConstraintName(BR.getDatabaseshortname(), BR.getTablename(), ruletype.getShortname(), BR.getTarget()));
                constraintList.add(constraint);

            } else {
                Procedure procedure = new Procedure();
                TablePackage tablePackage = createOrGetPackage(BR);
                tablePackage.addProcedure(BR.getTriggerMoment(), procedure);
                TriggerOnTable trigger = createOrGetTrigger(BR);
                if (!triggers.get(trigger).equals(tablePackage)) {
                    triggers.put(trigger, tablePackage);
                }
            }
        }
    }

    private ProjectData getAllData(int ticket) {
        ProjectData data = datapuller.getData(ticket);
        return data;
    }

    private TriggerOnTable createOrGetTrigger(BRData brData) {
        for (TriggerOnTable trigger : triggers.keySet()) {
            if (trigger.getTable().equals(brData.getTablename()))
                return  trigger;
        }
        return new TriggerOnTable();
    }

    private TablePackage createOrGetPackage(BRData brData) {
        for (TablePackage tablePackage : triggers.values()) {
            if (tablePackage.getTable().equals(brData.getTablename())) {
                return tablePackage;
            }
        }
        return new TablePackage();
    }

    private BRRuleType createRuleType(BRData BRData) {
        BRRuleType ruletype = null;

        switch (BRData.getBRRuleType()) {
            case ("ACMP"):
                ruletype = new AttributeCompare(BRData.getTarget(), BRData.getValue(0), BRData.getOperator(), BRData.getDatabasetype());
                break;
            case ("ARNG"):
                ruletype = new AttributeRange(BRData.getValue(0), BRData.getValue(1), BRData.getOperator(), BRData.getDatabasetype(), BRData.getTarget());
                break;
            case ("ALIS"):
                ruletype = new AttributeList(BRData.getOperator(), BRData.getDatabasetype(), BRData.getTarget(), BRData.getValues());
                break;
            case ("AOTH"):
                ruletype = new AttributeOther(BRData.getOperator(), BRData.getDatabasetype(), BRData.getValue(0), BRData.getTarget());
                break;
        }
        return ruletype;
    }


    public String getAllCode() {
        String code = "";
        for (Constraint constraint : constraintList) {
            code += constraint.getCode() + "\n/\n";
        }
        code += "\n";

        for (TablePackage TPackage : triggers.values()) {
            code = TPackage.getCode() + "\n/\n\n";
        }
        code += "\n";

        for (TriggerOnTable trigger : triggers.keySet()) {
            code += trigger.getCode() + "\n/\n\n";
        }
        System.out.println("\t Generated: " + code);
        return code;
    }

    public JSONArray getinfo() {
        JSONArray information = new JSONArray();
        JSONObject projectInfo = new JSONObject();
        projectInfo.put("projectID", projectID);

        JSONArray constraintInfo = new JSONArray();
        for (Constraint constraint : constraintList) {
            constraintInfo.put(constraint.getStatus());
        }
        projectInfo.put("Constraints", constraintInfo);

        JSONArray triggerInfo = new JSONArray();
        for (TriggerOnTable trigger : triggers.keySet()) {
            triggerInfo.put(trigger.getStatus());
        }
        projectInfo.put("Triggers", triggerInfo);

        JSONArray packageInfo = new JSONArray();
        for (TablePackage TPackage : triggers.values()) {
            packageInfo.put(TPackage.getStatus());
        }
        projectInfo.put("Packages", packageInfo);

        return information;
    }
}
