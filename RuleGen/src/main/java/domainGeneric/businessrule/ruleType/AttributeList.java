package domainGeneric.businessrule.ruleType;

import java.util.List;

/**
 * Created by Mitchell on 25/01/2017.
 */
public class AttributeList extends BRRuleType {
    private List<String> values;
    private String operator;

    public AttributeList(String operator, String databasetype, String target, List<String> values) {
        super(operator, databasetype, "LST", target);
        this.values = values;
        this.operator = operator;
    }

    @Override
    public String getConstraintCode() {
        return templateService.getRuleTypeListConstraintCode(databasetype, target, values, operator);
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeListProcedureCode(databasetype, target, operator, values);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeLSTCode(databasetype, target);
    }
}
