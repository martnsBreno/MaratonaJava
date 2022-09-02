package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> gomu = List.of("Gomu", "Gomu", "No", "Mi");
        String[] s = gomu.get(0).split(" ");
        System.out.println(Arrays.toString(s));

        List<String[]> collect = gomu.stream().map(g -> g.split("")).collect(Collectors.toList());
        Stream<String> stream = Arrays.stream(s);
        List<String> collect1 = gomu.stream().map(w -> w.split(""))//Stream<String[]>
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());//Stream<String>
        System.out.println(collect1);
    }
}
