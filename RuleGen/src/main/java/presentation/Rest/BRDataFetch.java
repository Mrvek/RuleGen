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

    public JSONArray getData(int ticket) {
        return controller.Generate(ticket);
    }

    public JSONArray getBR(Request request, Response response) {
        Response result = response;
        int ticket = request.attribute("project");
        List<String> keys = new ArrayList<>();
        JSONArray businessRule = getData(ticket);

        return businessRule;
    }
}
