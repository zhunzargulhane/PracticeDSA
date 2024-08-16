package datastructuresandalgorithms.graphs;

public class AdjacencyMatrixUndirectedGraph {

    private int v;  //number of vertices
    private int e;  // number of edges
    int[][] admatrix;

    public AdjacencyMatrixUndirectedGraph(int nodes) {
        this.v = nodes;
        this.e = 0;
        this.admatrix = new int[nodes][nodes];
    }

    public void addEdges(int u, int v) {
        admatrix[u][v] = 1;
        admatrix[v][u] = 1; //because it is undirected graph, so each edge will have 2 values of 1 in matrix.
        e++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(v + " Vertices " + e + " edges" + "\n");
        for (int i = 0; i < v; i++) {
            sb.append(i + " : ");
            for (int j = 0; j < admatrix[i].length; j++) {
                sb.append(admatrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numberOfIslands = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfsIsland(grid, i, i, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    public void dfsIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        dfsIsland(grid, i, j + 1, visited);
        dfsIsland(grid, i, j - 1, visited);
        dfsIsland(grid, i + 1, j, visited);
        dfsIsland(grid, i - 1, j, visited);

    }

    int central;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        central = image[sr][sc];
        boolean[][] visited = new boolean[m][n];
        dfs(image, sr, sc, color, visited);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc]
                || image[sr][sc] != central)
            return;
        visited[sr][sc] = true;
        image[sr][sc] = color;
        dfs(image, sr, sc + 1, color, visited);
        dfs(image, sr, sc - 1, color, visited);
        dfs(image, sr + 1, sc, color, visited);
        dfs(image, sr - 1, sc, color, visited);
    }


    public static void main(String[] args) {
        AdjacencyMatrixUndirectedGraph adMatrix = new AdjacencyMatrixUndirectedGraph(4);
        adMatrix.addEdges(0, 1);
        adMatrix.addEdges(1, 2);
        adMatrix.addEdges(2, 3);
        adMatrix.addEdges(3, 0);
        System.out.println(adMatrix);
        //char[][] grid = {{'1', '1', '0', '0'}, {'1', '0', '0', '0'}, {'0', '0', '1', '0'}, {'0', '0', '0', '1'}};
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        //System.out.println(adMatrix.numIslands(grid));
        adMatrix.floodFill(image,1,1,2);
    }















}
