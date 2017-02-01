package dataAccess.persistence.oracle.toolsdb;

import java.util.ArrayList;

import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.businessrules.BusinessruleType;
import dto.businessrules.Category;
import dto.businessrules.GeneratedTrigger;
import dto.businessrules.KoppelOperator;
import dto.businessrules.PosibleTriggerEvents;

public class BusinessRuleService {
	
	private static BusinessRuleDAO brdao =  new BusinessRuleDAO();
	
	public Category getCategory(int cat_id) {
		return brdao.getCategory(cat_id);
	}
	public BusinessruleType getBusinessRuleType(int bsrt_id) {
		return brdao.getBusinessRuleType(bsrt_id);
	}
	public KoppelOperator getKoppelOperator(int koppel_id) {
		return brdao.getKoppelOperator(koppel_id);
	}
	public Businessrule getBusinessrule(int businessrule_id) {
		return brdao.getBusinessrule(businessrule_id);
	}
	public ArrayList<BusinessValues> getAllBusinessValues(Businessrule businessrule) {
		return brdao.getAllBusinessValues(businessrule);
	}
	public boolean insertTrigger(GeneratedTrigger generatedtrigger) {
		return brdao.insertTrigger(generatedtrigger);
	}
        public boolean setBusinessRuleName (int businessrule_id, String name) {
            return brdao.setBusinessRuleName(businessrule_id, name);
        }
        public PosibleTriggerEvents getPosibleTriggerEvents(int poste_id) {
            return brdao.getPosibleTriggerEvents(poste_id);
        }
}
