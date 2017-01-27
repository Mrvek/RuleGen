package dataAccess.persistence.oracle;




import dto.businessrules.BusinessValues;
import dto.businessrules.Businessrule;
import dto.project.Attribute;
import dto.project.Table;
import dto.supported_units.SupportedDatabases;
import dto.supported_units.SupportedDatatypes;
import java.util.ArrayList;



/**
 *
 * @author Matthias
 */
public class Test {


    public static void main(String[] args) {
        SupportedDatabases sdbs = new SupportedDatabases(1, "Oracle 12c");
        
        ArrayList<Table> targetTables = new ArrayList<>();
        
        SupportedDatatypes s1 = new SupportedDatatypes(1, "CHAR", sdbs);
        SupportedDatatypes s2 = new SupportedDatatypes(2, "NUMBER", sdbs);
        SupportedDatatypes s3 = new SupportedDatatypes(3, "DATE", sdbs);
        
        Table t1 = new Table(1, "brood", null);
        Table t2 = new Table(2, "broodtype", null);
        Table t3 = new Table(3, "deeg", null);
        
        Attribute a1 = new Attribute(1, "brood_id", t1, s2);
        t1.addAttribute(a1);
        
        
        targetTables.add(t1);
        targetTables.add(t2);
        targetTables.add(t3);
        
        ArrayList<Table> toolsTables = new ArrayList<>();
        Table t5 = new Table(1, "brood", null);
        Attribute a2 = new Attribute(1, "brood_id", t5, s3);
        Attribute a3 = new Attribute(1, "brood_bla", t5, s3);
        t5.addAttribute(a2);
        t5.addAttribute(a3);
        
        Table t6 = new Table(2, "broodtype", null);
        
        toolsTables.add(t5);
        toolsTables.add(t6);
        
        
        StructureChangeAlgorithm sca = new StructureChangeAlgorithm(targetTables, toolsTables);
        sca.checkTables(); //Change sysout blocks in SCA in order to display output.
        sca.checkAttributes(); //Change sysout blocks in SCA in order to display output.

//        BaseService bs = new BaseService();
//        Businessrule brs = bs.getBusinessrule(74);
//        ArrayList<BusinessValues> values = bs.getAllBusinessValues(brs);
//
//        for (BusinessValues x : values) {
//            System.out.println("" + x.getType() + " " + x.getValue() + " " + x.getBusinessrule().getBusinessruletype().getCategory().getType()
//                                        + " " + x.getBusinessrule().getBusinessruletype().getType());
//        }

    }
}