package datastructuresandalgorithms.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mg = new MergeIntervals();
        mg.mergeIntervals(nums);
    }

    public int[][] mergeIntervals(int[][] nums) {
        int[][] ans = new int[nums.length][2];
        ArrayList<Integer[]> list1 = new ArrayList<Integer[]>();
        ArrayList<Integer[]> list2 = new ArrayList<Integer[]>();
        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] obj1, int[] obj2) {
                return obj1[0] - obj2[0];
            }
        });
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] < nums[i - 1][1]) {
                list1.add(new Integer[]{nums[i][0], Math.max(nums[i - 1][1], nums[i][1])});
            } else {
                list1.add((new Integer[]{nums[i][0], nums[i][1]}));
            }
        }
        System.out.println(list1);
        return ans;
    }


}
