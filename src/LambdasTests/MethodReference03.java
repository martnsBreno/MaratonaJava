package LambdasTests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReference03 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("William", "Carla", "Alan"));
        stringList.sort(String::compareTo);
        System.out.println(stringList);
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer apply = numStringToInteger.apply("20");
        System.out.println(apply);;

        BiPredicate<List<String>, String> checkIfNameContains = List::contains;
        System.out.println(checkIfNameContains.test(stringList, "Carla2"));
    }
}
