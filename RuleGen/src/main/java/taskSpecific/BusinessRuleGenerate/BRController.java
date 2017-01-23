package taskSpecific.BusinessRuleGenerate;

import dataAccess.DataPushService;
import domainGeneric.BusinessRuleService;
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
        System.out.println("Gathering Business Rules...");
        for (int key : i) {
            BRService.createBR(key);
        }
        System.out.println("");
        String result = BRService.getAllCode();
        System.out.println("Pushing code to TargetDatabase...");
        DPushService.Send(result);
        return result;
    }
}
