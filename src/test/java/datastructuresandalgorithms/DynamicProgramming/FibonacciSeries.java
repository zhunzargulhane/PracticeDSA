package datastructuresandalgorithms.DynamicProgramming;

import org.apache.groovy.json.internal.Chr;

import java.net.Inet4Address;
import java.util.*;

public class FibonacciSeries {
    int sum1 = 0;
    int sum2 = 0;
    int finalSum = 0;

    public static void main(String[] args) {
        FibonacciSeries fb = new FibonacciSeries();
        //System.out.println(fb.removeVowels("what is your name ?"));
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 4, 5};
        // fb.merge(nums1, 1, nums2, 5);
        int[] arr = {4, 4, 4};
        //   fb.slidingWindowMaximum(arr,3);
        System.out.println(fb.maximumSubarraySum(arr, 3));
       /* System.out.println(fb.fib(5));
        //1 2 3 4 5
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k]);
                }
                System.out.println();
            }
        }*/
        int[] array = {-2, 3, 4};
        //   System.out.println(fb.maxProduct(array));
    }

    public int maxSumSubArray(int[] array) {
        int currentMax = array[0];
        int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            if (currentMax + array[i] >= array[i])
                currentMax = currentMax + array[i];
            else
                currentMax = array[i];
            if (currentMax >= maxSoFar)
                maxSoFar = currentMax;
        }
        return maxSoFar;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = m;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                nums1[k++] = nums1[i];
                nums1[i] = nums2[j++];
            }
        }
        while (i < m) {
            if (k < nums1.length) nums1[k++] = nums1[i++];
            else i++;
        }
        while (j < n) {
            if (k < nums1.length) nums1[k++] = nums2[j++];
            else j++;
        }
    }

    public int[] slidingWindowMaximum(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] nge = nextGreaterElement(nums);
        for (int i = 0; i <= nums.length - k; i++) {
            int j = i;
            while (nge[j] < i + k)
                j = nge[j];
            list.add(nums[j]);
        }
        int[] ans = new int[list.size()];
        int count = 0;
        for (int number : list)
            ans[count++] = number;
        return ans;
    }

    public int subString(String s) {
        int n = s.length() * (s.length() + 1) / 2;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String t = s.substring(i, j);
                System.out.println(t);
                int len = removeDuplicatesAndReturnLength(t);
                if (len > max)
                    max = len;
            }
        }
        return max;
    }

    public int removeDuplicatesAndReturnLength(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        HashSet<Character> hs = new HashSet();
        for (int i = 0; i < charArray.length; i++) {
            if (hs.add(charArray[i]) == false)
                return -1;
        }
        return s.length();
    }

    //nums = [1,5,4,2,9,9,9], k = 3
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        long max = Long.MIN_VALUE;
        long windowSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            hashMap.put(nums[end], hashMap.getOrDefault(nums[end], 0) + 1);
            windowSum += nums[end];
            if (end >= k - 1) {
                if (hashMap.size() == k)
                    max = Math.max(max, windowSum);
                windowSum = windowSum - nums[start];
                hashMap.put(nums[start], hashMap.get(nums[start]) - 1);
                if (hashMap.get(nums[start]) < 1) hashMap.remove(nums[start]);
                start++;
            }

        }
        if(max==Long.MIN_VALUE) return 0;
        return max;
    }

    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
                    stack.pop();
            }
            if (stack.isEmpty())
                result[i] = nums.length;
            else
                result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }


    public int maxProduct(int[] array) {
        int currentMax = array[0];
        int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            if (currentMax * array[i] >= array[i])
                currentMax = currentMax * array[i];
            else
                currentMax = array[i];
            if (currentMax >= maxSoFar)
                maxSoFar = currentMax;
        }
        return maxSoFar;
    }

    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int left = fib(n - 1);
        int right = fib(n - 2);
        return left + right;
    }
}


