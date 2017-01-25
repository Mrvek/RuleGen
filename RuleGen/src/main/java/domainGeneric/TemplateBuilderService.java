package domainGeneric;

import dataAccess.DataPullService;
import dto.template.TemplateDummy;
import domainGeneric.template.Template;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateBuilderService {
    private DataPullService datapuller = new DataPullService();

    public Boolean checkForNewTemplates() {
        List<TemplateDummy> templates = datapuller.getNewTemplates(TemplateService.getTemplateNames());
        System.out.println("Checking for new templates...");
        if (templates.isEmpty()) {
            return false;
        } else {
            templates.forEach((td) -> {
                buildTemplate(td);
                System.out.println("\tTemplate found: " + td.name);
            });
            return true;
        }
    }

    private void buildTemplate(TemplateDummy td) {
        Template template = new Template(td.trigger, td.warning, td.error, td.constraint, td.constraintcompare,
                td.triggercompare, td.constraintRange, td.triggerRange, td.operatorTranslations, td.constraintOther, td.triggerOther, td.constraintList, td.triggerList);

        TemplateService.resetTemplates();
        TemplateService.addTemplate(td.name, template);
    }
}
