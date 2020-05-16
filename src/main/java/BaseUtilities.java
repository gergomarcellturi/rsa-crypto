import org.tinylog.Logger;

public class BaseUtilities {

    /**
     * Visszaadja a legnagyobb közös osztóját két számnak
     */
    public long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public long EEA(long phi, long e, long u1, long u2, long modolus) {
        if ( e == 1) {
            while(u2<0)
                u2 += modolus;
            return u2;
        }
        return EEA(e, phi%e, u2, u1-(u2 * (phi/e)), modolus);
    }
}
