package unstableTESTGround.businessrule;

import java.util.List;

/**
 * Created by Mitchell on 30/01/2017.
 */
public class ProjectData {
    private String projectID;
    private List<BRData> businessRules;

    public String getProjectID() {
        return projectID;
    }

    public List<BRData> getBusinessRules() {
        return businessRules;
    }
}
