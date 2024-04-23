package Fishman_Fears;

import java.util.*;

class Animal {
    String name;
    int cost;
    public Animal(String name, int cost) {
        this.name = name;
        this.cost = cost;
       }
}

public class Fishmans{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();

        Animal[] animals = new Animal[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int cost = scanner.nextInt();
            animals[i] = new Animal(name, cost);
        }


        Animal[] help = Arrays.<Animal>copyOf(animals, n);
        Arrays.sort(help, Comparator.comparing(a -> a.cost));

        int totalCost = 0;
        List<String> selectedAnimals = new ArrayList<>();

        for (int i = n - 1; i >= n - k; i--) {
            totalCost += help[i].cost;
            selectedAnimals.add(help[i].name);
            if (totalCost >= d) {
                i=0;;
            }
        }

        if (totalCost < d) {
            System.out.println("impossible");
        } else {
            System.out.println(selectedAnimals.size());
            for (int i=0; i<animals.length;i++) {
                for(int j=0;j< selectedAnimals.size();j++){
                    if(selectedAnimals.get(j).equals(animals[i].name)){
                        System.out.println(animals[i].name + ", I'm sorry. Goodbye!");
                    }
                }
            }
        }
    }
}
