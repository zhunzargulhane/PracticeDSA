package datastructuresandalgorithms.graphs;

public class Cloning {


    public static void main(String[] args) throws CloneNotSupportedException {
        Student obj1 = new Student();
        obj1.rollNo = "10";

        Address addresss = new Address();
        addresss.city="Nagpur";

        obj1.address=addresss;

        Student obj2 = (Student) obj1.clone();
        obj2.rollNo = "20";
        obj2.address.city="AN";



        System.out.println(obj1.address.city);
        System.out.println(obj2.address.city);

    }


}
