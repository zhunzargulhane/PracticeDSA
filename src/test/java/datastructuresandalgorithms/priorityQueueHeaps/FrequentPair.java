package datastructuresandalgorithms.priorityQueueHeaps;

import net.bytebuddy.description.field.FieldDescription;

public class FrequentPair implements Comparable<FrequentPair> {

    int key;
    int value;
    FrequentPair(){

    }
    FrequentPair(int key,int value){
        this.key=key;
        this.value=value;
    }

    public int getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }
    @Override
    public int compareTo(FrequentPair o) {
        return o.getValue()-this.getValue();
    }
}
