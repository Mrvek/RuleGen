package dataAccess.persistence.oracle.toolsdb;

import java.util.ArrayList;
import java.util.List;

import dto.domain.CodeReturnData;
import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.businessrules.BusinessruleType;
import dto.businessrules.Category;
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
	public boolean insertTableTrigger(CodeReturnData returnedCode) {
		return brdao.insertTableTrigger(returnedCode);
	}
	public boolean insertTableTriggers(List<CodeReturnData> returnedCode) {
		boolean result = false;
		try{
			for(CodeReturnData tableCode : returnedCode){
				brdao.insertTableTrigger(tableCode);
			}
			result = true;
		}catch (Exception ex) {
			System.out.println(ex);
        }
		return result;
	}
	
	
    public boolean setBusinessRuleName (int businessrule_id, String name) {
        return brdao.setBusinessRuleName(businessrule_id, name);
    }
    public PosibleTriggerEvents getPosibleTriggerEvents(int poste_id) {
        return brdao.getPosibleTriggerEvents(poste_id);
    }
}
