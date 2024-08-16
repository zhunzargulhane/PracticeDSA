package datastructuresandalgorithms.priorityQueueHeaps;


import javafx.util.Pair;

import java.util.*;

import static com.google.common.collect.ImmutableList.of;
import static java.util.List.*;

public class MinHeap {

    private Integer[] heap;
    private int n;

    public MinHeap(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public void insert(int value) {
        if (n == heap.length - 1)
            resize(2 * heap.length);
        n++;
        heap[n] = value;
        swim(n);
    }


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(stones[i]);
        }
        while (!priorityQueue.isEmpty() && priorityQueue.size() != 1) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            if (x != y) {
                priorityQueue.add(Math.abs(y - x));
            }
        }
        if (priorityQueue.size() == 1)
            return priorityQueue.peek();
        else return 0;
    }

    /*public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        PriorityQueue<Pair> priorityQueue = new PriorityQueue();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (priorityQueue.size() < k)
                    priorityQueue.add(new Pair(nums1[i] + nums2[j], nums1[i], nums2[j]));
                else if (priorityQueue.peek().getSum() > nums1[i] + nums2[j]) {
                    priorityQueue.add(new Pair(nums1[i] + nums2[j], nums1[i], nums2[j]));
                    priorityQueue.poll();
                } else break;
            }
        }
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll().getSum() + " ");
         *//*   Pair pair1 = priorityQueue.poll();
            list.add(pair1.getA());
            list.add(pair1.getB());
            lists.add(list);
            list = new ArrayList<Integer>();*//*
        }
        return lists;
    }
*/
    public List<List<Integer>> kSmallestPairsOptimal(int[] nums1, int[] nums2, int k) {
        return null;
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> hm = new HashMap();
        int count = 0;
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        PriorityQueue<FrequentPairString> pq = new PriorityQueue();
        hm.put(words[0], 1);
        for (int i = 1; i < words.length; i++) {
            if (hm.containsKey(words[i])) {
                hm.put(words[i], hm.get(words[i]) + 1);
            } else {
                hm.put(words[i], 1);
            }
        }
        for (Map.Entry<String, Integer> entry : set) {
            pq.add(new FrequentPairString(entry.getKey(), entry.getValue()));
        }
        while (count != k) {
            list.add(pq.poll().getKey());
            count++;
        }

        return list;
    }

    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        int k = grid[0].length;
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<MatrixPair> priorityQueue = new PriorityQueue<MatrixPair>();
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue(k, Collections.reverseOrder());
        while (k > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0)
                        priorityQueue.add(new MatrixPair(grid[i][j], j));
                }
                integerPriorityQueue.add(priorityQueue.peek().getMatValue());
                grid[i][priorityQueue.poll().getJ()] = 0;
                priorityQueue = new PriorityQueue<MatrixPair>();
            }
            ans += integerPriorityQueue.poll();
            integerPriorityQueue = new PriorityQueue(k, Collections.reverseOrder());
            k--;
        }
        return ans;
    }

    public int deleteGreatestValue1(int[][] grid) {
        ArrayList<PriorityQueue<Integer>> list = new ArrayList();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue(grid.length,Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                pq.add(grid[i][j]);
            }
            list.add(pq);
        }
        int result=0;
        for(int i=0;i<n;i++){
            int num=0;
            for(int j=0;j<m;j++){
                PriorityQueue<Integer> pq=list.get(j);
                int temp=pq.poll();
                num=Math.max(num,temp);
            }
            result+=num;
        }
        return result;
    }

    public void design(){
        LinkedList<Integer> list = new LinkedList();
        HashMap<Integer,LinkedList<Integer>> linkedListHashMap = new HashMap();
        list.add(5);
        linkedListHashMap.put(1,list);
        LinkedList list1 = linkedListHashMap.get(1);
        list1.add(linkedListHashMap.get(2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        Set<Map.Entry<Integer, Integer>> set = hm.entrySet();
        PriorityQueue<FrequentPair> pq = new PriorityQueue();
        hm.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : set) {
            pq.add(new FrequentPair(entry.getKey(), entry.getValue()));
        }
        while (count != k) {
            ans[count++] = pq.poll().getKey();
        }
        return ans;
    }

    int minProduct(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int result = 1;
        int count = 0;
        while (count != k) {
            result = result * pq.poll();
            count++;
        }
        return result;
    }

    public void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 1; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void swim(int k) {
        while (k > 1 && heap[k] < heap[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public void swap(int a, int b) {
        int temp = heap[b];
        heap[b] = heap[a];
        heap[a] = temp;
    }

    public Integer deleteMin() {
        if (n == 0)
            return null;
        int min = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n + 1] = null;
        return min;
    }

    public static long minSum(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            num1 = num1 * 10 + pq.poll();
            if (!pq.isEmpty())
                num2 = num2 * 10 + pq.poll();
        }
        return num1 + num2;
    }

    public void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && heap[j] > heap[j + 1])
                j++;
            if (heap[k] < heap[j])
                break;
            swap(k, j);
            k = j;
        }
    }

    public void display() {
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(3);
        /*minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(9);
        minHeap.display();
        while (minHeap.n != 3) {
            minHeap.deleteMin();
        }
        System.out.println();
        minHeap.display();*/
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {-3, 22, 35, 56, 76};
        int[] nums = {9, 10, 8};
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        // System.out.println(minHeap.topKFrequent(words, 2));
        int[][] mul = {{1, 2, 4}, {3, 3, 1}};

        System.out.println(minHeap.deleteGreatestValue1(mul));
    }
}
