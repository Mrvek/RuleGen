package domainGeneric.businessrule.ruleType;

import domainGeneric.template.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeRange extends BRRuleType {
    private String from;
    private String to;


    public AttributeRange(String from, String to, String operator, String databasetype, String target) {
        super(operator, databasetype, "RNG", target);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getConstraintCode() {
        return templateService.getRuleTypeRangeConstraintCode(databasetype, target , from, operator, to);
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeRangeProcedureCode(databasetype, from, operator, to, target);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeRNGCode(databasetype, target);
    }
}
