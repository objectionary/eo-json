package EOorg.EOeolang.EOmp;

import org.eolang.*;

import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOmap$EOput extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOmap$EOput(final Phi sigma) {
        super(sigma);
        this.add("t", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final EOitem[] data = new Param(rho).strong(EOitem[].class);
            final EOitem item = new Dataized(rho.attr("t").get()).take(EOitem.class);
            final EOitem[] dest = new EOitem[data.length + 1];
            System.arraycopy(data, 0, dest, 0, data.length);
            dest[data.length] = item;
            return new PhWith(
                    new EOmap(rho), 0,
                    new Data.ToPhi(dest)
            );
        }));
    }

}