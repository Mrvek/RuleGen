package domainGeneric.businessrule;

import dataAccess.DataPullService;
import domainGeneric.businessrule.CType.CodeType;
import domainGeneric.businessrule.CType.Constraint;
import domainGeneric.businessrule.CType.Trigger;
import domainGeneric.businessrule.ruletype.*;
import dto.businessrules.BRDefinition;
import dto.businessrules.BRToJSONConverter;
import dto.businessrules.Businessrule;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class BusinessruleManager {
//    private List<CodeType> rules = new ArrayList<>();
    private Map<String, CodeType> rules = new HashMap<>();
    private DataPullService datapuller = new DataPullService();
    private BRToJSONConverter jsonConverter;

    public void createBR(String primaryKey, String projectid) {
        BRDefinition BRData = datapuller.getData(primaryKey, projectid);
        BRRuleType ruletype = null;

        switch (BRData.BRRuleType) {
            case ("AttributeCompare"):
                ruletype = new AttributeCompare(BRData.target, BRData.values.get(1), BRData.operator, BRData.databasetype);
                break;
            case ("AttributeRange"):
                ruletype = new AttributeRange(BRData.values.get(0), BRData.values.get(1), BRData.operator, BRData.databasetype, BRData.target);
                break;
            case ("AttributeList"):
                ruletype = new AttributeList(BRData.operator, BRData.databasetype, BRData.target, BRData.values);
                break;
            case ("AttributeOther"):
                ruletype = new AttributeOther(BRData.operator, BRData.databasetype, BRData.values.get(0));
                break;
        }

//        TODO: Proper check for constraints
        if (BRData.trigger == null || BRData.trigger.isEmpty() || BRData.Severity == null) {
            CodeType rule = new Constraint(BRData.projectid, BRData.primarykey, ruletype, BRData.databasetype, BRData.target, BRData.tablename);
            rules.put(primaryKey, rule);

        } else {
            CodeType rule = new Trigger(BRData.projectid, BRData.primarykey, ruletype, BRData.databasetype, BRData.target, BRData.tablename, BRData.Severity, BRData.exceptionMessage, BRData.tokens, BRData.trigger);
            rules.put(primaryKey, rule);
        }
    }


    public String getAllCode() {
        String result = null;
        for (String i : rules.keySet()) {
            if (result == null) {
                result = rules.get(i).getCode();
            } else {
                result += "\n\n" + rules.get(i).getCode();
            }
        }
        System.out.println("\t Generated: " + result);

        System.out.println("Pushing code to ToolDatabase...");
//        TODO: push to toolDatabase
        System.out.println("\tERROR 404: Code Implementation not found!");
        return result;
    }

    public JSONArray getinfo() {
        jsonConverter = new BRToJSONConverter(rules);
        return jsonConverter.getResult();
    }

    public String getCodeforRule(String key) {
        for(String CT : rules.keySet()) {
            if (CT.equals(key)) {
                return rules.get(CT).getCode();
            }
        }
        return "";
    }

    public String getName(String key) {
        for(String CT : rules.keySet()) {
            if (CT.equals(key)) {
                return rules.get(CT).getName();
            }
        }
        return "Wrong Key!";
    }
}
