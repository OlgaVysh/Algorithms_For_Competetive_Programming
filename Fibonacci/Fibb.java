package Fibonacci;

import java.util.*;
import java.lang.*;
public class Fibb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<String> words = new ArrayList<>(n);
        ArrayList<Integer> numbers = new ArrayList<>(n);

        //hole die inputs
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            words.add(input[0]);
            numbers.add(Integer.parseInt(input[1]));
        }

        //equasions
        for (int j = 0; j < k; j++) {
            String[] equasion = scanner.nextLine().split(" ");

            if (equasion.length == 2)
            {
                if (words.contains(equasion[0]))
                {
                    System.out.println(equasion[0]);
                }
                else System.out.println("unknown");
            }
            else
            {
                int result = 0;
                int a = numbers.get(words.indexOf(equasion[0]));
                int b = numbers.get(words.indexOf(equasion[2]));

                if (Objects.equals(equasion[1], "-")) {
                    result = a - b;
                }
                else
                {
                    result = a + b;
                }

                //erste zwei sind durch
                int i = 4;
                while (i < equasion.length) {

                        int c = numbers.get(words.indexOf(equasion[i]));

                        if (Objects.equals(equasion[i-1], "-"))
                        {
                            result = result - c;
                        }
                        else result = result + c;
                        i=i+2;

                }


                if (numbers.contains(result)){
                    System.out.println(words.get(numbers.indexOf(result)));
                }

                else System.out.println("unknown");

            }

        }
    }
}