package interviews;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

public class HclMasterCard {
    public static void main(String[] args) {

    }

    public long power(int a, int b) throws Exception {
        if (a < 0 || b < 0) {
            throw new Exception("java.lang.Exception: n and p should not be zero.");
        }
        if (a == 0 || b == 0)
            throw new Exception("java.lang.Exception: n and p should not be zero.");

        return (long) Math.pow(a, b);
    }
}

class MyCalculator extends RuntimeException {
    MyCalculator() {
    }

    MyCalculator(String s) {
        super(s,null,false,false);
       // System.out.println(s);
    }

    public long power(int a, int b){
        if (a < 0 || b < 0)
            throw new MyCalculator("java.lang.Exception: n or p should not be negative.");
        if (a == 0 && b == 0)
            throw new MyCalculator("java.lang.Exception: n and p should not be zero.");
        return (long) Math.pow(a, b);
    }

    public static void main(String[] args) {
        MyCalculator mc = new MyCalculator();
        mc.power(0,0);

    }

    public void run() {
        try(BufferedReader br = new BufferedReader(new FileReader(""))){
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
