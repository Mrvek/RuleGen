package dataAccess.dto.businessrule.br;

import dataAccess.dto.businessrule.ruletype.BRRuleType;
import domainGeneric.TemplateService;

/**
 * Created by Mitchell on 19/01/2017.
 */
public abstract class CodeType {
    protected String primarykey;
    protected String projectid;
    protected BRRuleType ruletype;
    protected String databasetype;
    protected String target;
    protected String table;
    protected NameGen name;
    protected String initials;
    protected TemplateService manager;
    protected String Message = "not yet initiated";


    public abstract String getCode();

    public String getPrimarykey() {
        return primarykey;
    }

    public String getProjectid() {
        return projectid;
    }

    public String getMessage() {
        return Message;
    }
}
