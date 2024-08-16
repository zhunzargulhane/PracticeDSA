package interviews;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Salary {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Salary{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    private int salary;

    Salary(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    Salary(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

public class Epam {
    public static void main(String[] args) {
        Salary s1 = new Salary("zhunzar", 100, 10);
        Salary s2 = new Salary("kamlesh", 200, 20);
        Salary s3 = new Salary("rakesh", 300, 30);
        Salary s4 = new Salary("Rajesh", 400, 10);
        Salary s5 = new Salary("ALPHA", 500, 20);
        List<Salary> salaryList = new ArrayList<>();
        salaryList.add(s1);
        salaryList.add(s2);
        salaryList.add(s3);
        salaryList.add(s4);
        salaryList.add(s5);
        System.out.println("my max salary "+salaryList.stream().map(a->a.getSalary()).mapToInt(a->a).summaryStatistics().getMax());



        System.out.println(salaryList.stream().collect(Collectors.groupingBy(a->a.getAge(),Collectors.toSet())).entrySet());
        System.out.print("fvergferg "+Stream.of(1,2).peek(a->a.toString()));
        int[] a1 ={1,2,3,4,5};
        int[] a2 ={4,5,6,7,8};
        System.out.print(Stream.of(1,1,2,2).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().anyMatch(a->list.contains(2));
        Set<Integer> he=list.stream().filter(a->Collections.frequency(list,a)==1).collect(Collectors.toSet());
        System.out.println(he);


        Set<Integer> common = Arrays.stream(a1).boxed().filter(a->Arrays.stream(a2).anyMatch(a2Number->a2Number==a)).collect(Collectors.toSet());
        System.out.print("The common are "+common);
        System.out.println("The second smallest element is "+Stream.of(1,2,2,2,3,4).skip(2).findAny());
        //System.out.print(salaryList.stream().collect(Collectors.groupingBy(emp -> emp.getAge(),,Collectors.toSet())));

        System.out.println("Now the grouping is " + salaryList.stream().collect(Collectors.groupingBy(employee -> employee.getAge(),TreeMap::new, Collectors.toSet())));
        //System.out.println(salaryList1);



       // System.out.println(salaryList.stream().collect(Collectors.groupingBy(emp -> emp.getAge())).keySet().stream().sorted());
       /* Set<Map.Entry<Integer, List<Salary>>> sets = salaryList.stream().collect(Collectors.groupingBy(emp -> emp.getAge())).entrySet();
        for(Map.Entry<Integer, List<Salary>> set: sets){
            System.out.print(set.getKey()+" {-> ");
            for(Salary salary:set.getValue()){
                System.out.print(salary.getName()+" ");
            }
            System.out.println(" }");
        }
*/


        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        long count = Arrays.stream(new int[]{1, 2}).summaryStatistics().getCount();
        //System.out.println("the count is " + count);
        String s = "sdf";
       // System.out.println(Stream.of("hello", "word").map(a -> a.toUpperCase()).collect(Collectors.joining(",")));
        //System.out.println(set);
        //listInteger.stream().mapToInt(a->a).summaryStatistics().getMax()
        //System.out.println(salaryList.stream().mapToInt(a->a.getSalary()).summaryStatistics().getSum());



       /* Set<String> set = salaryList.stream().sorted((a, b)->b.getSalary()-a.getSalary()).skip(3).limit(1).map(e->e.getName()).collect(Collectors.toSet());
        int maxSalary = salaryList.stream().mapToInt(a1->a1.getSalary()).summaryStatistics().getMax();
        System.out.println(maxSalary);*/

    }
}

