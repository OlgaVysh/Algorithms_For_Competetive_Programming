package Shire;

import java.util.*;

public class Shire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String[] nameList = new String[n];
        for (int i = 0; i < n; i++) {
            nameList[i] = scanner.nextLine();
        }

     
        if (!inconsistent(n, nameList)) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
    }

    public static boolean inconsistent(int n, String[] nameList) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String statement : nameList) {
            String[] parts = statement.split(" ");
            String hobbit1 = parts[0];
            String comparison = parts[1];
            String hobbit2 = parts[2];

            if (comparison.equals(">")) {
                graph.computeIfAbsent(hobbit1, k -> new ArrayList<>()).add(hobbit2);
            } else {
                graph.computeIfAbsent(hobbit2, k -> new ArrayList<>()).add(hobbit1);
            }
        }

        Set<String> visited = new HashSet<>();
        Set<String> recursionList = new HashSet<>();

        // durch keySet() erhlaten wir die Menge der Hobbitsnamen/Schlüssel die im Graphen vorhanden sind. MERKEN!!
        for (String hobbit : graph.keySet()) {
            if (!visited.contains(hobbit)) {
                if (isCyclic(hobbit, graph, visited, recursionList)) {
                    return true;
                }
            }
        }

        return false;
    }
    // Set sorgt dafür das wir jedes Element einmal vorkommt, bedeutet keine Dopplungen
    public static boolean isCyclic(String hobbit, Map<String, List<String>> graph, Set<String> visited, Set<String> list) {
        visited.add(hobbit);
        list.add(hobbit);
        // containsKey:schaut ob ein bestimmer Key in unsren Graph ist. MERKEN!!
        if (graph.containsKey(hobbit)) {
            for (String neighbor : graph.get(hobbit)) {
                if (!visited.contains(neighbor)) {
                    if (isCyclic(neighbor, graph, visited, list)) {
                        return true;
                    }
                } else if (list.contains(neighbor)) {
                    return true;
                }
            }
        }
        list.remove(hobbit);
        return false;
    }
}
