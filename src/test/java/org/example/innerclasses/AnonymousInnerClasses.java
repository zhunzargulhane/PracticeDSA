package org.example.innerclasses;

class Inherit {
    public void inheritRun() {
        System.out.println("outer");
    }
}

public class AnonymousInnerClasses {

    public static void main(String[] args) {
        Inherit inherit = new Inherit() {
            @Override
            public void inheritRun() {
                hit();
                System.out.println("inner");
            }
            public void hit() {
                System.out.println("hit");
            }

        };
        inherit.inheritRun();
        Inherit inherit1 = new Inherit();
        inherit1.inheritRun();
    }
}
