package EOorg.EOeolang.EOmp;

import EOorg.EOeolang.EOjsn.EOjson;
import org.eolang.*;

import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOmap$EOget extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOmap$EOget(final Phi sigma) {
        super(sigma);
        this.add("key", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
//            final Phi[] data = new Param(rho).strong(Phi[].class);
            final String key = new Dataized(rho.attr("key").get()).take(String.class);

            return new Data.ToPhi("empty");
        }));
    }

}