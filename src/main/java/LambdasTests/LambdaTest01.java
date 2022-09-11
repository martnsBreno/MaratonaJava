package LambdasTests;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {
        List<String> listaNomes = List.of("Breno", "Marin", "Yasmin",   "Rin");
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        forEach(listaNomes, s-> System.out.println(s));
        System.out.println("-----------------------");
        forEach(integers, i-> System.out.println(i));
    }

    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }

    }
}
