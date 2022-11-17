package Ciphers.Transpostion;

import java.util.Scanner;

public class RailFenceCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plain text: ");
        String plainText = sc.nextLine();

        System.out.print("Enter rail count: ");
        int key = sc.nextInt();

        String cipherText = encrypt(plainText, key);
        System.out.println("plainText = " + plainText);
        System.out.println("cipherText = " + cipherText);
    }

    public static String encrypt(String plainText, int key) {
        StringBuilder cipherText = new StringBuilder();
        int len = plainText.length();

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < len; j++) {
                if ((j % (2 * key - 2)) == i || (j % (2 * key - 2)) == (2 * key - 2 - i)) {
                    cipherText.append(plainText.charAt(j));
                }
            }
        }

        return cipherText.toString();
    }
}
