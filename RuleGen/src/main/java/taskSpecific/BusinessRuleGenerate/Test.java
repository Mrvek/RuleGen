package taskSpecific.BusinessRuleGenerate;

import java.util.ArrayList;
import java.util.List;
import junit.framework.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class Test {
    private BRController controller = new BRController();
    private String projectId;
    private List<String> brIds = new ArrayList<>();

    @Before
    public void setUp() {
        projectId = "36";
        brIds.add("74");
    }

    @org.junit.Test
    public void TestController() {
        String result = controller.Generate(brIds, projectId).toString();
        JSONArray array = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("project","74");
        obj.put("message","Code Generated");
        obj.put("key","36");
        array.put(obj);

        System.out.println("JsonReturnvalue: "+result);
        assertTrue(result.equals(String.valueOf(array.toString())));
    }


}
