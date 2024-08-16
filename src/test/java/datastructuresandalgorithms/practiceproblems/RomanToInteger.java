package datastructuresandalgorithms.practiceproblems;

import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

import java.util.HashMap;
import java.util.Stack;

public class RomanToInteger {
    // I before V and X
    // X before L and C
    // C before D and M
    public int romanToInt(String s) {
        int sum = 0;
        HashMap<Character, Integer> hashmap = new HashMap();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1) {
                if (((s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') || (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M'))
                        || ((s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') || (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C'))
                        || ((s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') || (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X'))) {
                    sum = sum + (hashmap.get(s.charAt(i + 1)) - hashmap.get(s.charAt(i)));
                    i++;
                } else
                    sum = sum + hashmap.get(s.charAt(i));
            } else
                sum = sum + hashmap.get(s.charAt(i));
        }
        return sum;
    }


    public int romanToIntPart2(String s) {

        HashMap<Character, Integer> hashmap = new HashMap();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);

        int sum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == s.length() - 1)
                sum = sum + hashmap.get(s.charAt(i));
            else {
                if (hashmap.get(s.charAt(i)) >= hashmap.get(s.charAt(i + 1)))
                    sum = sum + hashmap.get(s.charAt(i));
                else
                    sum = sum - hashmap.get(s.charAt(i));
            }
        }
        return sum;
    }


    public int romanToIntPart3(String s) {
        HashMap<Character, Integer> hashmap = new HashMap();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                sum = sum + hashmap.get(s.charAt(i));
            else if (hashmap.get(s.charAt(i)) >= hashmap.get(s.charAt(i + 1)))
                sum = sum + hashmap.get(s.charAt(i));
            else {
                sum = sum + (hashmap.get(s.charAt(i + 1)) - hashmap.get(s.charAt(i)));
                i++;
            }
        }
        return sum;
    }

    public String integerToRoman(int num) {
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String finalData = "";
        for (int i = values.length - 1; i >= 0; ) {
            if (num >= values[i]) {
                finalData = finalData + roman[i];
                num = num - values[i];
            } else {
                i--;
            }
        }
        return finalData;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            if (!Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start)))
                start++;
            if (!Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end)))
                end--;
            if ((Character.isDigit(s.charAt(start)) || Character.isLetter(s.charAt(start))) && (Character.isDigit(s.charAt(end)) || Character.isLetter(s.charAt(end)))) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else return false;
            }
        }
        return true;
    }

    public int calculate(String s) {
        //322
        s = s.replaceAll(" ", "");
        if (s.contains("*")) {

        } else if (s.contains("/")) {

        } else if (s.contains("+")) {

        } else if (s.contains("-")) {

        } else {
            return Integer.parseInt(s);
        }
        int var = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                int a = s.charAt(i - 1) - '0';
                int b = s.charAt(i + 1) - '0';
                var = a * b;
            } else if (s.charAt(i) == '/') {
                int a = s.charAt(i - 1) - '0';
                int b = s.charAt(i + 1) - '0';
                var = a / b;
            } else if (s.charAt(i) == '+') {
                int a = s.charAt(i - 1) - '0';
                var = a + var;
            } else if (s.charAt(i) == '-') {
                int a = s.charAt(i - 1) - '0';
                var = a - var;
                if (var < 0)
                    var = var * (-1);
            }
        }
        int solution = 6 / 2 + 3 / 2 + 1;
        System.out.println(solution);
        return var;
    }

    public int calculateUsingStack(String s) {
        s = s.replaceAll(" ", "");
        String[] array = s.split("\\b");
        String operator = "";
        Stack<Integer> stack = new Stack();
        int result = 0;
        if (s.contains("-") || s.contains("*") || s.contains("/") || s.contains("+")) {

        } else
            return Integer.parseInt(s);
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("+") && !array[i].equals("-") && !array[i].equals("/") && !array[i].equals("*")) {
                if (operator.equals("-")) {
                    stack.push(Integer.parseInt(array[i]) * -1);
                    operator = "";
                } else {
                    stack.push(Integer.parseInt(array[i]));
                }
            }
            if (array[i].equals("-")) {
                operator = "-";
            }
            if (array[i].equals("/")) {
                if (operator.equals("-")) {
                    stack.push(stack.pop() / Integer.parseInt(array[i + 1]) * -1);
                    operator = "";
                } else {
                    stack.push(stack.pop() / Integer.parseInt(array[i + 1]));
                }
                i++;
            } else if (array[i].equals("*")) {
                if (operator.equals("-")) {
                    stack.push(stack.pop() * Integer.parseInt(array[i + 1]) * -1);
                    operator = "";
                } else
                    stack.push(stack.pop() * Integer.parseInt(array[i + 1]));
                i++;
            }

        }
        while (!stack.isEmpty())
            result = result + stack.pop();

        return result;
    }


    public int calculateSecondApproach(String s) {
        s = s.replaceAll(" ", "");
        String[] arr = s.split("\\b");
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        String operator = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("*")) {
                operator = "*";
            } else if (arr[i].equals("/")) {
                operator = "/";
            } else if (arr[i].equals("-")) {
                operator = "-";
            } else if (arr[i].equals("+")) {
                operator = "+";
            } else {
                if (operator.equals("*")) {
                    stack.push(stack.pop() * Integer.parseInt(arr[i]));
                } else if (operator.equals("/")) {
                    stack.push(stack.pop() / Integer.parseInt(arr[i]));
                } else if (operator.equals("-")) {
                    stack.push(Integer.parseInt(arr[i]) * -1);
                } else {
                    stack.push(Integer.parseInt(arr[i]));
                }
            }
        }
        while (!stack.isEmpty())
            sum = sum + stack.pop();
        return sum;
    }


    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(0);
            else {
                if (stack.peek() == 0 && s.charAt(i) == ')') {
                    stack.push(stack.pop() + 1);
                } else {
                    int sum = 0;
                    while (stack.peek() != 0) {
                        sum = sum + stack.pop();
                    }
                    stack.pop();
                    stack.push(sum * 2);
                }
            }
        }
        int num = 0;
        while (!stack.isEmpty())
            num = num + stack.pop();
        return num;
    }

    public static String minimumRemoval(String s) {
        Stack<Character> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack1.push(ch[i]);
                stack2.push(i);
            } else if (ch[i] == ')') {
                if (!stack1.isEmpty() && (stack1.peek() == '(' && ch[i] == ')')) {
                    stack1.pop();
                    stack2.pop();
                } else {
                    stack2.push(i);
                }
            }
        }
        StringBuffer sb = new StringBuffer(s);
        while (!stack2.isEmpty())
            sb.deleteCharAt(stack2.pop());
        return sb.toString();
    }


    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        // System.out.println(romanToInteger.romanToIntPart3("III"));
        // System.out.println(romanToInteger.integerToRoman(1994));
        //System.out.println(romanToInteger.isPalindrome(" "));
        //System.out.println(romanToInteger.calculateUsingStack("3+5/2"));
        System.out.println(scoreOfParentheses("()()"));
        //System.out.println(romanToInteger.scoreOfParentheses("(()())"));
        //(()(()()))                                //(1)
        //(1 (1 1))
        //(1 4)
        //(5)
        //10

    }

}
