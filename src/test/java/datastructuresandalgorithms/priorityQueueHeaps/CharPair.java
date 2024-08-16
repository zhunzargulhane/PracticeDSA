package datastructuresandalgorithms.priorityQueueHeaps;

public class CharPair implements Comparable<CharPair>{

    char key;
    int value;

    public CharPair(char key,int value){
        this.key=key;
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value=value;
    }

    public char getKey() {
        return key;
    }


    @Override
    public int compareTo(CharPair o) {
        return o.getValue()-this.getValue();
    }
}
