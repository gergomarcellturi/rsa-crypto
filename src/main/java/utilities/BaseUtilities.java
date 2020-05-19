package utilities;

public abstract class BaseUtilities {

    /**
     * Visszaadja a legnagyobb közös osztóját két számnak
     */
    public long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    /**
     * Kiterjesztett Euklideszi algoritmus. e^-1 mod phi értékét adja vissza.
     * u1 = 0
     * u2 = 1
     * modolus = phi
     */
    public long EEA(long phi, long e, long u1, long u2, long modolus) {
        if ( e == 1) {
            while(u2<0)
                u2 += modolus;
            return u2;
        }
        return EEA(e, phi%e, u2, u1-(u2 * (phi/e)), modolus);
    }

    /**
     * Visszaadja: (ExpBase ^ ExpPower) mod ExpDivider
     */
    protected long ModularExp(long ExpBase, long ExpPower, long ExpDivider ) {

        long Result = 1;
        ExpBase = ExpBase % ExpDivider;

        while (ExpPower > 0) {
            if ( ExpPower % 2 == 1)
                Result = (Result * ExpBase) % ExpDivider;

            ExpPower = ExpPower / 2;
            ExpBase = (ExpBase * ExpBase) % ExpDivider;
        }
        return Result;
    }
}
