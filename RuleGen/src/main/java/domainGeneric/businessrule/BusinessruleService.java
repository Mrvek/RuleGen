package domainGeneric.businessrule;


import dto.domain.CodeReturnData;
import org.json.JSONArray;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BusinessruleService {
    private BusinessruleManager factory = new BusinessruleManager();

    public void createBR(int ticket) {
        factory.createBR(ticket);
    }


    public List<CodeReturnData> getAllCode() {
        return factory.getAllCode();
    }

    public JSONArray getStatus() {
        return factory.getinfo();
    }
}
