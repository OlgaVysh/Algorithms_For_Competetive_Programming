package DogBreeding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DogBreeding {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //total dogs
        int k = scanner.nextInt(); //total Strings


        String [][] array = new String[2][n];

        scanner.nextLine(); 

        for(int i=0;i<n;i++) //speichere alle inputs im Array
        {
            String dog= scanner.nextLine();
            String[] input1 = dog.split(" ");
            array[0][i] = input1[0];
            array[1][i] = input1[1];

        }

        ArrayList<String> sortedArray = new ArrayList<String>();

        for(int i=0;i<n;i++)
        {
            StringBuilder name= new StringBuilder(array[0][i]); //hole Name
            int m = Integer.parseInt(array[1][i])-1; //hole Index der Mutter

            while(m!=-1) //solange Index der Mutter nicht gleich 0
            {
                name.append(array[0][m]); //füge Muttersname hinzu
                m = Integer.parseInt(array[1][m])-1;
            }

            sortedArray.add(name.toString());

        }

        Collections.sort(sortedArray);

        for(int a=0; a<k;a++) //fur jedes String
        {
            int count =0;
            String input = scanner.nextLine();
            for( String element : sortedArray ){

                if(element.startsWith(input))
                {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
