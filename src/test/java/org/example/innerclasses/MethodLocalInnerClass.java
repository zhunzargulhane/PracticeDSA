package org.example.innerclasses;

public class MethodLocalInnerClass {
    int a=10;
    static int b=11;
    public static void main(String[] args) {
        new MethodLocalInnerClass().run();
    }

    public static void run() {
         final int a=10;
         class InnerMethodLocalClass {
            InnerMethodLocalClass() {
                data();
            }
            public void data() {
                System.out.println("data"+a);
            }
        }
        InnerMethodLocalClass innerMethodLocalClass = new InnerMethodLocalClass();
        innerMethodLocalClass.data();

    }


}
