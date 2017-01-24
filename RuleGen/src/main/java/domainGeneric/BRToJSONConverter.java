package domainGeneric;

import domainGeneric.businessRule.BR.BusinessRule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by Mitchell on 24/01/2017.
 */
public class BRToJSONConverter {
    private JSONArray result = new JSONArray();

    public BRToJSONConverter(List<BusinessRule> rules) {
        for (BusinessRule br : rules) {
            JSONObject info = new JSONObject();
            info.put("key", br.getPrimarykey());
            info.put("project", br.getProjectid());
            info.put("message", br.getMessage());
            result.add(info);
//            TODO: get these parameters
        }
    }

    public JSONArray getResult() {
        return result;
    }
}
