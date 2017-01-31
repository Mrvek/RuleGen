package dataAccess.toolsdb;

import dataAccess.persistence.oracle.BaseService;
import dataAccess.persistence.oracle.toolsdb.DBConfig;
import dto.businessrules.Businessrule;
import dto.businessrules.GeneratedTrigger;
import dto.supported_units.SupportedDatabases;
import dto.template.TemplateDummy;
import unstableTESTGround.dto.ProjectData;

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

    public ProjectData getBusinessRule(int Ticket) {
        BaseService bs = new BaseService();

        /** get data en set it in a dto (ProjectData) */
        ProjectData data = null;
//        data = new ProjectData();
        return data;
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
