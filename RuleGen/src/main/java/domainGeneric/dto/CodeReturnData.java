package domainGeneric.dto;

/**
 * Created by Mitchell on 01/02/2017.
 */
public class CodeReturnData {
    private int tableID;
    private int supporteddatabase;
    private String code;

    public CodeReturnData(int tableID, int supporteddatabase, String code) {
        this.tableID = tableID;
        this.supporteddatabase = supporteddatabase;
        this.code = code;
    }

    public int getTableID() {
        return tableID;
    }

    public int getSupporteddatabase() {
        return supporteddatabase;
    }

    public String getCode() {
        return code;
    }
}
