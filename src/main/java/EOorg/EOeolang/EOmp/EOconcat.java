package EOorg.EOeolang.EOmp;
import org.eolang.*;

import java.util.Arrays;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOconcat extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOconcat(final Phi sigma) {
        super(sigma);
        this.add("arr1", new AtFree());
        this.add("arr2", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final Phi[] first = new Dataized(rho.attr("arr1").get()).take(Phi[].class);
            final Phi[] second = new Dataized(rho.attr("arr2").get()).take(Phi[].class);
            final Phi[] result = Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, result, first.length, second.length);
            return new Data.ToPhi(result);
        }));
    }

}