package Tickets;

import java.util.Scanner;

public class Tickets {

    static class Graph {
        int ins;
        int outs;
        int adjMatrix[][];

        public Graph(int outs, int ins) {
            this.ins = ins;
            this.outs = outs;
            adjMatrix = new int[outs][ins];
        }

        public void hasEdge(int out, int in) {
            //add edge - means out has edge to this in
            adjMatrix[out][in] = 1;
        }
    }

    public int maxMatching(Graph graph) {
        int outs = graph.outs;
        int ins = graph.ins;

        int assign[] = new int[ins];    //an array to track which in is assigned to which out
        for (int i = 0; i < ins; i++)
            assign[i] = -1;    //initially set all ins are available
        int edgeCount = 0;

        for (int out = 0; out < outs; out++) {    //for all outs
            //for each out, all ins will be not visited initially
            boolean visited[] = new boolean[ins];

            //check if applicant can get a job
            if (bipartiteMatch(graph, out, visited, assign)) {
                //if yes then increase the job count
                edgeCount++;
            }
        }
        return edgeCount;
    }

    boolean bipartiteMatch(Graph graph, int out, boolean visited[], int assign[]) {
        //check each job for the out
        for (int in = 0; in < graph.ins; in++) {
            //check if out can do this in means adjMatrix[out][in] == 1
            // and out has not considered for this in before, means visited[in]==false
            if (graph.adjMatrix[out][in] == 1 && !visited[in]) {
                //mark as in is visited, means out is considered for this in
                visited[in] = true;
                //now check if in was not assigned earlier - assign it to this out
                // OR in was assigned earlier to some other out 'X' earlier then
                //make recursive call for out 'X' to check if some other in can be assigned
                // so that this in can be assigned to current candidate.
                int assignedOut = assign[in];
                if (assignedOut < 0 || bipartiteMatch(graph, assignedOut, visited, assign)) {
                    assign[in] = out;    //assign in in to out out
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //Construct Graph with applicants and jobs
        int outs = n; //n
        int ins = n; //n
        Graph graph = new Graph(outs, ins);
        for(int i =0;i<n;i++)
        {
            int k = scanner.nextInt();//wie viele Kanten der hat
            for(int u=0;u<k;u++)
            {
                graph.hasEdge(i, scanner.nextInt());
            }
        }
        
        Tickets m = new Tickets();
        System.out.println(n - m.maxMatching(graph));
    }
}