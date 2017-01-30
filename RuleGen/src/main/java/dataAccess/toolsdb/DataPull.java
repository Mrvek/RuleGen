package dataAccess.toolsdb;

import dataAccess.persistence.oracle.BaseDAO;
import dataAccess.persistence.oracle.BaseService;
import dto.businessrules.*;
import dto.project.Attribute;
import dto.project.Table;
import dto.supported_units.SupportedDatabases;
import dto.template.TemplateDummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataAccess.persistence.oracle.toolsdb.DBConfig;
import unstableTESTGround.businessrule.ProjectData;

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
            TemplateDummy data = new TemplateDummy("Oracle 12c", optranslators,
                    "CREATE OR REPLACE TRIGGER ? BEFORE ? ON ? FOR EACH ROW DECLARE E_except Exception; ",
                    "BEGIN IF (!I_passed) THEN RAISE E_Except; END IF; EXCEPTION when E_except then raise_application_error(-20100, ?); END; ",
                    "BEGIN IF (!I_passed) THEN RAISE E_Except; END IF; EXCEPTION when E_except then raise_application_error(-20200, ?); END; ",
                    "ALTER TABLE ? ADD CONSTRAINT ? CHECK (?); ",
                    "{Target} {Operator} ?",
                    "I_passed := :NEW.{Target} {Operator} ?; ",
                    "{Target} {Operator} {From} and {To}",
                    "I_passed := :NEW.{Target} {Operator} {From} and {To}; ",
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

    public ProjectData getBusinessRule(int ticket) {


        BaseService bs = new BaseService();
        Businessrule brs = bs.getBusinessrule(Integer.parseInt(primaryKey));
        String jdbc = "";
        ArrayList<BusinessValues> values = bs.getAllBusinessValues(brs);
        ArrayList<String> valuables = new ArrayList<>();
        String target = "YOLO";
        String tablename = "HOLO";
        for (BusinessValues V : values) {
            if (V.getType().equals("Attribute")) {
//                target = V.getAttribute().getName();
//                tablename = V.getAttribute().getTable().getName();
            } if(V.getType().equals("Min")){
                valuables.add(V.getValue());
            }
        }
        for (BusinessValues V : values) {
            if (V.getType().equals("Max")) {
                valuables.add(V.getValue());
            }
        }
        String operator = brs.getKoppeloperator().getSupportedoperator().getOperator();
        SupportedDatabases databasetype = bs.getProject(Integer.parseInt(projectid)).getSupporteddatabase();
        BusinessruleType BRRuleType = brs.getBusinessruletype();
        List<String> triggers = new ArrayList<>();
        triggers.add("insert");
        triggers.add("update");
        String exception = "Hello [HI] World!";
        Map<String, String> tokens = new HashMap<>();
        tokens.put("[HI]", "HAPPY");
        String severity = "Warning";

//        BRDefinition definitions = new BRDefinition(projectid, jdbc, primaryKey, valuables, operator, databasetype.getDatabasetype(), "AttributeRange", target, triggers, exception, tokens, severity, tablename);




//        Temporary data for testing
       /* List<String> valuestoo = new ArrayList<>();
        valuestoo.add("2");
        valuestoo.add("4");
        List<String> triggers = new ArrayList<>();
        triggers.add("insert");
        Map<String, String> tokens = new HashMap<>();
        tokens.put("[Message]", "Cruel");
        BRDefinition definitions = new BRDefinition("1", "", "1", valuestoo, "BETWEEN", "Oracle 11g", "AttributeRange", "number", triggers, "HELLO [Message], [Message] WORLD!", tokens, "Error", "table");
        System.out.println("\tBRDefenitions found for a " + definitions.databasetype + " " + definitions.BRRuleType + "Rule"); */
        return definitions;
    }

    public boolean pushCode(String code, String primaryKey, String projectid, String name) {
        changename(Integer.parseInt(primaryKey), name);
        BaseService bs = new BaseService();
        SupportedDatabases DB = bs.getProject(Integer.parseInt(projectid)).getSupporteddatabase();
        Businessrule brs = bs.getBusinessrule(Integer.parseInt(primaryKey));
        GeneratedTrigger gtrigger = new GeneratedTrigger(code, "Hi!", brs, DB);
        bs.insertTrigger(gtrigger);
        return true;
    }

    private void changename(int primaryKey, String name) {
        BaseService bs = new BaseService();
        bs.setBusinessRuleName(primaryKey, name);
    }
}
