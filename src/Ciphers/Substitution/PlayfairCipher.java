package Ciphers.Substitution;

import java.util.*;

public class PlayfairCipher {
    private static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String plainText = scanner.nextLine().toUpperCase();
        System.out.print("Enter key: ");
        String key = scanner.nextLine().toUpperCase();

        String[][] cipherMatrix = getCipherMatrix(key);
        String cipherText = encrypt(cipherMatrix, plainText);
        System.out.println("cipherText = " + cipherText);
    }

    private static String encrypt(String[][] cipherMatrix, String plainText) {
        if (plainText.length() % 2 != 0) {
            plainText += "X";
        }

        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < plainText.length(); i += 2) {
            pairs.add(plainText.substring(i, i + 2));
        }

        Map<Character, int[]> cipherMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cipherMap.put(cipherMatrix[i][j].charAt(0), new int[]{i, j});
                if (cipherMatrix[i][j].equals("I")) {
                    cipherMap.put('J', new int[]{i, j});
                }
            }
        }

        StringBuilder cipherText = new StringBuilder();
        for (String pair : pairs) {
            int[] pos1 = cipherMap.get(pair.charAt(0));
            int[] pos2 = cipherMap.get(pair.charAt(1));

            if (pos1[0] == pos2[0]) {
                cipherText.append(cipherMatrix[pos1[0]][(pos1[1] + 1) % 5]);
                cipherText.append(cipherMatrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                cipherText.append(cipherMatrix[(pos1[0] + 1) % 5][pos1[1]]);
                cipherText.append(cipherMatrix[(pos2[0] + 1) % 5][pos2[1]]);
            } else {
                cipherText.append(cipherMatrix[pos1[0]][pos2[1]]);
                cipherText.append(cipherMatrix[pos2[0]][pos1[1]]);
            }
        }
        return cipherText.toString();
    }


    private static String[][] getCipherMatrix(String key) {
        List<String> cipherMatrix = new ArrayList<>();

        for (String k : key.concat(letters).split("")) {
            if (k.equals("J")) {
                k = "I";
            }
            if (!cipherMatrix.contains(k)) {
                cipherMatrix.add(k);
            }
        }

        String[][] cipherMatrix2D = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cipherMatrix2D[i][j] = cipherMatrix.get(i * 5 + j);
            }
        }
        return cipherMatrix2D;
    }
}
