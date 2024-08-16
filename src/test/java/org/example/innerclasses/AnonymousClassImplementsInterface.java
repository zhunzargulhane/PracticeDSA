package org.example.innerclasses;

public class AnonymousClassImplementsInterface {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("i am child");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
