package datastructuresandalgorithms.practiceproblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        String[] strings={"Apple","Banana","Avocado","Apple","Apricot","Grapes","waterlemon"};

       /* Collections.sort(Arrays.asList(strings),(a,b)->{
            return b.length()-a.length();
        });*/
        System.out.println(Arrays.stream(strings).distinct().collect(Collectors.toList()));
        System.out.println(Arrays.stream(strings).sorted((a,b)->b.length()-a.length()).findFirst().get());

    }
}
