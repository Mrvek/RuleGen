package domainGeneric.businessrule.ruleType;

import domainGeneric.template.TemplateService;

/**
 * Created by Mitchell on 31/01/2017.
 */
public class Modify extends BRRuleType {
    protected Modify(String operator, TemplateService manager, String databasetype, String shortname) {
        super(operator, manager, databasetype, shortname);
    }

    @Override
    public String getConstraintCode() {
        return null;
    }

    @Override
    public String getProcedureCode(String passedName) {
        return null;
    }

    @Override
    public String getParameterCode() {
        return null;
    }
}
