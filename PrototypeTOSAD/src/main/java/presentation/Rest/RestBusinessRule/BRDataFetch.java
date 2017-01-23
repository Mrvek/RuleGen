package presentation.Rest.RestBusinessRule;

import taskSpecific.BusinessRuleGenerate.BRGenerateService;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BRDataFetch {
    private BRGenerateService service = new BRGenerateService();

    public String getData(List<Integer> keys) {
        return service.getData(keys);
    }
}
