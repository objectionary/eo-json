package EOorg.EOeolang.EOmp;
import EOorg.EOeolang.EOint;
import org.eolang.*;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOrebuild extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOrebuild(final Phi sigma) {
        super(sigma);
        this.add("harr", new AtFree());
        this.add("arr", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final Phi[] harr = new Dataized(rho.attr("harr").get()).take(Phi[].class);
            final Phi[] arr = new Dataized(rho.attr("arr").get()).take(Phi[].class);

            for (final Phi item : harr) {
                final Long x = new Dataized(item).take(Long.class);
                System.out.println(x);
//                final Phi x = new Param(item).strong(Phi.class);
            }

//            new PhWith( new EOmap(rho), 0, new Data.ToPhi(dest) )

//            final Phi phi = new Data.ToPhi(arr);

            return new Data.ToPhi(arr);
        }));
    }

}