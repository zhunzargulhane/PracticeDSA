package datastructuresandalgorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i;
    int j;
    int count;

    Pair(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getCount() {
        return count;
    }
}

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int freshOrange=0;
        Queue<Pair> queue = new LinkedList<Pair>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, count));
                    visited[i][j] = true;
                }else if(grid[i][j]==1) freshOrange++;
            }
        }
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Pair pair = queue.poll();
                int x = pair.getI();
                int y = pair.getJ();
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1 && !visited[x][y+1]) {
                    queue.offer(new Pair(x, y + 1, count));
                    visited[x][y+1]=true;
                    grid[x][y+1]=2;freshOrange--;
                }  if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y-1]) {
                    queue.offer(new Pair(x, y - 1, count));
                    visited[x][y-1]=true;
                    grid[x][y-1]=2;freshOrange--;
                }  if (x + 1 < grid.length && grid[x + 1][y] == 1  && !visited[x+1][y]) {
                    queue.offer(new Pair(x + 1, y, count));
                    visited[x+1][y]=true;
                    grid[x+1][y]=2;freshOrange--;
                }  if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x-1][y]) {
                    queue.offer(new Pair(x - 1, y, count));
                    visited[x-1][y]=true;
                    grid[x-1][y]=2;freshOrange--;
                }
            }
            count++;
        }
        if(freshOrange>0) return -1;
        return count-1;
    }

    public static void main(String[] args) {
        RottenOranges rt = new RottenOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(rt.orangesRotting(grid));
    }
}
