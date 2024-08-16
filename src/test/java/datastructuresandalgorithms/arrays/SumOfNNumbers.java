package datastructuresandalgorithms.arrays;

public class SumOfNNumbers {
    public static void main(String[] args) {
        double now = System.currentTimeMillis();
        System.out.println(new SumOfNNumbers().sum(99999));
        double newTime = System.currentTimeMillis() - now;
        System.out.println("the required to complete the algorithm is " + newTime + " milliseconds");
        int[] arr={10,20,30};
        int aa=Integer.MIN_VALUE;
        System.out.println(aa);


    }

     public int sum(int n){
         return n*(n+1)/2;
     }
    /*public int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum = sum + i;
        return sum;
    }*/
}
