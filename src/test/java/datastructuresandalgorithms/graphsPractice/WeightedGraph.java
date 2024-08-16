package datastructuresandalgorithms.graphsPractice;

import java.util.LinkedList;

class WeightedPair {
    int node;
    int weight;

    public WeightedPair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

}

public class WeightedGraph {
    int e;
    int v;
    LinkedList<WeightedPair>[] linkedList;

    public WeightedGraph(int node) {
        this.v = node;
        linkedList = new LinkedList[node];
        for (int i = 0; i < v; i++) {
            linkedList[i] = new LinkedList();
        }
    }

    public void addEdges(int u, int v, int weight) {
        linkedList[u].add(new WeightedPair(v, weight));
        linkedList[v].add(new WeightedPair(u, weight));
        e++;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println(v + " vertices " + e + " edges");
        for (int i = 0; i < v; i++) {
            sb.append(i + " -> ");
            for (WeightedPair pair : linkedList[i]) {
                sb.append("(" + pair.getNode() + "," + pair.getWeight() + ") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(7);
        weightedGraph.addEdges(6, 4, 2);
        weightedGraph.addEdges(6, 5, 3);
        weightedGraph.addEdges(5, 4, 1);
        weightedGraph.addEdges(4, 0, 3);
        weightedGraph.addEdges(4, 2, 1);
        weightedGraph.addEdges(0, 1, 2);
        weightedGraph.addEdges(2, 3, 3);
        weightedGraph.addEdges(1, 3, 1);
        System.out.println(weightedGraph);
    }
}
