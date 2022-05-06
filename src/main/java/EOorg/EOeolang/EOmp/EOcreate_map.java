package EOorg.EOeolang.EOmp;

import org.eolang.*;

import java.util.HashMap;

public class EOcreate_map extends PhDefault {


    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOcreate_map(final Phi sigma) {
        super(sigma);
        this.add("φ", new AtComposite(this, rho -> {
            final Object o = new Object();
            return new PhWith(
                    new EOmap(rho), "m",
                    // this is a temporary decision, in the future I will use HashMap
                    new Data.ToPhi(new Phi[10000])
            );
        }));
    }

}
