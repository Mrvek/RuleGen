package domainGeneric.template;

import dataAccess.toolsdb.DataPullService;
import domainGeneric.dto.TemplateData;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateBuilderService {
    private DataPullService datapuller = new DataPullService();

    public Boolean checkForNewTemplates() {
        List<TemplateData> templates = datapuller.getNewTemplates(TemplateManager.getTemplateNames());
        System.out.println("Checking for new templates...");
        if (templates.isEmpty()) {
            return false;
        } else {
            TemplateManager.resetTemplates();
            templates.forEach((td) -> {
                System.out.println("\tTemplate found: " + td.getTemplate().getName());
                TemplateManager.addTemplate(td);
            });
            return true;
        }
    }
}
