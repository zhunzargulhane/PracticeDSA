package datastructuresandalgorithms.priorityQueueHeaps;

import java.util.stream.Stream;

public class MaxHeap {

    private Integer[] heap;
    private int n;

    public MaxHeap(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public int getLengthOfHeap() {
        return heap.length;
    }

    public void printMaxHeap() {
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 1; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void insert(int value) {
        if (n == getLengthOfHeap() - 1)
            resize(2 * getLengthOfHeap());
        n++;
        heap[n] = value;
        swim(n);
    }

    public void swim(int k) {
        while (k > 1 && heap[k / 2] < heap[k]) {
            int temp = heap[k / 2];
            heap[k / 2] = heap[k];
            heap[k] = temp;
            k = k / 2;
        }
    }

    public Integer deleteMax() {
        if (isEmpty())
            return null;
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n + 1] = null;
        return max;
    }

    public void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && heap[j] < heap[j + 1])
                j++;
            if (heap[k] >= heap[j])
                break;
            swap(k, j);
            k = j;
        }
    }

    public void swap(int a, int b) {
        int temp = heap[b];
        heap[b] = heap[a];
        heap[a] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(3);
        System.out.println(maxHeap.isEmpty());
        System.out.println(maxHeap.size());
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(11);
        System.out.println(maxHeap.size());
        System.out.println(maxHeap.isEmpty());
        maxHeap.printMaxHeap();
        System.out.println();
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        maxHeap.printMaxHeap();
    }

    public int kthLargest(){

        return 0;
    }
}
