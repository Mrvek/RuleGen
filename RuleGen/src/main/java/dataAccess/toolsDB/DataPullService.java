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
    public List<BRDefinition> getData(int primaryKey) {
        List<BRDefinition> result = new ArrayList<>();

        List<String> values = new ArrayList<String>();
        values.add("number");
        values.add("1");
        BRDefinition einz = new BRDefinition("", values, "=", "ORA", "Compare", "number", null, null, null, null, "table");
        result.add(einz);

        List<String> valuestoo = new ArrayList<>();
        valuestoo.add("2");
        valuestoo.add("4");
        List<String> triggers = new ArrayList<>();
        triggers.add("insert");
        Map<String, String> tokens = new HashMap<>();
        tokens.put("[Message]", "Cruel");
        BRDefinition zwei = new BRDefinition("", valuestoo, "BETWEEN", "ORA", "Range", "number", triggers, "HELLO [Message], [Message] WORLD!", tokens, "Error", "table");
        result.add(zwei);
        return result;
    }

    public List<TemplateDummy> getNewTemplates(List<String> templateNames) {
        List<TemplateDummy> result = new ArrayList<>();
        List<TemplateDummy> templates = puller.getNewTemplates(templateNames);

        return result;
    }
}
