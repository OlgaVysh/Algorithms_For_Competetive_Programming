package Rocks;

import java.util.*;
public class SmashingRocks {
    public static void main(String args[]) {


        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++)
        {
            int value = scanner.nextInt();
            heap.add(value);

        }


        while(heap.size()>2)
        {
            int max = heap.poll();
            int second = heap.poll();
            if(max>second)
            {
                heap.add(max-second);
            }
        }

        if(heap.size()==1)
        {
            System.out.println( heap.peek().toString() );
        }

        else {
            int max = heap.poll();
            int second = heap.poll();
            if(max>second)
            {
                int result = max-second;
                System.out.println (String.valueOf(result) );
            }
            else System.out.println("NONE");
        }
    }
}



