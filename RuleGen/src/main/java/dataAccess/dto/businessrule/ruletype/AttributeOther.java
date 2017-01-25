package dataAccess.dto.businessrule.ruletype;

import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 25/01/2017.
 */
public class AttributeOther extends BRRuleType {
    private String booleanStatement;

    public AttributeOther(String operator, String databasetype, String booleanStatement) {
        super(operator, new TemplateService(), databasetype, "THR");
        this.booleanStatement = booleanStatement;
    }

    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeOtherConstraintCode(databasetype, booleanStatement);
    }

    @Override
    public String getTriggerCode() {
        return manager.getRuleTypeOtherTriggerCode(databasetype, booleanStatement);
    }
}
