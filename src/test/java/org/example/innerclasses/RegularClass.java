package org.example.innerclasses;

public class RegularClass {
    public static void main(String[] args) {
       /* RegularClass.InnerRegular regularClass = new RegularClass().new InnerRegular();
        regularClass.run();*/
        new RegularClass().run1();
    }

    public static void run1() {
       /* new RegularClass().*//*new InnerRegular().run();*/
        System.out.println("sirji");
    }

    class InnerRegular {
        public void run() {
            System.out.println("hello");
            run1();
            RegularClass.this.run1();
        }


    }
}
class OutsideOuter {
    public static void main(String[] args) {
        new RegularClass().new InnerRegular().run();
    }
}