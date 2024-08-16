package interviews;

import java.util.Arrays;

public class Admiral {
    public static void main(String[] args) {

    }
}

class Base {
    static int i = 10;

    static {
        methodOne();
        System.out.println("First static block");
    }

    public static void main(String[] args) {
        methodOne();
        System.out.println("Main Method");
    }

    public static void methodOne() {
        System.out.println(j);
    }

    static {
        System.out.println("Second static block");
    }

    static int j = 20;
}
