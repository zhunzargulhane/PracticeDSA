package datastructuresandalgorithms.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class BubbleSort {

    public static String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack();
        char[] array = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else if(s.charAt(i)==')'){
                int start = stack.pop()+1;
                int end = i-1;
                reverse(array,start,end);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(char chars:array){
            if(chars!='(' && chars!=')')
                sb.append(chars);
        }
        return String.valueOf(sb);
    }

    public static void reverse(char[] chars,int start,int end){
        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }

    public int minInsertions(String s) {
        s=s.replace("))","}");
        Stack<Character> stack = new Stack();
        int req=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty() && s.charAt(i)=='}')
                    req=req+1;
                else if(stack.isEmpty() && s.charAt(i)==')')
                    req=req+2;
                else if(!stack.isEmpty() && s.charAt(i)==')'){
                    req=req+1;
                    stack.pop();
                }
                else if(!stack.isEmpty() && s.charAt(i)=='}')
                    stack.pop();
            }
        }
        if(!stack.isEmpty())
            req=req+stack.size()*2;
        return req;
    }


    public static void main(String[] args) {
        String s ="(abcd)";
        reverseParentheses(s);
    }

    public static char findTheDifference(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < s.length(); i++) {
            sum1 += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum2 += t.charAt(i);
        }
        return (char) (sum2 - sum1);
    }

    public static void display(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
    }
}
