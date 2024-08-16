package datastructuresandalgorithms.graphs;

import java.util.LinkedList;

public class NumberOPerations {
    private LinkedList<Integer>[] linkedLists;
    private int v;
    private int e;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices " + v + " edges " + e + "\n");
        for (int i = 0; i < linkedLists.length; i++) {
            sb.append(i + " : " + linkedLists[i] + "\n");
        }
        return sb.toString();
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        int connectedComponents = 0;
        boolean[] visited = new boolean[n];
        this.linkedLists = new LinkedList[n];
        this.v = n;
        for (int i = 0; i < n; i++) {
            this.linkedLists[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < connections.length; i++) {
            System.out.println(connections[i][0]+" "+connections[i][1]);
            linkedLists[connections[i][0]].add(connections[i][1]);
            linkedLists[connections[i][1]].add(connections[i][0]);
            e++;
        }
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(i, visited);
            }
        }
        return connectedComponents-1;
    }

    public void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int w : linkedLists[v]) {
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOPerations np =new NumberOPerations();
        //System.out.println(np);
        int[][] graph= {{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}};
        System.out.println(np.makeConnected(12,graph));

    }
}
