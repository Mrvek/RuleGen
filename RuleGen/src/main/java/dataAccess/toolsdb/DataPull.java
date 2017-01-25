package dataAccess.toolsdb;

import dataAccess.dto.businessrules.BRDefinition;
import dataAccess.dto.template.TemplateDummy;

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
                    "CREATE OR REPLACE TRIGGER ? BEFORE ? ON ? FOR EACH ROW DECLARE E_except Exception; ",
                    "BEGIN IF (!I_passed) THEN RAISE E_Except; END IF; EXCEPTION when E_except then raise_application_error(-20100, ?); END; ",
                    "BEGIN IF (!I_passed) THEN RAISE E_Except; END IF; EXCEPTION when E_except then raise_application_error(-20200, ?); END; ",
                    "ALTER TABLE ? ADD CONSTRAINT ? CHECK (?); ",
                    "{Target} {Operator} ?",
                    "I_passed := :NEW.{Target} {Operator} ?; ",
                    "{Target} {Operator} ? and ?",
                    "I_passed := :NEW.{Target} {Operator} ? and ?; ",
                    "?",
                    "I_passed := ? ",
                    "{Target} {Operator} (?)",
                    "I_passed := :NEW.{Target} {Operator} (?) ");
            templates.add(data);
        }

        return templates;
    }

    private void config() {
        if (config == null) {
            config = new DBConfig();
        }
    }

    public BRDefinition getBusinessRule(String primaryKey, String projectid) {
//        Temporary data for testing
        List<String> valuestoo = new ArrayList<>();
        valuestoo.add("2");
        valuestoo.add("4");
        List<String> triggers = new ArrayList<>();
        triggers.add("insert");
        Map<String, String> tokens = new HashMap<>();
        tokens.put("[Message]", "Cruel");
        BRDefinition definitions = new BRDefinition("1", "", "1", valuestoo, "BETWEEN", "Oracle 11g", "AttributeRange", "number", triggers, "HELLO [Message], [Message] WORLD!", tokens, "Error", "table");
        System.out.println("\tBRDefenitions found for a " + definitions.databasetype + " " + definitions.BRRuleType + "Rule");
        return definitions;
    }
}
