package unstableTESTGround.businessrule.ruleType;

import unstableTESTGround.template.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeRange extends BRRuleType {
    private String from;
    private String to;


    public AttributeRange(String from, String to, String operator, String databasetype, String target) {
        super(operator, new TemplateService(), databasetype, "RNG");
        this.from = from;
        this.to = to;
        this.target = target;
    }

    @Override
    public String getConstraintCode() {
        return manager.getRuleTypeRangeConstraintCode(databasetype, target , from, operator, to);
    }

    @Override
    public String getProcedureCode(String passedName) {
        return manager.getRuleTypeRangeProcedureCode(databasetype, from, operator, to, target);
    }

    @Override
    public String getParameterCode() {
        return manager.getParameterRuletTypeCode(databasetype, target);
    }
}
