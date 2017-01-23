package presentation.Rest;

import taskSpecific.BusinessRuleGenerate.BRController;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRDataFetch {
    private BRController controller = new BRController();

    public String getData(List<Integer> keys) {
        return controller.Generate(keys);
    }
}
