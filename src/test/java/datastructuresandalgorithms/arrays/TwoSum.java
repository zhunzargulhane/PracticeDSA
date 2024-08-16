package datastructuresandalgorithms.arrays;

import java.util.HashMap;
import java.util.StringTokenizer;

/*
Sum of two numbers should be equal to target and need to return the indices.
*/
public class TwoSum {
    public static void main(String[] args) {
       /* System.out.println(indexesofTwoSum());
        System.out.println(containsDuplicate());
        lengthOfLasWord();
*/

        /*int[] array = {1, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(array, 2));*/
       /* int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};*/
      /*  int m = 3;
        int n = 3;
        int[] nums1 = new int[m + n];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        int[] nums2 = new int[n];
        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;
        //System.out.println(nums1.length);*/
        //mergeTwoSortedArrays(nums1, m, nums2, n);
        //  int[] array = {0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6};
        int[] array = {3,1};
        int target = 4;
        int[] temp=indexesTwoSum(array, target);
        for(int a:temp)
            System.out.print(a+" ");
        //  System.out.println(removeDuplicatesFromSortedArray(array));

    }

    public static String indexesofTwoSum(int[] array, int target) {
        int i = 0, j = 0, k = j;
        while (k < array.length) {
            if (array[i] + array[k] == target)
                return i + " " + k;
            else k++;
            if (k == array.length) {
                i++;
                j++;
                k = j;
            }
        }
        return null;
    }


        public static int[] indexesTwoSum(int[] array, int target) {
        int[] temp =new int[2];
        int i = 0, j = 1;
        while (i < array.length) {
            while (j < array.length) {
                if (array[i] + array[j] == target) {
                    temp[0] = i ;
                    temp[1] = j;
                    return temp;
                }
                else
                    j++;
            }
            i++;
            j = i + 1;
        }
        return temp;
    }

    public static boolean containsDuplicate() {
        int[] array = {1, 2, 3, 4, 5};
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < array.length; i++) { // 1 +  6(n+1) + 3 = 6n+6+4=6n+10;
            if (hashMap.containsValue(array[i])) {
                return true;
            }
            hashMap.put(i, array[i]);
        }
        return false;
    }

    public static void lengthOfLasWord() {
        String s = "   fly me   to   the mouon  ";
        System.out.println(s.trim());
        String[] sSplit = s.split(" ");
        System.out.println(sSplit[sSplit.length - 1].length());
    }

    public static boolean canPlaceFlowers(int[] array, int n) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                int prev = (i == 0 || array[i - 1] == 0) ? 0 : 1;
                int next = (i == array.length - 1 || array[i + 1] == 0) ? 0 : 1;
                if (prev == 0 && next == 0) {
                    array[i] = 1;
                    count++;
                }
            }
        }
        return n <= count;
    }

    public static void mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = (m + n) - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2])
                nums1[i--] = nums1[p1--];
            else
                nums1[i--] = nums2[p2--];
        }
    }

    public static int removeDuplicatesFromSortedArray(int[] array) {
        int[] temp = new int[array.length];
        int j = 1;
        int i = 0;
        int k = 0;
        while (j < array.length) {
            if (j < array.length) {
                if (array[i] == array[j]) {
                    j++;
                } else {
                    temp[k] = array[i];
                    i = j;
                    k++;
                    i++;
                }
            } else {
                temp[k] = array[i];
            }
        }
        array = temp;
        for (int z = 0; z < array.length; z++)
            System.out.println(array[z] + " ");
        return 0;
    }
}
