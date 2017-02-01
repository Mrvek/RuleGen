package dataAccess;



import dataAccess.toolsdb.DataPull;
import domainGeneric.dto.TemplateData;
import dto.template.TemplateDummy;
import domainGeneric.dto.ProjectData;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPullService {
    private DataPull puller = new DataPull();
    public domainGeneric.dto.ProjectData getData(int ticket) {
        ProjectData result = puller.getBusinessRule(ticket);
        return result;
    }

    public boolean pushCode(String code, int table_id, int supporteddatabase_id) {
        return puller.pushCode(code, table_id, supporteddatabase_id);
    }



    public List<TemplateData> getNewTemplates(List<String> templateNames) {
        List<TemplateData> templates = puller.getNewTemplates(templateNames);
        return templates;
    }
}
