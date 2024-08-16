package datastructuresandalgorithms.graphs;

import java.util.LinkedList;

public class NumberOfProvince {
    private LinkedList<Integer>[] linkedLists;
    private int v;
    private int e;

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        boolean[] visited = new boolean[m];
        this.linkedLists = new LinkedList[m];
        int province = 0;
        for (int i = 0; i < m; i++) {
            this.linkedLists[i] = new LinkedList();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    this.linkedLists[i].add(j);
                    this.linkedLists[j].add(i);
                    e++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                province++;
            }
        }
        return province;
    }

    public void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int w : linkedLists[v]) {
            if (!visited[w])
                dfs(w, visited);
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) visited[i] = -1;
        this.linkedLists = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            this.linkedLists[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < dislikes.length; i++) {
            this.linkedLists[dislikes[i][0]].add(dislikes[i][1]);
            this.linkedLists[dislikes[i][1]].add(dislikes[i][0]);
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) {
                if (dfsBi(i, 0, visited) == false)
                    return false;
            }
        }
        return true;
    }

    public boolean dfsBi(int v, int color, int[] visited) {
        visited[v] = color;
        for (int w : linkedLists[v]) {
            if (visited[w] == -1) {
                if (visited[v] == 0) {
                    if (dfsBi(w, 1, visited) == false)
                        return false;
                } else {
                    if (dfsBi(w, 0, visited) == false)
                        return false;
                }
            } else {
                if (visited[w] == visited[v])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfProvince np = new NumberOfProvince();
        int[][] connected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
       // int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        int[][] dislikes = {{1,2},{1,3},{2,3}};
        System.out.println(np.possibleBipartition(3, dislikes));
    }
}
