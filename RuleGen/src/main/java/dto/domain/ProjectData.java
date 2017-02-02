package dto.domain;

import java.util.List;

/**
 * Created by Mitchell on 30/01/2017.
 */
public class ProjectData {
    private int projectID;
    private int supportedDatabase;
    private List<BRData> businessRules;

    public ProjectData(int projectID, int supportedDatabase, List<BRData> businessRules) {
        this.projectID = projectID;
        this.supportedDatabase = supportedDatabase;
        this.businessRules = businessRules;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getSupportedDatabase() {
        return supportedDatabase;
    }

    public List<BRData> getBusinessRules() {
        return businessRules;
    }
}
