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

    public long EEA(long phi, long e) {

        long r1 = phi, r2 = e, u1 = 0, u2 = 1, q = phi/e, result = 0;
        long swap;

        while ( r2 != 1 ) {
            result = u1 - ( u2 * q);
            swap = r2;
            r2 = r1 % r2;
            r1 = swap;
            q = r1 / r2;
            u1 = u2;
            u2 = result;
        }

        while ( result < 0 )
            result += phi;

        return result;
    }
}
