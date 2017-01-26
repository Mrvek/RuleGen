package taskSpecific.BusinessRuleGenerate;

import dataAccess.DataPushService;
import domainGeneric.BusinessruleService;
import org.json.JSONArray;
import taskSpecific.TemplateUpdate.UpdateService;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRController {
    private BusinessruleService BRService = new BusinessruleService();
    private DataPushService DPushService = new DataPushService();


    public JSONArray Generate(List<String> i, String projectid) {
        UpdateService template = new UpdateService();
        template.update();
        System.out.println("Gathering Business Rules...");
        for (String key : i) {
            BRService.createBR(key, projectid);
        }
        String code = BRService.getAllCode();
        System.out.println("");
        JSONArray result = BRService.getinfo();
        System.out.println("Pushing code to TargetDatabase...");
        DPushService.Send(code);

        return result;
    }
}
