package EOorg.EOeolang.EOmp;

import EOorg.EOeolang.EOjsn.EOjson;
import org.eolang.*;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOmap$EOwith extends PhDefault {
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOmap$EOwith(final Phi sigma) {
        super(sigma);
        this.add("pair", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final Phi[] pair = new Dataized(rho.attr("pair").get()).take(Phi[].class);
            final Phi[] array = new Param(rho).strong(Phi[].class);
            final Phi[] dest = new Phi[array.length + 1];
            System.arraycopy(array, 0, dest, 0, array.length);
            return new PhWith(
                    new EOjson(rho), 0,
                    new Data.ToPhi(data + leafName)
            );
        }));
    }

}
