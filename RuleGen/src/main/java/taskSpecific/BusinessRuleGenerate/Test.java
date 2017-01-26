package taskSpecific.BusinessRuleGenerate;

import dataAccess.persistence.oracle.BaseService;
import dto.businessrules.Businessrule;
import dto.businessrules.GeneratedTrigger;
import dto.supported_units.SupportedDatabases;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class Test {
   /* SupportedDatabases sdbs = new SupportedDatabases(1, "Oracle 12c");
    BusinessRuleDAO brdao = new BusinessRuleDAO();
    Businessrule brs = brdao.getBusinessrule(68);
    GeneratedTrigger gtrigger = new GeneratedTrigger("codeee", "eventjeee", brs, sdbs);
    System.out.println(brdao.insertTrigger(gtrigger)); */

    public static void main(String args[]) {
        BaseService bs = new BaseService();
        SupportedDatabases sdbs = new SupportedDatabases(1, "Oracle 12c");
//    BusinessRuleDAO brdao = new BusinessRuleDAO();
        Businessrule brs = bs.getBusinessrule(68);
        GeneratedTrigger gtrigger = new GeneratedTrigger("codeee", "eventjeee", brs, sdbs);
        System.out.println(bs.insertTrigger(gtrigger));
        System.out.println(brs.getKoppeloperator().getSupportedoperator().getOperator());
    }
}
