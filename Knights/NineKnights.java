package Knights;

import java.util.Scanner;

public class NineKnights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String count = scanner.nextLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = count.charAt(j);
            }
        }

        boolean isValid = isNineKnights(board);

        if (isValid) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

    static boolean isNineKnights(char[][] board) {
        // negativ value: Knight move to the enemy
        // positve value move to Owner
        int[][] directions = {
                { -2, -1 }, { -2, 1 },
                { -1, -2 }, { -1, 2 },
                { 1, -2 }, { 1, 2 },
                { 2, -1 }, { 2, 1 }
        };

        int steps = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 'k') {
                    steps++;

                    for (int[] field : directions) {
                        int x = i + field[0];
                        int y = j + field[1];
                        if (x >= 0 && x < 5 && y >= 0 && y < 5 && board[x][y] == 'k') {
                            return false;
                        }
                    }
                }
            }
        }
        return steps == 9;
    }
}
