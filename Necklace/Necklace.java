package Necklace;

import java.util.Scanner;

public class Necklace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] lengths = new int[n];

        for (int i = 0; i < n; i++) {
            lengths[i] = scanner.nextInt();
        }

        String result = stickers(n, k, lengths);
        System.out.println(result);
    }

    public static String stickers(int n, int k, int[] lengths) {

        int[] arr = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        for (int j : lengths) {
            for (int i = j; i <= k; i++) {
                if (arr[i - j] != Integer.MAX_VALUE) {
                    arr[i] = Math.min(arr[i], arr[i - j] + 1);
                }
            }
        }

        // Bedingung? 1 ausdruck : 2 ausdruck
        return arr[k] != Integer.MAX_VALUE ? String.valueOf(arr[k]) : "impossible";
    }
}
