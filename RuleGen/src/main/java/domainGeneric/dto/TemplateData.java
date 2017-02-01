package domainGeneric.dto;

import dto.supported_units.PackageTemplate;
import dto.supported_units.ProcedureTemplate;
import dto.supported_units.RuletypeTemplate;
import dto.supported_units.Template;
import dto.supported_units.TriggerTemplate;
import java.util.ArrayList;

public class TemplateData {

    private Template template;
    private TriggerTemplate triggerTemplate;
    private ArrayList<RuletypeTemplate> ruletypeTemplate;
    private ProcedureTemplate procedureTemplate;
    private PackageTemplate packageTemplate;

    public TemplateData(Template template, TriggerTemplate triggerTemplate, ArrayList<RuletypeTemplate> ruletypeTemplate, ProcedureTemplate procedureTemplate, PackageTemplate packageTemplate) {
        this.template = template;
        this.triggerTemplate = triggerTemplate;
        this.ruletypeTemplate = ruletypeTemplate;
        this.procedureTemplate = procedureTemplate;
        this.packageTemplate = packageTemplate;
    }

    public TemplateData() {
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public TriggerTemplate getTriggerTemplate() {
        return triggerTemplate;
    }

    public void setTriggerTemplate(TriggerTemplate triggerTemplate) {
        this.triggerTemplate = triggerTemplate;
    }

    public ArrayList<RuletypeTemplate> getRuletypeTemplate() {
        return ruletypeTemplate;
    }

    public void setRuletypeTemplate(ArrayList<RuletypeTemplate> ruletypeTemplate) {
        this.ruletypeTemplate = ruletypeTemplate;
    }

    public ProcedureTemplate getProcedureTemplate() {
        return procedureTemplate;
    }

    public void setProcedureTemplate(ProcedureTemplate procedureTemplate) {
        this.procedureTemplate = procedureTemplate;
    }

    public PackageTemplate getPackageTemplate() {
        return packageTemplate;
    }

    public void setPackageTemplate(PackageTemplate packageTemplate) {
        this.packageTemplate = packageTemplate;
    }
    
}
