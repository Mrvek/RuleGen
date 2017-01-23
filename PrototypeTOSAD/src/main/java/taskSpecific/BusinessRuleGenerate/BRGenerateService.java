package taskSpecific.BusinessRuleGenerate;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRGenerateService {
    private BRController controller = new BRController();

    public String getData(List<Integer> i) {
        return controller.Generate(i);
    }
}
