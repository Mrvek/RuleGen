package domainGeneric.businessrule.ruleType;


import domainGeneric.template.TemplateService;

/**
 * Created by Mitchell on 19/01/2017.
 */
public abstract class BRRuleType {
    protected String operator;
    protected TemplateService templateService;
    protected String databasetype;
    protected String shortname;
    protected String target;

    public BRRuleType(String operator, String databasetype, String shortname, String target) {
        this.operator = operator;
        this.templateService = new TemplateService();
        this.databasetype = databasetype;
        this.shortname = shortname;
        this.target = target;
    }

    public String getShortname() {
        return shortname;
    }
    public abstract String getConstraintCode();
    public abstract String getProcedureCode(String passedName);
    public abstract String getParameterCode();

    public String getTarget() {
        return target;
    }
}
