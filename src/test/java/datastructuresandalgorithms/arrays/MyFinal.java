package datastructuresandalgorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class MyFinal {

    public static void main(String[] args) {
        String[] str = {"Roja", "ShobaRani", "RajaKumari", "GangaBhavani"};
        Arrays.sort(str, (a, b) -> a.length() - b.length());

        /*for(String s:str)
            System.out.println(s);*/
        TreeSet<StringBuffer> t = new TreeSet((a, b) ->
        {
            int j = a.toString().length() - b.toString().length();
            if (j == 0)
                return a.toString().compareTo(b.toString());
            return j;
        });
        t.add(new StringBuffer("Roja"));
        t.add(new StringBuffer("ShobaRani"));
        t.add(new StringBuffer("RajaKumari"));
        t.add(new StringBuffer("GangaBhavani"));
        t.add(new StringBuffer("Ramulamma"));
        System.out.println(t);
        //Collections.sort(t, );
        Employee e1 = new Employee(12, "zhunzar");
        Employee e2 = new Employee(13, "kamles");
        Employee e3 = new Employee(14, "gul");


        TreeSet<Employee> treeSet1 = new TreeSet<>((a, b) -> b.id - a.id);
        treeSet1.add(e1);
        treeSet1.add(e2);
        treeSet1.add(e3);
        System.out.println("h "+treeSet1);

    }

}

class Name implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = (String) o1;
        return -s1.compareTo(s2);
    }
}

class Employee implements Comparable<Employee> {
    int id;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int compareTo(Employee employee) {
        return this.getName().length() - employee.getName().length();
    }


}

