package interviews;

import java.util.*;

public class InterviewEPAM {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue((a,b)->{
            int j=a.toString().length()-b.toString().length();
            if(j==0)
                return a.toString().compareTo(b.toString());
            return j;
        });
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k)
                pq.add(nums[i]);
            else if(nums[i].length()>pq.peek().length()){
                pq.poll();
                pq.add(nums[i]);
            }else if(nums[i].length()==pq.peek().length()){
               int z = nums[i].compareTo(pq.peek());
               if(z>0){
                   pq.poll();
                   pq.add(nums[i]);
               }
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        //0 1 1 2 3 5 .....100
        String[] a ={"eat","tea","tan","ate","nat","bat"};
        System.out.println(addStrings("11","123"));

    }

    public static String addStrings(String num1, String num2) {
        String largerNum=(num1.length()>=num2.length())?num1:num2;
        String smallerNum=(num1.length()<num2.length())?num1:num2;
        String stringBuffer = new String();
        int carry=0,j=smallerNum.length()-1;
        for(int i=largerNum.length()-1;i>=0;i--){
            int val1 = Integer.parseInt(String.valueOf(largerNum.charAt(i)));
            int val2 = (j>=0)?Integer.parseInt(String.valueOf(smallerNum.charAt(j--))):0;
            int sum = val1+val2+carry;
            if(sum>=10){
                int rem = sum%10;
                stringBuffer=rem+stringBuffer;
                carry = sum/10;
            }else{
                stringBuffer=sum+stringBuffer;
            }
        }
        return stringBuffer;
    }
}
