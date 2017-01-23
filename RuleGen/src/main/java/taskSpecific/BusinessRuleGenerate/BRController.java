package taskSpecific.BusinessRuleGenerate;

import domainGeneric.businessRule.BusinessRuleService;
import taskSpecific.TemplateUpdate.UpdateService;

import java.awt.*;
import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRController {
    private BusinessRuleService service = new BusinessRuleService();
    public String Generate(List<Integer> i) {
        UpdateService template = new UpdateService();
        template.update();
        for (int key : i) {
            service.createBR(key);
        }
        String result = service.getAllCode();
        return result;
    }
}
