import org.tinylog.Logger;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        RSA cryptosystem = new RSA();
        Logger.warn("Elapsed time: {}ms", System.currentTimeMillis() - start);
    }
}
