package domainGeneric.template;

import dataAccess.DataPullService;
import domainGeneric.dto.TemplateData;
import dto.template.TemplateDummy;

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
            templates.forEach((td) -> {
                buildTemplate(td);
                System.out.println("\tTemplate found: " + td.getDatabaseName());
            });
            return true;
        }
    }

    private void buildTemplate(TemplateData td) {
//        TODO: fill new Template() constructor
        Template template = new Template();
        TemplateManager.addTemplate(td.getDatabaseName(), template);
    }
}
