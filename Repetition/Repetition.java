package Repetition;

import java.util.*;

public class Repetition {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        scanner.nextLine();
        String input = scanner.nextLine();

        //für String input erstelle ein Suffix-Array (Folie 41) und sortiere es
        // mit InsertionSort lexikographisch
        String[][] suffix = new String[2][length];

        for (int i = 0; i < length; i++) {
            suffix[0][i] = input.substring(i); //speichere Suffixe
            suffix[1][i] = String.valueOf(i); //speichere Startposition von Suffix
        }

        //sortiere suffix lexikographisch
        mergeSort(suffix, 0,length-1);

        //erstelle LCP array (longest common prefix)
        int[] lcp = LCP(suffix, input);

        // Finde größten gemeinsamen Präfix aller Suffixe
        int max = Arrays.stream(lcp).max().getAsInt();

        System.out.println(max);
    }

    public static void mergeSort(String[][] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }// end mergeSort

    public static void merge(String[][] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[][] b = new String[n][n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {

            if (a[0][i1].compareTo(a[0][i2]) <= 0) {
                b[0][j] = a[0][i1];
                b[1][j] = a[1][i1];
                i1++;
            } else {
                b[0][j] = a[0][i2];
                b[1][j] = a[1][i2];
                i2++;
            }
            j++;
        }

        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[0][j] = a[0][i1];
            b[1][j] = a[1][i1];
            i1++;
            j++;
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[0][j] = a[0][i2];
            b[1][j] = a[1][i2];
            i2++;
            j++;
        }

        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[0][from + j] = b[0][j];
            a[1][from + j] = b[1][j];
        }
    }//end merge

    public static int[] LCP(String[][] suffix, String input)
    {
        int length = input.length();
        int[] lcp = new int[length];

        //index[start Position des Suffixes] = Platz des Suffixes in der Ordnung
        int[] index = new int[input.length()];
        for(int i =0;i<length;i++)
        {
            index[Integer.parseInt(suffix[1][i])] = i;
        }

        int count = 0;

        for (int i = 0; i < length; i++) {

            if (index[i] == length - 1)
            {
                count = 0;
            }

            else
            {

                int j = Integer.parseInt(suffix[1][index[i] + 1]); //für Suffix finde den Index von nächsten Suffix


                while (i + count < length && j + count < length && input.charAt(i + count) == input.charAt(j + count))
                {
                    count++; //Vergleiche zeichenweise die Präfixe
                }


                lcp[index[i]] = count; //speichere die Länge der gemeinsamen Präfix von beiden Suffixen

                //setze k zurück für nächste Iteration
                count=0;
            }
        }

        return lcp;
    }
}