package domainGeneric.businessrule;

import dataAccess.DataPullService;
import domainGeneric.businessrule.constraint.Constraint;
import domainGeneric.businessrule.ruleType.*;
import domainGeneric.businessrule.trigger.TriggerOnTable;
import domainGeneric.businessrule.trigger.tablePackage.Procedure;
import domainGeneric.businessrule.trigger.tablePackage.TablePackage;
import domainGeneric.dto.BRData;
import domainGeneric.dto.CodeReturnData;
import domainGeneric.dto.ProjectData;
import org.json.JSONArray;
import org.json.JSONObject;

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
    private int supportedDatabase;

    public void createBR(int ticket) {
        ProjectData projectData = getAllData(ticket);
        this.projectID = projectData.getProjectID();
        this.supportedDatabase = projectData.getSupportedDatabase();
        for (BRData BR : projectData.getBusinessRules()) {
            BRRuleType ruletype = createRuleType(BR);

//            TODO: add check if it's possible to make a constraint of the ruletype (3 ruletypes can't be constraints)
            if (BR.getTriggerMoment() == null || BR.getSeverity() == null || BR.getExceptionMessage() == null || BR.getTokens() == null || BR.getTokens().isEmpty()) {
                Constraint constraint = new Constraint(String.valueOf(BR.getPrimarykey()), ruletype, BR.getDatabasetype(), BR.getTarget(), BR.getTablename(), nameGen.getConstraintName(BR.getDatabaseshortname(), BR.getTablename(), ruletype.getShortname(), BR.getTarget()));
                constraintList.add(constraint);

            } else {
                Procedure procedure = new Procedure(String.valueOf(BR.getPrimarykey()), ruletype, BR.getDatabasetype(), BR.getTarget(), BR.getTablename(), nameGen.getProcedureName(BR.getDatabaseshortname(), BR.getTablename(), BR.getBRRuleType()), BR.getSeverity(), BR.getExceptionMessage(), BR.getTokens());
                TablePackage tablePackage = createOrGetPackage(BR);
                /** Hoe ziet de value van triggermoment eruit? */
                tablePackage.addProcedure(BR.getTriggerMoment(), procedure);
                TriggerOnTable trigger = createOrGetTrigger(BR, tablePackage);
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

    private TriggerOnTable createOrGetTrigger(BRData brData, TablePackage apackage) {
        for (TriggerOnTable trigger : triggers.keySet()) {
            if (trigger.getTable().equals(brData.getTablename()))
                return  trigger;
        }
        return new TriggerOnTable(nameGen.getTriggerName(brData.getDatabaseshortname(), brData.getTablename()), String.valueOf(brData.getPrimarykey()), brData.getDatabasetype(), brData.getTablename(), apackage);
    }

    private TablePackage createOrGetPackage(BRData brData) {
        for (TablePackage tablePackage : triggers.values()) {
            if (tablePackage.getTable().equals(brData.getTablename())) {
                return tablePackage;
            }
        }
        return new TablePackage(nameGen.getTablePackageName(brData.getDatabaseshortname(), brData.getTablename()), brData.getDatabasetype(), brData.getTablename(), brData.getDatabaseshortname());
    }

    private BRRuleType createRuleType(BRData BRData) {
        BRRuleType ruletype = null;

//        TODO: add the iteration 2 ruletypes to this list (their initials can be found in their classes)
        switch (BRData.getBRRuleType()) {
            case ("ACMP"):
                ruletype = new AttributeCompare(BRData.getTarget(), BRData.getTarget(), BRData.getOperator(), BRData.getDatabasetype(), BRData.getValue(0));
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


    public List<CodeReturnData> getAllCode() {
        List<CodeReturnData> result = new ArrayList<>();
        for (TriggerOnTable trigger : triggers.keySet()) {
            TablePackage tablePackage = triggers.get(trigger);

            String code = tablePackage.getCode();
            code += trigger.getCode();

            CodeReturnData Listvalue = new CodeReturnData(tablePackage.getTableID(), this.supportedDatabase, code);
            result.add(Listvalue);
        }

//        TODO: add constraints to the code of their corresponding table
//        String code = "";
//        for (Constraint constraint : constraintList) {
//            code += constraint.getCode() + "\n/\n";
//        }
        return result;
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
