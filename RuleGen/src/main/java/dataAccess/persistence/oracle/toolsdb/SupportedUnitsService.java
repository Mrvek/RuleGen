package dataAccess.persistence.oracle.toolsdb;

import dto.supported_units.PackageTemplate;
import dto.supported_units.ProcedureTemplate;
import dto.supported_units.RuletypeTemplate;
import java.util.ArrayList;

import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import dto.supported_units.SupportedOperators;
import dto.supported_units.Template;
import dto.supported_units.TriggerTemplate;

public class SupportedUnitsService {
	private SupportedUnitsDAO sudao = new SupportedUnitsDAO();
	
	public ArrayList<SupportedDatabases> getAllSupportedDatabases() {
		return sudao.getAllSupportedDatabases();
	}
	public SupportedDatabases getSupportedDatabaseById(int id) {		
		return sudao.getSupportedDatabaseById(id);
	}
	public ArrayList<SupportedDatatypes> getSupportedDataTypesByDB(SupportedDatabases database) {
		return sudao.getSupportedDataTypesByDB(database);
	}
	public SupportedDatatypes getSupportedDataTypesByID(int id) {
		return sudao.getSupportedDataTypesByID(id);
	}
	public ArrayList<SupportedOperators> getAllSupportedOperators() {
		return sudao.getAllSupportedOperators();
	}
	public SupportedOperators getSupportedOperator(int id) {
		return sudao.getSupportedOperator(id);
	}
        
        public Template getTemplate(int template_id) {
            return sudao.getTemplate(template_id);
        }
        
        public RuletypeTemplate getRuleTypeTemplate(int ruletype_id, int template_id) {
            return sudao.getRuleTypeTemplate(ruletype_id, template_id);
        }
        
        public ProcedureTemplate getProcedureTemplate(int template_id) {
            return sudao.getProcedureTemplate(template_id);
        }
        
        public PackageTemplate getPackageTemplate(int template_id) {
            return sudao.getPackageTemplate(template_id);
        }
	
        public TriggerTemplate getTriggerTemplate(int template_id) {
            return sudao.getTriggerTemplate(template_id);
        }
        
        public ArrayList<Template> getAllTemplates() {
            return sudao.getAllTemplates();
        }
        
        public ArrayList<RuletypeTemplate> getAllRuleTypeTemplates(int template_id) {
            return sudao.getAllRuleTypeTemplates(template_id);
        }
        
}
