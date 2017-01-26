package dto.businessrules;

import domainGeneric.businessrule.CType.CodeType;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.List;

/**
 * Created by Mitchell on 24/01/2017.
 */
public class BRToJSONConverter {
    private JSONArray result = new JSONArray();

    public BRToJSONConverter(List<CodeType> rules) {
        for (CodeType br : rules) {
            JSONObject info = new JSONObject();
            info.put("key", br.getPrimarykey());
            info.put("project", br.getProjectid());
            info.put("message", br.getMessage());
            result.put(info);
//            TODO: get these parameters
        }
    }

    public JSONArray getResult() {
        return result;
    }
}
