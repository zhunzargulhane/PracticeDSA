package interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
interface I<T>{
    public void get(String s);
}
public class HclTech {
    public HclTech(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        I i = HclTech::new;
        i.get("My interface");


        int[] arr = {0, 5, 10, 15, 20, 25, 30};
        /*Predicate<Integer> p = i -> i > 20;
        Predicate<Integer> p1 = i -> i >= 50;

        m1(p.or(p1), arr);*/

        Function<String,Integer> function = s->s.length();
        System.out.println(function.apply("zhunzar"));

        Consumer<String> consumer = System.out::println;
        consumer.accept("zhun");
        //HclTech hclTech = new HclTech();
        /*Consumer<String> consumer1 = hclTech::m2;
        consumer1.accept("hellosir");*/

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.forEach((data)->{
            if(data==20)
                list.remove(Integer.valueOf(20));
        });
        System.out.println(list);
        methodOne(list);
        ArrayList ll = new ArrayList();
        ll.add("");
        ll.add("");
        String s = (String)ll.get(0);
    }

    public static void methodOne(ArrayList<? super Integer> l){
        l.add(10);
    }

    public  void m2(String s1){
        System.out.println(s1);
    }
    public static void m1(Predicate<Integer> predicate, int[] arr) {
        for (int num : arr) {
            if (predicate.test(num))
                System.out.println(num);
        }
    }
}
