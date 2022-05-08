//package org.eolang;
//
//import EOorg.EOeolang.EOjsn.EOjson;
//import EOorg.EOeolang.EOmp.EOitem;
//import EOorg.EOeolang.EOmp.EOmap;
//import org.eolang.*;
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//@SuppressWarnings("PMD.AvoidDollarSigns")
//public class EOmap$EOget extends PhDefault {
//
//    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
//    public EOmap$EOget(final Phi sigma) {
//        super(sigma);
//        this.add("key", new AtFree());
//        this.add("φ", new AtComposite(this, rho -> {
//            final Phi[] data = new Param(rho).strong(Phi[].class);
//            final String key = new Dataized(rho.attr("key").get()).take(String.class);
//            for (Phi phi : data) {
//                if (!(phi instanceof EOitem)) {
//                    throw new Exception("Try get not item type from map");
//                } else {
//                    EOitem item = (EOitem) phi;
//                    if (item.)
//                    if (phi instanceof EOmap) {
//                        return (EOmap) phi;
//                    } else {
//                        return new Data.ToPhi(phi);
//                    }
//                }
//
//            }
//            throw new Exception("There is no such object here");
//        }));
//    }
//
//}