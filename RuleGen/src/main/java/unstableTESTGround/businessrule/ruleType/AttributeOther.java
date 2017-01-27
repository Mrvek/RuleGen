package unstableTESTGround.businessrule.ruleType;

import unstableTESTGround.template.TemplateService;

/**
 * Created by Mitchell on 25/01/2017.
 */
public class AttributeOther extends BRRuleType {
    private String booleanStatement;
    private String target;

    public AttributeOther(String operator, String databasetype, String booleanStatement, String target) {
        super(operator, new TemplateService(), databasetype, "THR");
        this.booleanStatement = booleanStatement;
        this.target = target;
    }

    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeOtherConstraintCode(databasetype, booleanStatement);
    }

    @Override
    public String getProcedureCode() {
        return manager.getRuleTypeOtherTriggerCode(databasetype, booleanStatement);
    }

    @Override
    public String getParameterCode() {
        return manager.getParameterRuletTypeCode(databasetype, target);
    }
}
