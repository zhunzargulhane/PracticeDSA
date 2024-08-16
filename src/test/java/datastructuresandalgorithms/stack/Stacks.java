package datastructuresandalgorithms.stack;

import java.util.EmptyStackException;

public class Stacks {
    private ListNode top;
    private int length;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void push(int value) {
        ListNode temp = new ListNode(value);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        int result = 0;
        if (top == null)
            throw new EmptyStackException();
        result = top.data;
        top = top.next;
        return result;
    }

    public int peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public int length() {

        return length;
    }

    public void display() {
        if (top == null)
            return;
        ListNode temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -->");
            temp = temp.next;
        }
        System.out.print(" null");
        System.out.println();
    }

    public static void main(String[] args) {
        Stacks stacks = new Stacks();
        stacks.push(10);
        stacks.push(20);
        stacks.push(30);
        /*System.out.println(stacks.length());
        stacks.display();
        System.out.println(stacks.pop());
        System.out.println(stacks.length());
        stacks.display();*/
        System.out.println(stacks.peek());
        stacks.pop();
        System.out.println(stacks.peek());
    }

    public void pushArray(){
        
    }
}
