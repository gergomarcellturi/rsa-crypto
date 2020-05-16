import model.PrivateKey;
import model.PublicKey;
import org.tinylog.Logger;

public class RSA extends RSAUtilities {

    private PrivateKey privateKey;
    private PublicKey publicKey;
    private final long p;
    private final long q;
    private long phi;

    public RSA() {
        Logger.info("Generating primes...\n");
        this.p = generatePrime(5, 10000000);
        this.q = generatePrime(5, 10000000);
        Initialization();
    }

    public RSA(long minimum, long maximum) {
        Logger.info("Generating primes...\n");
        this.p = this.generatePrime(minimum, maximum);
        this.q = this.generatePrime(minimum, maximum);
        Initialization();
    }

    private void Initialization() {
        Logger.info("Primes generated: \n p: {}\n q: {}\n", this.p, this.q);
        this.phi = (p-1)*(q-1);
        Logger.info("Phi generated: \n Phi: {}\n", this.phi);
        this.publicKey = new PublicKey(p*q, generateVariableE(this.phi));
        Logger.info("Public Key generated: \n e: {}\n n: {}\n",
                this.publicKey.getE(),this.publicKey.getN() );
        this.privateKey = new PrivateKey(calculateD(phi, this.publicKey.getE()));
        Logger.info("Private Key generated: \n d: {}\n", this.privateKey.getD());
    }
}
