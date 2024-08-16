package datastructuresandalgorithms.practiceproblems;

import java.util.*;

public class ImplementStack {

    int top = -1;

    int[] array;
    int length = 0;

    public ImplementStack(int capacity) {
        array = new int[capacity];
    }

    public void push(int num) {
        top++;
        array[top] = num;
        length++;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        int temp = array[top];
        top--;
        length--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top;
    }


    public static void main(String[] args) {
        ImplementStack implementStack = new ImplementStack(3);
        //"23434"
        implementStack.push(1);
        implementStack.push(2);
        implementStack.push(3);
        // System.out.println(implementStack.pop());
        //  System.out.println(implementStack.pop());
        //   System.out.println(implementStack.pop());
        //     System.out.println(implementStack.isEmpty());
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};
        int[] arra = {3, 2, 2};
        int[] temp = new int[arra.length];
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //Arrays.sort(s);
        //System.out.println("hello");
        //  int[] temp=arra;
        //  System.out.println(implementStack.nextGreaterElement(nums1, nums2));
        // implementStack.mergeSort(arra, temp, 0, arra.length - 1);
        int[] s1={3,2,3};

        //implementStack.insertionSort(nums2);
        //implementStack.display(nums2);
        int[][] array={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
 //       implementStack.reconstructQueue(array);
    }

    public void display(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> list;
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            if (hashMap.containsKey(String.valueOf(ch))) {
                list = hashMap.get(String.valueOf(ch));
                list.add(strs[i]);
            } else {
                list = new ArrayList<String>();
                list.add(strs[i]);
                hashMap.put(String.valueOf(ch), list);
            }
        }
        Set<Map.Entry<String, List<String>>> set = hashMap.entrySet();
        for (Map.Entry<String, List<String>> mp : set) {
            lists.add(mp.getValue());
        }
        return lists;
    }

    public void insertionSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int temp=nums[i];
            int j=i-1;
            while(j>=0 && temp<=nums[j]){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=temp;
        }
    }



    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> mp : set) {
            if (mp.getValue() > (nums.length / 2))
                max = mp.getKey();
        }
        return max;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        Stack<Integer> stack = new Stack();
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        stack.push(nums2[0]);
        for(int i=1;i<nums2.length;i++){
            if(nums2[i]>stack.peek()){
                while(!stack.isEmpty() && nums2[i]>stack.peek()){
                    if(hashMap.containsKey(stack.peek()))
                        ans[hashMap.get(stack.pop())]=nums2[i];
                    else stack.pop();
                }
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            if(hashMap.containsKey(stack.peek()))
                ans[hashMap.get(stack.pop())]=-1;
            else stack.pop();
        }
        return ans;
    }

    public void print(int num) {
        if (num > 100)
            return;
        System.out.println(num++);
        print(num);
    }


    public int[] nextGreater(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        Stack<Integer> stack = new Stack();
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] > stack.peek()) {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    if (hashMap.containsKey(stack.peek()))
                        ans[hashMap.get(stack.pop())] = nums2[i];
                    else stack.pop();
                }
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            if (hashMap.containsKey(stack.peek()))
                ans[hashMap.get(stack.pop())] = -1;
            else stack.pop();
        }
        return ans;
    }

    public void mergeSort(int[] array, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, temp, low, mid);
            mergeSort(array, temp, mid + 1, high);
            actualMerge(array, temp, low, mid, high);
        }
    }

    public void actualMerge(int[] array, int[] temp, int low, int mid, int high) {
        int k = low;
        for (int i = low; i <= high; i++) {
            temp[k++] = array[i];
        }
        k = low;
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                array[k++] = temp[i];
                i++;
            } else {
                array[k++] = temp[j];
                j++;
            }
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
    }


}
