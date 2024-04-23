package NoSubstitution;

import java.util.*;
public class NoSubst {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String input2 = scanner.nextLine();

        System.out.println(lCSDistance(input,input2));
    }

    static int lCSDistance(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();

        int [][] matrix = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) { //Matrix mit Nullen füllen
                    matrix[i][j] = 0;
                }

                else if (a.charAt(i - 1) == b.charAt(j - 1))
                {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1; //min +1 aufschreiben
                }
                else
                {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        int s = matrix[l1][l2]; //length of the longest sequence
        return (l1 - s) + (l2 - s); //Distance
    }
}