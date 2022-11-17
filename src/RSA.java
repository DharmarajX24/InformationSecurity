import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        BigInteger pn1 = BigInteger.probablePrime(1024, new Random());
        BigInteger pn2 = BigInteger.probablePrime(1024, new Random());
        BigInteger n = pn1.multiply(pn2);

        BigInteger phi = (pn1.subtract(BigInteger.ONE)).multiply(pn2.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.probablePrime(1024, new Random());
        BigInteger d = e.modInverse(phi);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String m = sc.nextLine();
        
        BigInteger message = new BigInteger(m.getBytes());
        BigInteger encrypted = message.modPow(e, n);

        System.out.println("pn1 = " + pn1);
        System.out.println("pn2 = " + pn2);
        System.out.println("n = " + n);
        System.out.println("phi = " + phi);
        System.out.println("e = " + e);
        System.out.println("d = " + d);
        System.out.println("message = " + message);
        System.out.println("encrypted = " + encrypted);
    }
}
