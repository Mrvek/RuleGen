package presentation.Rest;

import org.json.JSONArray;
import taskSpecific.BusinessRuleGenerate.BRController;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRDataFetch {
    private BRController controller = new BRController();

    public JSONArray getData(int ticket) {
        return controller.Generate(ticket);
    }

    public JSONArray getBR(String ticket) {
        JSONArray businessRule = getData(Integer.parseInt(ticket));
        return businessRule;
    }

    public boolean pushcode(String ticket) {
        boolean answer = controller.pushCodeToTarget(Integer.valueOf(ticket));
        return answer;
    }
}
