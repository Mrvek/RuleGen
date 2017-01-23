package taskSpecific.BusinessRuleGenerate;

import domainGeneric.businessRule.BusinessRuleService;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRController {
    private BusinessRuleService service = new BusinessRuleService();

    public String Generate(List<Integer> i) {
        for (int key : i) {
            service.createBR(key);
        }
        String result = service.getAllCode();
        return result;
    }
}
