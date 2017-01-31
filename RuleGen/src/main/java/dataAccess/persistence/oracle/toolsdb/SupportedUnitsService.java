package dataAccess.persistence.oracle.toolsdb;

import java.util.ArrayList;

import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import dto.supported_units.SupportedOperators;

public class SupportedUnitsService {
	private static SupportedUnitsDAO sudao = new SupportedUnitsDAO();
	
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
	
	

}
