package datastructuresandalgorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface Functional{
    void m1(int a);
}
public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();
        int[] a = {2,2,1,1,3,4,5};
        Map<Integer, Long> map = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println(map.entrySet().stream().filter(a1->a1.getValue()>1));
    }
}
