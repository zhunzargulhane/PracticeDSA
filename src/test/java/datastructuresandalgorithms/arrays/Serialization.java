package datastructuresandalgorithms.arrays;

import java.io.*;
import java.util.ArrayList;

public class Serialization {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Dog d2 = new Dog();
        System.out.println("Serialization started");
        FileOutputStream fileOutputStream = new FileOutputStream("abd.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(d2);
        System.out.println("Serialization ended");
        System.out.println("DeSerialization started");
        FileInputStream fileInputStream = new FileInputStream("abd.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Dog dog = (Dog)objectInputStream.readObject();
        System.out.println(dog.i);
        System.out.println(dog.j);


    }
}
class Dog implements Serializable{
    final transient int i=10;
    static transient int j=20;
   /* Dog(){
        i=10;
        j=20;
    }*/

}
