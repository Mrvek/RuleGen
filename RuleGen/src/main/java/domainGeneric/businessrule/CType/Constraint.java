package domainGeneric.businessrule.CType;

import domainGeneric.businessrule.NameGen;
import domainGeneric.businessrule.ruletype.BRRuleType;
import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Constraint extends CodeType {

    public Constraint(String projectid, String primarykey, BRRuleType ruletype, String databasetype, String target, String table) {
        super(primarykey, projectid, ruletype, databasetype, target, table, new NameGen(ruletype.getShortname(), databasetype), "CSTR", new TemplateService());
    }

    @Override
    public String getCode() {
        String ruletypecode = ruletype.getConstraintCode();
        String result = manager.getConstraintCode(name.toString(), table, ruletypecode, databasetype, target);
        Message = "Code Generated";
        return result;
    }
}
