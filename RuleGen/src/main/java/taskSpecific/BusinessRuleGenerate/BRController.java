package taskSpecific.BusinessRuleGenerate;

import dataAccess.DataPushService;
import domainGeneric.BusinessRuleService;
import org.json.JSONArray;
import taskSpecific.TemplateUpdate.UpdateService;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRController {
    private BusinessRuleService BRService = new BusinessRuleService();
    private DataPushService DPushService = new DataPushService();


    public JSONArray Generate(List<String> i, String projectid) {
        UpdateService template = new UpdateService();
        template.update();
        System.out.println("Gathering Business Rules...");
        for (String key : i) {
            BRService.createBR(key, projectid);
        }
        System.out.println("");
        JSONArray result = BRService.getinfo();
        String code = BRService.getAllCode();
        System.out.println("\t Generated: " + code);
        System.out.println("Pushing code to TargetDatabase...");
        DPushService.Send(code);

        return result;
    }
}
