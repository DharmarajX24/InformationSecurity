package Ciphers.Substitution;

import java.util.Scanner;

public class Monoalphabetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String plainText = scanner.nextLine().toLowerCase();

        String[] keys = "abcdefghijklmnopqrstuvwxyz".split("");
        String[] values = "mineavyqpjfbthdxukcswglrzo".split("");

        for (int i = 0; i < keys.length; i++) {
            plainText = plainText.replace(keys[i], values[i]);
        }

        System.out.println("Cipher text: " + plainText);
    }
}
