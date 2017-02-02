package dataAccess.toolsdb;



import dto.domain.CodeReturnData;
import dto.domain.ProjectData;
import dto.domain.TemplateData;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPullService {
    private DataPull puller = new DataPull();
    public dto.domain.ProjectData getData(int ticket) {
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
