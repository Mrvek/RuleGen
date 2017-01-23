package presentation.Rest;

import presentation.Rest.RestBusinessRule.BRDataFetch;
import taskSpecific.TemplateUpdate.UpdateService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class RestService {
    public static void main(String args[]) {
        UpdateService template = new UpdateService();
        template.update();
        List<Integer> keys = new ArrayList<>();
        keys.add(1);
        BRDataFetch dataFetch = new BRDataFetch();
        String result = dataFetch.getData(keys);
        System.out.println(result);
    }
}
