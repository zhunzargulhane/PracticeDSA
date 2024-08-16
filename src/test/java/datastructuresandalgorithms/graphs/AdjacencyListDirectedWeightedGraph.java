package datastructuresandalgorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Pairstops {
    int stops;
    int node;
    int distance;

    public Pairstops(int stops, int node, int distance) {
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    public int getStops() {
        return stops;
    }
}

class PairWeight {
    int node;
    int weight;

    public PairWeight(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getNode() {
        return node;
    }
}

public class AdjacencyListDirectedWeightedGraph {
    private int e;
    private int v;
    private LinkedList<PairWeight>[] linkedLists;


    public AdjacencyListDirectedWeightedGraph(int nodes) {
        this.v = nodes;
        linkedLists = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            linkedLists[i] = new LinkedList();
        }
    }

    public void addEdges(int u, int v, int weight) {
        this.linkedLists[u].add(new PairWeight(v, weight));
        e++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices " + v + " edges " + e + "\n");
        for (int i = 0; i < v; i++) {
            sb.append(i + " : ");
            for (int j = 0; j < linkedLists[i].size(); j++) {
                sb.append("[" + linkedLists[i].get(j).getNode() + "," + linkedLists[i].get(j).getWeight() + "]" + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void shortestPath(int sourceNode) {
        int[] distance = new int[v];
        for (int i = 0; i < distance.length; i++) distance[i] = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        int[] visited = new int[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0)
                dfsTOPO(i, visited, stack);
        }
        //step 1 of topo sort is done. now step 2 to relaxing the edges.
        distance[sourceNode] = 0;
        while (stack.peek() != sourceNode)
            stack.pop();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            int mainDistance = distance[v];
            for (PairWeight pairWeight : linkedLists[v]) {
                int w = pairWeight.getNode();
                int nodeDistance = pairWeight.getWeight();
                distance[w] = Math.min(mainDistance + nodeDistance, distance[w]);
            }
        }
        for (int i : distance)
            System.out.print(i + " ");
    }

    public void dfsTOPO(int v, int[] visited, Stack<Integer> stack) {
        visited[v] = 1;
        for (PairWeight pairWeight : linkedLists[v]) {
            int w = pairWeight.getNode();
            if (visited[w] == 0)
                dfsTOPO(w, visited, stack);
        }
        stack.push(v);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.linkedLists = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            this.linkedLists[i] = new LinkedList();
        }
        for (int i = 0; i < flights.length; i++) {
            this.linkedLists[flights[i][0]].add(new PairWeight(flights[i][1], flights[i][2]));
        }
        int[] distance = new int[n];
        for(int i=0;i<n;i++) distance[i]=Integer.MAX_VALUE;
        Queue<Pairstops> queue = new LinkedList();
        distance[src] = 0;
        queue.offer(new Pairstops(0, src, 0));
        while (!queue.isEmpty()) {
            Pairstops pairstops = queue.poll();
            int node = pairstops.getNode();
            int stops = pairstops.getStops();
            int dist = pairstops.getDistance();
            for (PairWeight pairWeight : linkedLists[node]) {
                int edgeWeight = pairWeight.getWeight();
                int w = pairWeight.getNode();
                if (dist + edgeWeight < distance[w]) {
                    distance[w] = dist + edgeWeight;
                    queue.offer(new Pairstops(stops + 1, w, distance[w]));
                    if (w == dst && stops + 1 == k + 1) return distance[w];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AdjacencyListDirectedWeightedGraph adjacencyListWeightedGraph = new AdjacencyListDirectedWeightedGraph(7);
        adjacencyListWeightedGraph.addEdges(6, 4, 2);
        adjacencyListWeightedGraph.addEdges(6, 5, 3);
        adjacencyListWeightedGraph.addEdges(5, 4, 1);
        adjacencyListWeightedGraph.addEdges(4, 0, 3);
        adjacencyListWeightedGraph.addEdges(4, 2, 1);
        adjacencyListWeightedGraph.addEdges(0, 1, 2);
        adjacencyListWeightedGraph.addEdges(1, 3, 1);
        adjacencyListWeightedGraph.addEdges(2, 3, 3);
       // System.out.println(adjacencyListWeightedGraph);
       // adjacencyListWeightedGraph.shortestPath(0);
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println(adjacencyListWeightedGraph.findCheapestPrice(4, flights, 0, 3, 1));
    }


}
