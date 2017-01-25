package presentation.Rest;


import org.json.JSONArray;
import spark.Request;
import spark.Response;
import taskSpecific.BusinessRuleGenerate.BRController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRDataFetch {
    private BRController controller = new BRController();

    public JSONArray getData(List<String> keys, String projectid) {
        return controller.Generate(keys, projectid);
    }

    public JSONArray getBR(Request request, Response response) {
        Response result = response;
        String key = request.attribute("BusinessRules");
        String projectid = request.attribute("project");
        List<String> keys = new ArrayList<>();
        keys.add(key);
        JSONArray businessRule = getData(keys, projectid);

        return businessRule;
    }
}
