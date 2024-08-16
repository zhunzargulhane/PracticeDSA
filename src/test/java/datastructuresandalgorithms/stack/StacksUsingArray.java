package datastructuresandalgorithms.stack;

import datastructuresandalgorithms.arrays.PrintArrayResusable;

import java.util.EmptyStackException;
import java.util.Stack;

public class StacksUsingArray {
    private int top;
    private int[] array;

    StacksUsingArray(int capacity) {
        top = -1;
        array = new int[capacity];
    }

    public StacksUsingArray() {
        this(10);
    }

    public int sizeOfStack() {
        return top + 1;
    }

    public void printData() {
        for (int i = 0; i <= top; i++)
            System.out.print(array[i] + " ");
        System.out.println("The size of stack is " + sizeOfStack());
    }

    public void push(int data) {
        if (array.length == sizeOfStack()) {
            throw new RuntimeException("Stack is Full");
        }
        top++;
        array[top] = data;
    }

    public int pop() {
        if (top < 0)
            throw new EmptyStackException();
        int temp = array[top];
        top--;
        return temp;
    }

    public int peek() {
        if (top < 0)
            throw new EmptyStackException();
        return array[top];
    }

    public String reverseString(String data) {
        Stack<Character> stack = new Stack();
        char[] chars = data.toCharArray();
        for (char ch : chars) {
            stack.push(ch);
        }
        for (int i = 0; i < data.length(); i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }


    public int[] nextGreaterElement(int[] array) {
        // 4 7 3 4 8 1
        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= array[i]) {
                    stack.pop();
                }
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

    public boolean isValidParenthesis(String parenthesis) {
        char[] chars = parenthesis.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{'))
                        stack.pop();
                    else return false;

                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StacksUsingArray stacksUsingArray = new StacksUsingArray();
       /* stacksUsingArray.push(4);
        stacksUsingArray.push(5);
        stacksUsingArray.push(6);
        stacksUsingArray.printData();*/
        ;
        // System.out.println("The top element is " + stacksUsingArray.peek());
        //  stacksUsingArray.printData();
     /*   stacksUsingArray.pop();
        stacksUsingArray.pop();*/
        //stacksUsingArray.pop();
        // stacksUsingArray.pop();
        // stacksUsingArray.printData();
        //System.out.println(stacksUsingArray.peek());
       /* String data = "ABCD";
        System.out.println(stacksUsingArray.reverseString(data));
        int[] array = {4, 7, 3, 4, 8, 1};
        array = stacksUsingArray.nextGreaterElement(array);
        PrintArrayResusable.printArray(array);*/
        String parenthesis = "{()}";
        System.out.println(stacksUsingArray.isValidParenthesis(parenthesis));


    }

}
