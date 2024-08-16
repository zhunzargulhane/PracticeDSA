package org.example.innerclasses;

public class StaticNestedClass {
    int a = 10;
    static int bb = 11;

    public static void main(String[] args) {
        new StaticNestedClass.Inner().methodOne();
    }

    static class Inner {
        public void methodOne() {
            System.out.println("I am methodOne"+bb);
        }

        public static void main(String[] args) {
            Inner inner = new Inner();
            inner.methodOne();
        }
    }
}
