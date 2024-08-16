package datastructuresandalgorithms.arrays;

import java.util.*;

public class Subarray {
    public static void main(String[] args) {
        int[] array = {10,15,20};
//        System.out.println(maxSubarraySumCircular(array));
        System.out.println(climbStairs(3));

    }
    public static  int climbStairs(int n) {
        int[] memo = new int[n+1];
        return dfs(1,n,memo);
    }

    public static int dfs(int index,int n,int[] memo){
        if(index>=n)
            return 1;
        if(memo[index]==0){
            int left = dfs(index+1,n,memo);
            int right = dfs(index+2,n,memo);
            memo[index]= left+right;
        }
        return memo[index];
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int sumOfNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOfNums += nums[i];
        }
        System.out.println(sumOfNums);
        int maxSum = sumOfNums - minSumSubarray(nums);
        System.out.println(maxSum);
        return Math.max(sumOfNums, maxSum);
    }

    public static int minCostClimbingStairs(int[] cost) {
//        int[] memo = new int[cost.length];
//        for(int i=0;i<cost.length;i++)
//            memo[i]=0;
        int a = dfs(cost, 0,0);
        int b = dfs(cost, 1,0);
        return Math.min(a, b);
    }

    public static int dfs(int[] cost, int index,int sum) {
        if (index >= cost.length) {
            return sum;
        }
        int left = dfs(cost, index + 1,sum+cost[index]);
        int right = dfs(cost, index + 2,sum+cost[index]);
        return Math.min(left, right);

    }

    public static int minSumSubarray(int[] nums) {
        int minSoFar = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (nums[i] < sum) {
                sum = nums[i];
            }
            minSoFar = Math.min(minSoFar, sum);
        }
        return minSoFar;
    }

    public static int longestOnes(int[] nums, int k) {
        int start = 0, noOfZeroes = 0, length = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0)
                noOfZeroes++;
            if (noOfZeroes == k + 1) {
                length = Math.max(length, end - start);
                while (noOfZeroes != k) {
                    if (nums[start++] == 0)
                        noOfZeroes--;
                }
                end++;
            }
        }
        return noOfZeroes;
    }

    public static int lenOfLongSubarr(int nums[], int N, int K) {
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (hashMap.containsKey(sum - K)) {
                maxLength = Math.max(maxLength, i - hashMap.get(sum - K));
            }
            hashMap.put(sum, i);
        }
        return maxLength;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int noOfSubArrays = 0, j = 0;
        int product = 1;
        for (int i = 0; i < nums.length && j < nums.length; ) {
            product = product * nums[j];
            if (product < k)
                noOfSubArrays = noOfSubArrays + (j - i + 1);
            else {
                while (product >= k && i < nums.length) {
                    product = product / nums[i];
                    i++;
                }
            }
            j++;
        }
        return noOfSubArrays;
    }

}
