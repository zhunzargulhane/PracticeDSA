package datastructuresandalgorithms.priorityQueueHeaps;

import java.util.*;

public class MinimumSumHeap {
    public static int deleteGreatestValue(int[][] grid) {
        int max=0;
        int sum=0;
        for(int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]);
        }
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                max=Math.max(max,grid[j][i]);
            }
            sum+=max;
            max=0;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        deleteGreatestValue(grid);

    }
}