package datastructuresandalgorithms.practiceproblems;

import datastructuresandalgorithms.arrays.ArrayResize;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] array, int target) {
        int[] copyArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
            copyArray[i] = array[i];
        int start = 0;
        int end = array.length - 1;
        Arrays.sort(array);
        int[] temp = new int[2];
        while (start < end) {
            int num = array[start] + array[end];
            if (num == target) {
                temp[0] = search(copyArray, array[start]);
                temp[1] = search(copyArray, array[end]);
                break;
            } else if (num > target)
                end--;
            else start++;
        }
        return temp;
    }

    public int[] twoSum1(int[] array, int target) {
        int[] temp = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < array.length; i++) {
            int num = Math.abs(array[i] - target);
            if (hashMap.containsKey(num)) {
                temp[0] = i;
                temp[1] = hashMap.get(num);
                break;
            } else {
                hashMap.put(array[i], i);
            }
        }
        return temp;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        hashSet.add(list);
//                        if(!lists.contains(list))
//                            lists.add(list);
                        list = new ArrayList<Integer>();
                    }

                }
            }
        }
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>(hashSet);
        return lists;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        HashSet<ArrayList<Integer>> hashSets = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int numsK = -(nums[i] + nums[j]);
                if (hashSet.contains(numsK)) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(numsK);
                    Collections.sort(list);
                    hashSets.add(list);
                    list = new ArrayList<Integer>();
                } else {
                    hashSet.add(nums[j]);
                }
            }
            hashSet = new HashSet<Integer>();
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>(hashSets);
        return lists;
    }

    public List<List<Integer>> threeSumExtraSpace(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (j < k) {
                    int sum=nums[i]+nums[j]+nums[k];
                    int benchJ=Integer.MIN_VALUE;
                    int benchK=Integer.MAX_VALUE;
                    if(sum==0){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                        list=new ArrayList<Integer>();
                        benchJ=nums[j++];
                        benchK=nums[k--];
                    }else if(sum<0)
                        j++;
                    else k--;
                    while(j< nums.length && benchJ==nums[j])
                         j++;
                    while(k>=0 && benchK==nums[k])
                        k--;
                }
            }
        }
        return lists;
    }

    public int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target)
                return (int) mid;
            else if (array[mid] < target)
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.threeSumExtraSpace(nums));
    }
}
