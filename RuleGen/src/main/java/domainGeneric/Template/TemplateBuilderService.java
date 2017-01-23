package domainGeneric.Template;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dataAccess.toolsDB.DataPullService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class TemplateBuilderService {
//    private static String templates = "src" + File.separator + "main" + File.separator + "java" + File.separator + "domainGeneric" + File.separator + "Template" + File.separator + "LocalTemplates.json";
    private DataPullService datapuller = new DataPullService();

    public TemplateBuilderService() {
    }

    public static void Build() {
        TemplateService.resetTemplates();
        Map<String, String> ORAOperators = new HashMap<>();
        ORAOperators.put("=", "==");
        Template Oracle = new Template("CREATE OR REPLACE TRIGGER ? BEFORE ? ON ? FOR EACH ROW DECLARE E_except Exception",
                " EXCEPTION when E_except then raise_application_error(-2000, ?); END;",
                " EXCEPTION when E_except then raise_application_error(-2000, ?); END;",
                "ALTER TABLE ? ADD CONSTRAINT ? CHECK (?);",
                "? ? ?",
                " BEGIN IF (!(? ? ?)) THEN E_exception; END IF;",
                "? ? ? AND ?",
                " BEGIN IF(!(? ? ? AND ?)) THEN E_exception; END IF;", ORAOperators);
        TemplateService.addTemplate("ORA", Oracle);

    }


//    public static void BuildTemplates() {
//        try {
//            final Type REVIEW_TYPE = new TypeToken<List<GsonTemplate>>() {
//            }.getType();
//            Gson gson = new Gson();
//            JsonReader reader = new JsonReader(new FileReader(templates));
//            List<GsonTemplate> data = gson.fromJson(reader, REVIEW_TYPE);
//            String result = "Found Templates:";
//            for (GsonTemplate d : data) {
//                result += "\n\t\t" + d.Name;
//            }
//            result += "\n";
//            System.out.println(result);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    static {
//        BuildTemplates();
//
//
//    }
//
    public Boolean checkForNewTemplates() {
        datapuller.getNewTemplates(TemplateService.getTemplateNames());
        return true;
    }
}
