package domainGeneric.businessrule.CType;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class NameGen {
    private String initials = "BRG";
    private String name;
    public NameGen(String ruletype, String codetype) {
        name = initials + "_" + codetype + "_" + ruletype;
    }

    @Override
    public String toString() {
        return name;
    }
}
