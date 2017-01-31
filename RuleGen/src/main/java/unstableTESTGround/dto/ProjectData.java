package unstableTESTGround.dto;

import java.util.List;

/**
 * Created by Mitchell on 30/01/2017.
 */
public class ProjectData {
    private String projectID;
    private List<BRData> businessRules;

    public ProjectData(String projectID, List<BRData> businessRules) {
        this.projectID = projectID;
        this.businessRules = businessRules;
    }

    public String getProjectID() {
        return projectID;
    }

    public List<BRData> getBusinessRules() {
        return businessRules;
    }
}
