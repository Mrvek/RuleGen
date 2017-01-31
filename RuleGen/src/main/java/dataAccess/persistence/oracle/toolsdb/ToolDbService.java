package dataAccess.persistence.oracle.toolsdb;

public class ToolDbService {
	private static BusinessRuleService brs = new BusinessRuleService();
	private static ProjectService prs = new ProjectService();
	private static SupportedUnitsService sus = new SupportedUnitsService();	
	
	public static BusinessRuleService getBRService(){
		return brs;
	}
	public static ProjectService getPService(){
		return prs;
	}
	public static SupportedUnitsService getSUService(){
		return sus;
	}	
}
