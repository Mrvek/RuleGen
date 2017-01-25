package domainGeneric;


import dataAccess.toolsDB.BRDefinition;
import dataAccess.DataPullService;
import domainGeneric.businessRule.BR.BusinessRule;
import domainGeneric.businessRule.BR.Constraint;
import domainGeneric.businessRule.BR.Trigger;
import domainGeneric.businessRule.RuleType.*;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BusinessRuleService {
    private List<BusinessRule> rules = new ArrayList<>();
    private DataPullService datapuller = new DataPullService();
    private BRToJSONConverter jsonConverter;

    public void createBR(String primaryKey, String projectid) {
        BRDefinition BRData = datapuller.getData(primaryKey, projectid);
        BRRuleType ruletype = null;

        switch (BRData.BRRuleType) {
            case ("AttributeCompare"):
                ruletype = new AttributeCompare(BRData.tablename, BRData.values.get(0), BRData.values.get(1), BRData.operator, BRData.databasetype);
                break;
            case ("AttributeRange"):
                ruletype = new AttributeRange(BRData.values.get(0), BRData.values.get(1), BRData.operator, BRData.databasetype, BRData.target, BRData.tablename);
                break;
            case ("AttributeList"):
                ruletype = new AttributeList(BRData.operator, BRData.databasetype, BRData.tablename, BRData.target, BRData.values);
                break;
            case ("AttributeOther"):
                ruletype = new AttributeOther(BRData.operator, BRData.databasetype, BRData.values.get(0));
                break;
        }

        if (BRData.trigger == null || BRData.trigger.isEmpty() || BRData.Severity == null) {
            BusinessRule rule = new Constraint(BRData.projectid, BRData.primarykey, ruletype, BRData.databasetype, BRData.target, BRData.tablename);
            rules.add(rule);

        } else {
            BusinessRule rule = new Trigger(BRData.projectid, BRData.primarykey, ruletype, BRData.databasetype, BRData.target, BRData.Severity, BRData.exceptionMessage, BRData.tokens, BRData.trigger, BRData.tablename);
            rules.add(rule);
        }
    }


    public String getAllCode() {
        String result = null;
        for (BusinessRule i : rules) {
            if (result == null) {
                result = i.getCode();
            } else {
                result += "\n\n" + i.getCode();
            }
        }

        System.out.println("Pushing code to ToolDatabase...");
//        TODO: push to toolDatabase
        System.out.println("ERROR 404: Code Implementation not found!");
        return result;
    }

    public JSONArray getinfo() {
        jsonConverter = new BRToJSONConverter(rules);
        return jsonConverter.getResult();
    }
}
