package EOorg.EOeolang.EOmp;
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

            System.out.println("Rebuild");
            for (final Phi item : harr) {
                System.out.println("here");
//                System.out.println(item);
//                final Phi x = new Param(item).strong(Phi.class);
//                System.out.println(x);
            }

            final Phi phi = new Data.ToPhi(1);
            final Long x = new Param(phi).strong(Long.class);
            System.out.println("value = " + x);

//            final Phi phi = new Data.ToPhi(arr);

            return new Data.ToPhi(arr);
        }));
    }

}