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

        return templates;
    }

    private void config() {
        if (config == null) {
            config = new DBConfig();
        }
    }

    public BRDefinition getBusinessRule(int primaryKey) {
        List<String> valuestoo = new ArrayList<>();
        valuestoo.add("2");
        valuestoo.add("4");
        List<String> triggers = new ArrayList<>();
        triggers.add("insert");
        Map<String, String> tokens = new HashMap<>();
        tokens.put("[Message]", "Cruel");
        BRDefinition definitions = new BRDefinition("", valuestoo, "BETWEEN", "Oracle 11g", "Range", "number", triggers, "HELLO [Message], [Message] WORLD!", tokens, "Error", "table");
        return definitions;
    }
}
