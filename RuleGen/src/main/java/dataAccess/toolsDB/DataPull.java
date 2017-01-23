package dataAccess.toolsDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPull {
    private DBConfig config;
    public List<TemplateDummy> getNewTemplates(List<String> templateNames) {
        List<TemplateDummy> templates = new ArrayList<>();
        config();
        return null;
    }

    private void config() {
        if (config == null) {
        }
    }
}
