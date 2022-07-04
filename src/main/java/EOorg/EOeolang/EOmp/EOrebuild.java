package EOorg.EOeolang.EOmp;
import org.eolang.*;

import java.util.ArrayList;

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

            ArrayList<Integer> hashes = new ArrayList<>();

            for (final Phi item : harr) {
                final Long x = new Dataized(item).take(Long.class);
                hashes.add(Math.toIntExact(x));
            }

            // This value can be changed for memory or speed optimization
            int TABLE_SIZE = hashes.size();

            ArrayList<ArrayList<Phi>> table = new ArrayList<>();

            for (int i = 0;i < TABLE_SIZE;++i) {
                table.add(new ArrayList<>());
            }

            for (int i = 0;i < arr.length;++i) {
                table.get(hashes.get(i) % TABLE_SIZE).add(arr[i]);
            }

            Phi[] result = new Phi[TABLE_SIZE];

            System.out.println("HERE 3");

            for (int i = 0;i < TABLE_SIZE;++i) {
                Phi[] array = new Phi[table.get(i).size()];
                for (int j = 0;j < table.get(i).size();++j) {
                    array[j] = table.get(i).get(j);
                }
                result[i] = new Data.ToPhi(array);
            }

            System.out.println("HERE 4");

            return new Data.ToPhi(result);
        }));
    }

}