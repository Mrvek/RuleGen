package domainGeneric.businessrule.ruletype;

import domainGeneric.TemplateService;

import java.util.List;

/**
 * Created by Mitchell on 25/01/2017.
 */
public class AttributeList extends BRRuleType {
    private String table;
    private String target;
    private List<String> values;
    private String operator;

    public AttributeList(String operator, String databasetype, String table, String target, List<String> values) {
        super(operator, new TemplateService(), databasetype, "LST");
        this.table = table;
        this.target = target;
        this.values = values;
    }

    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeListConstraintCode(databasetype, target, values, operator);
    }

    @Override
    public String getTriggerCode() {
        return manager.getRuleTypeListTriggerCode(databasetype, table, target, operator, values);
    }
}
