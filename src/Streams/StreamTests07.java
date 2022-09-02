package Streams;

import java.util.List;

public class StreamTests07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Integer reduce = integers.stream().reduce(10, Integer::sum);
        System.out.println(reduce);
    }
}
