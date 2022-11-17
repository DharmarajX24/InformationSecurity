package Ciphers.Substitution;

import java.util.List;
import java.util.Scanner;

public class HillCipher {
    private static final String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String plainText = scanner.nextLine().toUpperCase();

        System.out.print("Enter key: \n");
        int[][] key = getKeyMatrix();
        int[][] plainTextGroups = getGroups(plainText);

        StringBuilder cipherText = new StringBuilder();

        for (int[] plainTextGroup : plainTextGroups) {
            int[] cipherTextGroup = multiplyGroup(key, plainTextGroup);
            for (int k : cipherTextGroup) {
                cipherText.append(letters[k]);
            }
        }

        System.out.println("Cipher text: " + cipherText);
    }

    private static int[][] getKeyMatrix() {
        int[][] key = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Enter key[%d][%d]: ", i, j);
                key[i][j] = scanner.nextInt();
            }
        }
        return key;
    }

    private static int[][] getGroups(String plainText) {
        int length = plainText.length();
        int groupCount = length / 3;
        if (length % 3 != 0) {
            groupCount++;
        }
        int[][] groupsArray = new int[groupCount][3];
        for (int i = 0; i < groupCount; i++) {
            String group = plainText.substring(i * 3, Math.min((i + 1) * 3, length));
            if (group.length() < 3) {
                group += "x".repeat(3 - group.length());
            }

            for (int j = 0; j < 3; j++) {
                groupsArray[i][j] = List.of(letters).indexOf(group.charAt(j) + "");
            }
        }
        return groupsArray;
    }

    private static int[] multiplyGroup(int[][] key, int[] plainTextGroup) {
        int[] result = new int[3];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < plainTextGroup.length; j++) {
                result[i] += key[i][j] * plainTextGroup[j];
            }
            result[i] %= 26;
        }
        return result;
    }
}
