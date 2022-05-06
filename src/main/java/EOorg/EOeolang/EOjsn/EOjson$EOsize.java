package EOorg.EOeolang.EOjsn;

import org.eolang.*;
@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOjson$EOsize extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOjson$EOsize(final Phi sigma) {
        super(sigma);
        this.add("φ", new AtComposite(this, rho -> new Data.ToPhi(
                (long) new Param(rho).strong(String.class).length()
        )));
    }

}
