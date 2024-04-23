package Compression;

import java.util.*;
public class Compression {

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> list = new ArrayList<>(10);
        for(int i=0;i<n;i++)
        {
            int count =0;
            String input= scanner.nextLine();
            list.add(input);

            for(int j=0;j<i;j++)
            {
                if(list.get(j).startsWith(input))
                {
                    count++;
                }
            }
           System.out.println(count);

        }


    }
}