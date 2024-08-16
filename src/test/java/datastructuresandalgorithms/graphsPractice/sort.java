package datastructuresandalgorithms.graphsPractice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class sort {
    public static void main(String[] args) {
        String[] str = {"pune","nagpur","delhi","Bengaluru"};
       /* Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });*/
        Arrays.sort(str,Comparator.comparing(str1->str1.length()));

      //  Arrays.sort(str,(o1,o2)-> o2.length()-o1.length());
        for(String data:str){
            System.out.println(data);
        }
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(haystack.indexOf(needle));

    }
}
