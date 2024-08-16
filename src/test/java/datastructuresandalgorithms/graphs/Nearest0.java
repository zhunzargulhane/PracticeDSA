package datastructuresandalgorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pairs {
    int i;
    int j;
    int count;

    public Pairs(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }

    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    public int getCount() {
        return count;
    }
}

public class Nearest0 {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] temp = new int[m][n];
        int count = 0;
        Queue<Pairs> queue = new LinkedList<Pairs>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new Pairs(i, j, count));
                }
            }
        }
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Pairs pairs = queue.poll();
                int x = pairs.getI();
                int y = pairs.getJ();
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1 && !visited[x][y + 1]) {
                    queue.offer(new Pairs(x, y + 1, pairs.getCount() + 1));
                    visited[x][y + 1] = true;
                    temp[x][y + 1] = pairs.getCount() + 1;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
                    queue.offer(new Pairs(x, y - 1, pairs.getCount() + 1));
                    visited[x][y - 1] = true;
                    temp[x][y - 1] = pairs.getCount() + 1;
                    ;
                }
                if (x + 1 < grid.length && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
                    queue.offer(new Pairs(x + 1, y, pairs.getCount() + 1));
                    visited[x + 1][y] = true;
                    temp[x + 1][y] = pairs.getCount() + 1;
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
                    queue.offer(new Pairs(x - 1, y, pairs.getCount() + 1));
                    visited[x - 1][y] = true;
                    grid[x - 1][y] = pairs.getCount() + 1;
                }
            }
        }
        return temp;
    }
}
