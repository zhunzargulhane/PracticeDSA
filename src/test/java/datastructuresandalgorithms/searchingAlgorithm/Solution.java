package datastructuresandalgorithms.searchingAlgorithm;

import java.util.PriorityQueue;

class Pair1 implements Comparable<Pair1>{

    int i, j, val;

    public Pair1(int i, int j, int val){
        this.i=i;
        this.j=j;
        this.val=val;
    }

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }
    public int getVal(){
        return val;
    }

    public int compareTo(Pair1 object){
        return object.getVal()-this.getVal();
    }

}
public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        PriorityQueue<Pair1> pq= new PriorityQueue();
        int[] ans=new int[2];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                pq.add(new Pair1(i,j,mat[i][j]));
            }
        }
        Pair1 p=pq.poll();
        ans[0]=p.getI();
        ans[1]=p.getJ();
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat={{1,4},{3,2}};
        solution.findPeakGrid(mat);
    }
}