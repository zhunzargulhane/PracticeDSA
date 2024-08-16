package datastructuresandalgorithms.graphs;

import java.util.*;

public class AdjacencyListDirectedGraph {

    private int e;
    private int v;
    private LinkedList<Integer>[] linkedLists;


    public AdjacencyListDirectedGraph(int nodes) {
        this.v = nodes;
        linkedLists = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            linkedLists[i] = new LinkedList();
        }
    }

    public void addEdges(int u, int v) {
        this.linkedLists[u].add(v);
        e++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices " + v + " edges " + e + "\n");
        for (int i = 0; i < v; i++) {
            sb.append(i + " : " + linkedLists[i] + " " + "\n");
        }
        return sb.toString();
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        int[] pathVisited = new int[graph.length];
        ArrayList<Integer> al = new ArrayList();
        for (int i = 0; i < graph.length; i++) {
            if (dfsCycleDirected(i, visited, pathVisited, graph) == false)
                al.add(i);
        }
        return al;
    }

    public boolean dfsCycleDirected(int v, int[] visited, int[] pathVisited, int[][] graph) {
        visited[v] = 1;
        pathVisited[v] = 1;
        for (int w : graph[v]) {
            if (visited[w] == 0) {
                if (dfsCycleDirected(w, visited, pathVisited, graph) == true)
                    return true;
            } else {
                if (visited[w] == 1 && pathVisited[w] == 1)
                    return true;
            }
        }
        pathVisited[v] = 0;
        return false;
    }


    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if (m != n - 1)
            return -1;
        int connectedComponents = 0;
        boolean[] visited = new boolean[m + 1];
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(i, visited, connections);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    public void dfs(int v, boolean[] visited, int[][] connections) {
        visited[v] = true;
        for (int w : connections[v]) {
            if (!visited[w]) {
                dfs(w, visited, connections);
            }
        }
    }


    public boolean detectCycleDirectedGraph(int node) {
        int[] visited = new int[v];
        int[] pathVisited = new int[v];
        for (int i = 1; i < v; i++) {
            if (visited[i] == 0) {
                if (dfsCycleDirected(i, visited, pathVisited) == true)
                    return true;
            }
        }
        return false;
    }

    public boolean dfsCycleDirected(int v, int[] visited, int[] pathVisited) {
        visited[v] = 1;
        pathVisited[v] = 1;
        for (int w : linkedLists[v]) {
            if (visited[w] == 0) {
                if (dfsCycleDirected(w, visited, pathVisited) == true)
                    return true;
            } else {
                if (visited[w] == 1 && pathVisited[w] == 1)
                    return true;
            }
        }
        pathVisited[v] = 0;
        return false;
    }

    LinkedList<Integer> list = new LinkedList<Integer>();
    List<List<Integer>> lists = new LinkedList<List<Integer>>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfsPathsDAG(0, graph);
        return lists;
    }

    public void dfsPathsDAG(int v, int[][] graph) {
        list.add(v);
        for (int w : graph[v]) {
            dfsPathsDAG(w, graph);
        }
        if (list.getLast() == graph.length - 1) {
            lists.add(list);
            list = new LinkedList<Integer>(list);
        }
        list.removeLast();
    }

    public String topologicalSorting() {
        int[] visited = new int[v];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0)
                dfsTOPO(i, visited, stack);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop() + " ");
        return sb.toString();
    }

    public void dfsTOPO(int v, int[] visited, Stack<Integer> stack) {
        visited[v] = 1;
        for (int w : linkedLists[v]) {
            if (visited[w] == 0)
                dfsTOPO(w, visited, stack);
        }
        stack.push(v);
    }

    public void BfsTOPOSort() {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int w : linkedLists[i]) {
                inDegree[w]++;
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int w : linkedLists[u]) {
                inDegree[w]--;
                if (inDegree[w] == 0)
                    queue.offer(w);
            }
        }
    }

    public boolean cycleIdentificationDFS() {
        int[] visited = new int[v + 1];
        int[] pathVisited = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                if (dfsCycle(i, visited, pathVisited) == true)
                    return true;
            }
        }
        return false;
    }

    public boolean dfsCycle(int v, int[] visited, int[] pathVisited) {
        visited[v] = 1;
        pathVisited[v] = 1;
        for (int w : linkedLists[v]) {
            if (visited[w] == 0) {
                if (dfsCycle(w, visited, pathVisited) == true)
                    return true;
            } else {
                if (visited[w] == 1 && pathVisited[w] == 1)
                    return true;
            }
        }
        pathVisited[v] = 0;
        return false;
    }

    public boolean bfsCycleDetectionTOPO() {
        int[] indegree = new int[v];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count=0;
        for (int i = 1; i < v; i++) {
            for (int w : linkedLists[i]) {
                indegree[w]++;
            }
        }
        for (int i = 1; i < v; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            count++;
            for (int w : linkedLists[v]) {
                indegree[w]--;
                if (indegree[w] == 0)
                    queue.offer(w);
            }
        }
        if (count == v - 1) return false;
        else return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        linkedLists = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            linkedLists[i] = new LinkedList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            this.linkedLists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] indegree = new int[v];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count=0;
        for (int i = 1; i < v; i++) {
            for (int w : linkedLists[i]) {
                indegree[w]++;
            }
        }
        for (int i = 1; i < v; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            count++;
            for (int w : linkedLists[v]) {
                indegree[w]--;
                if (indegree[w] == 0)
                    queue.offer(w);
            }
        }
        if (count == prerequisites.length) return true;
        else return false;
    }

    public int[] getAns(){
        ArrayList<Integer> al = new ArrayList<Integer>();
        return new int[0];
    }

    public static void main(String[] args) {
        AdjacencyListDirectedGraph adjacencyListDirectedGraph = new AdjacencyListDirectedGraph(6);
        adjacencyListDirectedGraph.addEdges(1, 2);
        adjacencyListDirectedGraph.addEdges(2, 3);
        adjacencyListDirectedGraph.addEdges(5, 2);
        adjacencyListDirectedGraph.addEdges(3, 5);
        adjacencyListDirectedGraph.addEdges(3, 4);
        System.out.println(adjacencyListDirectedGraph);
        // System.out.println(adjacencyListDirectedGraph.detectCycleDirectedGraph(1));
        //int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        //int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        //   System.out.println(adjacencyListDirectedGraph.allPathsSourceTarget(graph));
        //System.out.println(adjacencyListDirectedGraph.eventualSafeNodes(graph));
        int[][] connection = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        //adjacencyListDirectedGraph.makeConnected(5, connection);
        //   System.out.println(adjacencyListDirectedGraph.topologicalSorting());
      //  System.out.println(adjacencyListDirectedGraph.bfsCycleDetectionTOPO());
        int[][] prerequisites={{1,0}};
        System.out.println(adjacencyListDirectedGraph.canFinish(2,prerequisites));
    }
}

