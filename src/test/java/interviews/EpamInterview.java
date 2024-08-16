package interviews;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Employee{
    String name;
    List<String> city;
    public Employee(String name,List<String> city){
        this.name=name;
        this.city=city;
    }
    public String getName(){return name;}
    public List<String> getCity(){return city;}
}
public class EpamInterview {
    public static void main(String[] args) {
        String s = "welcome to the code code world hello world";
        int[] arr = {1,2,3,4,5,5};
        ArrayList<Integer> alist = new ArrayList<>();
        for(int num:arr)
            alist.add(num);
        System.out.println(alist.stream().filter(a->Collections.frequency(alist,a)>1).findFirst().get());



        System.out.println(Arrays.stream(arr).skip(3).summaryStatistics().getMin());
        List<String> listsss = Arrays.asList(s.split(" "));
        System.out.println(listsss.stream().filter(a->Collections.frequency(listsss,a)>1).collect(Collectors.toSet()));
        Map<String,Long> integerMap = listsss.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("ONLYY "+integerMap);



        Map<String,Long> map = Arrays.stream(s.split("\\s")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Set<String> words = map.entrySet().stream().filter(a->a.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toSet());

        System.out.println(words);

        List<String> listString = Arrays.asList(s.split("\\s"));
        Set<String> aa=listString.stream().filter(a->Collections.frequency(listString,a)>1).collect(Collectors.toSet());
        System.out.println(aa);




        List<String> cityE1 = new ArrayList<>();
        cityE1.add("Nagpur");
        cityE1.add("Hyderabad");
        List<String> cityE2 = new ArrayList<>();
        cityE2.add("Pune");
        cityE2.add("Hyderabad");
        Employee e1 = new Employee("zhunzar",cityE1);
        Employee e2 = new Employee("kamlesh",cityE2);
        ArrayList<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        list.stream().flatMap(a->a.getCity().stream()).forEach(s3-> System.out.println("hh" +s3));
        list.stream().sorted((a,b)->a.getName().compareTo(b.getName())).collect(Collectors.toSet());

        list.stream().sorted((a,b)->a.getName().compareTo(b.getName())).forEach(a->System.out.println(a.getName()));
       /* Set<String> set = list.stream().flatMap(e->e.getCity().stream()).collect(Collectors.toSet());*/
       // System.out.println(set);
    }
}
