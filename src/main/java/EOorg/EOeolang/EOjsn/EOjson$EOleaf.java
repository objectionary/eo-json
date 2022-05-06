package EOorg.EOeolang.EOjsn;

import EOorg.EOeolang.EOjsn.EOjson;
import org.eolang.*;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOjson$EOleaf extends PhDefault {
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOjson$EOleaf(final Phi sigma) {
        super(sigma);
        this.add("name", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final String leafName = new Dataized(rho.attr("name").get()).take(String.class);
            final String data = new Param(rho).strong(String.class);
            return new PhWith(
                    new EOjson(rho), 0,
                    new Data.ToPhi(data + leafName)
            );
        }));
    }

}