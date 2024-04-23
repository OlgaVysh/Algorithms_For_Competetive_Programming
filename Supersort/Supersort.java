package Supersort;

import java.util.*;

public class Supersort {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //total animals
        int d = scanner.nextInt(); //money to save
        int k = scanner.nextInt(); //max of animals to sell

        String[] names = new String[n]; //speichere nur die Namen
        String[][] list = new String[n][n]; //speichere index und Kosten

        scanner.nextLine(); // Consume the newline character

        for(int i=0;i<n;i++) //speichere alle inputs im Array
        {
            String[] input = scanner.nextLine().split(" ");
            names[i] = input[0]; //names

            list[0][i] = String.valueOf(i);
            list[1][i] = input[1]; //cost
        }

        mergeSort(list, 0, list.length - 1); //Sortiere nach Kosten



        int cost = d;
        int anzahl=k;

        int sum=0;
        int count=0;

        for(int i=0;i<n;i++)
        {
            if(count<anzahl && sum<cost)
            {
                sum=sum + Integer.valueOf(list[1][i]);
                count++;
            }

            if(count>=anzahl || sum>=cost)
            {
                break;
            }
        }

        if(sum>=cost)
        {
            System.out.println(count);

            int[] result = new int[count];
            for(int i=0;i<count;i++)
            {
                result[i] = Integer.valueOf(list[0][i]); // Array zeigt auf die Namen
            }

            Arrays.sort(result); //sortiert die Namen wie in der Eingabe vorgekommen
            for(int i=0;i<count;i++)
            {
                int index = result[i];
                System.out.println( names[index]+", I'm sorry. Goodbye!");
            }
        }

        else System.out.println("impossible");
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

    public static void merge(String[][]a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[][] b = new String[n][n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (Integer.valueOf(a[1][i1]).compareTo(Integer.valueOf(a[1][i2])) > 0) {
                b[1][j] = a[1][i1];
                b[0][j] = a[0][i1];
                i1++;
            } else {
                b[1][j] = a[1][i2];
                b[0][j] = a[0][i2];
                i2++;
            }
            j++;
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[1][j] = a[1][i2];
            b[0][j] = a[0][i2];
            i2++;
            j++;
        }

        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[1][j] = a[1][i1];
            b[0][j] = a[0][i1];
            i1++;
            j++;
        }


        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[0][from + j] = b[0][j];
            a[1][from + j] = b[1][j];
        }
    }//end merge



}