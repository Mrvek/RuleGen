package dataAccess.toolsdb;

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
    public String constraintOther;
    public String triggerOther;
    public String constraintList;
    public String triggerList;

    public TemplateDummy(String name, Map<String, String> operatorTranslations, String trigger, String warning, String error, String constraint, String constraintcompare, String triggercompare, String constraintRange, String triggerRange, String constraintOther, String triggerOther, String constraintList, String triggerList) {
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
        this.constraintOther = constraintOther;
        this.triggerOther = triggerOther;
        this.constraintList = constraintList;
        this.triggerList = triggerList;
    }
}