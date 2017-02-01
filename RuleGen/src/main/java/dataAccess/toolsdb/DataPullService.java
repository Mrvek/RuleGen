package dataAccess.toolsdb;



import domainGeneric.dto.CodeReturnData;
import domainGeneric.dto.ProjectData;
import domainGeneric.dto.TemplateData;

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

    public boolean pushCode(List<CodeReturnData> code) {
        return puller.pushCode(code);
    }

    public List<TemplateData> getNewTemplates(List<String> templateNames) {
        List<TemplateData> templates = puller.getNewTemplates(templateNames);
        return templates;
    }

    public String getTableCode(Integer tableID) {
        return puller.getTableCode(tableID);
    }
}
