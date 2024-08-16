package datastructuresandalgorithms.priorityQueueHeaps;

public class PracticeMaxHeap {
    Integer[] heap;
    int n;

    public PracticeMaxHeap(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 1; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void insert(int val) {
        if (n == heap.length - 1) {
            resize(2 * heap.length);
        }
        n++;
        heap[n] = val;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && heap[k] > heap[k / 2]) {
            int temp = heap[k];
            heap[k] = heap[k / 2];
            heap[k / 2] = temp;
            k = k / 2;
        }
    }

    public int deleteMax() {
        if (n == 0) return -1;
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n + 1] = null;
        return max;
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && heap[k] < heap[j + 1])
                j++;
            if (heap[k] >= heap[j])
                break;
            else {
                swap(k, j);
            }
            k = j;
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        PracticeMaxHeap practiceMaxHeap = new PracticeMaxHeap(8);
        practiceMaxHeap.insert(9);
        practiceMaxHeap.insert(8);
        practiceMaxHeap.insert(3);
        practiceMaxHeap.insert(6);
        practiceMaxHeap.insert(7);
        practiceMaxHeap.insert(1);
        practiceMaxHeap.insert(2);
        System.out.println(practiceMaxHeap.deleteMax());
    }
}
