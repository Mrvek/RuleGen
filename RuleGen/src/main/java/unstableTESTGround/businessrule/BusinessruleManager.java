package unstableTESTGround.businessrule;

import dataAccess.DataPullService;
import dto.businessrules.BRDefinition;
import dto.businessrules.BRToJSONConverter;
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
    private BRToJSONConverter jsonConverter;
    private NameGen nameGen = new NameGen();
    private String projectID;

    public void createBR(String primaryKey, String projectid) {
        BRDefinition BRData = datapuller.getData(primaryKey, projectid);
        this.projectID = projectid;
        BRRuleType ruletype = createRuleType(BRData);

        if (BRData.trigger == null || BRData.Severity == null || BRData.exceptionMessage == null || BRData.tokens.isEmpty() || BRData.trigger == null) {
            Constraint constraint = new Constraint(BRData.primarykey, ruletype, BRData.databasetype, BRData.target, BRData.tablename, nameGen.getConstraintName(BRData.databaseshortname, BRData.tablename, ruletype.getShortname(), BRData.target));
            constraintList.add(constraint);

        } else {
            Procedure procedure = new Procedure();
            TablePackage tablePackage = createOrGetPackage(BRData);
            tablePackage.addProcedure(BRData.trigger, procedure);
            TriggerOnTable trigger = createOrGetTrigger(BRData);
            if (!triggers.get(trigger).equals(tablePackage)) {
                triggers.put(trigger, tablePackage);
            }
        }
    }

    private TriggerOnTable createOrGetTrigger(BRDefinition brData) {
        for (TriggerOnTable trigger : triggers.keySet()) {
            if (trigger.getTable().equals(brData.tablename))
                return  trigger;
        }
        return new TriggerOnTable();
    }

    private TablePackage createOrGetPackage(BRDefinition brData) {
        for (TablePackage tablePackage : triggers.values()) {
            if (tablePackage.getTable().equals(brData.tablename)) {
                return tablePackage;
            }
        }
        return new TablePackage();
    }

    private BRRuleType createRuleType(BRDefinition BRData) {
        BRRuleType ruletype = null;

        switch (BRData.BRRuleType) {
            case ("ACMP"):
                ruletype = new AttributeCompare(BRData.target, BRData.values.get(1), BRData.operator, BRData.databasetype);
                break;
            case ("ARNG"):
                ruletype = new AttributeRange(BRData.values.get(0), BRData.values.get(1), BRData.operator, BRData.databasetype, BRData.target);
                break;
            case ("ALIS"):
                ruletype = new AttributeList(BRData.operator, BRData.databasetype, BRData.target, BRData.values);
                break;
            case ("AOTH"):
                ruletype = new AttributeOther(BRData.operator, BRData.databasetype, BRData.values.get(0), BRData.target);
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
