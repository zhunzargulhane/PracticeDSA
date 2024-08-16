package datastructuresandalgorithms.searchingAlgorithm;

import java.util.*;

public class Sortings {

    public void sort(int[] array) {
        boolean swap = true;
        int length = array.length - 1;
        int count = 1;
        while (swap) {
            swap = false;
            for (int i = 1; i <= length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swap = true;
                }
            }
            count++;
            length = array.length - count;
        }
    }


    public void sort2(int[] num) {
        boolean isSwapped;
        for (int i = 0; i < num.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false) break;
        }
    }

    public void insertionSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < num[j]) {
                    num[j + 1] = num[j];
                    if (j == 0)
                        num[j] = temp;
                } else {
                    num[j + 1] = temp;
                    break;
                }
            }
        }
    }

    public void insertionSort2(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > temp) { // unsorted part
                num[j + 1] = num[j]; // shifting larger elements to temp by 1 position
                j--;
            }
            num[j + 1] = temp;
        }
    }

    public void selectionSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            int min = i;
            for (int j = i; j < num.length; j++) {
                if (num[j] <= num[min])
                    min = j;
            }
            int temp = num[min];
            num[min] = num[i];
            num[i] = temp;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int count = 0;
        int[] result = new int[m + n];
        for (int l = 0; l < result.length; l++) {
            if (i >= m) {
                for (int i1 = j; i1 < n; i1++) {
                    result[count++] = nums2[i1];
                }
                break;
            } else if (j >= n) {
                for (int i1 = i; i1 < m; i1++) {
                    result[count++] = nums1[i1];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                result[count++] = nums1[i];
                i++;
            } else {
                result[count++] = nums2[j];
                j++;
            }
        }
        count = 0;
        for (int i1 = 0; i1 < result.length; i1++) {
            nums1[count++] = result[i1];
        }
    }

    public void merge2Arrays(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int count = 0;
        int[] result = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[count++] = nums1[i++];
            } else {
                result[count++] = nums2[j++];
            }
        }
        while (j < n)
            result[count++] = nums2[j++];
        while (i < m)
            result[count++] = nums1[i++];
        count = 0;
        for (int i1 : result)
            nums1[count++] = i1;
    }


    public void mergeSort(int[] array, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, temp, low, mid);
            mergeSort(array, temp, mid + 1, high);
            mergeArrays(array, temp, low, mid, high);
        }
    }

    public void mergeArrays(int[] array, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++)
            temp[i] = array[i];
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j])
                array[k++] = temp[i++];
            else
                array[k++] = temp[j++];
        }
        while (i <= mid)
            array[k++] = temp[i++];
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        int j = low;
        while (i <= high) {
            if (array[i] <= pivot) {
                swap(array, i, j);
                j++;
            }
            i++;
        }
        return j - 1;
    }

    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int count = 0;
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();
        for (int i : nums) {
            if (i >= 0)
                queue1.offer(i);
            else
                queue2.offer(i);
        }
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            ans[count++] = queue1.poll();
            ans[count++] = queue2.poll();
        }
        return ans;
    }

    public int[] rearrangeArray2(int[] nums) {
        int[] ans = new int[nums.length];
        int count = 0;
        for (int i : nums) {
            if (i >= 0) {
                ans[count] = i;
                count = count + 2;
            }
        }
        count = 1;
        for (int i : nums) {
            if (i < 0) {
                ans[count] = i;
                count = count + 2;
            }
        }
        return ans;
    }


    public void rearrangeMinMax(int[] array) {
        int minIndex = 0;
        int maxIndex = array.length - 1;
        int max = array[maxIndex] + 1;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = array[i] + (array[maxIndex] % 10) * max;
                maxIndex--;
            } else {
                array[i] = array[i] + (array[minIndex] % 10) * max;
                minIndex++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] / max;
        }
    }


    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int k = nums.length - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];
                i++;
            } else {
                ans[k] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }


    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (i <= k) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[i] == 1)
                i++;
            else if (nums[i] == 2) {
                swap(nums, i, k);
                k--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void display(int[] array) {
        for (int i : array)
            System.out.print(i + " ");
    }

    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int key = 0;
        for (int i : nums) {
            if (hashMap.containsKey(i))
                hashMap.put(i, hashMap.get(i) + 1);
            else
                hashMap.put(i, 1);
        }
        Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> mp : set) {
            if (mp.getValue() == 1) {
                key = mp.getKey();
                break;
            }
        }
        return key;

    }

    public int singleNonDuplicate1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[0] != nums[1])
            return nums[0];
        else if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];
        while (low < high) {
            int mid = (low + high) / 2;
            if (mid % 2 != 0 && nums[mid] == nums[mid - 1])
                low = mid + 1;
            else high = mid - 1;
        }
        return nums[low];
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap.containsKey(nums1[i]))
                hashMap.put(nums1[i], hashMap.get(nums1[i]) + 1);
            else
                hashMap.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i])) {
                if (hashMap.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    hashMap.put(nums2[i], hashMap.get(nums2[i]) - 1);
                }
            }
        }
        int[] ans = new int[list.size()];
        int count = 0;
        for (int i : list)
            ans[count++] = i;
        return ans;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList();
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == x) break;
            if (arr[mid] < x)
                low = mid + 1;
            else high = mid - 1;
        }
        high = mid;
        low = mid - 1;
        while (low >= 0 && high <= arr.length - 1 && list.size() < k) {
            if (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x))
                list.add(arr[low--]);
            else
                list.add(arr[high++]);
        }
        while (list.size() < k && low >= 0)
            list.add(arr[low--]);
        while (list.size() < k && high <= arr.length - 1)
            list.add(arr[high++]);
        Collections.sort(list);
        return list;
    }

    public int searchRevision(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public boolean search3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }

    public int peakIndexInMountainArray(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                count++;
                if (count > 1)
                    return false;
                if (nums[0] < nums[nums.length - 1])
                    return false;
                // break;
            }
        }
        return true;
    }

    public int[] findPeakGrid(int[][] mat) {
        if (mat.length == 1 && mat[0].length == 1)
            return new int[]{0, 0};
        int r = mat.length;
        int c = mat[0].length;
        int low = 0;
        int high = c - 1;
        int indexI = 0, indexJ = 0;
        int[] ans = new int[2];
        int max = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            for (int i = 0; i < r; i++) {
                if (mat[i][mid] > max) {
                    max = mat[i][mid];
                    indexI = i;
                    indexJ = mid;
                }
            }
            int left = (mid > 0) ? mat[indexI][indexJ - 1] : -1;
            int right = (mid < c - 1) ? mat[indexI][indexJ + 1] : -1;
            if (mat[indexI][indexJ] > left && mat[indexI][indexJ] > right) {
                ans[0] = indexI;
                ans[1] = indexJ;
                return ans;
            } else if (mat[indexI][indexJ] < left)
                high = mid - 1;
            else low = mid + 1;
            max = Integer.MIN_VALUE;
        }
        ans[0] = indexI;
        ans[1] = indexJ;
        return ans;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = 0;
        int high = c - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            for (int i = 0; i < r; i++) {
                if (matrix[i][mid] == target)
                    return true;
            }
            if (matrix[r - 1][mid] < target)
                low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }


    public int findMinimum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int indexMin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                indexMin = i;
            }
        }
        return indexMin;
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int[] ans = new int[2];
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                break;
            if (nums[mid] < target)
                low = mid + 1;
            else high = mid - 1;
        }
        if (nums.length == 0 || nums[mid] != target) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        low = mid - 1;
        high = mid;
        while (low >= 0) {
            if (nums[low] != target) {
                ans[0] = low + 1;
                break;
            } else low--;
        }
        while (high <= nums.length) {
            if (high == nums.length || nums[high] != target) {
                ans[1] = high - 1;
                break;
            } else high++;
        }
        return ans;
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (target < nums[mid] && target >= nums[low])
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }


    public void quickSortRevision(int[] array, int low, int high) {
        if (low < high) {
            int p = partitioning(array, low, high);
            quickSortRevision(array, low, p - 1);
            quickSortRevision(array, p + 1, high);
        }
    }

    public int partitioning(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        int j = low;
        while (i <= high) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1;
    }

    public static void main(String[] args) {
        Sortings sortings = new Sortings();
        int[] num = {2, 0, 2, 1, 1, 0};
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        //  bubbleSort.sort2(array);
        // bubbleSort.display(array);
        //  bubbleSort.insertionSort2(array);
        // sortings.selectionSort(array);
        //sortings.display(array);
        //sortings.merge(nums1, 1, nums2, 1);
        //sortings.merge2Arrays(nums1, 1, nums2, 1);
        //sortings.display(nums1);
        //  int[] temp = new int[array.length];
        //sortings.mergeSort(array, temp, 0, array.length - 1);
        //   sortings.sortColors(array);
        int[] array = {2, 3, 5, 6, 8, 9};
        // sortings.quickSort(array, 0, array.length - 1);
        //sortings.display(array);
        int[] nums = {1, 2, 3};
        // sortings.rearrangeArray2(nums);
        // sortings.quickSortRevision(nums, 0, nums.length - 1);
        int[][] mat = {{1, 3}};
        System.out.println(sortings.searchMatrix(mat, 3));
        //  sortings.display(nums);

    }
}
