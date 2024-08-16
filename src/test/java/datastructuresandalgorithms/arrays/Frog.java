package datastructuresandalgorithms.arrays;

public class Frog {
    public static int frogJump(int n, int count[]) {
        int[] memo = new int[count.length];
        dfs(count.length-1,count,memo,3);
        return memo[n-1];
    }

    public static int dfs(int index,int[] count,int[] memo,int k){
        if(index<=0) return 0;
        if(memo[index]==0){
            int minSteps = Integer.MAX_VALUE;
            for(int i=1;i<=k;i++){
                int left = Integer.MAX_VALUE;
                if(index-i>=0)
                    left =Math.abs(count[index]-count[index-i])+ dfs(index-i,count,memo,k);
                memo[index]=Math.min(left,minSteps);
            }
        }
        return memo[index];
    }

}
