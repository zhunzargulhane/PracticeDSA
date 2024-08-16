package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        //printNumber(1);
       /* StringBuffer sb = null;
        String reverseString="";
        StringTokenizer stringTokenizer = new StringTokenizer("zhunzar is great", " ");
        while (stringTokenizer.hasMoreTokens()) {
            sb=new StringBuffer(stringTokenizer.nextToken());
            reverseString=reverseString+" "+sb.reverse();
        }
        System.out.println(reverseString);*/
        /*String s = "zhunzar";
        char[] sArray = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < sArray.length; i++) {
            if (hashMap.containsKey(sArray[i]))
                hashMap.put(sArray[i], hashMap.get(sArray[i]) + 1);
            else
                hashMap.put(sArray[i], 1);
        }
        System.out.println(hashMap);*/
        String s1= "abc.def";
        String[] arr = s1.split("\\.");
        System.out.println(arr[0]);
        System.out.println(arr[1]);

/*

        ArrayList<Integer> nonSortedList = new ArrayList();
        HashSet<Integer> hashSet = new HashSet<>();
        nonSortedList.stream().map(a->hashSet.add(a));
*/


    }

    public static int printNumber(int number) {
        if (number == 100) {
            System.out.println(number);
            return 100;
        } else {
            System.out.println(number);
            return printNumber(number + 1);
        }
    }




}
