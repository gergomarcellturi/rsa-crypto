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

    public long EEA(long a, long b) {

        long x = 0, y = 1, r1= a, r2 = b;
        long mod;
        long u = 0;

        while (r2 != 1) {
            mod = r1%r2;
            u = x - (y*mod);
            x = y;
            y = u;
            r1 = r2;
            r2 = mod;
        }

        while ( u < 0 ) {
            u += b;
        }

        return u;
    }
}
