package datastructuresandalgorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AdMatrixGraph {
    private LinkedList<Integer>[] linkedLists;
    int v;
    int e;

    public AdMatrixGraph(int nodes) {
        this.linkedLists = new LinkedList[nodes];
        this.v = nodes;
        for (int i = 0; i < v; i++) {
            this.linkedLists[i] = new LinkedList();
        }
    }

    public void addEdges(int u, int v) {
        this.linkedLists[u].add(v);
        this.linkedLists[v].add(u);
        e++;
    }

  /*  public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<v;i++){
            sb.append(i+" : ");
            for(int j=0;j<v;j++){
                sb.append(matrix[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
*/

    public void bfs(int node) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(node);
        boolean[] visited = new boolean[linkedLists.length];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int w : linkedLists[u]) {
                    if (!visited[w])
                        queue.offer(w);
                }
            }
        }

    }

    public static void main(String[] args) {
        AdMatrixGraph ad = new AdMatrixGraph(4);
        ad.addEdges(0, 1);
        ad.addEdges(1, 2);
        ad.addEdges(2, 3);
        ad.addEdges(3, 0);
        // System.out.println(ad);
        //   ad.bfs(0);
        char[][] board = {{'O', 'O', 'O'}, {'X', 'O', 'O'}, {'O', 'O', 'O'}};
     //   ad.solve(board);
        int[][] grid={{2,1,1},{1,1,0},{0,1,1,}};
        //ad.orangesRotting(grid);

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0, j = 0; j < n; j++) {
            if (board[i][j] == 'O')
                dfsCapture(board, i, j, visited);
        }
        for (int i = 0, j = 0; i < m; i++) {
            if (board[i][j] == 'O')
                dfsCapture(board, i, j, visited);
        }
        for (int i = m - 1, j = 0; j < n; j++) {
            if (board[i][j] == 'O')
                dfsCapture(board, i, j, visited);
        }
        for (int i = 0, j = n - 1; i < m; i++) {
            if (board[i][j] == 'O')
                dfsCapture(board, i, j, visited);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false)
                    board[i][j] = 'X';
            }
        }
    }
    public void dfsCapture(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] == 'X')
            return;
        visited[i][j] = true;
        dfsCapture(board, i, j + 1, visited);
        dfsCapture(board, i, j - 1, visited);
        dfsCapture(board, i + 1, j, visited);
        dfsCapture(board, i - 1, j, visited);
    }



    public void dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j >= grid[0].length || visited[i][j]==true || grid[i][j]==0)
            return;
        visited[i][j]=true;
        grid[i][j]=2;
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
    }

}
