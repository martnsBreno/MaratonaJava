package LambdasTests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> stringList = List.of("Marin", "Mai", "Saber");
        List<Integer> mapList = map(stringList, String::length);
        List<String> mapList2 = map(stringList, String::toUpperCase);
        System.out.println(mapList);
        System.out.println(mapList2);
    }

    private static <T, R> List<R> map(List<T> list, Function<T,R> function){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R apply = function.apply(t);
            result.add(apply);
        }
        return result;
    }
}
