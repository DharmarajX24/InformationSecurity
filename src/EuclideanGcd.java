import java.util.Scanner;

public class EuclideanGcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int a = scanner.nextInt();
        System.out.print("Enter number 2: ");
        int b = scanner.nextInt();

        int gcd = euclideanGcd(a, b);
        System.out.println("gcd = " + gcd);
    }

    public static int euclideanGcd(int a, int b) {
        if (a == 0) return b;
        return euclideanGcd(b % a, a);
    }
}
