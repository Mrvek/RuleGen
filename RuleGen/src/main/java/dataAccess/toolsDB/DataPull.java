package dataAccess.toolsDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class DataPull {
    private DBConfig config;
    public List<TemplateDummy> getNewTemplates(List<String> templateNames) {
        List<TemplateDummy> templates = new ArrayList<>();
        config();
//        TODO: get data out of database

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
            templates.add(data);
        }

        return templates;
    }

    private void config() {
        if (config == null) {
            config = new DBConfig();
        }
    }

    public BRDefinition getBusinessRule(int primaryKey) {
//        Temporary data for testing
        List<String> valuestoo = new ArrayList<>();
        valuestoo.add("2");
        valuestoo.add("4");
        List<String> triggers = new ArrayList<>();
        triggers.add("insert");
        Map<String, String> tokens = new HashMap<>();
        tokens.put("[Message]", "Cruel");
        BRDefinition definitions = new BRDefinition("", valuestoo, "BETWEEN", "Oracle 11g", "Range", "number", triggers, "HELLO [Message], [Message] WORLD!", tokens, "Error", "table");
        System.out.println("\tBRDefenitions found for a " + definitions.databasetype + " " + definitions.BRRuleType + "Rule");
        return definitions;
    }
}
