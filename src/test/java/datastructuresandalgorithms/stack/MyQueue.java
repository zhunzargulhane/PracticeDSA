package datastructuresandalgorithms.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public int peek() {
        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        int result = stack1.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
