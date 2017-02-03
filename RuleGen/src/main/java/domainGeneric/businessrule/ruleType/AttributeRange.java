package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class AttributeRange extends BRRuleType {
    private String from;
    private String to;
    private String table;

    public AttributeRange(String from, String to, String operator, String databasetype, String target, String table) {
        super(operator, databasetype, "ARNG", target);
        this.from = from;
        this.to = to;
        this.table = table;
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
        return templateService.getParameterRuleTypeRNGCode(databasetype, target, table);
    }
}
