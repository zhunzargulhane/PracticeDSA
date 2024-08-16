package datastructuresandalgorithms.customclasses;

import java.util.Comparator;

public class Pairs implements Comparable<Pairs> {

    Integer i;
    Integer j;
    Integer sum;

    public Pairs() {
    }

    public Pairs(int sum, int i, int j) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getSum() {
        return sum;
    }


    @Override
    public int compareTo(Pairs o) {
        /*int sumThis = this.getSum();
        int newSum = o.getSum();
        if (newSum > sumThis)
            return -1;
        else*//* if(newSum<sumThis)*//*
            return +1;
        //return o.getSum() - this.getSum();*/
        return +1;
    }
}
