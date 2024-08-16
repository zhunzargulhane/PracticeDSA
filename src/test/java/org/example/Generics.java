package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

class Gen<K, V> {
    K key;
    V value;

    public void show() {
        System.out.println("the type is " + key.getClass().getName());
    }

    public void generics(ArrayList<? extends Number> arrayList) {
        System.out.println("This is read operation" + arrayList.get(0));
    }

    public <K extends Number> void run(K t) {

    }

    public void add(K obj) {
        this.key = obj;
    }

    public K get() {
        return this.key;
    }
}

public class Generics {

    public <T extends Number> void run(T t) {
        System.out.println("Method level generics");
    }

    public <T extends Integer> void generics(ArrayList<? super Double> arrayList) {
        arrayList.add(0, 10.1);
        arrayList.add(null);
        System.out.println("This is read operation" + arrayList.get(0));
    }

    public static void main(String[] args) {
        Generics gen = new Generics();
        ArrayList<Number> arrayList = new ArrayList();
        arrayList.add(100.0);
        gen.generics(arrayList);
        gen.run(5);
    }
}
