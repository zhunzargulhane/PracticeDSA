package datastructuresandalgorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyNodeUndirectedGraph {

    private Node[] head;
    private int E;
    private int V;

    private static class Node {
        private int val;
        private List<Node> neighbours;

        public Node(int val, Node neighbours) {
            this.val = val;
            this.neighbours = new ArrayList<Node>();
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    public AdjacencyNodeUndirectedGraph(int nodes) {
        this.head = new Node[nodes];
        this.V = nodes;
        for (int i = 0; i < nodes; i++) {
            this.head[i].neighbours = new ArrayList<Node>();
        }
    }

    public void addEdges(int u, int v) {
        this.head[u].neighbours.add(new Node(v));
        this.head[v].neighbours.add(new Node(u));
        E++;
    }

    public static void main(String[] args) {
        AdjacencyNodeUndirectedGraph adNode = new AdjacencyNodeUndirectedGraph(4);
        adNode.addEdges(1,2);
        adNode.addEdges(1,4);
    }


}
