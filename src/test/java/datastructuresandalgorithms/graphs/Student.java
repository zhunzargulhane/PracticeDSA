package datastructuresandalgorithms.graphs;

public class Student implements Cloneable {
    String rollNo;
    Address address;

    protected Object clone() throws CloneNotSupportedException{
        Student student = (Student) super.clone();
        student.address=(Address) address.clone();
        return student;
    }
}
