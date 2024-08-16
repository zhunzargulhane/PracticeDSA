package datastructuresandalgorithms.practiceproblems;

import java.util.Stack;

public class ScoreOfParenthesis {
    public static int score(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(')
                stack.push(0);
            else {
                if (stack.peek() == 0 && ch == ')') {
                    stack.push(stack.pop() + 1);
                } else if (stack.peek() != 0 && ch == ')') {
                    int sum = 0;
                    while (stack.peek() != 0) {
                        sum = sum + stack.pop();
                    }
                    stack.pop();
                    stack.push(sum * 2);
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty())
            result = result + stack.pop();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(score("(()(()))"));
    }
}
