package datastructuresandalgorithms.graphsPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyListAgain {
    int e;
    int v;
    LinkedList<Integer>[] linkedList;

    public AdjacencyListAgain(int nodes) {
        this.v = nodes;
        linkedList = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            linkedList[i] = new LinkedList();
        }
        this.e = 0;
    }

    public void addEdges(int u, int v) {
        linkedList[u].add(v);
        linkedList[v].add(u);
        e++;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println(v + " vertices " + e + " edges");
        for (int i = 0; i < v; i++) {
            sb.append(i + " --> ");
            for (int j = 0; j < linkedList[i].size(); j++) {
                sb.append(linkedList[i].get(j) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void dfsStack(int node) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        stack.push(node);
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (!visited[num]) {
                visited[num] = true;
                System.out.println(num);
                for (int v : linkedList[num]) {
                    if (!visited[v])
                        stack.push(v);
                }
            }
        }
    }

    boolean flag = true;

    public int countCompleteComponents(int n, int[][] edges) {
        LinkedList<Integer>[] list = new LinkedList[n];
        boolean[] visited = new boolean[n];
        int connectedComponents = 0;

        for (int i = 0; i < n; i++)
            list[i] = new LinkedList();
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                recursiveDfs(list, visited, i, list[i].size());
                if (flag) connectedComponents++;
                flag = true;
            }
        }
        return connectedComponents;
    }

    public void recursiveDfs(LinkedList<Integer>[] list, boolean[] visited, int node, int adjNodes) {
        visited[node] = true;
        if (list[node].size() != adjNodes) flag = false;
        for (int num : list[node]) {
            if (!visited[num])
                recursiveDfs(list, visited, num, adjNodes);

        }
    }

    public void recursiveDFS(int v) {
        boolean[] visited = new boolean[v];
        int count = 0;
        int[] connectedComponent = new int[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                recursiveDFSs(i, visited, connectedComponent, count);
                count++;
            }
        }
        for (int i = 0; i < v; i++) {
            System.out.print(connectedComponent[i] + " ");
        }
        System.out.println("Number of connected componentes are " + count);
    }

    public void recursiveDFSs(int node, boolean[] visited, int[] connectedComponent, int count) {
        visited[node] = true;
        connectedComponent[node] = count;
        System.out.println(node);
        for (int num : linkedList[node]) {
            if (!visited[num]) {
                recursiveDFSs(num, visited, connectedComponent, count);
            }
        }
    }


    public void bfsGrapth(int node) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.println(n);
            for (int i = 0; i < linkedList[n].size(); i++) {
                int num = linkedList[n].get(i);
                if (visited[num] == false) {
                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }

    }


    public static void main(String[] args) {
        AdjacencyListAgain adjacencyListAgain = new AdjacencyListAgain(4);
        adjacencyListAgain.addEdges(0, 1);
        adjacencyListAgain.addEdges(0, 3);
        adjacencyListAgain.addEdges(1, 2);
        adjacencyListAgain.addEdges(2, 3);

        System.out.println("There " + adjacencyListAgain.isBipartiteCheck());

    }

    public boolean isBipartiteCheck() {
        int[] visited = new int[v];
        for (int i = 0; i < v; i++)
            visited[i] = -1;
        for (int i = 0; i < v; i++) {
            if (visited[i] == -1) {
                if (isBipartite(i, visited) == false) return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int node, int[] visited) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(node);
        visited[node] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : linkedList[u]) {
                if (visited[v] == -1) {
                    if (visited[u] == 0)
                        visited[v] = 1;
                    else visited[v] = 0;
                    queue.offer(v);
                } else {
                    if (visited[u] == visited[v])
                        return false;
                }
            }
        }
        return true;
    }


    public boolean containsCycleDfs() {
        boolean[] visited = new boolean[v];
        for (int i = 1; i < v; i++) {
            if (!visited[i]) {
                if (recursiveDfsOne(i, visited, -1))
                    return true;
            }
        }
        return false;
    }

    public boolean recursiveDfsOne(int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int num : linkedList[node]) {
            if (!visited[num]) {
                if (recursiveDfsOne(num, visited, node))
                    return true;
            } else {
                if (parent != num)
                    return true;
            }
        }
        return false;
    }

}


