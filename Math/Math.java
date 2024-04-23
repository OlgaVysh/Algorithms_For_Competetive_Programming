package Math;

import java.util.Scanner;

class Math{

   public static void main (String[] args){
    Scanner scanner= new Scanner(System.in);
    int n= scanner.nextInt();
    int k= scanner.nextInt();

    String F1 = "D";
    String F2 = "O";
    String F3 = null;

    for(int i=2; i< n; i++){
        F3 = F1 + F2;
        if(F3.length()>k){
            F3=F3.substring(0, k);
        }
        F1 = F2;
        F2 = F3;
    }

    if(n <= 2){
        F3 = n == 1 ? F1 : F2;
    }
    
    System.out.println(F3.charAt(k-1));
   }

   public static String substring(String string, int beginIndex, int length) {
    int endIndex = beginIndex + length;
    return string.substring(beginIndex, endIndex);
 }
   
}