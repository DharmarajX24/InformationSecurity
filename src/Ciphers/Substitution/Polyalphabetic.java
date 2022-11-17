package Ciphers.Substitution;

import java.util.Scanner;

public class Polyalphabetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String plainText = scanner.nextLine().toUpperCase();
        System.out.print("Enter key: ");
        String key = scanner.nextLine().toUpperCase();

        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            keyBuilder.append(key.charAt(i % key.length()));
        }
        key = keyBuilder.toString();

        String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int index = (plainText.charAt(i) + key.charAt(i)) % 26;
            cipherText.append(letters[index]);
        }

        System.out.println("Cipher text: " + cipherText);
    }
}
