package taskSpecific.BusinessRuleGenerate;

import dataAccess.projectDB.DataPushService;
import domainGeneric.businessRule.BusinessRuleService;
import taskSpecific.TemplateUpdate.UpdateService;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRController {
    private BusinessRuleService BRService = new BusinessRuleService();
    private DataPushService DPushService = new DataPushService();

    public String Generate(List<Integer> i) {
        UpdateService template = new UpdateService();
        template.update();
        for (int key : i) {
            BRService.createBR(key);
        }
        String result = BRService.getAllCode();
        DPushService.Send(result);
        return result;
    }
}
