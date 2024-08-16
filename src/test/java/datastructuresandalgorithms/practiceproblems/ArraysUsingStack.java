package datastructuresandalgorithms.practiceproblems;

import java.util.EmptyStackException;
import java.util.Stack;

public class ArraysUsingStack {
    private int top;
    int[] array;

    ArraysUsingStack(int capacity) {
        array = new int[capacity];
        top = -1;
    }

    ArraysUsingStack() {
        this(10);
    }

    public void push(int value) {
        if (array.length == size())
            throw new RuntimeException("Stack is Full");
        top++;
        array[top] = value;
    }

    public int peek() {
        if (top < 0)
            throw new RuntimeException("Stack is Empty");
        return array[top];
    }

    public int pop() {
        if (top < 0)
            throw new EmptyStackException();
        int result = array[top];
        top--;
        return result;
    }

    public int size() {
        return top + 1;
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }


    public static void main(String[] args) {
        /*ArraysUsingStack arraysUsingStack = new ArraysUsingStack(4);
        arraysUsingStack.push(10);
        arraysUsingStack.push(20);
        arraysUsingStack.push(30);
        arraysUsingStack.push(40);
       // arraysUsingStack.printArray();
        System.out.println(arraysUsingStack.size());
        System.out.println(arraysUsingStack.pop());
        System.out.println(arraysUsingStack.pop());
        System.out.println(arraysUsingStack.pop());
        System.out.println(arraysUsingStack.pop());
        System.out.println(arraysUsingStack.size());
        System.out.println(arraysUsingStack.pop());*/
        // arraysUsingStack.push(40);
      /*  String s = "zhunzar";
        reverseString(s.toCharArray());*/
        // nextGreater();
        int[] array = {4, 7, 3, 4, 8, 1};
        int[] result = nextGreaterElement(array);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

    public static void reverseString(char[] ch) {
       /* Stack<Character> stack = new Stack();
        for(int i=0;i<ch.length;i++)
            stack.push(ch[i]);
        for(int i=0;i<ch.length;i++)
            ch[i]=stack.pop();
*/
        int start = 0;
        int end = ch.length - 1;
        while (start < end) {
            char temp = ch[end];
            ch[end] = ch[start];
            ch[start] = temp;
            start++;
            end--;
        }
    }

    //4 7 3 4 8 1
    public static void nextGreater() {
        int[] array = {4, 7, 3, 4, 8, 1};
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    temp[i] = array[j];
                    break;
                }
            }
            if (temp[i] == 0)
                temp[i] = -1;
        }
        for (int k = 0; k < temp.length; k++)
            System.out.print(temp[k] + " ");
    }


    public static int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() < array[i])
                    stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(array[i]);
        }
        return result;
    }


    public int[] nextGreaterLeetCode(int[] nums1, int[] nums2) {
        //nums1 is a subset of nums2
        //nums1 = {4, 1, 2}    nums2 = {1, 3, 4, 2}
        Stack<Integer> stack = new Stack();
        for (int num2 : nums2)
            stack.push(num2);
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() < nums1[i])
                    stack.pop();
            }
            if (stack.isEmpty() || nums1[i] == stack.peek())
                nums1[i] = -1;
            else
                nums1[i] = stack.peek();
        }
        return nums1;
    }


}
