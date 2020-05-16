import org.tinylog.Logger;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        RSA cryptosystem = new RSA();
        long message = 1234;
        long encryption = cryptosystem.Encrypt(message);
        Logger.info("The message: {}\n",message);
        Logger.info("Encrypted message: {}\n", encryption);
        Logger.info("Decrypted message: {}\n", cryptosystem.Decrypt(encryption));



        Logger.warn("Elapsed time: {}ms", System.currentTimeMillis() - start);
    }
}
