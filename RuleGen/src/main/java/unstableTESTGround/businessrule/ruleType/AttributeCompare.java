package unstableTESTGround.businessrule.ruleType;

import unstableTESTGround.template.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeCompare extends BRRuleType {
    private String CompareWith;

    public AttributeCompare(String target, String compareWith, String operator, String databasetype) {
        super(operator, new TemplateService(), databasetype, "ACMP");
        this.target = target;
        this.CompareWith = compareWith;
    }


    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeACMPConstraintCode(databasetype, target, operator, CompareWith);
    }

    @Override
    public String getProcedureCode(String passedName) {
        return manager.getRuleTypeACMPProcedureCode(databasetype, target, operator, CompareWith);
    }

    @Override
    public String getParameterCode() {
        return manager.getParameterRuleTypeACMPCode(databasetype, target);
    }

}
