package datastructuresandalgorithms.graphs;

import datastructuresandalgorithms.customclasses.Pairs;

import java.util.*;

class MatrixPair {
    int i;
    int j;

    public MatrixPair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

public class AdjacencyListUndirectedGraph {
    private LinkedList<Integer>[] linkedLists;
    private int v;
    private int e;

    public AdjacencyListUndirectedGraph() {
    }

    public AdjacencyListUndirectedGraph(int nodes) {
        this.linkedLists = new LinkedList[nodes];
        this.v = nodes;
        for (int i = 0; i < nodes; i++) {
            this.linkedLists[i] = new LinkedList<Integer>();
        }
    }

    public void addEdges(int u, int v) {
        this.linkedLists[u].add(v);
        this.linkedLists[v].add(u);
        e++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices " + v + " edges " + e + "\n");
        for (int i = 0; i < linkedLists.length; i++) {
            sb.append(i + " : " + linkedLists[i] + "\n");
        }
        return sb.toString();
    }

    public boolean bfsCycleDetection(int node) {
        Queue<PairParent> queue = new LinkedList<PairParent>();
        boolean[] visited = new boolean[linkedLists.length + 1];
        queue.offer(new PairParent(node, -1));
        visited[node] = true;
        while (!queue.isEmpty()) {
            PairParent pair = queue.poll();
            int v = pair.getI();
            for (int w : linkedLists[v]) {
                if (visited[w] && w != pair.getParent())
                    return true;
                if (!visited[w]) {
                    visited[w] = true;
                    queue.offer(new PairParent(w, v));
                }
            }
        }
        return false;
    }

    public boolean isBipartite(int node) {
        int[] visited = new int[linkedLists.length + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        visited[node] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int w : linkedLists[u]) {
                if (visited[w] == -1) {
                    if (visited[u] == 0)
                        visited[w] = 1;
                    else visited[w] = 0;
                    queue.offer(w);
                } else {
                    if (visited[w] == visited[u])
                        return false;
                }

            }
        }
        return true;
    }

    boolean flag1 = true;

    public boolean isBipartiteArr(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) {
                bipartiteCycle(i, graph, visited);
                if (flag1 == true)
                    return true;
            }
        }
        return false;
    }

    public void bipartiteCycle(int i, int[][] graph, int[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        visited[i] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int w : graph[u]) {
                if (visited[w] == -1) {
                    if (visited[u] == 0)
                        visited[w] = 1;
                    else visited[w] = 0;
                    queue.offer(w);
                } else {
                    if (visited[w] == visited[u])
                        flag1 = false;
                }
            }
        }
    }

    boolean flag2 = true;

    public boolean isBipartiteDFS(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) visited[i] = -1;
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) {
                if (dfsBipartite(i, 0, graph, visited) == false)
                    return false;
            }
        }
        return true;
    }

    public boolean dfsBipartite(int v, int color, int[][] graph, int[] visited) {
        visited[v] = color;
        for (int w : graph[v]) {
            if (visited[w] == -1) {
                if (visited[v] == 0) {
                    if (dfsBipartite(w, 1, graph, visited) == false)
                        return false;
                } else {
                    if (dfsBipartite(w, 0, graph, visited) == false)
                        return false;
                }
            } else {
                if (visited[w] == visited[v])
                    return false;
            }
        }
        return true;
    }


    public void bfsTraversalLevelOrder(int node) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList();
        visited[node] = true;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v : linkedLists[u]) {  //Here we are traversing to the adjacent nodes of current node
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }


    public boolean canVisit(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        queue.offer(0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (!visited[u]) {
                visited[u] = true;
                counter++;
                for (int w : rooms.get(u)) {
                    if (!visited[w])
                        queue.offer(w);
                }
            }
        }
        if (counter == rooms.size())
            return true;
        else return false;
    }

    public void dfsTraversalUndirectedGraph(int node) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(node);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : linkedLists[u]) {
                    if (!visited[v])
                        stack.push(v);
                }
            }
        }
    }

    public void iterativeTraversalFloodFill(int node) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(node);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                System.out.println(u + " ");
                visited[u] = true;
                for (int w : linkedLists[u]) {
                    if (!visited[w])
                        stack.push(w);
                }
            }
        }

    }

    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        int out;
        int in;
        for (int i = 0; i < trust.length; i++) {
            out = outDegree[trust[i][0]];
            in = inDegree[trust[i][1]];
            outDegree[trust[i][0]] = out + 1;
            inDegree[trust[i][1]] = in + 1;
        }
        for (int i = 1; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                if (inDegree[i] == n - 1)
                    return i;
            }
        }
        return -1;
    }

    int counter = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int i = 0;
        boolean[] visited = new boolean[rooms.size()];
        dfsRooms(i, visited, rooms);
        if (counter == rooms.size())
            return true;
        else return false;
    }

    public void dfsRooms(int i, boolean[] visited, List<List<Integer>> rooms) {
        if (!visited[i]) {
            counter++;
            visited[i] = true;
            for (int w : rooms.get(i)) {
                if (!visited[w])
                    dfsRooms(w, visited, rooms);
            }
        }
    }

    public void dfs() {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    public void dfsRecursive(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w : linkedLists[v]) {
            if (!visited[w])
                dfsRecursive(w, visited);
        }
    }

    public void dfs1() {
        boolean[] visited = new boolean[v];
        Integer[] compId = new Integer[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs2(i, visited, count, compId);
                count++;
            }
        }
        System.out.println("The connected components are " + count);
        //  System.out.println(compId[2] == compId[5]);
    }

    public void dfs2(int v, boolean[] visited, int count, Integer[] compId) {
        visited[v] = true;
        compId[v] = count;
        for (int w : linkedLists[v]) {
            if (!visited[w])
                dfs2(w, visited, count, compId);
        }
    }

    public boolean detectCycleBFSUndirectedGraph(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[v];
        queue.offer(node);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (visited[u]) return true;
            if (!visited[u]) {
                visited[u] = true;
                for (int w : linkedLists[u]) {
                    if (!visited[w])
                        queue.offer(w);
                }
            }
        }
        return false;
    }

    public boolean cycleInConnectedComponent(int nodes) {
        boolean[] visited = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                if (isCycleDetected(i, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean isCycleDetected(int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (visited[u]) return true;
            if (!visited[u]) {
                visited[u] = true;
                for (int w : linkedLists[u]) {
                    if (!visited[w])
                        queue.offer(w);
                }
            }
        }
        return false;
    }

    boolean flag = false;

    public boolean detectCycleDFS(int node) {
        boolean[] visited = new boolean[v];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                boolean flag = cycleDFS(i, -1, visited);
                if (flag == true)
                    return true;
            }
        }
        return false;
    }

    public boolean cycleDFS(int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int w : linkedLists[v]) {
            if (visited[w] && w != parent) {
                System.out.println(w + " " + v);
                return true;
            }
            if (!visited[w]) {
                cycleDFS(w, v, visited);
            }
        }
        return false;
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length != n - 1)
            return -1;
        this.linkedLists = new LinkedList[n];
        this.v = n;
        for (int i = 0; i < n; i++) {
            this.linkedLists[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < connections.length; i++) {
            this.linkedLists[connections[i][0]].add(connections[i][1]);
            this.linkedLists[connections[i][1]].add(connections[i][0]);
            e++;
        }
        int m = connections.length;
        int connectedComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    public void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int w : linkedLists[v]) {
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }

    public void shortestPathUndirectedGraph(int node) {
        Queue<Integer> queue = new LinkedList();
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) distance[i] = Integer.MAX_VALUE;
        queue.offer(0);
        distance[node] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            int weight = distance[v];
            for (int w : linkedLists[v]) {
                if (weight + 1 < distance[w]) {
                    distance[w] = weight + 1;
                    queue.offer(w);
                }
            }
        }
        for (int i : distance) System.out.print(i + " ");
    }

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        linkedLists = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            linkedLists[i] = new LinkedList();
        }
        for (int i = 0; i < edges.length; i++) {
            this.linkedLists[edges[i][0]].add(edges[i][1]);
            this.linkedLists[edges[i][0]].add(edges[i][1]);
        }
        for (int i = 0; i < linkedLists.length; i++) {
            System.out.print(i+" : "+"[");
            for (int i1 : linkedLists[i])
                System.out.print(i1 + " ");
            System.out.println("]");
        }
        Queue<Integer> queue = new LinkedList();
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) distance[i] = Integer.MAX_VALUE;
        queue.offer(src);
        distance[src] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            int weight = distance[v];
            for (int w : linkedLists[v]) {
                if (weight + 1 < distance[w]) {
                    distance[w] = weight + 1;
                    queue.offer(w);
                }
            }
        }
        for (int i : distance) System.out.print(i + " ");
        return distance;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if (grid[0][0] == 1 || grid[m - 1][m - 1] == 1)
            return -1;
        Queue<MatrixPair> queue = new LinkedList();
        boolean[][] visited = new boolean[m][m];
        queue.offer(new MatrixPair(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            MatrixPair matrixPair = queue.poll();
            int x = matrixPair.getI();
            int y = matrixPair.getJ();
            if (x - 1 >= 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                int distance = grid[x][y];
                visited[x - 1][y] = true;
                grid[x - 1][y] = distance + 1;
                queue.offer(new MatrixPair(x - 1, y));
            }
            if (x + 1 < m && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                int distance = grid[x][y];
                visited[x + 1][y] = true;
                grid[x + 1][y] = distance + 1;
                queue.offer(new MatrixPair(x + 1, y));
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                int distance = grid[x][y];
                visited[x][y - 1] = true;
                grid[x][y - 1] = distance + 1;
                queue.offer(new MatrixPair(x, y - 1));
            }
            if (y + 1 < m && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                int distance = grid[x][y];
                visited[x][y + 1] = true;
                grid[x][y + 1] = distance + 1;
                queue.offer(new MatrixPair(x, y + 1));
            }
            if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] == 0 && !visited[x - 1][y - 1]) {
                int distance = grid[x][y];
                visited[x - 1][y - 1] = true;
                grid[x - 1][y - 1] = distance + 1;
                queue.offer(new MatrixPair(x - 1, y - 1));
            }
            if (x - 1 >= 0 && y + 1 < m && grid[x - 1][y + 1] == 0 && !visited[x - 1][y + 1]) {
                int distance = grid[x][y];
                visited[x - 1][y + 1] = true;
                grid[x - 1][y + 1] = distance + 1;
                queue.offer(new MatrixPair(x - 1, y + 1));
            }
            if (x + 1 < m && y - 1 >= 0 && grid[x + 1][y - 1] == 0 && !visited[x + 1][y - 1]) {
                int distance = grid[x][y];
                visited[x + 1][y - 1] = true;
                grid[x + 1][y - 1] = distance + 1;
                queue.offer(new MatrixPair(x + 1, y - 1));
            }
            if (x + 1 < m && y + 1 < m && grid[x + 1][y + 1] == 0 && !visited[x + 1][y + 1]) {
                int distance = grid[x][y];
                visited[x + 1][y + 1] = true;
                grid[x + 1][y + 1] = distance + 1;
                queue.offer(new MatrixPair(x + 1, y + 1));
            }
        }
        if (visited[m - 1][m - 1] == false) return -1;
        return grid[m - 1][m - 1] + 1;
    }


    public static void main(String[] args) {
        AdjacencyListUndirectedGraph adList = new AdjacencyListUndirectedGraph(9);
        adList.addEdges(0, 1);
        adList.addEdges(0, 3);
        adList.addEdges(1, 3);
        adList.addEdges(1, 2);
        adList.addEdges(3, 4);
        adList.addEdges(4, 5);
        adList.addEdges(5, 6);
        adList.addEdges(2, 6);
        adList.addEdges(6, 7);
        adList.addEdges(6, 8);
        adList.addEdges(8, 7);
        System.out.println(adList);
        adList.shortestPathUndirectedGraph(0);
        System.out.println();
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        adList.shortestPath(edges, 9, 10, 0);
        //    int[][] graph = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        // int[][] graph = {{1, 5}, {1, 7}, {1, 2}, {1, 4}, {3, 7}, {4, 7}, {3, 5}, {0, 6}, {0, 1}, {0, 4}, {2, 6}, {0, 3}, {0, 2}};
        //  System.out.println(adList.makeConnected(12, graph));
        //System.out.println(adList.bfsCycleDetection(1));
        //  System.out.println(adList.detectCycleBFSUndirectedGraph(0));
        //System.out.println(adList.cycleInConnectedComponent(9));
        //   System.out.println(adList.detectCycleDFS(1));
        //adList.addEdges(1, 2);
        //adList.addEdges(2, 3);
       /* adList.addEdges(3, 0);
        adList.addEdges(2, 4);
        adList.addEdges(5, 6);
        adList.addEdges(7, 8);*/
        /*System.out.println(adList);
        adList.bfsTraversalLevelOrder(0);
        System.out.println();
        adList.dfsTraversalUndirectedGraph(0);
        System.out.println();*/
        //adList.dfs();
        //adList.dfs1();
        //int[][] image = {{1, 3}, {2, 3}};
        //System.out.println(adList.findJudge(3, image));

    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int freshOranges = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, count));
                } else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        if (freshOranges == 0) return 0;
        while (!queue.isEmpty()) {
            int c = queue.size();
            count++;
            for (int i = 0; i < c; i++) {
                Pair pair = queue.poll();
                int x = pair.getI();
                int y = pair.getJ();
                if (y + 1 < n && grid[x][y + 1] == 1 && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    grid[x][y + 1] = 2;
                    queue.offer(new Pair(x, y + 1, count));
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    grid[x][y - 1] = 2;
                    queue.offer(new Pair(x, y - 1, count));
                }
                if (x + 1 < m && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    grid[x + 1][y] = 2;
                    queue.offer(new Pair(x + 1, y, count));
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    grid[x - 1][y] = 2;
                    queue.offer(new Pair(x - 1, y, count));
                }
            }
        }
        if (freshOranges > 1) return -1;
        return count - 1;
    }


}

