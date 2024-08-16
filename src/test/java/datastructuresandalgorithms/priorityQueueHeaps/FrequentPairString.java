package datastructuresandalgorithms.priorityQueueHeaps;

import net.bytebuddy.description.field.FieldDescription;

import java.util.Comparator;

public class FrequentPairString implements Comparable<FrequentPairString> {

    String key;
    int value;

    FrequentPairString() {

    }

    FrequentPairString(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(FrequentPairString o) {
        int j= o.getValue() - this.getValue();
        if(j==0){
            return this.getKey().compareTo(o.getKey());
        }
        return o.getValue() - this.getValue();
    }
}
