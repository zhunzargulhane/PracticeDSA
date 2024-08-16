package interviews;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hacker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a/b);
        }catch(ArithmeticException | InputMismatchException exception){
            System.out.println(exception.toString());
        }
    }
}
