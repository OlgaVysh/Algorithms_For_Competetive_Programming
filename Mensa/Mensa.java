package Mensa;

import java.util.*;

public class Mensa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] arr = new int[x + 1];

        for (int i = 0; i < n; i++) {
            int cost = scanner.nextInt();
            int calories = scanner.nextInt();

            for (int j = x; j >= cost; j--) {
                arr[j] = Math.max(arr[j], arr[j - cost] + calories);
            }
        }
        System.out.println(arr[x]);
    }
}
