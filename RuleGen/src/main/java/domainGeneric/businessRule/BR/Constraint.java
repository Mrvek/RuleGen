package domainGeneric.businessRule.BR;

import domainGeneric.businessRule.RuleType.BRRuleType;
import domainGeneric.Template.TemplateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class Constraint extends BusinessRule {

    public Constraint(BRRuleType ruletype, String databasetype, String target, String table) {
        this.ruletype = ruletype;
        this.databasetype = databasetype;
        this.target = target;
        this.table = table;
        this.initials = "CSTR";
        this.name = new NameGen(ruletype.getShortname(), databasetype);
        this.manager = new TemplateService();
    }


    @Override
    public String getCode() {
        String ruletypecode = ruletype.getConstraintCode();
        String result = manager.getConstraintCode(name.toString(), table, ruletypecode, databasetype, target);
        return result;
    }
}
