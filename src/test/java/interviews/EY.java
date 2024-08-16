package interviews;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EY {
    public static void main(String[] args) {
        /*Consumer<Integer> consumer1 = i->System.out.println(i*i);
        Consumer<Integer> consumer2 = i->System.out.println(2*i);
        consumer1.andThen(consumer2).accept(2);

        Function<Integer,Integer> function1 = i->i*i;
        Function<Integer,Integer> function2 = i->2*i;
        System.out.println(function1.andThen(function2).apply(2));
        System.out.println(function1.compose(function2).apply(2));

        Predicate<String> predicate = s->s.length()>5;
        System.out.println(predicate.test("sdfsdgfsg"));
        predicate.negate().test()*/

        String s="Dkjlkjdfdklkjkjaf*234***jknkj(@#$";
        String[] sArray = s.split("\\b");
        for(String eachElement:sArray){
            System.out.println(eachElement);
        }


    }

   /* public boolean equals(Object object){
        if(this==object)
            return true;
        if(object instanceof Employee){
            Employee e2 = (Employee) object;
            if("".equals(e2.getName()))
                return true;
            else return false;
        }
        return false;
    }*/
    StringBuffer sb1 = new StringBuffer("ashok");
    public boolean equals(StringBuffer object){
        /*if(this==object)
            return true;*/
        if(object instanceof StringBuffer){
            StringBuffer sb2=(StringBuffer) object;
            if(sb1.equals(sb2))
                return true;
            else return false;
        }
        return false;
    }
}
