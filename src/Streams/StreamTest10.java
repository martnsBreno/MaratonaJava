package Streams;

import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2).limit(50).forEach(System.out::println);
    }
}
