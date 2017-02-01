package taskSpecific.BusinessRuleGenerate;

import dataAccess.DataPullService;
import dataAccess.DataPushService;
import domainGeneric.businessrule.BusinessruleService;

import org.json.JSONArray;
import taskSpecific.TemplateUpdate.UpdateService;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRController {
    private BusinessruleService BRService = new BusinessruleService();
    private DataPushService DPushService = new DataPushService();
    private DataPullService DPullService = new DataPullService();

    //TODO: REMOVE HARDCODED PARTS!
    
    public JSONArray Generate(int ticket) {
        UpdateService template = new UpdateService();
        template.update();

//        TODO: rewrite below to do the following: 1. create businessrules with the ticketnumber 2. getCode 3. push code to targetDB and toolsDB 4. return status (BRService.getStatus())
        System.out.println("Gathering Business Rules...");
        for (String key : BRIds) {
            BRService.createBR(1);
            String code = "";
            System.out.println("\tGenerated Code for projectid "+ ": " + code + "\n");
            System.out.println("Pushing code results to ToolDatabase...");
            String BRName = "";
            DPullService.pushCode(code, key, projectid, BRName);
            System.out.println("Pushing code to TargetDatabase...");
            DPushService.Send(code);
        }
        System.out.println("");
        JSONArray result = BRService.getStatus();
        return result;
    }
}
