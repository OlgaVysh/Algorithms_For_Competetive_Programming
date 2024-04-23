package Kayaking;

import java.util.*;

class Kayaking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();

            graph.get(s).add(new Edge(t, c));
        }

        int result = maxConditionMeasure(n, m, graph);
        System.out.println(result);
    }

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int maxConditionMeasure(int n, int m, List<List<Edge>> graph) {
        int[] arr = new int[n + 1];
        int[] conditionMeasures = new int[n + 1];

        // Calculate in-degrees
        for (List<Edge> edges : graph) {
            for (Edge edge : edges) {
                arr[edge.to]++;
            }
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                queue.offer(i);
                conditionMeasures[i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Edge neighbor : graph.get(node)) {
                conditionMeasures[neighbor.to] = Math.max(conditionMeasures[neighbor.to],
                        conditionMeasures[node] + neighbor.weight);

                arr[neighbor.to]--;
                if (arr[neighbor.to] == 0) {
                    queue.offer(neighbor.to);
                }
            }
        }

        // Find the maximum condition measure
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, conditionMeasures[i]);
        }
        return max;
    }

}
