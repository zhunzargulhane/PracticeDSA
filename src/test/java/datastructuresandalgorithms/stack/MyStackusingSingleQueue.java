package datastructuresandalgorithms.stack;

import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class MyStackusingSingleQueue {
    Queue<Integer> queue1;

    public MyStackusingSingleQueue() {
        queue1 = new LinkedList();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        int count = 0;
        while (count != queue1.size() - 1) {
            queue1.offer(queue1.poll());
            count++;
        }
        int result = queue1.poll();
        return result;
    }

    public int top() {
        int count = 0;
        while (count != queue1.size() - 1) {
            queue1.offer(queue1.poll());
            count++;
        }
        int result = queue1.peek();
        queue1.offer(queue1.poll());
        return result;
    }

    public boolean empty() {
        if (queue1.isEmpty())
            return true;
        return false;
    }

    public static int compressString(char[] chars) {
        if (chars.length == 1)
            return 1;
        String s = "";
        Queue<Character> queue = new LinkedList();
        queue.offer(chars[0]);
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (queue.peek() == chars[i]) {
                count++;
            } else {
                if (count == 1)
                    s = s + queue.poll();
                else {
                    s = s + queue.poll() + count;
                }
                queue.offer(chars[i]);
                count = 1;
            }
        }
        if (count == 1)
            s = s + queue.poll();
        else
            s = s + queue.poll() + count;
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
            System.out.print(chars[i] + " ");
        }
        return s.length();
    }

    public static int compressStringTwoPointerApproach(char[] chars) {
        if (chars.length == 1)
            return 1;
        int count = 1;
        int j = 0;
        String s = "";
        for (int i = 1; i < chars.length; i++) {
            if (chars[j] != chars[i] && count != 1) {
                s = s + chars[j] + count;
                j = i;
                count = 1;
            } else if (chars[j] != chars[i] && count == 1) {
                s = s + chars[j];
                j = i;
            } else
                count++;
        }
        if (count == 1)
            s = s + chars[j];
        else
            s = s + chars[j] + count;

        for (int i = 0; i < s.length(); i++)
            chars[i] = s.charAt(i);
        return s.length();
    }

    public static boolean validStackSequence(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (stack.isEmpty())
                stack.push(pushed[i]);
            else if (stack.peek() != popped[j])
                stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
                if (stack.isEmpty())
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static int removeDuplicate(int[] array) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(array[0]);
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != queue.peek()) {
                array[j++] = queue.poll();
                queue.offer(array[i]);
            }
            if (i == array.length - 1) {
                array[j++] = queue.poll();
            }
        }
        if (!queue.isEmpty()) {
            array[j++] = queue.poll();
        }
        return j;
    }

    public static int removeDuplicateII(int[] array) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(array[0]);
        int j = 0;
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == queue.peek()) {
                if (count < 2) {
                    count++;
                    queue.offer(array[i]);
                }
            }
            if (array[i] != queue.peek()) {
                while (count > 0) {
                    array[j++] = queue.poll();
                    count--;
                }
                queue.offer(array[i]);
                count = 1;
            }
            if (i == array.length - 1) {
                array[j++] = queue.poll();
            }
        }
        if (!queue.isEmpty()) {
            array[j++] = queue.poll();
        }
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        return j;
    }

    public static int removeDuplicates80LeetCode(int[] array) {
        Stack<Integer> stack = new Stack();
        int count = 1;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
                array[k] = stack.peek();
                k++;
            } else if (stack.peek() == array[i]) {
                if (count < 2) {
                    stack.push(array[i]);
                    count++;
                    array[k] = stack.peek();
                    k++;
                }
            } else {
                stack.push(array[i]);
                count = 1;
                array[k] = stack.peek();
                k++;
            }
        }
        return k;
    }

    public static int removeDuplicates80LeetCodeAnotherApproach(int[] nums) {
        int count = 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else {
                count = 0;
            }
            if (count <= 1) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }


    public String removeAdjacentDuplicates(String s) {
        //s=abbaca
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        String s1 = "";
        while (!stack.isEmpty())
            s1 = s1 + stack.pop();
        StringBuffer sb = new StringBuffer(s1);
        return sb.reverse().toString();
    }

    public static String removeAdjacentDuplicatesII(String s, int k) {
        Stack<Integer> stack = new Stack();
        LinkedList<Character> linkedList = new LinkedList<Character>();
        linkedList.push(s.charAt(0));
        stack.push(1);
        for (int i = 1; i < s.length(); i++) {
            if (linkedList.contains(s.charAt(i))) {
                int i1 = linkedList.lastIndexOf(linkedList.getLast());
                linkedList.addLast(s.charAt(i));
                if (linkedList.get(i1) == s.charAt(i)) {
                    int val = stack.pop();
                    stack.push(val + 1);
                } else
                    stack.push(1);
            } else {
                linkedList.addLast(s.charAt(i));
                stack.push(1);
            }
            if (k == stack.peek()) {
                int count = stack.peek();
                while (count > 0) {
                    linkedList.removeLast();
                    count--;
                }
                stack.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (!linkedList.isEmpty()) {
            sb.append(linkedList.get(index));
            linkedList.remove();
        }
        return sb.toString();
    }

    public static String samepl(String s, int k) {
        Stack<Character> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack1.isEmpty()) {
                stack1.push(s.charAt(i));
                stack2.push(1);
            } else if (s.charAt(i) == stack1.peek()) {
                stack1.push(s.charAt(i));
                int val = stack2.pop();
                stack2.push(val + 1);
                if (stack2.peek() == k) {
                    int count = 1;
                    while (count <= k) {
                        stack1.pop();
                        count++;
                    }
                    stack2.pop();
                }
            } else {
                stack1.push(s.charAt(i));
                stack2.push(1);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack1.isEmpty())
            sb.append(stack1.pop());

        return sb.reverse().toString();
    }

    public static int countBinarySubStrings(String s) {
        Stack<Character> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stack1.isEmpty()) {
                stack1.push(s.charAt(i));
                stack2.push(1);
            } else if (stack1.peek() == s.charAt(i)) {
                int val = stack2.pop();
                stack2.push(val + 1);
            } else {
                stack1.push(s.charAt(i));
                stack2.push(1);
            }
        }
        while (!stack2.isEmpty()) {
            int a = stack2.pop();
            if (!stack2.isEmpty()) {
                int b = stack2.peek();
                sum = sum + Math.min(a, b);
            }
        }
        return sum;
    }

    public static int countBinaryStringSolutionII(String s){
        //10101
        int count=1;
        int prev=0;
        int sum=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                sum=sum+Math.min(prev,count);
                prev=count;
                count=1;
            }
        }
        sum=sum+Math.min(prev,count);
        return sum;
    }


    public static void main(String[] args) {
      /*  char[] ch = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compressStringTwoPointerApproach(ch));*/
      /*  int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        System.out.println(validStackSequence(pushed, popped));*/
        //  int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //System.out.println(removeAdjacentDuplicatesII("abbcccd", 2));
        //   System.out.println(samepl("pbbcggttciiippooaais", 2));
        //   System.out.println(countBinarySubStrings("00110011"));
        int[] array = {0, 0, 1, 1, 1, 2, 2, 2, 3, 4};
        //  System.out.println(removeDuplicates80LeetCodeAnotherApproach(array));

       // System.out.println(countBinarySubStrings("00110011"));
        System.out.println(countBinaryStringSolutionII("00110011"));


    }
}

