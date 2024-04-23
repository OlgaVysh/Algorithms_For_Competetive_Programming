package Mismatch;

import java.util.Scanner;
import java.util.ArrayList;

class Mismatch{

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int count= scanner.nextInt();
        int dublicate =0;
        int miss =0; 
  

        
        int[] array = new int [count+1];
        array[0]=1;


     	while(scanner.hasNextLine() && count>0){
        
        int x=scanner.nextInt();
            if(array[x] == 0 )
            {
                array[x]=x;
            }
            
            else
            {
                dublicate=x;
            }
            count--;
                
        }

        for (int i =1;i<array.length;i++)
        {
           if(array[i] ==0)
           {miss = i;
            i=array.length;
        }
        }
    
    System.out.println(miss);
    System.out.println(dublicate);
    }

}