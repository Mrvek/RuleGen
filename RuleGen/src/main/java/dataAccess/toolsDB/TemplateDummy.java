package dataAccess.toolsDB;

import java.util.Map;

/**
 * Created by Mitchell on 23/01/2017.
 */
public class TemplateDummy {
    public String name;
    public Map<String, String> operatorTranslations;
    public String trigger;
    public String warning;
    public String error;
    public String constraint;
    public String constraintcompare;
    public String triggercompare;
    public String constraintRange;
    public String triggerRange;

    public TemplateDummy(String name, Map<String, String> operatorTranslations, String trigger, String warning, String error, String constraint, String constraintcompare, String triggercompare, String constraintRange, String triggerRange) {
        this.name = name;
        this.operatorTranslations = operatorTranslations;
        this.trigger = trigger;
        this.warning = warning;
        this.error = error;
        this.constraint = constraint;
        this.constraintcompare = constraintcompare;
        this.triggercompare = triggercompare;
        this.constraintRange = constraintRange;
        this.triggerRange = triggerRange;
    }
}