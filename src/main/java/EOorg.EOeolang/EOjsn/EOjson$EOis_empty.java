package EOorg.EOeolang.EOjsn;

import org.eolang.*;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOjson$EOis_empty extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOjson$EOis_empty(final Phi sigma) {
        super(sigma);
        this.add("φ", new AtComposite(this, rho -> new Data.ToPhi(
                new Param(rho).strong(String.class).isEmpty()
        )));
    }

}
