package org.example;

import java.util.*;

public class BLRProject {

    public static void main(String[] args) {
        Integer[] input = {1, 12, 35, 46, 22, 12, 1};
        TreeSet<Integer> treeSet=new TreeSet();
        for(int inputs:input){
            treeSet.add(inputs);
        }
        System.out.println(treeSet);


     /*   HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < input.length; i++) {

            if (hashMap.containsKey(input[i])) {
                hashMap.put(input[i], hashMap.get(input[i]) + 1);
            }
            else{
                hashMap.put(input[i], 1);
            }
        }
        System.out.println(hashMap);
        TreeMap treeMap = new TreeMap(hashMap);
        System.out.println(treeMap);*/

       /* String data = "zhunzar sudhanshu public";
        char[] vowels = data.toCharArray();
        int count = 0;
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == 'a' || vowels[i] == 'e' || vowels[i] == 'i' || vowels[i] == 'o' || vowels[i] == 'u')
                count++;
        }
        System.out.println("The vowels count is " + count);
*/
    }
}
//String s="zhunzar sudhanshu public";
//a e i o u

