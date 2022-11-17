package Ciphers.Substitution;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String plainText = scanner.nextLine();
        System.out.print("Enter key: ");
        int shift = scanner.nextInt();

        String cipherText = encrypt(plainText, shift);
        System.out.println("Cipher text: " + cipherText);
    }

    public static String encrypt(String plainText, int shift) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c + shift);
                if (c > 'z') {
                    c = (char) (c - 26);
                }
            }
            cipherText.append(c);
        }
        return cipherText.toString();
    }
}
