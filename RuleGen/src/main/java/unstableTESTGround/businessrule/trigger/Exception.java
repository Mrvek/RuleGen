package unstableTESTGround.businessrule.trigger;

import unstableTESTGround.template.TemplateService;

import java.util.Map;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class Exception {
    private String databasetype;
    private TemplateService templateService = new TemplateService();
    private String errorStackName = "e_ErrorStack";
    private String warningStackName = "e_WarningStack";
    private String errorExceptionName = "e_Error";
    private String warningExceptionName = "e_Warning";

    public Exception(String databasetype, TemplateService templateService) {
        this.databasetype = databasetype;
        this.templateService = templateService;
    }

    public String getExceptionParameters() {
        return templateService.getExceptionParameters(databasetype, warningStackName, errorStackName);
    }

    public String getExceptionTriggerEnd() {
        String code = getExceptionRaiseWarning();
        code += getExceptionRaiseError();
        code += templateService.getExceptionExceptStartCode(databasetype);
        code += getExceptionExceptWarning();
        code += getExceptionExceptError();
        return code;
    }

    public String getExceptionTriggerDeclarations() {
        return templateService.getExceptionTriggerDeclarationCode(databasetype, warningStackName, warningExceptionName, errorStackName, errorExceptionName);
    }

    public String getExceptionProcedureParameters() {
        return warningStackName + ", " + errorStackName;
    }

    public String getAddExceptionInProcedureCode(String severity, String message, Map<String, String> tokens) {
        String code = "";
        if(severity.equals("Warning")) {
            code += templateService.getAddStringToExceptionStackCode(databasetype, warningStackName, message, tokens);
        }else {
            code += templateService.getAddStringToExceptionStackCode(databasetype, errorStackName, message, tokens);
        }
        return code;
    }

    private String getExceptionExceptError() {
        return templateService.getExceptionExceptErrorCode(databasetype, errorStackName, errorExceptionName);
    }

    private String getExceptionRaiseError() {
        return templateService.getExceptionRaiseErrorCode(databasetype, errorStackName, errorExceptionName);
    }

    private String getExceptionExceptWarning() {
        return templateService.getExceptionExceptWarningCode(databasetype, errorStackName, errorExceptionName);
    }

    private String getExceptionRaiseWarning() {
        return templateService.getExceptionRaiseWarningCode(databasetype, warningStackName, warningExceptionName);
    }


}
