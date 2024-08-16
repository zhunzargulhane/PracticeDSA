package datastructuresandalgorithms.graphs;

import java.util.*;

class PairWeightPQ implements Comparable<PairWeightPQ> {
    int node;
    int weight;

    public PairWeightPQ(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getNode() {
        return node;
    }

    @Override
    public int compareTo(PairWeightPQ o) {
        int j = this.getWeight() - o.getWeight();
        if (j == 0)
            return this.getNode() - o.getNode();
        return this.getWeight() - o.getWeight();
    }
}

class Coordinates {
    int i;
    int j;
    int distance;

    public Coordinates(int distance, int i, int j) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getDistance() {
        return distance;
    }
}

class PairMinEffort implements Comparable<PairMinEffort> {
    int i;
    int j;
    int diff;

    public PairMinEffort(int diff, int i, int j) {
        this.i = i;
        this.j = j;
        this.diff = diff;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getDiff() {
        return diff;
    }

    @Override
    public int compareTo(PairMinEffort o) {
        return this.getDiff() - o.getDiff();
    }
}

public class AdjacencyListUnDirectedWeightedGraph {
    private int e;
    private int v;
    private LinkedList<PairWeight>[] linkedLists;


    public AdjacencyListUnDirectedWeightedGraph(int nodes) {
        this.v = nodes;
        linkedLists = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            linkedLists[i] = new LinkedList();
        }
    }

    public void addEdges(int u, int v, int weight) {
        this.linkedLists[u].add(new PairWeight(v, weight));
        this.linkedLists[v].add(new PairWeight(u, weight));
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

    public void shortestPathWeightedUndirectedGraph(int node) {
        Queue<PairWeight> queue = new LinkedList();
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) distance[i] = Integer.MAX_VALUE;
        queue.offer(new PairWeight(node, 0));
        distance[node] = 0;
        while (!queue.isEmpty()) {
            PairWeight pairWeight = queue.poll();
            int v = pairWeight.getNode();
            int maindistance = pairWeight.getWeight();
            for (PairWeight pair : linkedLists[v]) {
                int w = pair.getNode();
                int shortdistance = pair.getWeight();
                if (maindistance + shortdistance < distance[w]) {
                    distance[w] = maindistance + shortdistance;
                    queue.offer(new PairWeight(w, maindistance + shortdistance));
                }
            }
        }
        for (int i : distance) System.out.print(i + " ");
    }


    public void shortestPathWeightedUndirectedGraphPQ(int node) {
        PriorityQueue<PairWeightPQ> priorityQueue = new PriorityQueue();
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) distance[i] = Integer.MAX_VALUE;
        priorityQueue.offer(new PairWeightPQ(node, 0));
        distance[node] = 0;
        while (!priorityQueue.isEmpty()) {
            PairWeightPQ pairWeight = priorityQueue.poll();
            int v = pairWeight.getNode();
            int maindistance = pairWeight.getWeight();
            for (PairWeight pair : linkedLists[v]) {
                int adjNode = pair.getNode();
                int edgeWeight = pair.getWeight();
                if (maindistance + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = maindistance + edgeWeight;
                    priorityQueue.offer(new PairWeightPQ(adjNode, distance[adjNode]));
                }
            }
        }
        for (int i : distance) System.out.print(i + " ");
    }

    public void shorttestSet(int node) {
        Set<PairWeight> set = new TreeSet<PairWeight>(new Comparator<PairWeight>() {
            @Override
            public int compare(PairWeight o1, PairWeight o2) {
                int j = o1.getWeight() - o2.getWeight();
                if (j == 0)
                    return o1.getNode() - o2.getNode();
                return o1.getWeight() - o2.getWeight();
            }
        });
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) distance[i] = Integer.MAX_VALUE;
        distance[node] = 0;
        set.add(new PairWeight(node, 0));
        while (!set.isEmpty()) {
            PairWeight pairWeight = set.iterator().next();
            set.remove(pairWeight);
            int maindistance = pairWeight.getWeight();
            int v = pairWeight.getNode();
            for (PairWeight pair : linkedLists[v]) {
                int adjNode = pair.getNode();
                int edgeWeight = pair.getWeight();
                if (maindistance + edgeWeight < distance[adjNode]) {
                    if (distance[adjNode] != Integer.MAX_VALUE)
                        set.remove(pair);
                    distance[adjNode] = maindistance + edgeWeight;
                    set.add(new PairWeight(adjNode, distance[adjNode]));
                }
            }
        }
        for (int i : distance) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        AdjacencyListUnDirectedWeightedGraph adjacencyListWeightedGraph = new AdjacencyListUnDirectedWeightedGraph(6);
        adjacencyListWeightedGraph.addEdges(0, 2, 4);
        adjacencyListWeightedGraph.addEdges(0, 1, 4);
        adjacencyListWeightedGraph.addEdges(1, 2, 2);
        adjacencyListWeightedGraph.addEdges(2, 3, 3);
        adjacencyListWeightedGraph.addEdges(2, 4, 1);
        adjacencyListWeightedGraph.addEdges(2, 5, 6);
        adjacencyListWeightedGraph.addEdges(3, 5, 2);
        adjacencyListWeightedGraph.addEdges(4, 5, 3);
        // System.out.println(adjacencyListWeightedGraph);
        //adjacencyListWeightedGraph.shortestPathWeightedUndirectedGraph(0);
        // System.out.println();
        //adjacencyListWeightedGraph.shortestPathWeightedUndirectedGraphPQ(0);
        //System.out.println();
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        //     System.out.println(adjacencyListWeightedGraph.shortestPath(5, 6, edges));
        int[][] grid = {{0}};
        adjacencyListWeightedGraph.shortestpathInBinaryMaze(grid);
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        linkedLists = new LinkedList[n + 1];
        for (int i = 1; i < m; i++) {
            linkedLists[i] = new LinkedList();
        }
        for (int i = 0; i < edges.length; i++) {
            this.linkedLists[edges[i][0]].add(new PairWeight(edges[i][1], edges[i][2]));
            this.linkedLists[edges[i][1]].add(new PairWeight(edges[i][0], edges[i][2]));
        }
        PriorityQueue<PairWeightPQ> priorityQueue = new PriorityQueue();
        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++) distance[i] = Integer.MAX_VALUE;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        priorityQueue.offer(new PairWeightPQ(1, 0));
        distance[1] = 0;
        List<Integer> arrayList = new ArrayList();
        while (!priorityQueue.isEmpty()) {
            PairWeightPQ pairWeight = priorityQueue.poll();
            int v = pairWeight.getNode();
            int maindistance = pairWeight.getWeight();
            for (PairWeight pair : linkedLists[v]) {
                int adjNode = pair.getNode();
                int edgeWeight = pair.getWeight();
                if (maindistance + edgeWeight < distance[adjNode]) {
                    parent[adjNode] = v;
                    distance[adjNode] = maindistance + edgeWeight;
                    priorityQueue.offer(new PairWeightPQ(adjNode, distance[adjNode]));
                }
            }
        }
        int k = n;
        while (parent[k] != k) {
            arrayList.add(k);
            k = parent[k];
        }
        arrayList.add(1);
        Collections.reverse(arrayList);
        if (distance[n] == Integer.MAX_VALUE) {
            arrayList = new ArrayList<Integer>();
            arrayList.add(-1);
            return arrayList;
        }
        return arrayList;
    }

    public int shortestpathInBinaryMaze(int[][] grid) {
        int m = grid.length;
        if (grid[m - 1][m - 1] == 1 || grid[0][0] == 1)
            return -1;
        if (grid.length == 1) return 1;
        int[][] distance = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        queue.offer(new Coordinates(0, 0, 0));
        distance[0][0] = 0;
        while (!queue.isEmpty()) {
            Coordinates coordinates = queue.poll();
            int x = coordinates.getI();
            int y = coordinates.getJ();
            int far = coordinates.getDistance();
            if (x - 1 >= 0 && grid[x - 1][y] == 0 && far + 1 < distance[x - 1][y]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x - 1, y));
                distance[x - 1][y] = far + 1;
                if (x - 1 == m - 1 && y == m - 1) return unitDistance + 1;
            }
            if (x + 1 < m && grid[x + 1][y] == 0 && far + 1 < distance[x + 1][y]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x + 1, y));
                distance[x + 1][y] = unitDistance;
                if (x + 1 == m - 1 && y == m - 1) return unitDistance + 1;
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 0 && far + 1 < distance[x][y - 1]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x, y - 1));
                distance[x][y - 1] = unitDistance;
                if (x == m - 1 && y - 1 == m - 1) return unitDistance + 1;
            }
            if (y + 1 < m && grid[x][y + 1] == 0 && far + 1 < distance[x][y + 1]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x, y + 1));
                distance[x][y + 1] = unitDistance;
                if (x == m - 1 && y + 1 == m - 1) return unitDistance + 1;
            }
            if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] == 0 && far + 1 < distance[x - 1][y - 1]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x - 1, y - 1));
                distance[x - 1][y - 1] = unitDistance;
                if (x - 1 == m - 1 && y - 1 == m - 1) return unitDistance + 1;
            }
            if (x - 1 >= 0 && y + 1 < m && grid[x - 1][y + 1] == 0 && far + 1 < distance[x - 1][y + 1]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x - 1, y + 1));
                distance[x - 1][y + 1] = unitDistance;
                if (x - 1 == m - 1 && y + 1 == m - 1) return unitDistance + 1;
            }
            if (x + 1 < m && y - 1 >= 0 && grid[x + 1][y - 1] == 0 && far + 1 < distance[x + 1][y - 1]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x + 1, y - 1));
                distance[x + 1][y - 1] = unitDistance;
                if (x + 1 == m - 1 && y - 1 == m - 1) return unitDistance + 1;
            }
            if (x + 1 < m && y + 1 < m && grid[x + 1][y + 1] == 0 && far + 1 < distance[x + 1][y + 1]) {
                int unitDistance = far + 1;
                queue.offer(new Coordinates(unitDistance, x + 1, y + 1));
                distance[x + 1][y + 1] = unitDistance;
                if (x + 1 == m - 1 && y + 1 == m - 1) return unitDistance + 1;
            }
        }
        return -1;
    }

    public int minimumEffortPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<PairMinEffort> priorityQueue = new PriorityQueue<PairMinEffort>();
        distance[0][0] = 0;
        priorityQueue.add(new PairMinEffort(0, 0, 0));
        while (!priorityQueue.isEmpty()) {
            PairMinEffort pairMinEffort = priorityQueue.poll();
            int x = pairMinEffort.getI();
            int y = pairMinEffort.getJ();
            int diff = pairMinEffort.getDiff();
            if (x - 1 >= 0) {
                int node = grid[x][y];
                int diff1 = Math.max(Math.abs(grid[x - 1][y] - node), diff);
                if (diff1 < distance[x - 1][y]) {
                    distance[x - 1][y] = diff1;
                    priorityQueue.add(new PairMinEffort(diff1, x - 1, y));
                }
            }
            if (x + 1 < m) {
                int node = grid[x][y];
                int diff1 = Math.max(Math.abs(grid[x + 1][y] - node), diff);
                if (diff1 < distance[x + 1][y]) {
                    distance[x + 1][y] = diff1;
                    priorityQueue.add(new PairMinEffort(diff1, x + 1, y));
                }
            }
            if (y - 1 >= 0) {
                int node = grid[x][y];
                int diff1 = Math.max(Math.abs(grid[x][y - 1] - node), diff);
                if (diff1 < distance[x][y - 1]) {
                    distance[x][y - 1] = diff1;
                    priorityQueue.add(new PairMinEffort(diff1, x, y - 1));
                }
            }
            if (y + 1 < n) {
                int node = grid[x][y];
                int diff1 = Math.max(Math.abs(grid[x][y + 1] - node), diff);
                if (diff1 < distance[x][y + 1]) {
                    distance[x][y + 1] = diff1;
                    priorityQueue.add(new PairMinEffort(diff1, x, y + 1));
                }
            }
        }
        return distance[m - 1][n - 1];
    }


    public int countPaths(int n, int[][] roads) {
        this.linkedLists = new LinkedList[n];
        for (int i = 0; i < n; i++) this.linkedLists[i] = new LinkedList();
        for (int i = 0; i < roads.length; i++) {
            this.linkedLists[roads[i][0]].add(new PairWeight(roads[i][1], roads[i][2]));
            this.linkedLists[roads[i][1]].add(new PairWeight(roads[i][0], roads[i][2]));
        }
        long[] distance = new long[n];
        for (int i = 0; i < n; i++) distance[i] = Long.MAX_VALUE;
        PriorityQueue<PairWeightPQ> priorityQueue = new PriorityQueue<PairWeightPQ>();
        distance[0] = 0;
        priorityQueue.add(new PairWeightPQ(0, 0));
        while (!priorityQueue.isEmpty()) {
            PairWeightPQ pairWeightPQ = priorityQueue.poll();
            int node = pairWeightPQ.getNode();
            long nodeDistance = pairWeightPQ.getWeight();
            for (PairWeight pairWeight : linkedLists[node]) {
                long adjDistance = pairWeight.getWeight();
                int adjNode = pairWeight.getNode();
                if (nodeDistance + adjDistance < distance[adjNode]) {
                    distance[adjNode] = nodeDistance + adjDistance;
                    priorityQueue.add(new PairWeightPQ(adjNode, (int) distance[adjNode]));
                }
            }
        }
        int shortestDistance = (int) distance[n - 1];
        for (int i = 0; i < n; i++) distance[i] = Long.MAX_VALUE;
        distance[0] = 0;
        priorityQueue.add(new PairWeightPQ(0, 0));
        long count = 0;
        while (!priorityQueue.isEmpty()) {
            PairWeightPQ pairWeightPQ = priorityQueue.poll();
            if (pairWeightPQ.getWeight() == shortestDistance) count++;
            int node = pairWeightPQ.getNode();
            long nodeDistance = pairWeightPQ.getWeight();
            for (PairWeight pairWeight : linkedLists[node]) {
                long adjDistance = pairWeight.getWeight();
                int adjNode = pairWeight.getNode();
                if (nodeDistance + adjDistance <= distance[adjNode]) {
                    distance[adjNode] = nodeDistance + adjDistance;
                    priorityQueue.add(new PairWeightPQ(adjNode, (int) distance[adjNode]));
                }
            }
        }
        return (int)count;
    }

}
