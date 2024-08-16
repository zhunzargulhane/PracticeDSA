package datastructuresandalgorithms.practiceproblems;

public class HimanshuInterview {
    public static void main(String[] args) {
        String s = "Java is a good language. I know java";
        StringBuilder sb = new StringBuilder();
        //sb.

        int counter = 0;
        String[] array = s.split("\\s");
        for (String arr : array) {
            if (arr.equalsIgnoreCase("java"))
                counter++;
        }
        System.out.println(counter);

        //int a= 1222333445;
        //123
        //3*100 + 2*10 +1 *1 = 321
        int a = 1222333445;
        long b = a;
        long sum = 0;
        while (b > 0) {
            long val = b % 10;
            sum=sum*10+val;
            b = b / 10;
        }

        System.out.println(sum);
    }

}

