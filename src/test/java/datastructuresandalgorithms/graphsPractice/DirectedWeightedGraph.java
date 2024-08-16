package datastructuresandalgorithms.graphsPractice;

import java.util.LinkedList;
import java.util.Stack;

public class DirectedWeightedGraph {
    int e;
    int v;
    LinkedList<WeightedPair>[] linkedLists;

    public DirectedWeightedGraph(int nodes) {
        this.v = nodes;
        this.linkedLists = new LinkedList[nodes];
        for (int i = 0; i < v; i++) {
            linkedLists[i] = new LinkedList<>();
        }
    }

    public void addEdges(int u, int v, int weight) {
        linkedLists[u].add(new WeightedPair(v, weight));
        e++;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println(v + " vertices " + e + " edges ");
        for (int i = 0; i < v; i++) {
            sb.append(i + " --> ");
            for (WeightedPair weightedPair : linkedLists[i]) {
                sb.append("{" + weightedPair.getNode() + " , " + weightedPair.getWeight() + "} ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DirectedWeightedGraph weightedGraph = new DirectedWeightedGraph(7);
        weightedGraph.addEdges(6, 4, 2);
        weightedGraph.addEdges(6, 5, 3);
        weightedGraph.addEdges(5, 4, 1);
        weightedGraph.addEdges(4, 0, 3);
        weightedGraph.addEdges(4, 2, 1);
        weightedGraph.addEdges(0, 1, 2);
        weightedGraph.addEdges(2, 3, 3);
        weightedGraph.addEdges(1, 3, 1);
        System.out.println(weightedGraph);
        int[] output = weightedGraph.shortestPathFromSource(6);
        for(int num:output)
            System.out.print(num+" ");
    }

    public int[] shortestPathFromSource(int source) {
        int[] visited = new int[v];
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfsTOPO(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            int currentWeight = distance[num];
            for (WeightedPair weightedPair : linkedLists[num]) {
                int adjNode = weightedPair.getNode();
                int adjNodeWeight = weightedPair.getWeight();
                int adjTotalWeight = currentWeight+adjNodeWeight;
                if(adjTotalWeight<distance[adjNode]){
                    distance[adjNode] = adjTotalWeight;
                }
            }
        }
        return distance;
    }

    public void dfsTOPO(int node, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for (WeightedPair weightedPair : linkedLists[node]) {
            int adjNode = weightedPair.getNode();
            if (visited[adjNode] == 0)
                dfsTOPO(adjNode, visited, stack);
        }
        stack.push(node);
    }

}

