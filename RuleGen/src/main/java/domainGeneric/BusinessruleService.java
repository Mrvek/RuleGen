package domainGeneric;


import domainGeneric.businessrule.BusinessruleManager;
import org.json.JSONArray;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class BusinessruleService {
    private BusinessruleManager factory = new BusinessruleManager();

    public void createBR(String primaryKey, String projectid) {
        factory.createBR(primaryKey, projectid);
    }


    public String getAllCode() {
        return factory.getAllCode();
    }

    public JSONArray getinfo() {
        return factory.getinfo();
    }
}
