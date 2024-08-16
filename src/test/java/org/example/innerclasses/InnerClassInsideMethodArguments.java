package org.example.innerclasses;

public class InnerClassInsideMethodArguments {
    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("run");
                    }
                }
        ).start();
    }
}
