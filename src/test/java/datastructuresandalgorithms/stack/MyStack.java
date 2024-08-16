package datastructuresandalgorithms.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int result = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return result;
    }

    public int top() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int result = queue1.peek();
        queue2.offer(queue1.poll());
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return result;
    }

    public boolean empty() {
        if (queue1.isEmpty())
            return true;
        return false;
    }
}
