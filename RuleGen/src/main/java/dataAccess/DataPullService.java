package dataAccess;



import dataAccess.toolsdb.BRDefinition;
import dataAccess.toolsdb.DataPull;
import dataAccess.toolsdb.TemplateDummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPullService {
    private DataPull puller = new DataPull();
    public BRDefinition getData(String primaryKey, String projectid) {
        BRDefinition result = puller.getBusinessRule(primaryKey, projectid);
        return result;
    }

    public List<TemplateDummy> getNewTemplates(List<String> templateNames) {
        List<TemplateDummy> templates = puller.getNewTemplates(templateNames);
        return templates;
    }
}
