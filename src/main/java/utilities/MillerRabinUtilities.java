package utilities;

import java.util.concurrent.ThreadLocalRandom;

public abstract class MillerRabinUtilities extends BaseUtilities {

    /**
     * Ellenőrzi hogy az adott szám prím-e
     */
    protected boolean isPrime(long prime, int accuracy, long d) {
        if ( accuracy == 0 ) {
            return true;
        }
        return MillerRabin(prime, d) && isPrime(prime, accuracy - 1, d);
    }

    /**
     * Generálja a d-t a MillerRabin teszthez
     */
    protected long dForMillerRabin(long prime) {
        long d = prime - 1;
        while (d % 2 == 0)
            d /= 2;
        return d;
    }
    /**
     * Miller-Rabin teszt első tesztje
     */
    protected boolean MillerRabin(long prime, long d) {
        long a = generateBase(prime);
        long x = ModularExp(a, d, prime);
        return  x == 1 || MillerRabinIterative(x, d, prime);
    }

    /**
     * Miller-Rabin teszt többi része
     */
    protected boolean MillerRabinIterative(long x, long d, long prime) {
        while ( d != prime - 1 ) {
            x = (x * x) % prime;
            d *= 2;

            if ( x == 1) {
                return false;
            }
            if ( x == prime - 1 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generál egy alapot a Miller-Rabin teszthez
     */
    protected long generateBase(long prime) {
        long result = ThreadLocalRandom.current().nextLong(2, prime);
        return GCD(prime, result) == 1 ? result : generateBase(prime);
    }
}
