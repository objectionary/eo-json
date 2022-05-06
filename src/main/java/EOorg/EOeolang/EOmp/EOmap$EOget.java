package EOorg.EOeolang.EOmp;

import EOorg.EOeolang.EOjsn.EOjson;
import org.eolang.*;

import java.util.HashMap;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOmap$EOget extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOmap$EOget(final Phi sigma) {
        super(sigma);
        this.add("key", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final String key = new Dataized(rho.attr("key").get()).take(String.class);
//            final HashMap<String, Phi> map = new Param(rho).strong(HashMap.class);
//            if (map.isEmpty()) {
//                return new Data.ToPhi("empty");
//            } else {
//                return new Data.ToPhi("not empty");
//            }
            return new Data.ToPhi("empty");
        }));
    }

}