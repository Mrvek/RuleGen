package unstableTESTGround.businessrule.trigger.tablePackage;

import unstableTESTGround.TemplateService;
import unstableTESTGround.businessrule.trigger.TriggerMoment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class TablePackage {
    private TemplateService templateService;
    private Map<List<TriggerMoment>, Procedure> procedures = new HashMap();

    public List<String> getDeclarationCode(TriggerMoment moment) {
        return null;
    }

    public String getCode() {
        return null;
    }


}
