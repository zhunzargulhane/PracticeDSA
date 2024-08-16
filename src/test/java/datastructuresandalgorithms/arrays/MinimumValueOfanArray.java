package datastructuresandalgorithms.arrays;

import java.util.PriorityQueue;

class Pairs implements Comparable<Pairs>{
    String number;
    Pairs(String number){
        this.number=number;
    }
    public String getNumber(){
        return number;
    }
    public int compareTo(Pairs pair){
        int j=this.getNumber().length()-pair.getNumber().length();
        if(j==0)
            return this.getNumber().compareTo(pair.getNumber());
        return j;
    }

    public static void main(String[] args) {
       System.out.println(fact(5));

    }

    private static int fact(int num) {
        if(num==1) return 1;
        num=num*fact(num-1);
        return num;
    }

}
