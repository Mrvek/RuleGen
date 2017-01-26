package dataAccess.persistence.oracle;

import java.util.ArrayList;

import dataAccess.persistence.oracle.toolsdb.BusinessRuleDAO;
import dataAccess.persistence.oracle.toolsdb.DBConfig;
import dataAccess.persistence.oracle.toolsdb.ProjectDAO;
import dataAccess.persistence.oracle.toolsdb.SupportedUnitsDAO;
import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.businessrules.BusinessruleType;
import dto.businessrules.Category;
import dto.businessrules.GeneratedTrigger;
import dto.businessrules.KoppelOperator;
import dto.project.Attribute;
import dto.project.DatabaseSchema;
import dto.project.Project;
import dto.project.Table;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import dto.supported_units.SupportedOperators;

public class BaseService {
	
	//private static DatabaseSchema dbc = DBConfig.DBConfigToSchema();
	private SupportedUnitsDAO sudao = new SupportedUnitsDAO();
	private ProjectDAO pdao = new ProjectDAO();
	private BusinessRuleDAO brdao =  new BusinessRuleDAO();
	
	//SU DAO
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
	
	//P DAO
	public ArrayList<Table> getAllTablesFromProject(int project_id) {
		return pdao.getAllTablesFromProject(project_id);
	}
	public ArrayList<Attribute> getAllAttributesFromTableAndProjectID(Table table, int project_id) {
		return pdao.getAllAttributesFromTableAndProjectID(table,project_id);
	}
	public int getSchemaId(int project_id) {
		return pdao.getSchemaId(project_id);
	}
	public boolean projectExists(int project_id) {
		return pdao.projectExists(project_id);
	}
	public void insertTables(int database_schema_id, ArrayList<Table> tables) {
		pdao.insertTables(database_schema_id,tables);
	}
	public void insertAttributes(Table table, ArrayList<Attribute> attributes) {
		pdao.insertAttributes(table,attributes);
	}
	public DatabaseSchema getDatabaseSchema(int databaseSchema_id) {
		return pdao.getDatabaseSchema(databaseSchema_id);
	}
	public Table getTable(int table_id) {
		return pdao.getTable(table_id);
	}
	public Attribute getAttribute (int atr_id) {
		return pdao.getAttribute(atr_id);
	}
	public Project getProject (int project_id) {
		return pdao.getProject(project_id);
	}

	
	
	//BR DAO	
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
	
}
