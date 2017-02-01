package domainGeneric.businessrule.ruleType;

import domainGeneric.template.TemplateService;

/**
 * Created by Mitchell on 31/01/2017.
 */
public class TupleOther extends BRRuleType {
    private String compareWith;

    public TupleOther(String operator, String databasetype, String target, String compareWith) {
        super(operator, databasetype, "TOTH", target);
        this.compareWith = compareWith;
    }

    @Override
    public String getConstraintCode() {
        return null;
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeTOTHProcedureCode(databasetype, target, operator, compareWith);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeTOTHCode(databasetype, target);
    }
}
