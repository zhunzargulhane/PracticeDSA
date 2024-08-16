package datastructuresandalgorithms.practiceproblems;

import datastructuresandalgorithms.arrays.PrintArrayResusable;

import java.util.TreeSet;

public class Practices {

    public static void main(String[] args) {
        //int[] array = {1, 0, 0, 1, 0, 1, 0, 0};
        int[] nums1={7,8,9,0,0,0};
        int[] nums2={1,2,3};
        PrintArrayResusable.printArray(mergeSortedArray(nums1,3,nums2,3));



        //String s = "A man, a plan, a canal: Panama";
        // PrintArrayResusable.printArray();
      //  System.out.println(canPlaceFlower(array, 1));
    }

    public static int[] reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
        return array;
    }

    public static int[] removeEvenIntegers(int[] array) {
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                oddCount++;
        }
        int[] result = new int[oddCount];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result[j] = array[i];
                j++;
            }

        }
        return result;
    }

    public static int sumNaturalNumbers(int num) {
        return num * (num + 1) / 2;
    }

    public static int minimumValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int thirdmaximumValue(int[] array) {
        int max = array[0];
        int secondMax = -1;
        int thirdMax = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax && array[i] != max) {
                thirdMax = secondMax;
                secondMax = array[i];
            } else if (array[i] > thirdMax && array[i] != secondMax && array[i] != max) {
                thirdMax = array[i];
            }
        }
        return thirdMax;
    }

    public static int[] movezeroToEnd(int[] array) {
        //1,0,4,5,0,2,0,6
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[j] == 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if (array[j] != 0) {
                j++;
            }
        }

        return array;
    }


    public int missingNumber(int[] array) {
        int num = 8;
        int total = num * (num + 1) / 2;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return total - sum;
    }

    public static boolean isPalindrome(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (!Character.isLetter(array[start]) & !Character.isDigit(array[start])) {
                start++;
            }
            if (!Character.isLetter(array[end]) & !Character.isDigit(array[end])) {
                end--;
            }
            if ((Character.isLetter(array[start]) || Character.isDigit(array[start])) && (Character.isLetter(array[end]) || Character.isDigit(array[end]))) {
                if (array[start] == array[end]) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean containsDuplicate(int[] array) {
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < array.length; i++) {
            if (!treeSet.add(array[i])) {
                return true;
            }
        }
        return false;
    }

    public static int lengthOfLastWord(String s) {
        String[] s1 = s.trim().split("\\s");
        return s1[s1.length - 1].length();
    }

    public static boolean canPlaceFlower(int[] array, int n) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                int prev = (i == 0 || array[i - 1] == 0) ? 0 : 1;
                int next = (i == array.length - 1 || array[i + 1] == 0) ? 0 : 1;
                if (prev == 0 && next == 0)
                    count++;
            }
        }
        if (n <= count)
            return true;
        else return false;
    }

    public static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        return nums1;
    }
}
