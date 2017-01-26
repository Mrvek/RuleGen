package taskSpecific.BusinessRuleGenerate;

import dataAccess.DataPullService;
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
    private DataPullService DPullService = new DataPullService();


    public JSONArray Generate(List<String> BRIds, String projectid) {
        UpdateService template = new UpdateService();
        template.update();
        System.out.println("Gathering Business Rules...");
        for (String key : BRIds) {
            BRService.createBR(key, projectid);
            String code = BRService.getCodeforKey(key);
            System.out.println("Pushing code results to ToolDatabase...");
            String BRName = BRService.getName(key);
            DPullService.pushCode(code, key, projectid, BRName);
            System.out.println("Pushing code to TargetDatabase...");
            DPushService.Send(code);
        }
        System.out.println("");
        JSONArray result = BRService.getinfo();
        return result;
    }
}
