package Elections;

import java.util.Scanner;

public class Elections {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();
        int[] voters = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            voters[i] = scanner.nextInt();
        }

        int[][] T = new int[n + 1][2];
        T[1][0] = 0;
        T[1][1] = voters[1];

        for (int i = 2; i <= n; i++) {
            T[i][0] = Math.max(T[i - 1][0], T[i - 1][1]);
            T[i][1] = Math.max(T[i - 1][0] + voters[i], T[i - 2][0] + voters[i] + voters[i - 1]);
        }

        int maxVoters = Math.max(T[n][0], T[n][1]);

        System.out.println(maxVoters);
    }
}
