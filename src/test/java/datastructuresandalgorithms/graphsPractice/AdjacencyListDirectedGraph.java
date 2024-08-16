package datastructuresandalgorithms.graphsPractice;

import java.util.LinkedList;
import java.util.Stack;

public class AdjacencyListDirectedGraph {
    int e;
    int v;
    LinkedList<Integer>[] linkedList;

    public AdjacencyListDirectedGraph(int node) {
        this.v = node;
        linkedList = new LinkedList[node];
        for (int i = 0; i < v; i++)
            linkedList[i] = new LinkedList();
    }

    public void addEdges(int u, int v) {
        linkedList[u].add(v);
        e++;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println(v + " vertices " + e + " edges");
        for (int i = 0; i < v; i++) {
            sb.append(i + " -> ");
            for (int num : linkedList[i])
                sb.append(num + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyListDirectedGraph adjacencyListDirectedGraph = new AdjacencyListDirectedGraph(7);
        adjacencyListDirectedGraph.addEdges(1, 2);
        adjacencyListDirectedGraph.addEdges(2, 3);
        adjacencyListDirectedGraph.addEdges(3, 4);
        adjacencyListDirectedGraph.addEdges(4, 5);
        adjacencyListDirectedGraph.addEdges(4, 6);
        adjacencyListDirectedGraph.topoSort();
    }

    public void topoSort() {
        Stack<Integer> stack = new Stack<>();
        dfsTOPO(1, stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void dfsTOPO(int node, Stack<Integer> stack) {
        for (int num : linkedList[node]) {
            dfsTOPO(num, stack);
        }
        stack.push(node);
    }

    public boolean containsCycle() {
        int[] visited = new int[v];
        int[] pathVisited = new int[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (recursiveDfs(i, visited, pathVisited) == true)
                    return true;
            }
        }
        return false;
    }

    private boolean recursiveDfs(int node, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;
        for (int num : linkedList[node]) {
            if (visited[num] == 0) {
                recursiveDfs(num, visited, pathVisited);
            } else {
                if (pathVisited[num] == 1)
                    return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }

}
