package dataAccess;



import dataAccess.toolsdb.DataPull;
import dto.template.TemplateDummy;
import unstableTESTGround.dto.ProjectData;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPullService {
    private DataPull puller = new DataPull();
    public ProjectData getData(int ticket) {
        ProjectData result = puller.getBusinessRule(ticket);
        return result;
    }

    public boolean pushCode(String code, String primaryKey, String projectid,  String name) {
        return puller.pushCode(code, primaryKey, projectid, name);
    }



    public List<TemplateDummy> getNewTemplates(List<String> templateNames) {
        List<TemplateDummy> templates = puller.getNewTemplates(templateNames);
        return templates;
    }
}
