package datastructuresandalgorithms.priorityQueueHeaps;

public class IndexPair implements Comparable<IndexPair> {
    int key;
    int value;

    public IndexPair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(IndexPair o) {
        return o.getKey() - this.getKey();
    }
}
