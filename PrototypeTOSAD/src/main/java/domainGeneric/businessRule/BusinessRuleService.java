package domainGeneric.businessRule;



import dataAccess.toolsDB.BRDefinition;
import dataAccess.toolsDB.DataPullService;
import domainGeneric.businessRule.BR.BusinessRule;
import domainGeneric.businessRule.BR.Constraint;
import domainGeneric.businessRule.BR.Trigger;
import domainGeneric.businessRule.RuleType.BRRuleType;
import domainGeneric.businessRule.RuleType.Compare;
import domainGeneric.businessRule.RuleType.Range;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BusinessRuleService {
    private List<BusinessRule> rules = new ArrayList<>();
    private DataPullService datapuller = new DataPullService();

    public void createBR(int primaryKey) {
        List<BRDefinition> myData = datapuller.getData(primaryKey);
        for(BRDefinition BRData: myData) {
            BRRuleType ruletype = null;
            switch (BRData.BRRuleType) {
                case ("Compare"):
                    ruletype = new Compare(BRData.values.get(0), BRData.values.get(1), BRData.operator, BRData.databasetype);
                    break;
                case ("Range"):
                    ruletype = new Range(BRData.values.get(0), BRData.values.get(1), BRData.operator, BRData.databasetype, BRData.target);
                    break;
            }
            if (BRData.trigger == null || BRData.trigger.isEmpty() || BRData.Severity == null) {
                BusinessRule rule = new Constraint(ruletype, BRData.databasetype, BRData.target, BRData.tablename);
                rules.add(rule);

            } else {
                BusinessRule rule = new Trigger(ruletype, BRData.databasetype, BRData.target, BRData.Severity, BRData.exceptionMessage, BRData.tokens, BRData.trigger, BRData.tablename);
                rules.add(rule);
            }
        }
    }

    public String getAllCode() {
        String result = null;
        for (BusinessRule i : rules) {
            if (result ==  null) {
                result = i.getCode();
            }else {
                result += "\n\n" + i.getCode();
            }
        }
        return result;
    }
}
