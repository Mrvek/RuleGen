package unstableTESTGround.businessrule.trigger.tablePackage;

import org.json.JSONObject;
import unstableTESTGround.businessrule.ruleType.BRRuleType;
import unstableTESTGround.businessrule.trigger.Exception;
import unstableTESTGround.template.TemplateService;

import java.util.Map;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class Procedure {
    private String primarykey;
    private BRRuleType ruletype;
    private String databasetype;
    private String attribute;
    private String table;
    private String initials;
    private TemplateService manager;
    private String name;
    private String Message = "not yet initiated";
    private String severity;
    private String ExceptionMessage;
    private Map<String, String> tokens;
    private Exception exception;
    private TemplateService templateService = new TemplateService();
    private String passedName;

    public Procedure(String primarykey, BRRuleType ruletype, String databasetype, String attribute, String table, String initials, TemplateService manager, String name, String severity, String exceptionMessage, Map<String, String> tokens, Exception exception) {
        this.primarykey = primarykey;
        this.ruletype = ruletype;
        this.databasetype = databasetype;
        this.attribute = attribute;
        this.table = table;
        this.initials = initials;
        this.manager = manager;
        this.name = name;
        this.severity = severity;
        ExceptionMessage = exceptionMessage;
        this.tokens = tokens;
        this.exception = exception;
    }

    /** Code for executing the procedure*/
    public String getExcecutionCode() {
        String code = templateService.getProcedureExecutionCode(databasetype, name, exception.getExceptionParameters());
        return code;
    }

    /** Code for creating a standalone procedure or a package_body procedure (ORA)*/
    public String getCode() {
        String code = templateService.getProcedureBodyStartCode(databasetype, name);
        code += templateService.getProcedureBodyDeclarationCode(databasetype, passedName);
        code += ruletype.getProcedureCode(passedName);
        code += exception.getAddExceptionInProcedureCode(severity, ExceptionMessage, tokens);
        code += templateService.getProcedureBodyEndCode(databasetype, name);
        return code;
    }

    public JSONObject getStatus() {
        JSONObject status = new JSONObject();
        status.put("ID", primarykey);
        status.put("Message", Message);
        return status;
    }

    public String getPrimarykey() {
        return primarykey;
    }

    public String getMessage() {
        return Message;
    }


    /** Code for the package specification*/
    public String getPackageSpecificationCode() {
        String code = templateService.getProcedureSpecification(name, exception.getExceptionProcedureParameters(), ruletype.getParameterCode());
        return code;
    }
}
