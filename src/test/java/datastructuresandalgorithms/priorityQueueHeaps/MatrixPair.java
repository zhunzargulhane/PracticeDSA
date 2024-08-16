package datastructuresandalgorithms.priorityQueueHeaps;

public class MatrixPair implements Comparable<MatrixPair> {
    int matValue;
    int j;

    public MatrixPair() {

    }

    public MatrixPair(int matValue, int j) {
        this.matValue = matValue;
        this.j = j;
    }

    public int getJ() {
        return j;
    }

    public int getMatValue() {
        return matValue;
    }

    @Override
    public int compareTo(MatrixPair o) {
        return o.getMatValue() - this.getMatValue();
    }
}
