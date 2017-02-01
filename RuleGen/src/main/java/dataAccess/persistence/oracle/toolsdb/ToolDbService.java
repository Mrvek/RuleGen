package dataAccess.persistence.oracle.toolsdb;

public class ToolDbService {
	private static BusinessRuleService brs = new BusinessRuleService();
	private static ProjectService prs = new ProjectService();
	private static SupportedUnitsService sus = new SupportedUnitsService();	
	
	public static BusinessRuleService getBRService(){
		return new BusinessRuleService();
	}
	public static ProjectService getPService(){
		return new ProjectService();
	}
	public static SupportedUnitsService getSUService(){
		return new SupportedUnitsService();
	}	
}
