package datastructuresandalgorithms.stack;

import java.util.*;

public class MinStack {
    Stack<Integer> minstack;
    Stack<Integer> Allstack;

    public MinStack() {
        Allstack = new Stack();
        minstack = new Stack();
    }

    public void push(int val) {
        if (!minstack.isEmpty() && minstack.peek() < val) {
            minstack.push(minstack.peek());
        } else {
            minstack.push(val);
        }
        Allstack.push(val);
    }

    public void pop() {
        if (Allstack.isEmpty()) {
            return;
        }
        minstack.pop();
        Allstack.pop();
    }

    public int top() {
        if (Allstack.isEmpty()) {
            return -1;
        }
        return Allstack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }

    public static int removeDuplicatedFromSortedArray(int[] array) {
        /*LinkedHashSet<Integer> hashSet = new LinkedHashSet();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        int i = 0;
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext())
            array[i++] = (Integer) iterator.next();
        return hashSet.size();*/
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < array.length; i++) {
            treeSet.add(array[i]);
        }
        int i = 0;
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext())
            array[i++] = (Integer) iterator.next();
        return treeSet.size();
        /*
        Queue<Integer> queue = new LinkedList();
        queue.offer(array[0]);
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (!queue.isEmpty() && array[i] != queue.peek()) {
                array[j++] = queue.poll();
                queue.offer(array[i]);
            }
            if (!queue.isEmpty() && i == array.length - 1) {
                array[j++] = queue.poll();
            }
        }
        if(!queue.isEmpty()){
            array[j++]=queue.poll();
        }
        return j;*/

    }

    public static int firstUnique(String s) {
        //loveleetcode
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (linkedHashMap.containsKey(chars[i]))
                linkedHashMap.put(chars[i], linkedHashMap.get(chars[i]) + 1);
            else
                linkedHashMap.put(chars[i], 0);
        }
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            if (linkedHashMap.get(chars[i]) == 0)
                return i;
        }
        return index;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();

       /* MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        obj.push(-3);
        obj.push(-4);
        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.pop();
      *//*  obj.pop();
        obj.pop();*//*
        System.out.println(obj.getMin());*/
        /*int[] nums = {-3, -1, 0, 0, 0, 3, 3};
        //int[] nums = {1, 1, 2};
        System.out.println("The NONDuplicates are " + removeDuplicatedFromSortedArray(nums));*/
        System.out.println(firstUnique("loveleetcode"));

    }

}
