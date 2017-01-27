package unstableTESTGround.template;

import unstableTESTGround.template.TemplateManager;

import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateService {
    private TemplateManager factory = new TemplateManager();


    public String getDeleteMomentCode(String databasetype) {
        return null;
    }

    public String getUpdateMomentCode(String databasetype) {
        return null;
    }

    public String getInsertMomentCode(String databasetype) {
        return null;
    }

    public String getTriggerStartCode(String databasetype) {
        return null;
    }

    public String getTriggerDeclarationCode(String databasetype) {
        return null;
    }

    public String getRuleTypeCompareConstraintCode(String databasetype, String target, String operator, String compareWith) {
        return null;
    }

    public String getRuleTypeCompareTriggerCode(String databasetype, String target, String operator, String compareWith) {
        return null;
    }

    public String getRuleTypeListConstraintCode(String databasetype, String target, List<String> values, String operator) {
        return null;
    }

    public String getRuleTypeListTriggerCode(String databasetype, String target, String operator, List<String> values) {
        return null;
    }

    public String getParameterRuletTypeCode(String databasetype, String target) {
        return null;
    }

    public String getRuleTypeOtherConstraintCode(String databasetype, String booleanStatement) {
        return null;
    }

    public String getRuleTypeOtherTriggerCode(String databasetype, String booleanStatement) {
        return null;
    }

    public String getRuleTypeRangeConstraintCode(String databasetype, String target, String from, String operator, String to) {
        return null;
    }

    public String getRuleTypeRangeTriggerCode(String databasetype, String from, String operator, String to, String target) {
        return null;
    }

    public String getPackageHeaderStartCode(String databasetype, String name) {
        return null;
    }

    public String getPackageEndCode(String databasetype, String name) {
        return null;
    }
}
