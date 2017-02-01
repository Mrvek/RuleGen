package taskSpecific.BusinessRuleGenerate;

import dataAccess.toolsdb.DataPullService;
import dataAccess.targetdb.DataPushService;
import domainGeneric.businessrule.BusinessruleService;

import domainGeneric.dto.CodeReturnData;
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
    
    public JSONArray Generate(int ticket) {
        UpdateService template = new UpdateService();
        template.update();

        System.out.println("Gathering Business Rules...");
        BRService.createBR(ticket);
        System.out.println("Generating Code...");
        List<CodeReturnData> code = BRService.getAllCode();
        for (CodeReturnData tableCode : code) {
            System.out.println("Code Generated:\n\t" + tableCode.getCode());
        }

        System.out.println("\nPushing code results to ToolDatabase...");
        DPullService.pushCode(code);
//        System.out.println("Pushing code to TargetDatabase...");
//        DPushService.Send(code);

        System.out.println("\n Returning Data...");
        JSONArray result = BRService.getStatus();
        return result;
    }

    public boolean pushCodeToTarget(Integer tableID) {
        String Code = DPullService.getTableCode(tableID);
        boolean answer = DPushService.Send(Code);
        return answer;
    }
}
