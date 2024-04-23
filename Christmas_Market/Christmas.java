package Christmas_Market;

import java.util.*;

class Christmas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int indexTest = 0; indexTest < t; indexTest++) {
            int numStores = scanner.nextInt();

            List<Integer> inputList = new ArrayList<>();
            int length = numStores * 2 + 4;

            for (int i = 0; i < length; i++) {
                inputList.add(scanner.nextInt());
            }
         //   System.out.println(indexTest + " " + inputList);

            int[][] locations = new int[numStores + 2][2];
            int index = 0;

            for (int i = 0; i < numStores + 2; i++) {
                for (int j = 0; j < 2; j++) {
                    locations[i][j] = inputList.get(index++);
                }
            }

        /*    for (int i = 0; i < locations.length; i++) {
                System.out.println(indexTest + " " + locations[i][0] + " " + locations[i][1]);
            }*/

            boolean result = canReach(numStores+2, locations);
            System.out.println(result ? "happy" : "sad");
        }
    }

    public static boolean canReach(int n, int[][] locations) {
        int[][] point = new int[n + 2][2];
        int distance = 1000;

        point[0][0] = locations[0][0];
        point[0][1] = locations[0][1];

        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];

        x.offer(locations[0][0]);
        y.offer(locations[0][1]);

        while (!x.isEmpty()) {
            int x2 = x.poll();
            int y2 = y.poll();
            // Abfrage manhattan distanz
            if (Math.abs(x2 - locations[n-1][0]) + Math.abs(y2 - locations[n-1 ][1]) <= distance) {
                return true;
            }

            for (int i = 1; i < n + 2; i++) {
                if (!visited[i] && i < locations.length && Math.abs(x2 - locations[i][0]) + Math.abs(y2 - locations[i][1]) <= distance) {
                    visited[i] = true;
                    x.offer(locations[i][0]);
                    y.offer(locations[i][1]);
                }
            }
        }
        return false;
    }

}
