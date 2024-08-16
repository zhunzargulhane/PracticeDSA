package datastructuresandalgorithms.searchingAlgorithm;

import java.util.LinkedList;

public class LinearSearch {

    public int search(int[] num,int x){
        for(int i=0;i<num.length;i++){
            if(x==num[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num={1,2,8,6,4,3};
        LinearSearch linearSearch = new LinearSearch();
        System.out.println(linearSearch.search(num,8));
    }
}
