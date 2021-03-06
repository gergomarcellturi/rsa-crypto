package utilities;

import java.util.concurrent.ThreadLocalRandom;

public abstract class RSAUtilities extends MillerRabinUtilities {

    /**
     * Véletlenszerű prímet generál
     */
    protected long generatePrime(long minimum, long maximum) {
        long prime = ThreadLocalRandom.current().nextLong(minimum, maximum-1);
        prime += prime % 2 == 0 ? 1 : 0;
        return isPrime(prime, 4, dForMillerRabin(prime)) ?
                prime : generatePrime(minimum, maximum);
    }

    /**
     * e random változót generálja le.
     */
    protected long generateVariableE(long phi) {
        long e = ThreadLocalRandom.current().nextLong(2, phi-1);
        return GCD(e,phi)  == 1 ? e : generateVariableE(phi);
    }

    protected long calculateD(long phi, long e) {
        return EEA(phi, e, 0, 1, phi);
    }
}
