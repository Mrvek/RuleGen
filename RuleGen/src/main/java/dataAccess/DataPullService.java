package dataAccess;



import dto.businessrules.BRDefinition;
import dataAccess.toolsdb.DataPull;
import dto.businessrules.Businessrule;
import dto.supported_units.SupportedDatabases;
import dto.template.TemplateDummy;

import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPullService {
    private DataPull puller = new DataPull();
    public BRDefinition getData(String primaryKey, String projectid) {
        BRDefinition result = puller.getBusinessRule(primaryKey, projectid);
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
