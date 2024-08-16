package datastructuresandalgorithms.priorityQueueHeaps;

public class PracticeMinHeap {
    Integer[] heap;
    int n;

    public PracticeMinHeap(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insertMin(int val) {
        if (n == heap.length - 1) {
            resize(2 * heap.length);
        }
        n++;
        heap[n] = val;
        swim(n);
    }

    public int deleteMin() {
        int min = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n+1]=null;
        return min;
    }

    private void sink(int k) {
        while(k*2<=n){
            int j=k*2;
            if(j<n && heap[j+1]<heap[j])
                j++;
            if(heap[j]>heap[k]) break;
            else{
                swap(k,j);
            }
            k=j;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && heap[k] < heap[k / 2]) {
            int temp = heap[k];
            heap[k] = heap[k / 2];
            heap[k / 2] = temp;
            k = k / 2;
        }
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 1; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public static void main(String[] args) {
        PracticeMinHeap practiceMinHeap = new PracticeMinHeap(7);
        for (int i = 1; i < practiceMinHeap.heap.length; i++) {
            practiceMinHeap.insertMin(i);
        }
        practiceMinHeap.insertMin(0);
        System.out.println(practiceMinHeap.deleteMin());
        System.out.println(practiceMinHeap.deleteMin());
        System.out.println(practiceMinHeap.deleteMin());
        System.out.println(practiceMinHeap.deleteMin());
        System.out.println("helol");
    }
}
