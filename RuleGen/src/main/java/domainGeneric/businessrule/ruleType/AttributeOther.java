package domainGeneric.businessrule.ruleType;

import domainGeneric.template.TemplateService;

/**
 * Created by Mitchell on 25/01/2017.
 */
public class AttributeOther extends BRRuleType {
    private String booleanStatement;

    public AttributeOther(String operator, String databasetype, String booleanStatement, String target) {
        super(operator, databasetype, "THR", target);
        this.booleanStatement = booleanStatement;
    }

    @Override
    public String getConstraintCode() {
        return templateService.getRuleTypeOtherConstraintCode(databasetype, booleanStatement);
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeOtherProcedureCode(databasetype, booleanStatement);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeTHRCode(databasetype, target);
    }
}
