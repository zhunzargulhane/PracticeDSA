package interviews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persistent {
}

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

}

class Student implements Cloneable {
    int rollNo;
    String name;
    Animal animal;

    Student(int rollNo, String name, Animal animal) {
        this.rollNo = rollNo;
        this.name = name;
        this.animal = animal;
    }

    public boolean equals(Student student) {
        if (this == student) return true;
        try {
            if (this.rollNo == student.rollNo)
                return true;
            else return false;
        } catch (ClassCastException | NullPointerException exception) {
            return false;
        }
    }

    protected Object clone() {
        Animal animal1 = new Animal(this.animal.name);
        return new Student(this.rollNo, this.name, animal1);
        //return s1;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal1 = new Animal("Dog");
        Student s1 = new Student(10, "zhunzar", animal1);
        Student s2 = (Student) s1.clone();
        System.out.println(s1.getClass().getName());
        // s1.rollNo=20;
        s2.rollNo = 30;
        s1.animal.name = "cat";
        System.out.println(s1.animal.name);
        System.out.println(s2.animal.name);
        System.out.println(s1.rollNo);
        System.out.println(s2.rollNo);
    }
}

final class Students {
    private int data;

    public Students(int data) {
        this.data = data;
    }

    public Students modify(int newData) {
        if (data == newData)
            return this;
        return new Students(newData);
    }

    public static void main(String[] args) {
        Students students1 = new Students(100);
        System.out.println(students1.data);
        System.out.println(students1 == students1.modify(100));
        System.out.println(students1 == students1.modify(200));
    }
}

class Gandhi {
    public static void main(String[] args) {
        int[] a1 = {3, 4, 6, 23, 25, 1, 2};
        Arrays.stream(a1).boxed().sorted((a, b) -> {
            if (a > b) return -1;
            else if (a < b) return +1;
            else return 0;
        }).forEach(a -> System.out.print(a + " "));
        /*Arrays.sort(a1,(a,b)->{
            if(a>b) return -1;
            else if(a<b) return +1;
            else return 0;
        });
        for(int a:a1)
            System.out.print(a+" ");*/
    }
}