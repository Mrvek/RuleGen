package dataAccess.toolsDB;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPullService {
    private DataPull puller = new DataPull();
    public BRDefinition getData(int primaryKey) {
        BRDefinition result = puller.getBusinessRule(primaryKey);
        return result;
    }

    public List<TemplateDummy> getNewTemplates(List<String> templateNames) {
        List<TemplateDummy> result = new ArrayList<>();
        List<TemplateDummy> templates = puller.getNewTemplates(templateNames);


//        temporary data for testing
        if (!templateNames.contains("Oracle 11g")) {
            Map<String, String> optranslators = new HashMap<>();
            optranslators.put("=", "==");
            TemplateDummy data = new TemplateDummy("Oracle 11g", optranslators,
                    "CREATE OR REPLACE TRIGGER ? BEFORE ? ON ? FOR EACH ROW DECLARE E_except Exception",
                    " EXCEPTION when E_except then raise_application_error(-2000, ?); END;",
                    "EXCEPTION when E_except then raise_application_error(-2000, ?); END;",
                    "ALTER TABLE ? ADD CONSTRAINT ? CHECK (?);",
                    "? ? ?",
                    " BEGIN IF (!(? ? ?)) THEN E_exception; END IF;",
                    "? ? ? AND ?",
                    " BEGIN IF(!(? ? ? AND ?)) THEN E_exception; END IF;");
            result.add(data);
        }
        return result;
    }
}
