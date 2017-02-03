package domainGeneric.businessrule.ruleType;

/**
 * Created by Mitchell on 31/01/2017.
 */
public class TupleCompare extends BRRuleType {
    private String compareWith;
    private String table;


    public TupleCompare(String operator, String databasetype, String compareWith, String target, String table) {
        super(operator, databasetype, "TCMP", target);
        this.compareWith = compareWith;
        this.table = table;
    }

    @Override
    public String getConstraintCode() {
        return templateService.getRuleTypeTCMPConstraintCode(databasetype, target, operator, compareWith);
    }

    @Override
    public String getProcedureCode(String passedName) {
        return templateService.getRuleTypeTCMPProcedureCode(databasetype, target, operator, compareWith);
    }

    @Override
    public String getParameterCode() {
        return templateService.getParameterRuleTypeTCMPCode(databasetype, target, compareWith, table);
    }
}
