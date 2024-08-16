package datastructuresandalgorithms.practiceproblems;

import org.apache.groovy.parser.antlr4.GroovyParser;
import org.codehaus.groovy.syntax.Numbers;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

import java.util.*;

public class Stacks {
    private ListNode top;
    private int length;

    private static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public int size() {
        return length;
    }

    public void push(int value) {
        ListNode temp = new ListNode(value);
        temp.next = top;
        top = temp;
        length++;
    }

    public ListNode pop() {
        if (top == null)
            throw new EmptyStackException();
        ListNode temp = top;
        top = top.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode peek() {
        if (top == null)
            throw new EmptyStackException();
        return top;
    }

    public static void main(String[] args) {
/*        Stacks stacks = new Stacks();
        stacks.push(10);
        stacks.push(20);
        stacks.push(30);
        stacks.push(40);
        stacks.display();
        System.out.println(stacks.size());
        System.out.println(stacks.peek().data);
        System.out.println(stacks.pop().data);
        System.out.println(stacks.pop().data);
        System.out.println(stacks.pop().data);
        stacks.display();
        System.out.println(stacks.pop().data);
        System.out.println(stacks.size());
        stacks.display();*/

       /* int[] nums2 = {2, 4};
        int[] ans = resultOfGreaterElement(nums1, nums2);
        for (int i : ans)
            System.out.print(i + " ");

        String s = "{}}";
        System.out.println(isValidParentheses(s));*/
       /* int[] nums1 = {0, -2, -3};

        int[] ans = nextGreaterElements(nums1);
        for (int a : ans)
            System.out.print(a + " ");

*/
        //   System.out.println(isValid("]"));
        //System.out.println(removeMinToMakeValidParenthesis("a)b(c)d"));
        System.out.println(reverseIntegerMath(-123));

    }

    public void display() {
        if (top == null)
            return;
        ListNode temp = top;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print(" null");
        System.out.println();
    }

    public static int[] nextGreaterIII(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(i, nums2[i]);
        }
        for (int i = nums1.length - 1; i >= 0; i--) {
            Set<Integer> set = hashMap.keySet();
            int k = 0;
            for (int key : set) {
                if (hashMap.get(key).equals(nums1[i])) {
                    k = key;
                    break;
                }
            }
            for (int j = k + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[k]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
            if (ans[i] == 0)
                ans[i] = -1;
        }
        return ans;
    }

    public int[] greater(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    hashMap.put(nums2[i], nums2[j]);
                    break;
                } else if (j == nums2.length - 1) {
                    hashMap.put(nums2[i], -1);
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hashMap.get(nums1[i]);
        }
        return nums1;
    }

    public static int[] greaterElementForArray(int[] nums1) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack();
        for (int i = nums1.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() < nums1[i])
                stack.pop();
            result[i] = (stack.size() > 0) ? stack.peek() : -1;
            stack.push(nums1[i]);
        }
        return result;
    }

    //nums1 = greater element of each index
    //nums2 = for this we need to generate output
    public static int[] resultOfGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = greaterElementForArray(nums1);
        int[] result = new int[nums2.length];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], ans[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            result[i] = hashMap.get(nums2[i]);
        }
        return result;
    }

    //{}}
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                char top = 0;
                if (!stack.isEmpty()) {
                    top = stack.peek();
                }
                if (!stack.isEmpty() && (top == '{' && ch == '}') || (top == '(' && ch == ')') || (top == '[' && ch == ']')) {
                    stack.pop();
                } else
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public static int[] nextGreaterMedium(int[] nums1) {
        int[] result = new int[nums1.length];
        int n = 2 * nums1.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (nums1[j % nums1.length] > nums1[i % nums1.length]) {
                    result[i % nums1.length] = nums1[j % nums1.length];
                    break;
                } else if (j == n) {
                    result[i % nums1.length] = -1;
                }
            }
            if (i == n) {
                result[i % nums1.length] = -1;
            }
        }
        return result;
    }


    public static int[] nextGreaterElements(int[] nums1) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        int n = 2 * nums1.length - 1;
        int size = nums1.length;
        int count = 0;
        for (int i = n; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() <= nums1[i % size]) {
                stack.pop();
                count++;
            }
            if (i <= nums1.length) {
                if (stack.size() > 0)
                    result[i % size] = stack.peek();
                else result[i % size] = -1;
            }
            stack.push(nums1[i % size]);
        }
        System.out.println(count);
        return result;
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char ch : chars) {
            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                if (stack.size() > 0) {
                    if ((stack.peek() == '{' && ch == '}') || (stack.peek() == '(' && ch == ')') || (stack.peek() == '[' && ch == ']')) {
                        stack.pop();
                    } else
                        return false;
                } else
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public static String removeMinToMakeValidParenthesis(String s) {
        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.size() > 0) {
                    if (s.charAt(stack.peek()) == '(' && s.charAt(i) == ')')
                        stack.pop();
                    else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        s = sb.toString();
        return s;
    }

    public static boolean isPalindrome(int x) {
        int num = 0;
        int originalNum = x;
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        while (x > 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        if (originalNum == num)
            return true;
        else return false;

       /* String num=String.valueOf(x);
        int start=0;
        int end=num.length()-1;
        while(start<end){
            if(num.charAt(start)==num.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;*/
    }

    public static int reverseInteger(int num) {
        String operator = "";
        String val = String.valueOf(num);
        if (val.charAt(0) == '-') {
            operator = "-";
            val = val.substring(1);
        }
        StringBuffer sb = new StringBuffer(val);
        sb = sb.reverse();
        double d = Double.parseDouble(sb.toString());
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        if (operator.equals("-")) {
            sb = sb.insert(0, "-");
            d = Double.parseDouble(sb.toString());
            if (d >= a && d <= b) {
                return Integer.parseInt(sb.toString());
            } else {
                return 0;
            }
        }
        if (d >= a && d <= b) {
            return Integer.parseInt(sb.toString());
        }
        return 0;
    }


    public static int reverseIntegerMath(int x) {
        long sum = 0;
        long k = x;
        int operator = 0;
        if (k < 0) {
            operator = -1;
            k = k * -1;
        }
        while (k > 0) {
            sum = sum * 10 + k % 10;
            k = k / 10;
        }
        if (operator == -1)
            sum = sum * -1;
        if (sum < Math.pow(-2, 31) || sum > Math.pow(2, 31))
            return 0;
        else
            return (int) sum;
    }


}