import java.math.BigInteger;

public class DiffieHellman {
    public static void main(String[] args) {
        System.out.println("DiffieHellman");
        BigInteger n = new BigInteger("23");
        BigInteger g = new BigInteger("5");

        BigInteger x = new BigInteger("6");
        BigInteger y = new BigInteger("15");

        BigInteger A = g.modPow(x, n);
        BigInteger B = g.modPow(y, n);

        BigInteger K1 = B.modPow(x, n);
        BigInteger K2 = A.modPow(y, n);

        System.out.println("n = " + n);
        System.out.println("g = " + g);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("K1 = " + K1);
        System.out.println("K2 = " + K2);
        
    }
}
