package EOorg.EOeolang.EOjsn;

import org.eolang.*;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOjson$EOparse extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOjson$EOparse(final Phi sigma) {
        super(sigma);
        this.add("d", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final String data = new Dataized(rho.attr("d").get()).take(String.class);
            return new PhWith(
                    new EOjson(rho), 0,
                    new Data.ToPhi(data)
            );
        }));
    }

}
