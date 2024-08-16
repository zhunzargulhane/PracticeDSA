package datastructuresandalgorithms.DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class PartitionsGivenDifference {
    static int mod = 1000000007;

    public int countPartitions(int n, int d, int arr[]) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        int sum = (totalSum - d) / 2;
        System.out.println(sum);
        int[][] memo = new int[arr.length][sum + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < sum+1; j++) {
                memo[i][j] = -1;
            }
        }
        return f(arr.length - 1, arr, sum, memo);
    }

    public int f(int index, int[] nums, int sum, int[][] memo) {
        if (index == 0) {
            if (sum == 0 && nums[0] == 0) return 2;
            if (sum == 0 || nums[0] == sum) return 1;
            return 0;
        }
        if (memo[index][sum] == -1) {
            int notPick = f(index - 1, nums, sum, memo) % mod;
            int pick = 0;
            if (sum >= nums[index]) {
                pick = f(index - 1, nums, sum - nums[index], memo) % mod;
            }
            memo[index][sum] = (notPick + pick) % mod;
        }
        return memo[index][sum];
    }

    public static int countPartitions1(int n, int d, int arr[]){
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        if((totalSum-d)%2!=0) return 0;
        if((totalSum-d)<0) return 0;
        int sum1=(totalSum-d)/2;
        int[][] table = new int[arr.length][sum1+1];
        if(arr[0]==0)
            table[0][0]=2;
        else table[0][0]=1;
        if(arr[0]<=sum1 && arr[0]!=0)
            table[0][arr[0]]=1;
        for(int index=1;index<arr.length;index++){
            for(int sum=0;sum<=sum1;sum++){
                int notPick=(table[index-1][sum])%mod;
                int pick=0;
                if(sum>=arr[index]){
                    pick = (table[index-1][sum-arr[index]])%mod;
                }
                table[index][sum]=(notPick+pick)%mod;
            }
        }
        return (table[arr.length-1][sum1]);
    }


    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][] memo = new int[weight.length][maxWeight+1];
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++)
                memo[i][j]=-1;
        }
        f(weight.length-1,maxWeight,weight,value,memo);
        System.out.println("he");
        return 1;
    }

    static int knapsack1(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];
        for(int i=0;i<=maxWeight;i++){
            if(i>=weight[0])
                prev[i]=value[0];
        }
        for(int index=1;index<n;index++){
            for(int weights=maxWeight;weights>=0;weights--){
                int notTake = 0 +prev[weights];
                int take=Integer.MIN_VALUE;
                if(weights>=weight[index])
                    take=value[index]+prev[weights-weight[index]];
                prev[weights]=Math.max(take,notTake);
            }
        }
        System.out.println("e");
        return prev[maxWeight];
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList();
        LinkedList<Integer> list = new LinkedList();
        int[] maps = new int[nums.length];
        permutations(nums,maps,list,lists);
        return lists;
    }

    public void permutations(int[] nums,int[] maps,LinkedList<Integer> list,List<List<Integer>> lists){
        if(list.size()==nums.length){
            lists.add(new LinkedList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(maps[i]==1) continue;
            list.add(nums[i]);
            maps[i]=1;
            permutations(nums,maps,list,lists);
            list.removeLast();
            maps[i]=0;
            StringBuilder sb = new StringBuilder();

        }
    }

    public static int f(int index,int maxWeight,int[] weight,int[] value,int[][] memo){
        if(index==0){
            if(maxWeight>=weight[0])
                return value[0];
            else return 0;
        }
        if(memo[index][maxWeight]==-1){
            int notTake = 0 +f(index-1,maxWeight,weight,value,memo);
            int take=Integer.MIN_VALUE;
            if(maxWeight>=weight[index])
                take=value[index]+f(index-1,maxWeight-weight[index],weight,value,memo);
            memo[index][maxWeight]=Math.max(take,notTake);
        }
        return memo[index][maxWeight];
    }

    public static void main(String[] args) {
        PartitionsGivenDifference pt = new PartitionsGivenDifference();
        int[] weight = {3,2,4};
        int[] value={30,40,60};
        System.out.println(pt.knapsack1(weight, value,3,6));
    }
}
