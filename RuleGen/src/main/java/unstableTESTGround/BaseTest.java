package unstableTESTGround;

import dataAccess.persistence.oracle.BaseService;
import dto.businessrules.Businessrule;
import dto.businessrules.GeneratedTrigger;
import dto.supported_units.SupportedDatabases;

/**
 * Created by Mitchell on 27/01/2017.
 */
public class BaseTest {

    public static void main(String[] args) {

        BaseService bs = new BaseService();

        SupportedDatabases sdbs = new SupportedDatabases(1, "Oracle 12c");
        Businessrule brs = bs.getBusinessrule(74); // voer hier bestaande business rule ID in
        GeneratedTrigger gtrigger = new GeneratedTrigger("codeee", "eventjeee", brs, sdbs);
        System.out.println(bs.insertTrigger(gtrigger));
        System.out.println(brs.getKoppeloperator().getSupportedoperator().getOperator());
    }

}
